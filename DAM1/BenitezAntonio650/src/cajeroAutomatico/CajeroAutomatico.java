/*
 * Objetivo: Programa que actúa como un Cajero Automático,
 * haciendo uso de la clase creada CuentaBancaria para
 * utilizar sus métodos y realizar operaciones sobre sus atributos
 * Excepciones: IllegalStateException, InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/02/2025
 */
package cajeroAutomatico;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {

	public static void main(String[] args)
	{
		
		// INICIALIZACIÓN DE ATRIBUTOS ===================================
		
		Scanner entradaTeclado = new Scanner(System.in);
		CuentaBancaria[] banco = new CuentaBancaria[10]; //Creamos un array Banco de 10 objetos CuentaBancaria
		boolean loginTrue = false, programExit = false;
		int opcion;
		
		//Llenamos el banco de cuentas bancarias por defecto
		for(int i=0;i<banco.length - 1; i++)
		{
			banco[i] = new CuentaBancaria();
			/*Número de cuenta: AA0000000000000000000000
			  PIN: 1234*/
		}
		
		banco[9] = new CuentaBancaria("CuentaPersonal", 28122001); //Cuenta personal para testeo de login diferente
		/*Número de cuenta: CuentaPersonal
		  PIN: 28122001*/
		
		// PROGRAMA ===================================
		
		do // BUCLE - Do while que termina cuando el programa se apaga por completo
		{
			System.out.println("===================================="+
							"\n||           C A J E R O            ||"+
							"\n||        A U T O M Á T I C O       ||"+
							"\n=====================================" +
							"\n\n - Bienvenido al Cajero Automático. -\n");
			do // BUCLE - Do while que termina cuando se ha ingresado en el Login correctamente
			{
				System.out.println("=== || LOGIN || ===\n");
				System.out.println("Por favor, introduzca su número de cuenta (formato IBAN)."+
								"\nSi desea apagar el cajero automático, escriba 'Apagar'");
				String numeroCuentaTeclado = entradaTeclado.nextLine();
				if(numeroCuentaTeclado.equals("Apagar") || numeroCuentaTeclado.equals("apagar"))
				{
					System.out.println("Apagando cajero automático ...");
					loginTrue = true;
					programExit = true;
				}
				else
				{
					CuentaBancaria cuentaEncontrada = buscarCuenta(banco, numeroCuentaTeclado);
					if(cuentaEncontrada == null)
					{
						System.out.println("No se ha encontrado una cuenta con ese número de cuenta." +
										"\nPor favor, inténtelo de nuevo y asegúrese de que las credenciales son correctas.\n");
					}
					else
					{
						System.out.println("Cuenta encontrada.");
						int pinTeclado = inputInt("Introduzca su PIN para continuar.", entradaTeclado);
						if(cuentaEncontrada.getPin() == pinTeclado)
						{
							System.out.println("Se ha iniciado sesión, se mostrará el menú principal a continuación.");
							loginTrue = true;
							opcion = 1;
							do // BUCLE - Do while que termina cuando se escoge la opción de salir
							{
								opcion = menuPrincipal(entradaTeclado);
								switch(opcion)
								{
								case 1: // ---------- MOSTRAR SALDO DE CUENTA
									System.out.printf("Saldo de la cuenta: %.2f€ \n", cuentaEncontrada.getSaldo());
									break;
								case 2: // ---------- INGRESAR DINERO
									ingresarDinero(seleccionarCantidad("INGRESAR", entradaTeclado), cuentaEncontrada, entradaTeclado);
									break;
								case 3: // ---------- SACAR DINERO
									sacarDinero(seleccionarCantidad("RETIRAR", entradaTeclado), cuentaEncontrada, entradaTeclado);
									break;
								case 4: // ---------- MOSTRAR MOVIMIENTOS DE LA CUENTA
									System.out.printf(" - MOVIMIENTOS - \n" +
													"\n%s", cuentaEncontrada.movimientosToString());
									break;
								case 5: // ---------- SALIR DEL MENÚ PRINCIPAL
									System.out.println("Saliendo del menú principal...\n");
									loginTrue = false;
									break;
								}
							}while(opcion != 5);
						}
						else
						{
							System.out.println("PIN incorrecto, por favor vuelva a introducir sus credenciales.\n");
						}
					}
				}
			}while(loginTrue == false);
		}while(programExit == false);
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n=== || MENÚ PRINCIPAL || ==="+
					"\n\n 1. Ver saldo de cuenta"+
					"\n 2. Ingresar dinero"+
					"\n 3. Sacar dinero" +
					"\n 4. Ver movimientos"+
					"\n 5. Salir\n");
			opcion = inputInt("Elija una opción", entradaTeclado);
			if(opcion < 1 || opcion > 5) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 5);
		return opcion;
	}
	
	//SELECCIONAR CANTIDAD - Devuelve la cantidad seleccionada por teclado
	private static double seleccionarCantidad(String operacion, Scanner entradaTeclado)
	{
		double cantidad = 0;
		int opcionCantidad;
		do
		{
			System.out.printf("- %s - "+
					"\n 1. 1000€" +
					"\n 2. 500€" +
					"\n 3. 200€" +
					"\n 4. 100€" +
					"\n 5. 50€\n\n", operacion);
			opcionCantidad = inputInt("Seleccione la cantidad que desea sacar.", entradaTeclado);
			if(opcionCantidad < 1 || opcionCantidad > 5)
			{
				System.out.println("Opción inválida, inténtelo de nuevo.");
			}
			else
			{
				switch(opcionCantidad)
				{
				case 1: // Ingresar 1000
					cantidad = 1000;
					break;
				case 2: // Ingresar 500
					cantidad = 500;
					break;
				case 3: // Ingresar 200
					cantidad = 200;
					break;
				case 4: // Ingresar 100
					cantidad = 100;
					break;
				case 5: // Ingresar 50
					cantidad = 50;
					break;
				}
			}
		}while(opcionCantidad < 1 || opcionCantidad > 5);
		return cantidad;
	}
	
	//INGRESAR DINERO - Ingresa el dinero introducido y confirma o cancela la operación
	private static void ingresarDinero(double cantidad, CuentaBancaria cuenta, Scanner entradaTeclado)
	{
		cuenta.ingresarDinero(cantidad);
		if(confirmacion(String.format("Se van a ingresar %.2f€. \n¿Confirmar transacción?\n Y/N \n", cantidad), entradaTeclado))
		{
			System.out.printf("Confirmado. Ingresando %.2f€. \n", cantidad);
			cuenta.confirmarOperacion("Ingreso");	
		}
		else
		{
			System.out.println("Cancelando ingreso...");
			cuenta.cancelarOperacion();
		}
	}
	
	//SACAR DINERO - Retira el dinero introducido y confirma o cancela la operación, tratando las excepciones posibles
	private static void sacarDinero(double cantidad, CuentaBancaria cuenta, Scanner entradaTeclado)
	{
		try //TRY CATCH - Trata las excepciones dadas al retirar dinero de la cuenta
		{
			System.out.printf("Retirando %.2f€ de la cuenta ...\n", cantidad);
			cuenta.sacarDinero(cantidad);
			
			if(confirmacion(String.format("Se van a retirar %.2f€. \n¿Confirmar transacción?\n Y/N \n", cantidad), entradaTeclado))
			{
				System.out.printf("Confirmado. Retirando %.2f€. \n", cantidad);
				cuenta.confirmarOperacion("Retirada");	
				mostrarBilletes(cantidad);
			}
			else
			{
				System.out.println("Cancelando retirada...");
				cuenta.cancelarOperacion();
			}
		}catch(IllegalStateException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
		}
	}
	
	//CONFIRMACIÓN - Devuelve true or false dependiendo si se confirma la transacción o no
	private static boolean confirmacion(String mensaje, Scanner entradaTeclado)
	{
		String confirmacionTeclado;
		boolean confirmacion = false, flag = false;
		do //BUCLE - Do while que termina cuando se confirma o cancela la operación
		{
			System.out.printf(mensaje);
			confirmacionTeclado = entradaTeclado.nextLine();
			confirmacionTeclado.toLowerCase();
			if(confirmacionTeclado.equals("y"))
			{
				confirmacion = true;
				flag = true;
			}else if(confirmacionTeclado.equals("n"))
			{
				confirmacion = false;
				flag = true;
			}
			else
			{
				System.out.println("Comando incorrecto. Por favor introduzca 'Y' o 'N'.\n");
				flag = false;
			}
		}while(flag == false);
		return confirmacion;
	}
	
	//BUSCAR CUENTA - Recorre el array de banco para buscar la CuentaBancaria con el mismo número de cuenta
	private static CuentaBancaria buscarCuenta(CuentaBancaria[] banco, String numeroCuentaTeclado)
	{
		CuentaBancaria cuentaEncontrada = null;
		int contador = 0;
		boolean encontrada = false;
		do
		{
			if(banco[contador].getNumeroCuenta().equals(numeroCuentaTeclado))
			{
				cuentaEncontrada = banco[contador];
				encontrada = true;
			}
			contador++;
		}while(contador < banco.length && encontrada == false);
		return cuentaEncontrada;
	}
	
	//INPUT INT - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	private static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			try //TRY CATCH - Trata las excepciones dadas al introducir datos por teclado
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				entrada.nextLine(); //Depuración Scanner
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine(); //Depuración Scanner
			}
		}while(inputTrue == false);
		return num;
	}
	
	//MOSTRAR BILLETES - Calcula y muestra la cantidad de billetes que devuelve en torno a una cantidad introducida
	private static void mostrarBilletes(double cantidad)
	{
		double centimos = Math.round(cantidad * 100); //Conversión a céntimos
		
		int billete100 = (int) centimos / 10000;
		int billete50 = (int) centimos % 10000;
		int billete20 = billete50 % 5000;
		int billete10 = billete20 % 2000;
		
		System.out.printf("\n = BILLETES A ENTREGAR = \n\n - Billetes 100€: %d \n - Billetes 50€: %d \n - Billetes 20€: %d \n - Billetes 10€: %d \n",
				billete100, (int) billete50 / 5000, (int) billete20 / 2000, (int) billete10 / 1000);
	}
}
