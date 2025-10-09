/*
 * Objetivo: Programa que transforma una cantidad
 * introducida de pesetas en euros y viceversa.
 * Autor: Antonio Benítez Rodríguez
 * Fecha:04/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración variables
		double euroIntroducido, euroResultado, pesetaIntroducida, pesetaResultado, valorPesetas = 166.386;
		
		//Solicitud de euros
		System.out.println("Introduza una cantidad de Euros");
		euroIntroducido = entradaTeclado.nextFloat();
		
		//Cálcula euro a pesetas y muestra de resultado
		pesetaResultado = valorPesetas * euroIntroducido;
		System.out.println(euroIntroducido + " euros son " + pesetaResultado + " pesetas.");
		
		//Solicitud de pesetas
		System.out.println("Introduza una cantidad de Pesetas");
		pesetaIntroducida = entradaTeclado.nextFloat();
		
		//Cálcula pesetas a euros y muestra de resultado
		euroResultado = pesetaIntroducida / valorPesetas;
		System.out.println(pesetaIntroducida + " pesetas son " + euroResultado + " euros.");

	}

}
