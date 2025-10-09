/*
 * Objetivo: Programa que pide un número
 * entero al usuario y luego te muestra
 * la suma de sus cifras.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/10/2024
 */
package ejercicio16;

import java.util.Scanner;

public class Ejercicio16 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n, suma = 0;
		
		do
		{
			System.out.println("Introduzca un número entero y positivo.");
			n = entradaTeclado.nextInt();
			if(n < 0)
			{
				System.out.println("El número introducido es negativo, no es válido.");
			}
		}while(n < 0);
		
		while(n != 0)
		{
			suma += n%10;
			n = n/10;
		}
		System.out.println("La suma de las cifras del número introducido es " + suma + ".");
	}
}
