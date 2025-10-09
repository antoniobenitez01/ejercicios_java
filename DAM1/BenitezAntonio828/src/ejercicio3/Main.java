/*
 * Programa que hace uso de la clase creada Trabajador
 * y colecciones LinkedList para simular el funcionamiento de una empresa
 * y realizar diferentes cálculos sobre sus valores
 * Excepciones: InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025
 */
package ejercicio3;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import ejercicio3.Trabajador.estadoCivil;

public class Main {

	public static void main(String[] args) 
	{
		//INICIALIZACIÓN ---------------------------------------------------------------------------------------------------------------
		
		Scanner entradaTeclado = new Scanner(System.in);
		
		//CREACIÓN DE COLECCIÓN --------------------------------------------------------------------------------------------------------
		
		LinkedList<Trabajador> empresa = new LinkedList<Trabajador>();
		empresa.add(new Trabajador("Juan José", 10, true, estadoCivil.SOLTERO, 1250.50));
		empresa.add(new Trabajador("Carlos", 10, true, estadoCivil.COMPROMETIDO, 1750.50));
		empresa.add(new Trabajador("María", 10, false, estadoCivil.VIUDO, 1050.50));
		empresa.add(new Trabajador("Antonio", 10, true, estadoCivil.CASADO, 1550.50));
		empresa.add(new Trabajador("Eva", 10, false, estadoCivil.COMPROMETIDO, 1110.50));
		empresa.add(new Trabajador("Mario", 10, true, estadoCivil.CASADO, 950.50));
		empresa.add(new Trabajador("Carmen", 10, false, estadoCivil.SOLTERO, 875.50));
		empresa.add(new Trabajador("Elizabeth", 10, false, estadoCivil.CASADO, 2256.50));
		empresa.add(new Trabajador("Francisco", 10, true, estadoCivil.SOLTERO, 3050.50));
		empresa.add(new Trabajador("Carlos", 10, true, estadoCivil.CASADO, 2523.50));
		
		//PROGRAMA ----------------------------------------------------------------------------------------------------------------------
		
		System.out.println("\n=== COLECCIONES EJERCICIO 3: TRABAJADORES ===");
		
		int opcion;
		do
		{
			opcion = menuPrincipal(entradaTeclado);
			switch(opcion)
			{
			case 1: // MOSTRAR TRABAJADORES --------------------------------------------------------------------------------
				int contador = 1;
				empresa.sort(new ComparatorTrabajador());
				for(Trabajador i:empresa)
				{
					System.out.printf("%d. %s\n", contador, i.toString());
					contador++;
				}
				break;
			case 2: // CANTIDAD TRABAJADORES HOMBRE --------------------------------------------------------------------------
				int sumaHombres = 0;
				for(Trabajador i:empresa)
				{
					if(i.esHombre())
					{
						sumaHombres++;
					}
				}
				System.out.printf("Número de trabajadores hombre: %d\n", sumaHombres);
				break;
			case 3: // CANTIDAD TRABAJADORAS CASADAS ---------------------------------------------------------------------
				int sumaCasadas = 0;
				for(Trabajador i:empresa)
				{
					if(!i.esHombre() && i.getEstadoCivil() == estadoCivil.CASADO)
					{
						sumaCasadas++;
					}
				}
				System.out.printf("Número de trabajadoras casadas: %d\n", sumaCasadas);
				break;
			case 4: // CALCULAR SUMA DE SUELDOS --------------------------------------------------------------
				double suma = 0;
				for(Trabajador i:empresa)
				{
					suma += i.getSalarioBase();
				}
				System.out.printf("Suma de todos los sueldos: %.2f€\n", suma);
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
					"\n\n 1. Mostrar trabajadores"+
					"\n 2. Calcular cantidad trabajadores masculinos"+
					"\n 3. Calcular cantidad de trabajadoras casadas" +
					"\n 4. Calcular suma de todos los sueldos" +
					"\n 5. Salir del programa\n");
			opcion = inputInt("Elija una opción:", entradaTeclado);
			if(opcion < 1 || opcion > 5) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 5);
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
