/*
 * Objetivo: Programa que pide diez números reales
 * por teclado y los almacena dentro de un array para
 * a continuación mostrar la suma de todos los valores.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double numeroIntroducido, sumaNumeros = 0;
		double[] numeros = new double [10];
		
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("Introduzca un número real.");
			numeroIntroducido = entradaTeclado.nextDouble();
			numeros[i] =  numeroIntroducido;
			sumaNumeros += numeros[i];
		}
		
		//Mostramos los valores de cada posición para demostrar que los valores están almacenados correctamente.
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("El valor de la posición " + i + " es " + numeros[i] + ".");
		}
		
		//Resultado Suma
		System.out.println("La suma de todos los valores almacenados en el Array es: " + sumaNumeros + ".");
	}
}
