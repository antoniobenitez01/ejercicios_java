/*
 * Objetivo: Programa que crea una matriz de tamaño NxM,
 * introduciendo el valor de N y M por teclado para luego
 * recorrer toda la matriz y mostrar cuantos valores son
 * mayores que cero, cuantos menores que cero y cuantos iguales que cero.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 24/10/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n,m, sumaMayorCero=0, sumaMenorCero=0, sumaIgualCero=0;
		do
		{
			System.out.println("Introduzca el tamaño de la primera dimensión del Array (entero y positivo)");
			n = entradaTeclado.nextInt();
			if(n<0)
			{
				System.out.println("El número introducido es menor que 0, no es válido.");
			}
		}while(n<0);
		
		do
		{
			System.out.println("Introduzca el tamaño de la segunda dimensión del Array (entero y positivo)");
			m = entradaTeclado.nextInt();
			if(m<0)
			{
				System.out.println("El número introducido es menor que 0, no es válido.");
			}
		}while(m<0);		
		int numeros[][] = new int[n][m];
		
		final int FILAS = n, COLUMNAS = m;
		for(int i=0; i < FILAS; i++)
		{
			for(int j=0; j < COLUMNAS; j++)
			{
				System.out.println("Introduzca el valor de [" + i + "] [" + j + "]");
				numeros[i][j] = entradaTeclado.nextInt();
				if(numeros[i][j] > 0)
				{
					sumaMayorCero++;
				}
				else if(numeros[i][j] < 0)
				{
					sumaMenorCero++;
				}
				else
				{
					sumaIgualCero++;
				}
			}
		}
		
		for (int i=0; i< numeros.length; i++) 
		{
		    for (int j=0;j< numeros[i].length;j++) 
		    {
		        System.out.print ("[" + i + "][" + j + "] = " + numeros[i][j] + "    ") ;
		    }
		    System.out.println() ;
		}
		
		System.out.println("La cantidad de números mayor que 0 es: " + sumaMayorCero +
						"\nLa cantidad de números menor que 0 es: " + sumaMenorCero +
						"\nLa cantidad de números igual que 0 es: " + sumaIgualCero);
	}

}
