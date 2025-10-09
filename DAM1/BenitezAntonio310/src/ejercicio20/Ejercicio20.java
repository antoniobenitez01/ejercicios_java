/*
 * Objetivo: Programa que crea un array
 * de tamaño 1000 rellenado con valores enteros
 * aleatorios entre 0 y 99, pidiendo luego un
 * valor N por teclado para mostrar por pantalla
 * si el número introducido existe en el array
 * y cuántas veces se repite.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio20;

import java.util.Scanner;

public class Ejercicio20 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int[] numeros = new int [1000];
		int n, sumaRepite = 0;
		
		for(int i=0; i < numeros.length; i++)
		{
			numeros[i] = (int) (Math.random()* 100);
		}
		
		//Bucle do while para confirmar que el valor N está entre 0 y 99.
		do {
			System.out.println("Introduzca un número entero entre 0 y 99.");
			n = entradaTeclado.nextInt();
			if(n < 0)
			{
				System.out.println("El número introducido es menor que 0.");
			}
			else if(n > 99)
			{
				System.out.println("El número introducido es mayor que 99.");
			}
		}while((n < 0) || (n > 99));
		
		for(int i=0; i < numeros.length; i++)
		{
			if(numeros[i] == n)
			{
				sumaRepite++;
			}
		}
		
		//Condición para mostrar el resultado
		if(sumaRepite > 0)
		{
			System.out.println("El número introducido aparece en el array " + sumaRepite + " veces.");
		}
		else if(sumaRepite == 1)
		{
			System.out.println("El número introducido aparece en el array " + sumaRepite + " vez.");
		}
		else
		{
			System.out.println("El número introducido no aparece en el array");
		}
	}
}
