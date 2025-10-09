/*
 * Objetivo: Programa que resuelve una ecuación de
 * primer grado (ax + b = 0).
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double a, x, b;
		
		System.out.println("Este programa está diseñado para resolver la siguiente ecuación:" +
						"\nax + b = 0" +
						"\nSi se introduce '-1' en todos los valores, se apagará el programa.");
		do
		{
			//Comprobación a != 0
			do
			{
				System.out.println("----------------------------------------------"
								+ "\nIntroduce un valor real para 'A' que no sea 0.");
				a = entradaTeclado.nextDouble();
				if(a == 0)
				{
					System.out.println("El valor de 'A' no puede ser 0.");
				}
			}while(a == 0);
			System.out.println("Introduce un valor real para B.");
			b = entradaTeclado.nextDouble();
			if(a == -1 && b == -1)
			{
				System.out.println("Apagando el programa.");
			}
			else
			{
				x = -(b/a);
				System.out.println("El resultado de la ecuación es: x = " + x);
			}
		}while(a != -1 && b != -1);
	}
}
