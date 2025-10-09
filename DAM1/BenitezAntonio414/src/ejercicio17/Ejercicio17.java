/*
 * Objetivo: Programa que pida numeros enteros hasta que
 * introduzcamos el número 0, diciendo si cada número es primo o no
 * mediante una función que devuelva si es primo o no
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio17;

import java.util.Scanner;

public class Ejercicio17 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num;
		
		do
		{
			System.out.println("Introduzca un número entero, introduzca 0 para apagar el programa.");
			num = entradaTeclado.nextInt();
			if(num == 0)
			{
				System.out.println("Apagando programa...");
			}
			else
			{
				if(esPrimo(num) == true)
				{
					System.out.println("El número " + num + " es primo.");
				}
				else
				{
					System.out.println("El número " + num + " no es primo.");
				}
			}
		}while(num != 0);
	}
	
	//MÉTODO - Recoge un número entero y comprueba si es primo o no
	public static boolean esPrimo(int num)
	{
		boolean esPrimo = true;
		int contador=2;
		
		if(num == 0 || num == 1)
		{
			esPrimo = false;
		}
		else
		{
			do
			{
				if(num%contador==0)
				{
					esPrimo = false;
				}
				contador++;
			}while(contador < num && esPrimo == false);
		}
		return esPrimo;
	}
}
