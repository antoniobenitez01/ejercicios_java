/*
 * Objetivo: Programa que crea un array de tamaño 100
 * de números enteros, rellenado con valores entre 1 y 10;
 * pidiendo luego un valor N para mostrar en qué posiciones
 * aparece en el valor N dentro del array.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n;
		int[] numeros = new int [100];
		
		//Bucle do while para confirmar que la entrada N es un valor entero entre 1 y 10.
		do
		{
			System.out.println("Introduzca el valor N, siendo un valor entero en 1 y 10");
			n = entradaTeclado.nextInt();
			if(n < 1)
			{
				System.out.println("El número introducido es menor que 1, no es válido.");
			}
			else if(n > 10)
			{
				System.out.println("El número introducido es mayor que 10, no es válido.");
			}
		}while ((n < 1) || (n > 10));
		
		for(int i=0; i < numeros.length; i++)
		{
			numeros[i] = (int) (Math.random()* 11);
			if(numeros[i] == n)
			{
				System.out.println("En la posición " + i + " aparece el valor " + numeros[i]);
			}
		}
	}

}
