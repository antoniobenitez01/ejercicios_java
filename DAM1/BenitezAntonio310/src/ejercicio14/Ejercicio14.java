/*
 * Objetivo: Programa que crea un array de enteros
 * una secuencia de valores hasta introducir 10 veces,
 * mostrando los valores por pantalla
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio14;

public class Ejercicio14 
{

	public static void main(String[] args) 
	{
		int[] numeros = new int [55];
		int posicion = 0;
		
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < i; j++)
			{
				numeros[posicion] = i;
				posicion++;
			}
		}
		
		for(int i = 0; i < (numeros.length); i++)
		{
			System.out.println("El valor en la posición " + i + " es " + numeros[i]);
		}
	}
}
