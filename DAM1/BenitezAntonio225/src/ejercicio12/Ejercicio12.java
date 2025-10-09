/*
 * Objetivo: Programa que muestra los N primeros
 * números de la secuencia de Fibonacci.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/10/2024
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n, num1 = 0, num2 = 1, resultado;
		
		do
		{
			System.out.println("Introduzca el valor entero N (mayor que uno)");
			n = entradaTeclado.nextInt();
			if(n<1)
			{
				System.out.println("El número introducido es menor que uno, no es válido.");
			}
		}while(n < 1);
		
		System.out.print(num2 + " ");
		for(int i=1; i<n; i++)
		{
			resultado = num1 + num2;
			System.out.print(resultado + " ");
			num1 = num2;
			num2 = resultado;
		}
	}
}
