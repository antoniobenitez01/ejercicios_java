/*
 * Objetivo: Programa que guarda las temperaturas de 15 días
 * de las capitales andaluzas, calculando entonces
 * la media de las temperaturas de cada capital,
 * el nombre de la capital con más temperatura media
 * y el día con menos temperatura en cada una de las capitales.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 25/11/2024
 */
package ejercicio20241125;

public class Ejercicio20241125 
{

	public static void main(String[] args) 
	{
		//Array bidimensional de Temperaturas - 15 DÍAS 8 CAPITALES
		int temperaturas [][] = {{29, 17, 32, 28, 22, 18, 25, 12}, {26, 26, 13, 20, 31, 16, 32, 27}, {23, 32, 31, 10, 33, 34, 24, 21},
						  {26, 36, 28, 11, 11, 39, 40, 13}, {27, 12, 20, 10, 39, 34, 15, 17}, {19, 32, 35, 39, 17, 14, 11, 34},
						  {17, 24, 16, 22, 35, 22, 30, 21}, {15, 17, 31, 32, 22, 35, 38, 13}, {39, 35, 14, 26, 19, 26, 13, 19},
						  {20, 38, 30, 22, 34, 19, 10, 14}, {36, 13, 33, 27, 31, 25, 10, 23}, {27, 38, 36, 40, 36, 24, 22, 25},
						  {27, 13, 18, 28, 32, 40, 31, 40}, {20, 17, 26, 21, 11, 36, 25, 12}, {32, 23, 17, 23, 39, 26, 24, 23}};
		String [] nombreCapitales = {"Almería", "Cádiz", "Córdoba", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla"};
		double media[] = new double [8];
		
		//Bucle cálculo temperaturas media de cada capital
		System.out.println("\n" + "=== TEMPERATURAS MEDIA ===" + "\n");
		for(int capital=0; capital<8; capital++)
		{
			//Introducimos las medias calculadas en el método mediaTemperatura dentro del array de medias para cálculos a continuación
			//Solo llamamos al método una vez por capital para evitar llamarlo demasiadas veces cuando queremos mostrar resultados por consola
			media[capital] = mediaTemperatura(temperaturas, capital);
			System.out.println("La temperatura media de " + nombreCapitales[capital] + " es: " + media[capital]);
		}
		
		//Usamos el array de medias y el metodo capitalMediaMax para calcular la media más alta de temperaturas
		System.out.println("\n" + "La capital con la media más alta es " + nombreCapitales[capitalMediaMax(media)] + "." + "\n");
		
		//Bucle cálculo día con menos temperatura de cada capital
		System.out.println("\n" + "=== DÍA CON MENOS TEMPERATURA ===");
		for(int capital=0; capital<8; capital++)
		{
			//Introducimos el resultado del método en una variable para solo llamar al método una vez
			int diaTempMin = diaTempMin(temperaturas, capital);
			System.out.println("\nEl día con la menor temperatura en " + nombreCapitales[capital] + " es el día " + (diaTempMin+1) +
							"\nCon una temperatura de " + temperaturas[diaTempMin][capital] + ".");
		}
	}
	
	//MÉTODO - Recoge un array bidimensional y la posición de la capital para calcular la media de la capital deseada
	public static double mediaTemperatura(int temperaturas[][], int capital)
	{
		double media=0;
		for(int dia = 0; dia < 15; dia++)
		{
			media += temperaturas[dia][capital];
		}
		media = media/15;
		return media;
	}
	
	//MÉTODO - Recoge el array de medias para devolver la posición de la media más alta
	public static int capitalMediaMax(double media[])
	{
		int posicionCapital = 0;
		for(int capital=1; capital<7;capital++)
		{
			if(media[posicionCapital] < media[capital])
			{
				posicionCapital = capital;
			}
		}
		return posicionCapital;
	}
	
	//MÉTODO - Recoge el array bidimensional de temperaturas y la posición de la capital para devolver el día con la temperatura mínima
	public static int diaTempMin(int temperaturas[][], int capital)
	{
		int diaTempMin = 0;
		for(int dia = 0; dia < 15; dia++)
		{
			if(temperaturas[diaTempMin][capital] > temperaturas[dia][capital])
			{
				diaTempMin = dia;
			}
		}
		return diaTempMin;
	}
}
