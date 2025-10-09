/*
 * Objetivo: Programa que calcula y escribe
 * la suma y el producto de los 10 primeros números naturales.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num = 1, numSuma = 0, numProducto = 1;
		
		for(int i=0; i<10; i++)
		{
			System.out.println(num);
			numSuma = numSuma + num;
			System.out.println("La suma es: " + (numSuma));
			numProducto = numProducto * num;
			System.out.println("El producto es: " + (numProducto));
			num++;
		}
	}

}
