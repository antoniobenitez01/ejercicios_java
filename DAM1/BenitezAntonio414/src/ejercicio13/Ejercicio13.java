/*
 * Objetivo: Programa que calcula el porcentaje de
 * descuento que nos han hecho al comprar algo, utilizando
 * una función que recoja el valor sin descuento y con descuento
 * y nos devuelva el porcentaje en %.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio13;

import java.util.Scanner;

public class Ejercicio13 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double precioSin, precioCon;
		
		System.out.println("Introduzca el precio sin descuento.");
		precioSin = entradaTeclado.nextDouble();
		do
		{
			System.out.println("Introduzca el precio con descuento.");
			precioCon = entradaTeclado.nextDouble();
			if(precioCon > precioSin)
			{
				System.out.println("El precio con descuento no puede ser mayor que el precio sin descuento.");
			}
		}while(precioCon > precioSin);
		
		System.out.println("Precio sin descuento: " + precioSin + " €" +
						"\nPrecio con descuento: " + precioCon + " €");
		System.out.printf("Porcentaje de descuento: %.2f", porcentajeDescuento(precioSin, precioCon));
		System.out.print("%");
	}
	
	//MÉTODO - Recoge los precios sin y con descuento y calcula el porcentaje de descuento
	public static double porcentajeDescuento(double precioSin, double precioCon)
	{
		double cantidadDescuento, porcentaje;
		cantidadDescuento = precioSin - precioCon;
		porcentaje = (cantidadDescuento * 100)/precioSin;
		return porcentaje;
	}
}
