/*
 * Objetivo: Programa que muestre los números pares
 * comprendidos entre 1 y 200; creado mediante un
 * contador	y suma de 2 en 2.
 * Autor: Antonio Benítez Rodríguez
 * Fecha:16/10/2024
 */
package ejercicio2;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		int num=2;
		
		System.out.println("1");
		for(int i=1; i<=100; i++)
		{
			System.out.println(num);
			num = num + 2;
		}
	}
}
