/*
 * Objetivo: Programa que pide un número entero por
 * teclado y muestra si es positivo, negativo o cero.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/11/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num;
		
		System.out.println("Introduzca un número entero.");
		num = entradaTeclado.nextInt();
		
		switch(dimeSigno(num))
		{
		case -1:
			System.out.println("El número entero " + num + " es negativo.");
			break;
		case 0:
			System.out.println("El número entero " + num + " es cero.");
			break;
		case 1:
			System.out.println("El número entero " + num + " es positivo.");
			break;
		}
	}

	//MÉTODO - Recoge un valor entero y calcula si es negativo, igual que cero o positivo
	public static int dimeSigno(int a)
	{
		int resultado;
		
		if(a < 0)
		{
			resultado = -1;
		}
		else if(a == 0)
		{
			resultado = 0;
		}
		else
		{
			resultado = 1;
		}
		
		return resultado;
	}
}
