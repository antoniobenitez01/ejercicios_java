/*
 * Objetivo: Programa que pide al usuario 20 valores enteros
 * e introduzca los diez primeros en un array y los diez
 * últimos en otro array, comparando los dos arrays
 * y diciéndole al usuario si son iguales o no.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio17;

import java.util.Scanner;

public class Ejercicio17 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido, sumaIgual = 0;
		int[] numeros1 = new int [10];
		int[] numeros2 = new int [10];
		
		//Array 1
		System.out.println("-------- ARRAY 1 ---------");
		for(int i=0; i < numeros1.length; i++)
		{
			System.out.println("Introduzca un número entero.");
			numIntroducido = entradaTeclado.nextInt();
			numeros1[i] =  numIntroducido;
		}
		//Array 2
		System.out.println("-------- ARRAY 2 ---------");
		for(int i=0; i < numeros2.length; i++)
		{
			System.out.println("Introduzca un número entero.");
			numIntroducido = entradaTeclado.nextInt();
			numeros2[i] =  numIntroducido;
		}
		
		for(int i=0; i < numeros1.length; i++)
		{
			if(numeros1[i] == numeros2[i])
			{
				sumaIgual++;
			}
		}
		
		if(sumaIgual == 10)
		{
			System.out.println("Los dos arrays creados son iguales.");
		}
		else
		{
			System.out.println("Los dos arrays creados no son iguales");
		}
		
	}

}
