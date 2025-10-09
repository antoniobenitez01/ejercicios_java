/*
 * Objetivo: Programa que pide veinte numeros reales
 * por teclado, los almacena en un array y luego los
 * recorre para mostrar la media de todos los valores.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double mediaNumeros, numeroIntroducido, sumaNumeros = 0;
		
		double[] numeros = new double [20];
		
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("Introduzca un número real");
			numeroIntroducido = entradaTeclado.nextDouble();
			numeros[i] =  numeroIntroducido;
			sumaNumeros += numeros[i];
		}
		
		//Mostramos los valores de cada posición para demostrar que los valores están almacenados correctamente.
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("El valor de la posición " + i + " es " + numeros[i]);
		}
		
		//Operación y resultado media		
		mediaNumeros = sumaNumeros / numeros.length;
		System.out.println("La media de todos los valores del Array es: " + mediaNumeros);
	}

}
