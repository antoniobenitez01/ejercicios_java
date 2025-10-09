/*
 * Objetivo: Programa que pregunta los siguientes datos:
 * Nombre, Direccón y Teléfono y escriba a continuación
 * una ficha acorde a los datos introducidos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		String nombre, direccion;
		int telefono;
		
		System.out.println("¿Cuál es su nombre?");
		nombre = entradaTeclado.nextLine();
		System.out.println("¿Cuál es su dirección?");
		direccion = entradaTeclado.nextLine();
		System.out.println("¿Cuál es su número de teléfono?");
		telefono = entradaTeclado.nextInt();
		
		System.out.println("Nombre: " + nombre +
						"\nDirección: " + direccion +
						"\nTeléfono: " + telefono); 

	}

}
