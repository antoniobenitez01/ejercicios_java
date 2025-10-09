/*
 * Programa que hace uso de la clase creada DiaTemperatura
 * y de listas LinkedList para realizar operaciones sobre
 * las temperaturas medias del mes de Marzo (31 días)
 * Excepciones: InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 24/03/2025
 */
package ejercicio8;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		
		// INICIALIZACIÓN DE VARIABLES ----------------------------------------------------------------------------------
		
		Scanner entradaTeclado = new Scanner(System.in);
		LinkedList<DiaTemperatura> mes = new LinkedList<DiaTemperatura>();
		String[] diasSemana = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO", "DOMINGO"};
		
		//PROGRAMA ------------------------------------------------------------------------------------------------------
		
		System.out.println("\n=== COLECCIONES EJERCICIO 8: TEMPERATURAS MEDIA DE MARZO ===");
		
		int opcion;
		do
		{
			opcion = menuPrincipal(entradaTeclado);
			switch(opcion)
			{
			case 1: // RELLENAR TEMPERATURAS ----------------------------------------------------
				mes.clear();
				int dia = 1, diaSemana = 0;
				for(int i=0; i<31; i++)
				{
					if(diaSemana > 6)
					{
						diaSemana = 0;
					}
					double temp = Math.random() * 50 + 1;
					mes.add(new DiaTemperatura(dia, diasSemana[diaSemana], temp));
					System.out.printf("%s día %d - %.2fºC\n", diasSemana[diaSemana], dia, temp);
					dia++;
					diaSemana++;
				}
				mes.sort(new Comparator_DiaTemperatura());
				break;
			case 2: // MOSTRAR TEMPERATURAS ------------------------------------------------------
				if(mes.isEmpty())
				{
					System.out.println("No hay ninguna temperatura registrada.");
				}else
				{
					for(DiaTemperatura i: mes)
					{
						System.out.printf("%s\n", i.toString());
					}
				}
				break;
			case 3: // TEMPERATURA MEDIA ----------------------------------------------------------
				System.out.printf("Temperatura media del mes: %.2fºC", calcularMedia(mes));
				break;
			case 4: // DIAS MAS CALUROSOS ----------------------------------------------------------
				LinkedList<DiaTemperatura> diasMasCalurosos = new LinkedList<DiaTemperatura>();
				double media = calcularMedia(mes);
				for(DiaTemperatura i: mes)
				{
					if(i.getTempMedia() > media)
					{
						diasMasCalurosos.add(i);
					}
				}
				for(DiaTemperatura i: diasMasCalurosos)
				{
					System.out.printf("%s\n", i.toString());
				}
				break;
			case 5: // APAGAR PROGRAMA --------------------------------------------------------------
				System.out.println("Apagando programa ...");
				break;
			}
		}while(opcion != 5);
		
		//FIN PROGRAMA -------------------------------------------------------------------------------------------------------
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n=== || MENÚ PRINCIPAL || ==="+
					"\n\n 1. Rellenar temperaturas del mes"+
					"\n 2. Mostrar temperaturas del mes"+
					"\n 3. Calcular la temperatura media del mes" +
					"\n 4. Mostrar día o días más calurosos del mes" +
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
	
	//CALCULAR MEDIA - Recoge una Lista de DiaTemperatura para calcular la temperatura media de la lista entera
	private static double calcularMedia(LinkedList<DiaTemperatura> lista)
	{
		double suma = 0;
		for(DiaTemperatura i: lista)
		{
			suma += i.getTempMedia();
		}
		suma = suma / lista.size();
		return suma;
	}
}
