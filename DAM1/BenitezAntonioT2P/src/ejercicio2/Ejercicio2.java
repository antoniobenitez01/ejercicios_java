/*
 * Objetivo: Hacer uso de distintos arrays para
 * realizar una serie de cálculos sobre el consumo
 * por horas de una factura eléctrica.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/01/2025
 */
package ejercicio2;

public class Ejercicio2 
{
	public static void main(String[] args) 
	{
		//Declaración e inicialización de variables
		int[] horas = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		int[] consumos = {146,75,69,65,62,59,67,67,141,291,239,656,1166,788,1000,226,201,297,590,317,353,505,259,244};
		double[] precios = {0.176913085, 0.162418527, 0.163008205, 0.161324055, 0.160931245, 0.156762018, 0.151811078, 0.140889361, 
				0.133800035, 0.125667033, 0.108986202, 0.092593459, 0.085345099, 0.083556969, 0.077146071, 0.08592403, 0.105271229, 
				0.115156177, 0.125293963, 0.144438618, 0.15376299, 0.148261656, 0.131731964, 0.114278129};
		double[] costesPorHora = {0.02582931041, 0.012181389525, 0.011247566145, 0.010486063575, 0.00997773719, 0.009248959062, 
				0.010171342226, 0.009439587187, 0.018865804935, 0.036569106603, 0.026047702278, 0.060741309104, 0.099512385434, 
				0.065842891572, 0.077146071, 0.01941883078, 0.021159517029, 0.034201384569, 0.07392343817, 0.045787041906, 
				0.05427833547, 0.07487213628, 0.034118578676, 0.027883863476};
		
		System.out.println("1. Método que calcule el coste de las horas pares del día.");
		System.out.printf("Coste horas pares: %.2f€\n",costeHorasPares(horas, costesPorHora));
		
		System.out.println("\n2. Método que calcule qué hora del día ha tenido el precio más alto.");
		System.out.printf("Hora del día con el precio más alto: %d \n",horaPrecioMasAlto(horas, precios));
		
		System.out.println("\n3. Método que calcule las tres horas con el precio más bajo.");
		int[] horasMasBajas = horasMasBajas(horas, precios);
		for(int i=0; i<horasMasBajas.length; i++)
		{
			System.out.printf("%d. ", (i+1));
			System.out.printf("%d \n", horasMasBajas[i]);
		}
	}
	
	//MÉTODO - Recoge arrays de horas y costesPorHora para devolver el coste de las horas pares en total
	private static double costeHorasPares(int[] horas, double[] costesPorHora)
	{
		double costePar = 0;
		for(int i=0; i<horas.length;i++)
		{
			if(horas[i] % 2 == 0)
			{
				costePar += costesPorHora[i];
			}
		}
		return costePar;
	}
	
	//MÉTODO - Recoge arrays de horas y precios para devolver la hora con el precio más alto
	private static int horaPrecioMasAlto(int[] horas, double[] precios)
	{
		int horaPrecioMasAlto = horas[0], posicionMax = 0;
		for(int i=0; i<horas.length;i++)
		{
			if(precios[i] > precios[posicionMax])
			{
				posicionMax = i;
				horaPrecioMasAlto = horas[i];
			}
		}
		return horaPrecioMasAlto;
	}
	
	//MÉTODO - Recoge arrays de horas y precios para calcular las tres horas con precios más bajos
	private static int[] horasMasBajas(int[] horas, double[] precios)
	{
		int[] horasMasBajas = new int[3];
		horasMasBajas[0] = horaPrecioMasBajo(horas, precios);
		int posicionMin = 0, contador = 0;
		for(int i=0; i<horas.length; i++)
		{
			if(precios[i] < precios[posicionMin] && horas[i] != horasMasBajas[contador] && contador != 2)
			{
				contador++;
				horasMasBajas[contador] = horas[i];
				posicionMin = i;
			}
		}
		return horasMasBajas;
	}
	
	//MÉTODO - Recoge arrays de horas y precios para devolver la hora con el precio más bajo
	private static int horaPrecioMasBajo(int[] horas, double[] precios)
	{
		int horaPrecioMasBajo = horas[0], posicionMin = 0;
		for(int i=0; i<horas.length;i++)
		{
			if(precios[i] < precios[posicionMin])
			{
				posicionMin = i;
				horaPrecioMasBajo = horas[i];
			}
		}
		return horaPrecioMasBajo;
	}
}
