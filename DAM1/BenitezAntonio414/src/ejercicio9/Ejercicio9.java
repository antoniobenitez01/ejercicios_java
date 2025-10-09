/*
 * Objetivo: Programa que pide tres valores enteros y
 * nos dice cual de ellos es el más pequeño mediante
 * solo una función que pida dos números y devuelva el
 * mínimo de los dos números.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num1, num2, num3, numMinimo;
		
		System.out.println("Introduzca un número entero.");
		num1 = entradaTeclado.nextInt();
		System.out.println("Introduzca otro número entero.");
		num2 = entradaTeclado.nextInt();
		System.out.println("Introduzca un último número entero.");
		num3 = entradaTeclado.nextInt();
		
		//Cálculo número mínimo y resultado
		numMinimo = calculoMinimo(num1, num2);
		numMinimo = calculoMinimo(numMinimo, num3);
		System.out.println("El número más pequeño de los números introducidos es: " + numMinimo);
	}
	
	//MÉTODO - Recoge dos valores y devuelve el valor más pequeño
	public static int calculoMinimo(int a, int b)
	{
		int numMin;
		if(a<b)
		{
			numMin = a;
		}
		else
		{
			numMin = b;
		}
		return numMin;
	}
}
