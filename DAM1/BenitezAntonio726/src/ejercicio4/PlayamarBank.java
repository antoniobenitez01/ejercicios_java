/*
 * Objetivo: Hacer uso de la Clase creada CuentaBancaria para
 * utilizar sus métodos y realizar operaciones sobre sus atributos
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/02/2025
 */
package ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayamarBank 
{
	public static void main(String[] args) throws CuentaException, AvisarHaciendaException
	{
		//INICIALIZACIÓN DE ATRIBUTOS ==================================
		
		final Pattern PATRON_IBAN = Pattern.compile("[A-Z]{2}[0-9]{22}");
		Scanner entradaTeclado = new Scanner(System.in);
		String ibanTeclado, titularTeclado;
		CuentaBancaria cuenta = null;
		int opcion = 0;
		boolean ibanTrue = false, cuentaTrue = false;
		
		//PROGRAMA =====================================================
		
		do //BUCLE - Do while que termina cuando el objeto CuentaBancaria se cree correctamente
		{
			do // BUCLE - Do while que termina una vez el IBAN introducido es correcto
			{
				System.out.println("Introduzca el IBAN de la cuenta.");
				ibanTeclado = entradaTeclado.nextLine();
				Matcher ibanMatch = PATRON_IBAN.matcher(ibanTeclado);
				if(ibanMatch.matches())
				{
					ibanTrue = true;
				}
				else
				{
					System.out.println("El IBAN introducido es incorrecto." +
									"\nAsegúrese de que sigue el formato estándar: AA0000000000000000000000\n");
				}
			}while(ibanTrue == false);
			
			System.out.println("Introduzca el nombre completo del Titular de la cuenta.");
			titularTeclado = entradaTeclado.nextLine();
			
			try //TRY CATCH - Trata las excepciones que se dan al crear un objeto CuentaBancaria
			{
				System.out.println("Creando cuenta bancaria...");
				cuenta = new CuentaBancaria(ibanTeclado, titularTeclado);
				System.out.println("Cuenta bancaria creada con éxito.\n");
				cuentaTrue = true;
			}catch(CuentaException ex)
			{
				System.out.printf("%s\n",ex.toString());
				System.out.println("Ha habido un problema creando su cuenta bancaria, inténtelo de nuevo.\n");
			}
		}while(cuentaTrue == false);
		
		System.out.printf("Bienvenido %s.\n",cuenta.getTitular());
		do // BUCLE - Do while que termina cuando el usuario elige salir del programa
		{
			System.out.println("====== PLAYAMAR BANK ======\n" +
					"\n1. Datos de la cuenta" +
					"\n2. IBAN" +
					"\n3. Titular" +
					"\n4. Saldo" +
					"\n5. Ingreso" +
					"\n6. Retirada" +
					"\n7. Movimientos" +
					"\n8. Salir\n\n");
			do
			{
				opcion = inputInt("Introduzca la opción a elegir.", entradaTeclado);
				if(opcion > 8)
				{
					System.out.println("La opción introducida no puede ser mayor que 8.");
				}
				else if(opcion < 1)
				{
					System.out.println("La opción introducida no puede ser menor que 1.");
				}
			}while(opcion > 8 || opcion < 1);
			
			switch(opcion)
			{
			case 1:
				System.out.printf("\n= INFORMACIÓN DE LA CUENTA = \n\n%s\n", cuenta.toString());
				break;
			case 2:
				System.out.printf("\nIBAN de la cuenta: %s\n", cuenta.getIban());
				break;
			case 3:
				System.out.printf("\nTitular de la cuenta: %s\n", cuenta.getTitular());
				break;
			case 4:
				System.out.printf("\nSaldo de la cuenta: %.2f\n", cuenta.getSaldo());
				break;
			case 5:
				boolean ingresarTrue = false;
				double cantidadIngreso = 0;
				do // BUCLE - Do while que termina cuenta se ingresa dinero en la cuenta correctamente
				{
					try
					{
						cantidadIngreso = inputDouble("Introduzca la cantidad a ingresar.", entradaTeclado);						
						System.out.printf("Ingresando %.2f en la cuenta...\n", cantidadIngreso);
						cuenta.ingreso(cantidadIngreso);
						System.out.println("Ingresado con éxito.");
						ingresarTrue = true;
					}catch(IllegalArgumentException ex)
					{
						System.out.printf("%s\n", ex.getMessage());
					}catch(IllegalStateException ex2)
					{
						System.out.printf("%s\n", ex2.getMessage());
					}catch(AvisarHaciendaException ex3)
					{
						System.out.printf("%s\n", ex3.toString());
						ex3.printStackTrace();
						System.out.println("Ingresado con éxito.");
						ingresarTrue = true;
					}
				}while(ingresarTrue == false);				
				break;
			case 6:
				boolean retirarTrue = false;
				double cantidadRetirada = 0;
				do // BUCLE - Do while que termina cuando se retira dinero de la cuenta correctamente
				{
					try //TRY CATCH - Trata las excepciones que se dan al retirar dinero del objeto CuentaBancaria
					{
						cantidadRetirada = inputDouble("Introduzca la cantidad a retirar.", entradaTeclado);						
						System.out.printf("Retirando %.2f en la cuenta...\n", cantidadRetirada);
						cuenta.retirar(cantidadRetirada);
						System.out.println("Retirado con éxito.");
						retirarTrue = true;
					}catch(IllegalArgumentException ex)
					{
						System.out.printf("%s\n", ex.getMessage());
					}catch(IllegalStateException ex2)
					{
						System.out.printf("%s\n", ex2.getMessage());
					}catch(AvisarHaciendaException ex3)
					{
						System.out.printf("%s\n", ex3.toString());
						ex3.printStackTrace();
						System.out.println("Retirado con éxito.");
						retirarTrue = true;
					}				
				}while(retirarTrue == false);	
				break;
			case 7:
				System.out.printf("\n= MOVIMIENTOS DE LA CUENTA = \n\n%s\n", cuenta.movimientosToString());
				break;
			}
		}while(opcion != 8);
		
		System.out.println("\nApagando programa...");
	}
	
	//INPUT INT - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				entrada.nextLine(); // Depuración Scanner
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine(); // Depuración Scanner
			}
		}while(inputTrue == false);
		return num;
	}
	
	//INPUT DOUBLE - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Double correctamente
	public static double inputDouble(String mensaje, Scanner entrada)
	{
		double num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextDouble();
				entrada.nextLine(); // Depuración Scanner
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine(); // Depuración Scanner
			}
		}while(inputTrue == false);
		return num;
	}
}
