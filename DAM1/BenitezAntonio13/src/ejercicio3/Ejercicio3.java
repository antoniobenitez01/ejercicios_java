/*
 * Objetivo: Programa que intercambia los valores
 * de variables num1 y num2 entre sí.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/10/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración variables
		int num1, num2, tempNum;
		
		//Solicitud valores
		System.out.println("Introduzca un número entero.");
		num1 = entradaTeclado.nextInt();
		
		System.out.println("Introduzca otro número entero.");
		num2 = entradaTeclado.nextInt();
		
		//Intercambio de valores
		tempNum = num1;
		num1 = num2;
		num2 = tempNum;
		
		//Resultado
		System.out.println("El valor del primer número es " + num1 + " y el valor del segundo número es " + num2 + ".");
	

	}

}
