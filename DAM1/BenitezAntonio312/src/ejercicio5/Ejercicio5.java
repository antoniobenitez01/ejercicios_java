/*
 * Objetivo: Programa que lee una frase por teclado e
 * indica si la frase es un palíndromo o no (ignorando
 * espacios y sin diferenciar enter mayúsculas ni minúsculas).
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/11/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String frase, temp = "";
		
		System.out.println("Introduzca una frase (sin comas, ni puntos, ni acentos, etc.).");
		frase = entradaTeclado.nextLine();
		
		//Reducimos la frase a minúsculas y borramos los espacios
		frase = frase.toLowerCase();
		frase = frase.replaceAll("\\s", "");
		
		//Bucle String temp = frase al revés
		for (int i = 0; i < frase.length(); i++) 
		{
			temp = frase.charAt(i) + temp;
		}
		
		//Condición y resultado
		if(temp.equals(frase))
		{
			System.out.println("La frase es un palíndromo.");
		}
		else
		{
			System.out.println("La frase no es un palíndromo.");
		}
	}
}
