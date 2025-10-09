/*
 * Objetivo: Programa que pregunta por la edad,
 * si el usuario es mayor de 18 entonces además
 * se le preguntará por el nombre y apellidos para
 * formar un mensaje acorde a los datos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 08/10/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int edad;
		String nombre, apellidos;
		
		System.out.println("¿Cuántos años tienes?");
		edad = entradaTeclado.nextInt();
		
		if(edad >= 18)
		{
			entradaTeclado.nextLine();
			System.out.println("Introduzca su nombre");
			nombre = entradaTeclado.nextLine();
			System.out.println("Introduzca sus apellidos");
			apellidos = entradaTeclado.nextLine();
			
			System.out.println("Nombre: " + nombre
							+ "\nApellidos: " + apellidos
							+ "\nEdad: " + edad
							+ "\n"
							+ "\nUsted ha sido admitido.");
		}
		else
		{
			System.out.println("No tiene la edad requerida para realizar estos estudios");
		}


	}

}
