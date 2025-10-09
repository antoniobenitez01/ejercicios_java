/*
 * Objetivo: Programa que pida dos cadenas de texto
 * y luego indique si son iguales, además de si
 * son iguales sin diferenciar entre mayúsculas y minúsculas.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 30/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String entrada1, entrada2;
		
		System.out.println("Introduzca una cadena de texto.");
		entrada1 = entradaTeclado.nextLine();
		System.out.println("Introduzca otra cadena de texto.");
		entrada2 = entradaTeclado.nextLine();
		
		if(entrada1.equals(entrada2))
		{
			System.out.println("Sin ignorar las mayúsculas y minúsculas, las dos cadenas de texto son iguales.");
		}
		else
		{
			System.out.println("Sin ignorar las mayúsculas y minúsculas, las dos cadenas de texto no son iguales.");
		}
		
		if(entrada1.equalsIgnoreCase(entrada2))
		{
			System.out.println("Ignorando las mayúsculas y minúsculas, las dos cadenas de texto son iguales.");
		}
		else
		{
			System.out.println("Ignorando las mayúsculas y minúsculas, las dos cadenas de texto no son iguales.");
		}
	}
}
