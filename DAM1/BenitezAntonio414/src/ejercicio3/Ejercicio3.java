/*
 * Objetivo: Programa que pide dos números enteros por teclado
 * y muestra por pantalla cual es el mínimo
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/11/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("Introduzca un número entero.");
		num1 = entradaTeclado.nextInt();
		System.out.println("Introduzca otro número entero.");
		num2 = entradaTeclado.nextInt();
		
		System.out.println("El número mínimo introducido es " + minimo(num1, num2));
	}
	
	//MÉTODO - Recoje los valores enteros y calcula cuál es el mínimo
	public static int minimo(int a, int b)
	{
		int numMin = 0;
		
		if(a > b)
		{
			numMin = b;
		}
		else
		{
			numMin = a;
		}
		
		return numMin;
	}
}
