/*
 * Objetivo: Programa que almacena 50 numeros enteros
 * que se encuentran en el archivo valoresVector.txt
 * para luego mostrar los valores almacenados,
 * el mayor valor y su posición, el menor valor y su posición,
 * la cantidad de valores almacenados entre 0 y 100 y
 * la media de los valores almacenados entre 100 y 200.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 29/10/2024
 */
package ejercicio3;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		int numeros[] = {139, 103, 151, 114, 153, 28, 64, 7, 151, 66, 35, 53, 86, 121, 169, 44, 126, 23, 197, 75, 10, 3, 95, 55, 183, 98, 149, 91, 174, 125, 200, 37, 138, 174, 5, 10, 115, 146, 2, 47, 192, 71, 161, 129, 185, 82, 102, 32, 11, 71};
		int contadorLinea = 0, posicionMax=0, posicionMin=0, numMax, numMin, sumaCeroCien = 0, sumaDoscien = 0, cantidadDoscien = 0;
		double mediaDoscien;
		
		//Mostrar los valores almacenados de 10 en 10
		for(int i=0; i < numeros.length; i++)
		{
			System.out.print(numeros[i] + " ");
			contadorLinea++;
			if(contadorLinea == 10)
			{
				System.out.println(" ");
				contadorLinea = 0;
			}
		}
		
		//Mostrar el mayor valor almacenado y su posición
		numMax = numeros[0];
		for(int i=0; i < numeros.length; i++)
		{
			if(numMax < numeros[i])
			{
				numMax = numeros[i];
				posicionMax = i;
			}
		}
		System.out.println("--------------------------------------------------------------------" +
						 "\nEl valor mayor almacenado es " + numMax + " y su posición es " + posicionMax + ".");
		
		//Mostrar el menor valor almacenado y su posición
		numMin = numeros[0];
		for(int i=0; i < numeros.length; i++)
		{
			if(numMin > numeros[i])
			{
				numMin = numeros[i];
				posicionMin = i;
			}
		}
		System.out.println("El valor menor almacenado es " + numMin + " y su posición es " + posicionMin + ".");
		
		//Mostrar la cantidad de valores almacenados entre 0 y 100
		for(int i=0; i < numeros.length; i++)
		{
			if(numeros[i] >= 0 && numeros[i] <= 100)
			{
				sumaCeroCien++;
			}
		}
		System.out.println("La cantidad de valores entre 0 y 100 son " + sumaCeroCien + ".");
		
		//Mostrar la cantidad de valores almacenados entre 100 y 200
		for(int i=0; i < numeros.length; i++)
		{
			if(numeros[i] >= 100 && numeros[i] <= 200)
			{
				sumaDoscien += numeros[i];
				cantidadDoscien++;
			}
		}
		
		mediaDoscien = (sumaDoscien / cantidadDoscien);
		System.out.println("La media de valores entre 100 y 200 son " + mediaDoscien + ".");
	}
}
