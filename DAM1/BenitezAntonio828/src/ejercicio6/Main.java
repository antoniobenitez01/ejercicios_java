/*
 * Programa que hace uso de la clase creada Ingrediente
 * y de listas LinkedList para simular el funcionamiento 
 * de inventario de un restaurante
 * Excepciones: InputMismatchException, IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 23/03/2025
 */
package ejercicio6;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		//INICIALIZACIÓN ----------------------------------------------------------------------------------------------------
		
		Scanner entradaTeclado = new Scanner(System.in);
		LinkedList<Ingrediente> restaurante = new LinkedList<Ingrediente>();
		LinkedList<Ingrediente> listaSinStock = new LinkedList<Ingrediente>();
		
		// CREACIÓN DE LISTA -------------------------------------------------------------------------------------------------
		
		for(int i=0; i<50;i++)
		{
			int randCantidad = (int) (Math.random() * 50 + 1);
			int randMin;
			do
			{
				randMin = (int) (Math.random() * 15 + 1);
			}while(randMin > randCantidad);
			restaurante.add(new Ingrediente("Ingrediente", randCantidad, randMin));
		}
		
		// PROGRAMA ----------------------------------------------------------------------------------------------------------
		
		System.out.println("\n=== COLECCIONES EJERCICIO 6: INGREDIENTES Y STOCK ===");
		
		int opcion;
		do
		{
			opcion = menuPrincipal(entradaTeclado);
			switch(opcion)
			{
			case 1: // SOLICITUD A COCINA ---------------------------------------------------------------------
				System.out.println("Introduzca el código del Ingrediente.");
				String codTeclado = entradaTeclado.nextLine();
				Ingrediente encontrado = null;
				for(Ingrediente i: restaurante)
				{
					if(i.getCodigo().equals(codTeclado))
					{
						encontrado = i;
					}
				}
				if(encontrado == null)
				{
					System.out.println("No se ha encontrado ningún Ingrediente con ese código.");
				}else
				{
					int cantTeclado = inputInt("Introduzca la cantidad a solicitar", entradaTeclado);
					try
					{
						encontrado.actualizarStock(cantTeclado);
						System.out.println("Stock actualizado con éxito.");
						System.out.printf("%s\n", encontrado.toString());
					}catch(IllegalArgumentException ex)
					{
						System.out.printf("%s\n", ex.getMessage());
						System.out.println("El Ingrediente solicitado está ahora fuera de stock.");
						listaSinStock.add(encontrado);
						restaurante.remove(encontrado);
					}
				}
				break;
			case 2: // MOSTRAR INGREDIENTES ----------------------------------------------------------------------
				for(Ingrediente i: restaurante)
				{
					System.out.printf("%s\n", i.toString());
				}
				break;
			case 3: // MOSTRAR INGREDIENTES SIN STOCK -------------------------------------------------------------
				if(listaSinStock.isEmpty())
				{
					System.out.println("No hay ningún Ingrediente sin stock disponible.");
				}else
				{
					for(Ingrediente i:listaSinStock)
					{
						System.out.printf("%s\n", i.toString());
					}
				}
				break;
			case 4: // APAGAR PROGRAMA ------------------------------------------------------------------------------
				System.out.println("Apagando programa ...");
				break;
			}
		}while(opcion != 4);
		
		//FIN PROGRAMA -------------------------------------------------------------------------------------------------------
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n=== || MENÚ PRINCIPAL || ==="+
					"\n\n 1. Elaborar solicitud a cocina"+
					"\n 2. Mostrar ingredientes del restaurante"+
					"\n 3. Mostrar ingredientes fuera de stock" +
					"\n 4. Apagar el programa \n");
			opcion = inputInt("Elija una opción:", entradaTeclado);
			if(opcion < 1 || opcion > 4) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 4);
		return opcion;
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
}
