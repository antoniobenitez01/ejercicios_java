/*
 * Objetivo: Programa que pide una cadena de texto
 * y luego muestre cada palabra de la cadena en una línea distinta.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 30/10/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String entrada;
		String regex = " ";
	
		System.out.println("Introduzca una cadena de caracteres.");
		entrada = entradaTeclado.nextLine();
		
		String [] stringPalabras = entrada.split(regex);
		for(int i=0; i<stringPalabras.length;i++)
		{
			System.out.println(stringPalabras[i]);
		}
	}
}
