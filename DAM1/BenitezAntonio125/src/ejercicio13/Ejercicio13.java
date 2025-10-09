/*
 * Objetivo: Programa que convierte
 * un valor de Mb a Kb.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio13;

import java.util.Scanner;

public class Ejercicio13 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		float valorMb, valorKb;
		
		System.out.println("Introduce el número de Mbs");
		valorMb = entradaTeclado.nextFloat();
		
		valorKb = valorMb * 1000;
		System.out.println(valorMb + " Mbs son " + valorKb + " Kbs.");
	}

}
