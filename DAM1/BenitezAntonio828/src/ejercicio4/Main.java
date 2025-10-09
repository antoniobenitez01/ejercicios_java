/*
 * Clase que hace uso de la clase creada Persona
 * y de listas LinkedList para simular el funcionamiento de
 * un censo de población
 * Excepciones: InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025
 */
package ejercicio4;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import ejercicio4.Persona.estadoCivil;

public class Main {

	public static void main(String[] args) 
	{
		
		//INICIALIZACIÓN ---------------------------------------------------------------------------------------------------------------
		
		Scanner entradaTeclado = new Scanner(System.in);
		
		//CREACIÓN DE COLECCIÓN --------------------------------------------------------------------------------------------------------
		
		LinkedList<Persona> censo = new LinkedList<Persona>();
		
		censo.add(new Persona("Juan José", true, estadoCivil.CASADO, 25));
		censo.add(new Persona("María", false, estadoCivil.DIVORCIADO, 15));
		censo.add(new Persona("Penélope", false, estadoCivil.VIUDO, 35));
		censo.add(new Persona("Antonio", true, estadoCivil.CASADO, 10));
		censo.add(new Persona("Carlos", true, estadoCivil.SOLTERO, 48));
		censo.add(new Persona("Francisco", true, estadoCivil.CASADO, 34));
		censo.add(new Persona("Elizabeth", false, estadoCivil.SOLTERO, 56));
		censo.add(new Persona("Maria Jesús", false, estadoCivil.VIUDO, 25));
		censo.add(new Persona("Curro", true, estadoCivil.DIVORCIADO, 17));
		censo.add(new Persona("Eva", false, estadoCivil.DIVORCIADO, 19));
		
		//PROGRAMA ---------------------------------------------------------------------------------------------------------------------
		
		System.out.println("\n=== COLECCIONES EJERCICIO 4: CENSO DE POBLACIÓN ===");
		
		int opcion;
		do
		{
			opcion = menuPrincipal(entradaTeclado);
			switch(opcion)
			{
			case 1: // BUSCAR POR SEXO --------------------------------------------------------------------------------
				boolean sexoTeclado = booleanCheck("¿Buscar por Hombre o Mujer?", entradaTeclado);
				int numSexo = 0;
				for(Persona i:censo)
				{
					if(i.esHombre() == sexoTeclado)
					{
						System.out.printf("- %s\n", i.toString());
						numSexo++;
					}
				}
				if(numSexo == 0)
				{
					System.out.println("No se ha encontrado ninguna Persona con ese Sexo.");
				}
				break;
			case 2: // BUSCAR POR ESTADO CIVIL --------------------------------------------------------------------------
				estadoCivil estadoTeclado = getEstadoCivil("Introduzca el estado civil a buscar "
						+ "(Casado, Viudo, Divorciado o Soltero)", entradaTeclado);
				int numCivil = 0;
				for(Persona i:censo)
				{
					if(i.getEstadoCivil().equals(estadoTeclado))
					{
						System.out.printf("- %s\n", i.toString());
						numCivil++;
					}
				}
				if(numCivil == 0)
				{
					System.out.println("No se ha encontrado ninguna Persona con ese Estado civil");
				}
				break;
			case 3: // BUSCAR POR RANGO DE EDAD ---------------------------------------------------------------------
				int min = inputInt("Introduzca el rango mínimo de edad.", entradaTeclado);
				int max = inputInt("Introduzca el rango máximo de edad", entradaTeclado);
				int numEdad = 0;
				for(Persona i:censo)
				{
					if(i.getEdad() > min && i.getEdad() < max)
					{
						System.out.printf("- %s\n", i.toString());
						numEdad++;
					}
				}
				if(numEdad == 0)
				{
					System.out.println("No se ha encontrado ninguna Persona con ese rango de edad");
				}
				break;
			case 4: // BUSCAR POR SEXO Y ESTADO CIVIL --------------------------------------------------------------
				boolean sexoTeclado2 = booleanCheck("¿Buscar por Hombre o Mujer?", entradaTeclado);
				estadoCivil estadoTeclado2 = getEstadoCivil("Introduzca el estado civil a buscar "
						+ "(Casado, Viudo, Divorciado o Soltero)", entradaTeclado);
				int numSexoEstado = 0;
				for(Persona i:censo)
				{
					if(i.esHombre() == sexoTeclado2 && i.getEstadoCivil() == estadoTeclado2)
					{
						System.out.printf("- %s\n", i.toString());
						numSexoEstado++;
					}
				}
				if(numSexoEstado == 0)
				{
					System.out.println("No se ha encontrado ninguna Persona con esos parámetros.");
				}
				break;
			case 5: // SALIR DEL PROGRAMA --------------------------------------------------------------------------
				System.out.println("Saliendo del programa...");
				break;
			}
		}while(opcion != 5);
		
		//FIN PROGRAMA -----------------------------------------------------------------------------------------------------------
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n=== || MENÚ PRINCIPAL || ==="+
					"\n\n 1. Buscar por sexo"+
					"\n 2. Buscar por estado civil"+
					"\n 3. Buscar por rango de edad" +
					"\n 4. Buscar por sexo y estado civil" +
					"\n 5. Salir del programa\n");
			opcion = inputInt("Elija una opción:", entradaTeclado);
			if(opcion < 1 || opcion > 5) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 5);
		return opcion;
	}
	
	//GET ESTADO CIVIL - Devuelve un enum estadoCivil basado en un parámetro introducido por teclado
	public static estadoCivil getEstadoCivil(String mensaje, Scanner entradaTeclado)
	{
		estadoCivil resultado = null;
		boolean flag = false;
		do
		{
			System.out.println(mensaje);
			String respuesta = entradaTeclado.nextLine();
			if(respuesta.toLowerCase().equals("casado") || respuesta.toLowerCase().equals("casada"))
			{
				resultado = estadoCivil.CASADO;
				flag = true;
			}else if(respuesta.toLowerCase().equals("divorciado") || respuesta.toLowerCase().equals("divorciada"))
			{
				resultado = estadoCivil.DIVORCIADO;
				flag = true;
			}else if(respuesta.toLowerCase().equals("viudo") || respuesta.toLowerCase().equals("viuda"))
			{
				resultado = estadoCivil.VIUDO;
				flag = true;
			}else if(respuesta.toLowerCase().equals("soltero") || respuesta.toLowerCase().equals("soltera"))
			{
				resultado = estadoCivil.SOLTERO;
				flag = true;
			}else
			{
				System.out.println("Respuesta no válida. Inténtelo de nuevo.");
				flag = false;
			}
		}while(flag == false);
		return resultado;
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
	
	//BOOLEAN CHECK - Devuelve un boolean en base a la respuesta SI o NO introducida por teclado
	private static boolean booleanCheck(String mensaje, Scanner entradaTeclado)
	{
		boolean resultado = false, flag = false;
		
		do
		{
			System.out.println(mensaje);
			String respuesta = entradaTeclado.nextLine();
			
			if(respuesta.toLowerCase().equals("hombre"))
			{
				resultado = true;
				flag = true;
			}
			else if(respuesta.toLowerCase().equals("mujer"))
			{
				resultado = false;
				flag = true;
			}
			else
			{
				System.out.println("Respuesta no válida. Inténtelo de nuevo.");
				flag = false;
			}
		}while(flag == false);
		
		return resultado;
	}
}
