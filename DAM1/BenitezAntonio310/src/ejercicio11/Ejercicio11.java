/*
 * Objetivo: Programa que crea dos array de números 
 * enteros de tamaño 100; a continuación introduce todos
 * los valores del 1 al 100 en un array y se copian
 * los valores en inverso al otro array.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio11;

public class Ejercicio11 
{

	public static void main(String[] args) 
	{
		int[] numeros = new int [100];
		System.out.println("-------------- PRIMER ARRAY ----------------");
		for(int i=0; i < numeros.length; i++)
		{
			numeros[i] = (i+1);
			System.out.println("El número en la posición " + i + " es " + numeros[i]);
		}
		
		int[] numerosInversos = new int [100];
		System.out.println("-------------- SEGUNDO ARRAY ----------------");
		for(int i=0; i < numerosInversos.length; i++)
		{
			numerosInversos[i] = numeros[99 - i];
			System.out.println("El número en la posición " + i + " es " + numerosInversos[i]);
		}
	}
}
