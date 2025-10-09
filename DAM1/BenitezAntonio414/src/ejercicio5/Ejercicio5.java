/*
 * Objetivo: Programa que pide un valor entero en millas
 * y muestre el equivalente en kilometros (1 milla = 1,60934 km)
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/11/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int millas;
		
		System.out.println("Introduzca el número entero de millas.");
		millas = entradaTeclado.nextInt();
		
		System.out.println("El equivalente de " + millas + " millas en kilómetros es " + millas_a_kilometros(millas) + ".");
	}
	
	//MÉTODO - Recoge un valor entero de millas para calcular el equivalente en kilometros
	public static double millas_a_kilometros(int millas)
	{
		double resultado;
		resultado = 1.60934 * millas;
		return resultado;
	}
}
