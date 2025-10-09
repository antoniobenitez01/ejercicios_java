/*
 * Objetivo: Programa que calcula
 * el total de una factura a partir 
 * de la base imponible.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio11;

import java.util.Scanner;

public class Ejercicio11 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		double baseImponible, facturaTotal;
		
		System.out.println("¿Cuál es la base imponible de la factura?");
		baseImponible = entradaTeclado.nextDouble();
		
		facturaTotal = baseImponible * 1.21;
		System.out.println("El precio total de la factura es de " + facturaTotal);


	}

}
