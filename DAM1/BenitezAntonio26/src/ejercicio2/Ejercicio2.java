/*
 * Objetivo: Programa que solicita datos de
 * nombre, edad y nota académica para comprobar
 * si puede acceder a unos estudios que requieren
 * que el usuario sea mayor de 18 y que tenga
 * una nota académica mayor de 7.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 08/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración variables
		String nombre;
		int edad;
		double notaAcademica;
		
		//Entrada de datos
		System.out.println("Introduce tu nombre");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduce tu edad");
		edad = entradaTeclado.nextInt();
		System.out.println("Introduce tu nota académica");
		notaAcademica = entradaTeclado.nextDouble();
		
		//Condicional y resultado
		if((edad >= 18) && (notaAcademica >= 7))
		{
			System.out.println(nombre + ", usted ha sido admitido en el curso, cumple las condiciones requeridas.");
		}
		else
		{
			System.out.println(nombre + ", lo sentimos, no ha sido admitido en el curso ya que no cumple los requisitos mínimos");
		}

	}

}
