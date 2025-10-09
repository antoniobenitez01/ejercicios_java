/*
 * Objetivo: Programa que crea un array del tamaño
 * introducido por teclado y lo rellena de valores aleatorios
 * mediante una función
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio16;

import java.util.Scanner;

public class Ejercicio16 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n;
		
		do
		{
			System.out.println("Introduzca el tamaño del array. (Mayor que 1)");
			n = entradaTeclado.nextInt();
			if(n<1)
			{
				System.out.println("El valor introducido no es válido.");
			}
		}while(n<1);
		
		double[] numeros = new double [n];
		rellenarArray(numeros);
		
		for(int i=0;i<numeros.length;i++)
		{
			System.out.printf("%.2f ", numeros[i]);
		}
	}
	
	//MÉTODO - Recoge un array y lo rellena de números aleatorios
	public static void rellenarArray(double[] numeros)
	{
		for(int i=0; i<numeros.length;i++)
		{
			numeros[i] = Math.random();
		}
	}
}
