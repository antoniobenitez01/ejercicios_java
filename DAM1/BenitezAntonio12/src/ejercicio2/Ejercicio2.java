/*
 * Objetivo: Programa que solitica datos mediante
 * Scanner y luego los muestra de una manera específica.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 01/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner
		Scanner entradaTeclado = new Scanner (System.in);
		
		//Declaración variables
		String nombreEquipo, nombreEstadio, nombreCapitan;
		int anyoFundacion;
		
		//Entrada de variables
		System.out.println("¿Cuál es el nombre del equipo?");
		nombreEquipo = entradaTeclado.nextLine();
		
		System.out.println("¿En qué año se fundó el equipo?");
		anyoFundacion = entradaTeclado.nextInt();
		
		entradaTeclado.nextLine();
		System.out.println("¿Cómo se llama el estadio?");
		nombreEstadio = entradaTeclado.nextLine();
		
		System.out.println("¿Cómo se llama el capitán?");
		nombreCapitan = entradaTeclado.nextLine();
		
		
		//Mostrar información de forma específica
		System.out.println("**********************************************************"
						  + "\n******* Nombre del Equipo: " + nombreEquipo + "****************************"
						  + "\n******* Fundado en: " + anyoFundacion + "***********************************"
						  + "\n******* Estadio: " + nombreEstadio + "**************************************"
						  + "\n******* Capitán: " + nombreCapitan + "*****************************************");
						

	}

}
