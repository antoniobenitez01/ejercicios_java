/*
 * Programa que hace uso de la clase creada Venta
 * para simular el funcionamiento de un concesionario de coches
 * Excepciones: InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 24/03/2025
 */
package ejercicio7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		
		//INICIALIZACIÓN -----------------------------------------------------------------------------------------------------
		
		Scanner entradaTeclado = new Scanner(System.in);
		
		//CREACIÓN DE COLECCIÓN ----------------------------------------------------------------------------------------------
		
		ArrayList<Venta> concesionario = new ArrayList<Venta>(12);
		
		// PROGRAMA -----------------------------------------------------------------------------------------------------------
		
		System.out.println("\n=== COLECCIONES EJERCICIO 7: VENTA DE COCHES ===\n");
		
		int opcion;
		do
		{
			opcion = menuPrincipal(entradaTeclado);
			switch(opcion)
			{
			case 1:
				concesionario.clear();
				for (Venta.mes mes : Venta.mes.values()) 
				{
					int ventasTeclado = inputInt(String.format("Introduzca las ventas del mes %s", mes.toString()), entradaTeclado);
					concesionario.add(new Venta(mes, ventasTeclado));
				}
				break;
			case 2:
				if(concesionario.isEmpty())
				{
					System.out.println("No se ha encontrado ninguna Venta registrada.");
				}else
				{
					for(Venta i:concesionario)
					{
						if(i != null)
						{
							System.out.printf("%s\n", i.toString());
						}
					}	
				}
				break;
			case 3:
				int suma = 0;
				for(Venta i: concesionario)
				{
					suma += i.getVentas();
				}
				System.out.printf("Suma total de ventas del año: %d ventas", suma);
				break;
			case 4:
				int sumaMesA = 0;
				for(Venta i: concesionario)
				{
					if(i.getMes().toString().toLowerCase().charAt(0) == 'a')
					{
						sumaMesA++;
					}
				}
				System.out.printf("Suma total de ventas de meses que empiezan por A: %d ventas", sumaMesA);
				break;
			case 5:
				if(concesionario.isEmpty())
				{
					System.out.println("No se ha encontrado ninguna Venta registrada.");
				}else
				{
					int ventasMax = 0;
					String nombreMax = "";
					for(Venta i: concesionario)
					{
						if(i.getVentas() > ventasMax)
						{
							ventasMax = i.getVentas();
							nombreMax = i.getMes().toString();
						}
					}
					System.out.printf("Mes con más ventas: %s con %d ventas", nombreMax, ventasMax);
				}
				break;
			case 6:
				System.out.println("Apagando programa ...");
				break;
			}
		}while(opcion != 6);
		
		//FIN PROGRAMA -------------------------------------------------------------------------------------------------------
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n=== || MENÚ PRINCIPAL || ==="+
					"\n\n 1. Introducir Ventas del año"+
					"\n 2. Mostrar ventas"+
					"\n 3. Mostrar suma total de ventas" +
					"\n 4. Mostrar ventas totales de meses que empiezan por A" +
					"\n 5. Mostrar mes con más ventas" +
					"\n 6. Salir del programa\n");
			opcion = inputInt("Elija una opción:", entradaTeclado);
			if(opcion < 1 || opcion > 6) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 6);
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
