/*
 * Objetivo: Programa que pide cinco precios y
 * muestre por pantalla el precio de cada venta
 * tras aplicarle el 21% de IVA.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/11/2024
 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double precio;
		
		//Bucle entrada datos de 5 precios y resultado
		for(int i=0; i < 5; i++)
		{
			System.out.println("Introduzca el precio  Nº" + (i+1) + ".");
			precio = entradaTeclado.nextDouble();
			System.out.println("El precio de la venta con IVA es " + precioConIVA(precio) + "€.");
		}
	}

	//MÉTODO - Recoge un precio real para calcular el IVA
	public static double precioConIVA(double precio)
	{
		double iva, resultado;
		iva = (precio * 21) / 100;
		resultado = precio + iva;
		return resultado;
	}
}
