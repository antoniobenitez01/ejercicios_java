/*
 * Objetivo: Programa que imprime las tablas de
 * multiplicar del 1 al 10 de un número introducido
 * mediante una función
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio20;

import java.util.Scanner;

public class Ejercicio20 
{
	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num;
		
		System.out.println("Introduzca un número entero.");
		num = entradaTeclado.nextInt();
		
		tablaMultiplicar(num);
	}
	
	//MÉTODO - Recoge un valor int y muestra la tabla de multiplicar de ese número
	public static void tablaMultiplicar(int num)
	{
		for(int i=1; i <= 10; i++)
		{
			System.out.println(num + " x " + i + " = " + (num*i));
		}
	}
}
