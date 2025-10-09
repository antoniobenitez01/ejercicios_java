/*
 * Objetivo: Programa que lea 100 números no nulos para 
 * luego decir si ha leído un número negativo o no.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido;
		for(int i=1; i<100; i++)
		{
			System.out.println("Introduzca un número no nulo.");
			numIntroducido = entradaTeclado.nextInt();
			
			if(numIntroducido < 0)
			{
				System.out.println("He leído un número negativo.");
			}
		}
	}
}
