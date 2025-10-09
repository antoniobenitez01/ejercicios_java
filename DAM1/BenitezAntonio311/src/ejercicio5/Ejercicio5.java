/*
 * Objetivo: Programa que registra los sueldos
 * de hombres y mujeres de una empresa, detectando
 * si existe una brecha salarial entre ellos.
 * Se pide los salarios de N personas, pidiendo
 * el género para cada persona; mostrando el sueldo medio de cada género.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 25/10/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		final int GENEROS = 2;
		int n, genero;
		double numHombre=0, numMujer=0, totalHombre=0, totalMujer=0;
		
		do
		{
			System.out.println("Introduzca el número de personas N (entero y positivo)");
			n = entradaTeclado.nextInt();
			if(n<0)
			{
				System.out.println("El número introducido es menor que 0, no es válido.");
			}
		}while(n<0);
		
		double salarios[][] = new double[n][GENEROS];
		
		for(int i=0; i < n; i++)
		{
			do
			{
				System.out.println("Introduzca el género de la persona " + (i+1) + " (0 para Varón - 1 para Mujer).");
				genero = entradaTeclado.nextInt();
				if(genero != 0 && genero != 1)
				{
					System.out.println("El valor introducido no es válido.");
				}
			}while(genero != 0 && genero != 1);
			System.out.println("Introduzca el salario de la persona " + (i+1));
			salarios[i][genero] = entradaTeclado.nextDouble();
			if(genero == 0)
			{
				totalHombre += salarios[i][genero];
				numHombre++;
			}
			else
			{
				totalMujer += salarios[i][genero];
				numMujer++;
			}
		}
		
		if((totalHombre / numHombre) == (totalMujer / numMujer))
		{
			System.out.println("No hay diferencia entre los salarios de mujer y de hombre");
		}
		else
		{
			if((totalHombre / numHombre) > (totalMujer / numMujer))
			{
				System.out.println("Hay una diferencia salarial de " + ((totalHombre / numHombre) - (totalMujer / numMujer)) + " euros.");
			}
			else
			{
				System.out.println("Hay una diferencia salarial de " + ((totalMujer / numMujer) - (totalHombre / numHombre)) + " euros.");
			}
		}
	}
}
