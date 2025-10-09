/*
 * Objetivo: Programa que resuelve una 
 * ecuación de segundo grado (ax2 + bx + c = 0)
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double x, a, b, c;
		
		System.out.println("Este programa está diseñado para resolver la siguiente ecuación:" +
						"\nax2 + bx + c = 0" +
						"\nSi se introduce '-1' en todos los valores, se apagará el programa.");
		do
		{
			System.out.println("---------------------------------"
							+ "\nIntroduce un valor real para B.");
			b = entradaTeclado.nextDouble();
			//Comprobación a != -(b/2)
			do
			{
				System.out.println("Introduce un valor real para 'A' que no sea -(b/2).");
				a = entradaTeclado.nextDouble();
				if(a == -(b/2))
				{
					System.out.println("El valor de 'A' no puede ser -(b/2).");
				}
			}while(a == -(b/2));
			System.out.println("Introduce un valor real para C.");
			c = entradaTeclado.nextDouble();
			if(a == -1 && b == -1 && c == -1)
			{
				System.out.println("Apagando el programa.");
			}
			else
			{
				//Operación
				x = -(c/((2*a) + b));
				System.out.println("El resultado de la ecuación es: x = " + x);
			}
		}while(a != -1 && b != -1 && c != -1);
	}

}
