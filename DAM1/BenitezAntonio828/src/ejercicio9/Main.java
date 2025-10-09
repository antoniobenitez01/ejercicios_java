/*
 * Programa que hace uso de la clase creada Cliente
 * y de listas ArrayList para realizar operaciones
 * sobre las compras y teléfonos de un Cliente
 * Excepcion: InputMismatchException, IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 20/03/2025
 */
package ejercicio9;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		//INICIALIZACION DE VARIABLES ------------------------------------------------------------------------------
		
		Scanner entradaTeclado = new Scanner(System.in);
		Cliente cliente = new Cliente("Antonio Benítez","antonio@mail.com");
		
		// PROGRAMA ------------------------------------------------------------------------------------------------
		
		System.out.println("\n=== COLECCIONES EJERCICIO 9: COMPRAS DE CLIENTE ===");
		
		int opcion;
		do
		{
			opcion = menuPrincipal(entradaTeclado);
			switch(opcion)
			{
			case 1: // INTRODUCIR TELEFONO -----------------------------------------
				System.out.println("Introduzca el teléfono a añadir");
				String tlfTeclado = entradaTeclado.nextLine();
				try
				{
					cliente.addTelefono(tlfTeclado);
					System.out.println("Teléfono añadido con éxito.");
					System.out.printf("%s\n",cliente.toString());
				}catch(IllegalArgumentException ex)
				{
					System.out.printf("ERROR: %s\n", ex.getMessage());
				}
				break;
			case 2: // BUSCAR TELEFONO POR INDICE -----------------------------------
				int indTeclado = inputInt("Introduzca el número de índice del teléfono que desea mostrar", entradaTeclado) - 1;
				String numEncontrado = cliente.getTelefono(indTeclado);
				if(numEncontrado.isEmpty())
				{
					System.out.println("No se ha encontrado ningún número en ese índice.");
				}else
				{
					System.out.printf("Teléfono encontrado: %s", numEncontrado);
				}
				break;
			case 3: // BUSCAR TELEFONO POR CADENA ------------------------------------
				System.out.println("Introduzca una cadena que contenga el teléfono que desea buscar");
				String cadenaTeclado = entradaTeclado.nextLine();
				ArrayList<String> resultado = cliente.buscarTelefono(cadenaTeclado);
				if(resultado.isEmpty())
				{
					System.out.println("No se ha encontrado ningún número con esa cadena.");
				}else
				{
					System.out.printf("Números encontrados: %s\n",resultado.toString());
				}
				break;
			case 4: // AÑADIR COMPRA --------------------------------------------------
				System.out.println("Introduzca el nombre del producto");
				String nombreProducto = entradaTeclado.nextLine();
				int cantidadProducto = inputInt("Introduzca la cantidad comprada del producto", entradaTeclado);
				try
				{
					cliente.addCompra(nombreProducto, cantidadProducto);
					System.out.println("Compra añadida con éxito.");
					System.out.printf("%s\n",cliente.toString());
				}catch(IllegalArgumentException ex)
				{
					System.out.printf("ERROR: %s\n", ex.getMessage());
				}
				break;
			case 5: // ELIMINAR COMPRA ------------------------------------------------
				System.out.println("Introduzca el nombre del producto de la compra que desea eliminar");
				String prodBorrar = entradaTeclado.nextLine();
				try
				{
					cliente.eliminarProducto(prodBorrar);
					System.out.println("Producto eliminado con éxito.");
					System.out.printf("%s\n",cliente.toString());
				}catch(IllegalArgumentException ex)
				{
					System.out.printf("%s\n", ex.getMessage());
				}
				break;
			case 6: // VER PRODUCTOS --------------------------------------------------
				try
				{
					ArrayList<String> productos = cliente.verProductos();
					System.out.println(" --- Productos comprados ---");
					for(String i: productos)
					{
						System.out.printf("- %s\n", i);
					}
				}catch(IllegalStateException ex)
				{
					System.out.printf("%s\n", ex.getMessage());
				}
				break;
			case 7: // TOTAL UNIDADES -------------------------------------------------
				System.out.printf("Total unidades compradas: %d %s\n", 
						cliente.totalUnidades(), cliente.totalUnidades() == 1 ? "unidad" : "unidades");
				break;
			case 8: // MOSTRAR INFORMACION CLIENTE ------------------------------------
				System.out.printf("%s\n", cliente.toString());
				break;
			case 9: // APAGAR PROGRAMA ------------------------------------------------
				System.out.println("Apagando programa ...");
				break;
			}
		}while(opcion != 9);
		
		//FIN PROGRAMA -----------------------------------------------------------------------------------------------------
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n=== || MENÚ PRINCIPAL || ===" +
					"\n\n ------ TELEFONOS ------\n" +
					"\n 1. Añadir teléfono" +
					"\n 2. Buscar teléfono por índice" +
					"\n 3. Buscar teléfono por cadena" +
					"\n\n ------ COMPRAS -------\n" +
					"\n 4. Añadir compra" +
					"\n 5. Eliminar producto" +
					"\n 6. Ver productos" +
					"\n\n ------ INFORMACIÓN ------\n" +
					"\n 7. Calcular total de unidades" +
					"\n 8. Mostrar información del cliente" +
					"\n 9. Salir del programa\n");
			opcion = inputInt("Elija una opción:", entradaTeclado);
			if(opcion < 1 || opcion > 9) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 9);
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
