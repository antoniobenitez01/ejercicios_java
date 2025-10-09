/*
 * Objetivo: Programa que dice si un numero
 * introducido por teclado es par y/o divisible entre 5
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 25/10/2024
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido;
		
		System.out.println("Introduzca un número entero");
		numIntroducido = entradaTeclado.nextInt();
		if(numIntroducido%2 == 0 && numIntroducido%5 == 0)
		{
			System.out.println(numIntroducido + " es un número par divisible entre 5.");
		}else if(numIntroducido%2 == 0 && numIntroducido%5 != 0)
		{
			System.out.println(numIntroducido + " es un número par pero no divisible entre 5.");
		}
		else if(numIntroducido%2 != 0 && numIntroducido%5 == 0)
		{
			System.out.println(numIntroducido + " es un número impar divisible entre 5.");
		}
		else
		{
			System.out.println(numIntroducido + " es un número impar no divisible entre 5.");
		}
	}

}
