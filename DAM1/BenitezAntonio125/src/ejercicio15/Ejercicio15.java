/*
 * Objetivo: Programa que convierte
 * un valor de temperatura Fahrenheit
 * a temperatura Celsius
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio15;

import java.util.Scanner;

public class Ejercicio15 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		float valorFahrenheit, valorCelsius;
		
		System.out.println("Introduzca el valor de temperatura Fahrenheit");
		valorFahrenheit = entradaTeclado.nextFloat();
		
		valorCelsius = (valorFahrenheit - 32) / (float)1.8;
		System.out.println(valorFahrenheit + " grados Fahrenheit son " + valorCelsius + " grados Celsius.");

	}

}
