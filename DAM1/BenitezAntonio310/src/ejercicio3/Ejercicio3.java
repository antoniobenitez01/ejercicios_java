/*
 * Objetivo: Programa que pide diez numeros reales
 * por teclado, los almacena en un array y luego
 * lo recorra para averiguar el máximo y el mínimo por pantalla
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double numeroIntroducido, numeroMax = 0, numeroMin = 0;
		double[] numeros = new double [10];
		
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("Introduzca un número real.");
			numeroIntroducido = entradaTeclado.nextDouble();
			numeros[i] =  numeroIntroducido;
		}
		
		numeroMin = numeros[1];
		
		for(int i=0; i < numeros.length; i++)
		{
			if(numeroMax < numeros[i])
			{
				numeroMax = numeros[i];
			}
			if(numeroMin > numeros[i])
			{
				numeroMin = numeros[i];
			}
		}
		
		//Mostramos los valores de cada posición para demostrar que los valores están almacenados correctamente.
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("El valor de la posición " + i + " es " + numeros[i] + ".");
		}
		
		//Resultado Max y Min
		System.out.println("El valor máximo almacenado en el array es: " + numeroMax +
						"\nEl valor mínimo almacenado en el array es: " + numeroMin + ".");
	}
}
