/*
 * Objetivo: Programa que utiliza un método para comprobar
 * si dos nombres introducidos por teclados son iguales
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 15/11/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String nombre1, nombre2;
		
		System.out.println("Introduzca un nombre.");
		nombre1 = entradaTeclado.nextLine();
		System.out.println("Introduzca otro nombre.");
		nombre2 = entradaTeclado.nextLine();
		
		if(comparaNombres(nombre1, nombre2) == true)
		{
			System.out.println("Los nombres " + nombre1 + " y " + nombre2 + " son iguales.");
		}
		else
		{
			System.out.println("Los nombres " + nombre1 + " y " + nombre2 + " no son iguales.");
		}

	}
	
	//MÉTODO - Recoge dos cadenas de caracteres (nombres) y compara si son iguales o no, devolviendo un booleano
	public static boolean comparaNombres(String nombre1, String nombre2)
	{
		boolean igual;
		if(nombre1.equals(nombre2))
		{
			igual = true;
		}
		else
		{
			igual = false;
		}
		return igual;
	}

}
