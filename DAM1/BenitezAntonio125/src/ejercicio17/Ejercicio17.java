/*
 * Objetivo: Programa que calcula factura total a partir
 * de la base imponible (precio sin IVA).
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio17;

import java.util.Scanner;

public class Ejercicio17 
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
