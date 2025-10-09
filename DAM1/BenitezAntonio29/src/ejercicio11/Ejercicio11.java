/*
 * Objetivo: Escribe un programa que suma
 * independientemente los pares y los impares
 * de los números entre 100 y 200 y luego
 * muestra por pantalla ambas sumas.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio11;

public class Ejercicio11 
{
	public static void main(String[] args) 
	{
		int num = 100, sumaPares = 0, sumaImpares = 0;
		
		for(int i=100; i<200; i++)
		{
			if(num%2 == 0)
			{
				sumaPares = sumaPares + num;
			}
			else
			{
				sumaImpares = sumaImpares + num;
			}
			num++;
		}
		
		System.out.println("La suma de los números pares entre 100 y 200 es: " + sumaPares +
						"\nLa suma de los números impares entre 100 y 200 es: " + sumaImpares);
	}
}
