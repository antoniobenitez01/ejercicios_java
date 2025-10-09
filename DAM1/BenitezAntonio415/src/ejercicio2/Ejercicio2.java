/*
 * Objetivo: Programa que utiliza un método para 
 * calcular el descuento de una compra a partir
 * de los datos de cantidad, precio y descuento
 * Autor: Antonio Benitez Rodríguez
 * Fecha: 15/11/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double precio;
		String nombre;
		int cantidad, descuento;
		
		System.out.println("Escriba el nombre del producto.");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduzca el precio del producto.");
		precio = entradaTeclado.nextDouble();
		System.out.println("Introduzca la cantidad del producto comprada.");
		cantidad = entradaTeclado.nextInt();
		System.out.println("Introduzca el porcentaje entero de descuento aplicado.");
		descuento = entradaTeclado.nextInt();
		
		System.out.println("Usted ha adquirido " + cantidad + " de productos " + nombre + ", a un precio de " + precio + " euros la unidad." +
						"\nEl precio a pagar es " + precio + ", pero al aplicarlo un descuento del " + descuento + "% el precio final a pagar es: " + productosDescuento(precio, cantidad, descuento) + ".");
	}
	
	//MÉTODO - Recoge valores de precio, cantidad y descuento para calcular el precio total
	public static double productosDescuento(double precio, int cantidad, int descuento)
	{
		double resultado = 0, descuentoFinal;
		descuentoFinal = descuento;
		
		resultado = precio * cantidad;
		descuentoFinal = descuentoFinal / 100;
		resultado = resultado * descuentoFinal;
		return resultado;
	}
}
