/*
 * Objetivo: Programa que muestra por pantalla un triángulo
 * mediante una función que recoge dos parámetros: un carácter 
 * y el número de líneas del triángulo.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio14;

import java.util.Scanner;

public class Ejercicio14 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String entrada;
		char caracter;
		int num;
		
		System.out.println("Introduzca el carácter de la pirámide." +
						"\nSolo se tendrá en cuenta el primer carácter.");
		entrada = entradaTeclado.nextLine();
		caracter = entrada.charAt(0);
		
		do
		{
			System.out.println("Introduzca el número de líneas de la pirámide." +
							"\nEl número tiene que ser mayor o igual que 1");
			num = entradaTeclado.nextInt();
			if(num < 1)
			{
				System.out.println("El número introducido es menor que 1.");
			}
		}while(num < 1);
		
		piramide(caracter, num);
	}
	
	//MÉTODO - Recoge un carácter y un número de líneas entero y crea una pirámide a partir de esos valores
	public static void piramide(char caracter, int num)
	{
		for(int i=0; i<(num+1); i++)
		{
            for (int j=(num+1)-i; j>1; j--)
            {
                System.out.print(" ");
            }
            
			for(int j=0; j<i; j++)
			{
				System.out.print(caracter + " ");
			}
			System.out.println("");
		}
	}
}
