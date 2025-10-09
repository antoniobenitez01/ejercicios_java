/*
 * Clase principal que hace uso de las clases creadas
 * Empleado y Empresa para utilizar sus métodos y constructores
 * Excepciones: IllegalArgumentException, IllegalStateException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/02/2025
 */
package ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa 
{

	public static void main(String[] args) 
	{
		//VARIABLES ================================================================
		
		Scanner entradaTeclado = new Scanner(System.in);
		Empresa empresa = new Empresa("Google Spain SL.","B63272603","917486400","PL. PABLO RUIZ PICASSO, 1 - TORRE PICASSO PLANTA.", 50);
		
		// Rellenamos la empresa de Empleados random
		for(int i=0; i < empresa.getTamanyoEmpresa(); i++)
		{
			try
			{
				empresa.anadirEmpleado(new Empleado(dniRandom(),nombreRandom(),((Math.random()*3000) + 1000)));
			}catch(NullPointerException ex)
			{
				System.out.printf("%s\n", ex.getMessage());
			}catch(IllegalStateException ex2)
			{
				System.out.printf("%s\n", ex2.getMessage());
			}
			
			/* Debido a la forma en la que están generados los parámetros random, no necesitamos comprobar
			   las excepiones posibles que se pueden dar, pero lo comprobamos de todos modos por si pudiera
			   saltar cualquier error.*/
		}
		
		//PROGRAMA ==================================================================
		
		int opcion = 0;
		do
		{
			opcion = menuPrincipal(entradaTeclado);
			switch(opcion)
			{
			case 1: // Crear empleado -----------------------------------------------
				Empleado empleadoCreado = crearEmpleado(entradaTeclado);
				try
				{
					empresa.anadirEmpleado(empleadoCreado);
				}catch(NullPointerException ex)
				{
					System.out.println("Se ha detectado un error y no se ha insertado el Empleado.");
				}catch(IllegalStateException ex2)
				{
					System.out.printf("%s\n", ex2.getMessage());
				}
				break;
			case 2: // Eliminar empleado --------------------------------------------
				int opcionEliminar = inputInt("Indique el número del empleado que desea eliminar.", entradaTeclado);
				try
				{
					empresa.eliminarEmpleado(opcionEliminar);
					System.out.printf("Empleado Nº%d eliminado con éxito.\n",opcionEliminar);
				}catch(NullPointerException ex)
				{
					System.out.printf("%s\n", ex.getMessage());
				}
				break;
			case 3: // Mostrar todos los empleados ----------------------------------
				empresa.mostrarTodosEmpleados();
				break;
			case 4: // Mostrar todos los empleados ----------------------------------
				empresa.mostrarSueldosEmpleados();
				break;
			case 5: // Mostrar suma salarios bruto ----------------------------------
				System.out.printf("Suma Salario Bruto: %.2f€\n",empresa.sumaSueldoBruto());
				break;
			case 6: // Mostrar suma salarios neto -----------------------------------
				System.out.printf("Suma Salario Neto: %.2f€\n", empresa.sumaSueldoNeto());
				break;
			case 7: // Apagar programa -----------------------------------------------
				System.out.println("Apagando programa ...");
				break;
			}
		}while(opcion != 7);
		
		//FIN PROGRAMA
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do
		{
			System.out.println("\n=== || EMPRESA || ==="+
					"\n\n 1. Añadir empleado"+
					"\n 2. Eliminar empleado"+
					"\n 3. Mostrar todos los empleados" +
					"\n 4. Mostrar todos los saldos de los empleados"+
					"\n 5. Mostrar la suma de todos los salarios brutos"+
					"\n 6. Mostrar la suma de todos los salarios netos"+
					"\n 7. Apagar el programa\n");
			opcion = inputInt("Elija una opción", entradaTeclado);
			if(opcion < 1 || opcion > 7)
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 7);
		return opcion;
	}
	
	//CREAR EMPLEADO - Devuelve un objeto Empleado creado a partir de parámetros introducidos por teclado
	private static Empleado crearEmpleado(Scanner entradaTeclado)
	{
		Empleado empleado = null;
		
		System.out.println("Introduzca el DNI del empleado:");
		String dniTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca el nombre del Empleado:");
		String nombreTeclado = entradaTeclado.nextLine();
		
		double saldoTeclado = inputDouble("Introduzca el saldo bruto del Empleado:", entradaTeclado);
		
		try
		{
			empleado = new Empleado(dniTeclado, nombreTeclado, saldoTeclado);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		return empleado;
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
	
	//INPUT DOUBLE - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Double correctamente
	public static double inputDouble(String mensaje, Scanner entrada)
	{
		double num = 0;
		boolean inputTrue = false;
		do
		{
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
	
	//NOMBRE RANDOM - Devuelve un nombre random de una lista de nombres disponibles
	private static String nombreRandom()
	{
		String nombre = "";
		int opcion = (int) (Math.random() * 5);
		switch(opcion)
		{
		case 0:
			nombre = "Antonio";
			break;
		case 1:
			nombre = "Silvia";
			break;
		case 2:
			nombre = "Marcos";
			break;
		case 3:
			nombre = "Laura";
			break;
		case 4:
			nombre = "Manolo";
			break;
		}
		return nombre;
	}
	
	//DNI RANDOM - Devuelve un DNI random de una lista de DNIs disponibles
	private static String dniRandom()
	{
		String dni = "";
		int opcion = (int) (Math.random() * 5);
		switch(opcion)
		{
		case 0:
			dni = "26267841R";
			break;
		case 1:
			dni = "96614082Y";
			break;
		case 2:
			dni = "09650792S";
			break;
		case 3:
			dni = "50189184X";
			break;
		case 4:
			dni = "69484686F";
			break;
		}
		return dni;
	}
}
