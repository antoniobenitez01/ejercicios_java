/*
 * Objetivo: Programa que escriba la tabla de multiplicar
 * de un número introducido por teclado mediante una función
 * que recibe el número y muestra por pantalla la tabla de multiplicar
 * del dato introducido.
 * Autor: Antonio Benitez Rodriguez
 * Fecha: 12/11/2024
 */
package ejercicio11;

import java.util.Scanner;

public class Ejercicio11 
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
