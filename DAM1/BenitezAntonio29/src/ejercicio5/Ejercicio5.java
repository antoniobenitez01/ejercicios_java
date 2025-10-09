/*
 * Objetivo: Programa que lea un número positivo N
 * y calcule su factorial N!.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n = 1, nFinal, contador = 1;
		
		System.out.println("Introduzca el valor N (entero y positivo).");
		n = entradaTeclado.nextInt();
		nFinal = n;
		
		for(int i=1; i<=(n-1); i++)
		{
			nFinal = nFinal * (n-contador);
			contador++;
		}
		
		System.out.println("El factorial del número introducido es: " + nFinal);
	}

}
