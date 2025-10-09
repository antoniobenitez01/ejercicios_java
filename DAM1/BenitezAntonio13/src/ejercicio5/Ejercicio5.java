/*
 * Objetivo: Programa que solicite dos números 
 * al usuario y realice una serie de cálculos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/10/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración variables
		int num1, num2;
		double resultadoComparacion, resultadoElevado, resultadoRaiz, resultadoRandom;
		
		//Entrada de valores
		System.out.println("Introduzca un número entero.");
		num1 = entradaTeclado.nextInt();
		System.out.println("Introduzca otro número entero.");
		num2 = entradaTeclado.nextInt();
		
		//Operaciones y resultado
		resultadoComparacion = Math.min(num1, num2);
		System.out.println("El número menor es " + resultadoComparacion);
		
		resultadoElevado = Math.pow(num1, num2);
		System.out.println(num1 + " elevado a " + num2 + " es igual a " + resultadoElevado);
		
		resultadoRaiz = Math.sqrt(num1);
		System.out.println("La raíz cuadrada de " + num1 + " es " + resultadoRaiz);
		
		resultadoRandom = (int)(Math.random() * num2);
		System.out.println("Un valor random de " + num2 + " puede ser " + resultadoRandom);
		
	}

}
