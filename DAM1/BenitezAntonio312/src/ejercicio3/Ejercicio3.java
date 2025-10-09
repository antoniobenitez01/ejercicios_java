/*
 * Objetivo: Programa que pide por teclado
 * tres cadenas de texto: nombre, apellido 1 y apellido 2.
 * Luego mostrará un código de usuario (mayúsculas) formado por
 * la concatenación de las tres primeras letras de cada uno de ellos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/11/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String nombre, apellido1, apellido2, resultado;
		
		System.out.println("Introduzca su nombre.");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduzca su primer apellido.");
		apellido1 = entradaTeclado.nextLine();
		System.out.println("Introduzca su segundo apellido");
		apellido2 = entradaTeclado.nextLine();
		
		resultado = nombre.substring(0,3).concat(apellido1.substring(0,3).concat(apellido2.substring(0,3)));
		resultado = resultado.toUpperCase();
		System.out.println(resultado);
	}
}
