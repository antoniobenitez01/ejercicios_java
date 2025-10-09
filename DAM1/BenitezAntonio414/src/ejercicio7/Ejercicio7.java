/*
 * Objetivo: Programa que pide el ancho y el alto
 * de un rectángulo para luego mostrar el área y
 * el perímetro
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/11/2024
 */
package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double ancho, alto;
		
		System.out.println("Introduzca el ancho del rectángulo.");
		ancho = entradaTeclado.nextDouble();
		System.out.println("Introduzca el alto del rectángulo.");
		alto = entradaTeclado.nextDouble();
		
		System.out.println("El área del rectángulo es " + areaRectangulo(ancho, alto) + " y el perímetro es " + perimetroRectangulo(ancho, alto) + ".");
	}
	
	//MÉTODO - Recoge dos valores reales de ancho y alto para calcular el área
	public static double areaRectangulo(double ancho, double alto)
	{
		double resultado;
		resultado = ancho * alto;
		return resultado;
	}
	//MÉTODO - Recoge dos valores reales de ancho y alto para calcular el perímetro
	public static double perimetroRectangulo(double ancho, double alto)
	{
		double resultado;
		resultado = (2*ancho) + (2*alto);
		return resultado;
	}
}
