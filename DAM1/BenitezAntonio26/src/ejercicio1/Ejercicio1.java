/*
 * Objetivo: Programa que solicita
 * datos num1 y num2 y comprueba si
 * num1 es mayor que num2, si es
 * viceversa o si son iguales.
 * Autor: Antonio Benítez Rodríguez
 * Fecha:08/10/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);

		//Declaración variables
		int num1, num2;
		
		//Entrada variables
		System.out.println("Introduzca un número entero.");
		num1 = entradaTeclado.nextInt();
		System.out.println("Introduzca otro número entero");
		num2 = entradaTeclado.nextInt();
		
		//Condicional y  resultado
		if (num1 > num2)
		{
			System.out.println(num1 + " es mayor que " + num2 + ".");
		}
		else if (num1 < num2)
		{
			System.out.println(num1 + " es menor que " + num2 + ".");
		}
		else
		{
			System.out.println(num1 + " es igual que " + num2 + ".");
		}
	}

}
