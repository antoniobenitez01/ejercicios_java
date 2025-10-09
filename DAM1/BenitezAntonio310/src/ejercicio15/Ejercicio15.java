/*
 * Objetivo: Programa que pide los valores N y M
 * para luego crear un array del tamaño N y que contenga M en todas
 * sus posiciones, mostrando el array por pantalla.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio15;

import java.util.Scanner;

public class Ejercicio15 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n, m;
		
		//Bucle do while para confirmar que la entrada n es un valor positivo y diferente de 0.
		do
		{
			System.out.println("Introduzca el valor n (entero y positivo).");
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
		
		System.out.println("Introduzca un valor m (entero).");
		m = entradaTeclado.nextInt();		
		
		int[] numeros = new int [n];
		for(int i=0; i < numeros.length; i++)
		{
			numeros[i] = m;
			System.out.println("El valor de la posición " + i + " es " + numeros[i]);
		}
	}

}
