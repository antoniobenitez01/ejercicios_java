/*
 * Objetivo: Programa que pide dos números reales por
 * teclado y muestra el resultado de su multiplicación
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/11/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double num1, num2;
		
		System.out.println("Introduzca un número real.");
		num1 = entradaTeclado.nextDouble();
		System.out.println("Introduzca otro número real.");
		num2 = entradaTeclado.nextDouble();
		
		System.out.println("El resultado de la multiplicación de los valores introducidos es: " + multiplica(num1, num2) + ".");
	}
	
	//MÉTODO - Recoje dos valores reales y calcula su multiplicación
	public static double multiplica(double num1, double num2)
	{
		double resultado;
		resultado = num1 * num2;
		return resultado;
	}

}
