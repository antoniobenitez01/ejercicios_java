/*
 * Clase Main que hace uso de las clases creadas
 * Coche y Deportivo, utilizando sus constructores y métodos
 * Excepciones: IllegalArgumentException, InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025
 */
package ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClasePrincipal 
{
	public static void main(String[] args) 
	{
		//Esta clase nos servirá para poder poner a prueba las clases anteriores.
		
		/*Crearemos objetos de tipo Coche, le daremos valores válidos y no válidos. 
		  Por último haremos uso del método toString.*/
		
		Scanner entradaTeclado = new Scanner(System.in);
		System.out.println("\n=== CREACIÓN OBJETOS COCHE ===\n");
		Coche coche1;
		
		try
		{
			System.out.println("Creando coche con cilindrada y potencia negativa...");
			coche1 = new Coche(-500, -50);
			System.out.println("Coche creado con éxito.\n");
			System.out.printf("%s\n",coche1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando coche con matrícula incorrecta...");
			coche1 = new Coche("matricula", "Pepe", 2000, 50);
			System.out.println("Coche creado con éxito.\n");
			System.out.printf("%s\n",coche1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando coche con nombre de propietario vacío...");
			coche1 = new Coche("1234ABC", "", 1500, 50);
			System.out.println("Coche creado con éxito.\n");
			System.out.printf("%s\n",coche1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			System.out.println("\nCreando coche con valores correctos...");
			coche1 = new Coche("1234ABC", "José", 1500, 50);
			System.out.println("Coche creado con éxito.\n");
			System.out.printf("%s\n",coche1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		//Se mostrará información de los objetos creados de este tipo.
		System.out.println("\n=== COCHE DEPORTIVO ===\n");
		System.out.printf("\n%s\n", obtenerDeportivo(entradaTeclado).toString());;
	}
	
	/*Se creará un método obtenerDeportivo, el cual devolverá objetos de tipo
	  Deportivo solicitando al usuario la información necesaria.*/
	private static Deportivo obtenerDeportivo(Scanner entradaTeclado)
	{
		Deportivo deportivo = null;
		boolean deportivoCreado = false;
		do
		{
			System.out.println("Introduzca la matrícula.");
			String matricula = entradaTeclado.nextLine();
			
			System.out.println("Introduzca el nombre del propietario.");
			String nombrePropietario = entradaTeclado.nextLine();
			
			double cilindrada = inputDouble("Introduzca la cilindrada.", entradaTeclado);
			double potencia = inputDouble("Introduzca la potencia", entradaTeclado);
			
			boolean traccionTrue = false;
			boolean traccion = false;
			do
			{
				System.out.println("¿Que tipo de tracción desea para su Deportivo?"
						+ "\nPor favor responda con 'Total' o 'Delantera'");
				String respuesta = entradaTeclado.nextLine();
				if(respuesta.toLowerCase().equals("total"))
				{
					traccion = true;
					traccionTrue = true;
				}
				else if(respuesta.toLowerCase().equals("delantera"))
				{
					traccion = false;
					traccionTrue = true;
				}
				else
				{
					System.out.println("Valor introducido no válido, por favor inténtelo de nuevo.");
				}
			}while(traccionTrue == false);
			
			try
			{
				deportivo = new Deportivo(matricula, nombrePropietario, cilindrada, potencia, traccion);
				System.out.println("Deportivo creado con éxito.");
				deportivoCreado = true;
			}catch(IllegalArgumentException ex)
			{
				System.out.printf("%s\nInténtelo de nuevo.\n", ex.getMessage());
			}
		}while(deportivoCreado == false);
		return deportivo;
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
