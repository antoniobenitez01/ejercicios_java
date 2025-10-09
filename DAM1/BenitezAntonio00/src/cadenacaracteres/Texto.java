/*
 * Objetivo: Programa que te pide tu nombre y 
 * te calcula la longitud del nombre introducido
 * y te muestra el primer carácter y el último carácter
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 02/10/2024
 */
package cadenacaracteres;

import java.util.Scanner;

public class Texto 
{

	public static void main(String[] args) 
	{
		//Inicializacion variables
		Scanner entradaTeclado = new Scanner (System.in);
		int nombreLongitud;
		char primerCaracter, ultimoCaracter;
		String nombre;
		
		//Pregunta nombre
		System.out.println("¿Cuál es tu nombre?");
		nombre = entradaTeclado.nextLine();
		
		//Cálculo de longitud y caracteres
		nombreLongitud = nombre.length();
		primerCaracter = nombre.charAt(0);
		ultimoCaracter = nombre.charAt(nombre.length()-1);
		//Resultado
		System.out.println("Tu nombre tiene " + nombreLongitud + " letras."
						  + "\n La primera letra de tu nombre es " + primerCaracter
						  + "\n La última letra de tu nombre es " + ultimoCaracter);
	}

}
