/*
 * Objetivo: Programa que preguntar por tu nombre
 * y escriba su texto correspondiente.
 * Autor: Antonio Benítez Rodríguez
 * Fecha:07/10/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración de variable
		String nombre;
		
		//Entrada de nombre
		System.out.println("¿Cómo te llamas?");
		nombre = entradaTeclado.nextLine();
		
		//Resultado
		System.out.println("Hola " + nombre + ".");

	}

}
