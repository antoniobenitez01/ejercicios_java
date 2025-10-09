/*
 * Objetivo: Programa que convierte
 * un valor de Kb a Mb.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio14;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		float valorMb, valorKb;
		
		System.out.println("Introduce el número de Kbs");
		valorKb = entradaTeclado.nextFloat();
		
		valorMb = valorKb / 1000;
		System.out.println(valorKb + " Kbs son " + valorMb + " Mbs.");

	}

}
