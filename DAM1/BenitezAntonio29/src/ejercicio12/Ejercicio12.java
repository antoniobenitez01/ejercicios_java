/*
 * Objetivo: Programa que calcule el valor
 * de A elevado a B sin hacer uso del operador
 * de potencia (^), mostrando el resultado.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/10/2024
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double a, resultado = 1;
		int b;
		
		System.out.println("Introduzca el valor A.");
		a = entradaTeclado.nextDouble();
		System.out.println("Introduzca el valor B (entero).");
		b = entradaTeclado.nextInt();
		
		for(int i=1; i<=(b); i++)
		{
			resultado = resultado * a;
		}
		System.out.println("El resultado de " + a + " elevado a " + b + " es " + resultado);
	}

}
