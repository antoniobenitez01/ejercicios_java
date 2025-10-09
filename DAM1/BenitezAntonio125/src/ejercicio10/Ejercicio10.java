/*
 * Objetivo: Programa que calcula
 * el área de un triángulo.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		float base, altura, area;
		
		System.out.println("¿Cuál es la base del triángulo?");
		base = entradaTeclado.nextFloat();
		System.out.println("¿Cuál es la altura del triángulo?");
		altura = entradaTeclado.nextFloat();
		
		area = (base * altura) / 2;
		System.out.println("Un rectángulo de " + base + " de base y de " +
						"\n" + altura + " de altura, tiene un área de " + area + ".");
		
	}
	

}
