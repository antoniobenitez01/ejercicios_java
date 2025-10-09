/*
 * Objetivo: Programa que pide la edad por teclado
 * y muestra por pantalla si el usuario es mayor de edad
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/11/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int edad;
		
		System.out.println("Introduzca su edad.");
		edad = entradaTeclado.nextInt();
		
		if(esMayorEdad(edad) == true)
		{
			System.out.println("Usted es mayor de edad.");
		}
		else
		{
			System.out.println("Usted no es mayor de edad.");
		}
	}
	
	//MÉTODO - Recoje el valor de edad para comprobar si es mayor de edad o no
	public static boolean esMayorEdad(int a)
	{
		boolean mayorEdad;
		if(a >= 18)
		{
			mayorEdad = true;
		}
		else
		{
			mayorEdad = false;
		}
		return mayorEdad;
	}

}
