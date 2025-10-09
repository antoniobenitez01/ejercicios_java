/*
 * Objetivo: Programa que traduce kilómetros a millas
 * mediante una función que recoge el valor de
 * kilómetros y devuelve el valor en millas.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double km;
		
		System.out.println("Introduzca el número de kilómetros.");
		km = entradaTeclado.nextDouble();
		
		System.out.println(km + " kilómetros son " + kilometrosMillas(km) + " millas.");
	}
	
	//MÉTODO - Recoge el valor de kilometros y calcula el valor en millas
	public static double kilometrosMillas(double km)
	{
		double resultado;
		resultado = km/1.60934;
		return resultado;
	}
}
