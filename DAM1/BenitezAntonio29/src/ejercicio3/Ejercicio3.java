/*
 * Objetivo: Programa que muestra los números
 * pares comprendidos entre el 1 y el 200; utilizando
 * un contador y sumando de uno en uno.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio3;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		int num=1;
		
		System.out.println("1");
		for(int i=1; i<=200; i++)
		{
			if(num%2 == 0)
			{
				System.out.println(num);
				num++;
			}
			else
			{
				num++;
			}
		}
	}
}
