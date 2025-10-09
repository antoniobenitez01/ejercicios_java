/*
 * Objetivo: Programa que lea 100 números no-nulos
 * y luego muestre un mensaje que indique cuántos números
 * son positivos y cuantos negativos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 
{


	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido, contadorPositivo=0, contadorNegativo=0;
		for(int i=0; i<100; i++)
		{
			System.out.println("Introduzca un número no nulo.");
			numIntroducido = entradaTeclado.nextInt();
			
			if(numIntroducido < 0)
			{
				contadorNegativo++;
			}
			else
			{
				contadorPositivo++;
			}
		}
		System.out.println("La cantidad de números positivos es: " + contadorPositivo +
						"\nLa cantidad es números negativos es: " + contadorNegativo);
	}

}
