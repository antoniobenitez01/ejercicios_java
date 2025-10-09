/*
 * Objetivo: Programa que calcula
 * el área de un rectángulo.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		float ancho, largo, area;
		
		System.out.println("¿Cuál es el ancho del rectángulo?");
		ancho = entradaTeclado.nextFloat();
		System.out.println("¿Cuál es el largo del rectángulo?");
		largo = entradaTeclado.nextFloat();
		
		area = ancho * largo;
		System.out.println("Un rectángulo de " + ancho + " de ancho y de " +
						"\n" + largo + " de largo, tiene un área de " + area + ".");

	}

}
