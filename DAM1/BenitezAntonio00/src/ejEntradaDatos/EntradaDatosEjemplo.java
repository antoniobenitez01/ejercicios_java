/*
 * Objetivo: Programa que recoge tus datos de
 * Nombre, Edad, Peso y Población
 * y luego te los imprime en orden.
 * Autor: Antonio Benítez
 * Fecha: 01/10/2024
 */
package ejEntradaDatos;

import java.util.Scanner;

public class EntradaDatosEjemplo 
{

	public static void main(String[] args) 
	{
		//Declaración Scanner
		Scanner entradaTeclado = new Scanner (System.in);
		
		//Declaración variables
		String nombre, poblacion;
		byte edad;
		double peso;
		
		//Entrada variables
		System.out.println("¿Cómo te llamas?");
		nombre = entradaTeclado.nextLine();
		
		System.out.println("¿Cuántos años tienes?");
		edad = entradaTeclado.nextByte();
		
		System.out.println("¿Cuánto pesas?");
		peso = entradaTeclado.nextDouble();
		
		entradaTeclado.nextLine(); //Depuración entrada
		System.out.println("¿Dónde vives?");
		poblacion = entradaTeclado.nextLine();
		
		//Resultado
		System.out.println("Tu nombre es " + nombre + "."
							+ "\nTienes " + edad + " años."
							+ "\nPesas " + peso + " KGs."
							+ "\nVives en " + poblacion + ".");
		
	}

}
