/*
 * Objetivo: Programa que pida diez números reales
 * por teclado, los almacene en un array y luego
 * muestre todos los valores
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double numeroIntroducido;
		double[] numeros = new double [10];
		
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("Introduzca un número real.");
			numeroIntroducido = entradaTeclado.nextDouble();
			numeros[i] =  numeroIntroducido;
		}
		
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("El valor de la posición " + i + " es " + numeros[i] + ".");
		}
	}
}
