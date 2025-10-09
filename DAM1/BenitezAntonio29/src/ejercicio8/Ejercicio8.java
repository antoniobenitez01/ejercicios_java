/*
 * Objetivo: Programa que lea una secuencia
 * de números no nulos hasta que se introduzca un 0 para
 * luego mostrar si ha leído algún número negativo y muestre
 * la cantidad de números negativos y positivos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 
{
	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido, cantidadNegativo = 0, cantidadPositivo = 0;
		do
		{
			System.out.println("Introduzca un número entero" +
							"\nSi el número introducido es 0 se apagará el programa.");
			numIntroducido = entradaTeclado.nextInt();
			if(numIntroducido != 0)
			{
				if(numIntroducido < 0)
				{
					System.out.println("He leído un número negativo.");
					cantidadNegativo++;
				}
				else
				{
					cantidadPositivo++;
				}
			}
		}while(numIntroducido != 0);
		
		System.out.println("La cantidad de números positivos es: " + cantidadPositivo +
						"\nLa cantidad de números negativos es: " + cantidadNegativo +
						"\nApagando el programa.");
	}

}
