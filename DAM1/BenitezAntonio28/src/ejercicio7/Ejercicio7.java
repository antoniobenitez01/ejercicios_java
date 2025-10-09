/*
 * Objetivo: Juego que adivina un número,
 * pidiendo un número para luego indicarte
 * si estás introduciendo números mayores o
 * menores, terminando cuando el usuario acierta.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/10/2024
 */
package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numN, numIntroducido;
		
		numN = (int)(Math.random() * 101);
		
		System.out.println(numN);
		System.out.println("¡Adivina mi número! Introduzca un número entero del 0 al 100 para comenzar.");
		numIntroducido = entradaTeclado.nextInt();
		
		while(numIntroducido != numN) {
			if(numIntroducido < numN)
			{
				System.out.println("El número introducido es menor que mi número.");
			}
			else
			{
				System.out.println("El número introducido es mayor que mi número.");
			}
			System.out.println("Introduzca otro número entero del 0 al 100.");
			numIntroducido = entradaTeclado.nextInt();
		}
		System.out.println("¡Felicidades! Has adivinado mi número");
	}

}
