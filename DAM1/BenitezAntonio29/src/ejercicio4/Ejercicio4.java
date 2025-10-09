/*
 * Objetivo: Programa que muestre los números desde el 1 hasta
 * el número N que se introduce por teclado.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int N, num = 1;
		
		System.out.println("Introduzca el valor (entero y positivo) de N." +
						"\nSi el valor es negativo o 0 el programa se apagará.");
		N = entradaTeclado.nextInt();
		
		if(N < 0)
		{
			System.out.println("El valor introducido es negativo, apagando programa.");
		}
		else if (N == 0)
		{
			System.out.println("El valor introducido es 0, apagando programa.");
		}
		else
		{
			for(int i=1; i<=N; i++)
			{
				System.out.println(num);
				num++;
			}			
		}
	}
}
