/*
 * Objetivo: Programa que pida veinte numeros enteros
 * por teclado, los almacene en un array y luego
 * muestre por separado la suma de todos los valores
 * positivos y negativos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numeroIntroducido, sumaPositivo = 0, sumaNegativo = 0;
		int[] numeros = new int [20];
		
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("Introduzca un número entero");
			numeroIntroducido = entradaTeclado.nextInt();
			numeros[i] =  numeroIntroducido;
			if(numeros[i] >= 0)
			{
				sumaPositivo += numeros[i];
			}
			else
			{
				sumaNegativo += numeros[i];
			}
		}
		
		//Mostramos los valores de cada posición para demostrar que los valores están almacenados correctamente.
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("El valor de la posición " + i + " es " + numeros[i]);
		}
		
		//Resultado suma positivos y suma negativos
		System.out.println("La suma de todos los valores positivos es: " + sumaPositivo +
						"\nLa suma de todos los valores negativos es: " + sumaNegativo);
	}

}
