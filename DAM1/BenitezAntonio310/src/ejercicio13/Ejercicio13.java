/*
 * Objetivo: Programa que almacena una secuencia aritmética en
 * un array para luego mostrarla, solicitando el número inicial (V),
 * su incremento (I) y el número de valores a crear (N)
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio13;

import java.util.Scanner;

public class Ejercicio13 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int v, i, n;
		
		System.out.println("Introduzca el valor inicial entero (V)");
		v = entradaTeclado.nextInt();
		System.out.println("Introduzca el incremento entero (I)");
		i = entradaTeclado.nextInt();
		//Bucle do while para confirmar que la entrada N es un valor positivo y diferente de 0.
		do
		{
			System.out.println("Introduzca el número entero y positivo de valores a crear (N).");
			n = entradaTeclado.nextInt();
			if(n < 0)
			{
				System.out.println("El número introducido es negativo, no es válido.");
			}
			else if (n == 0)
			{
				System.out.println("El número introducido es cero, no es válido.");
			}
		}while (n <= 0);
		
		//Array
		int[] numeros = new int [n];
		numeros[0] = v;
		System.out.println("El valor en la posición 0 es " + numeros[0]);
		for(int j=1; j < (numeros.length); j++)
		{
			numeros[j] = numeros[j-1] + i;
			System.out.println("El valor en la posición " + j + " es " + numeros[j]);
		}
	}

}
