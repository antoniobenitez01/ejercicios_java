/*
 * Objetivo:Calcular la superficie y volúmen
 * de una esfera a partir de un radio.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio16;

import java.util.Scanner;

public class Ejercicio16 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		double radio, superficie, volumen, pi = 3.1415;
		
		System.out.println("¿Cuál es el radio de la esfera?");
		radio = entradaTeclado.nextDouble();
		
		superficie = 4 * pi * Math.pow(radio, 2);
		volumen = 1.3 * pi * Math.pow(radio, 3);
		System.out.println("Dado el radio de la esfera " + radio +
						"\n la superficie de la esfera es de " + superficie + 
						"\n y el volúmen de la esfera es " + volumen);
	}

}
