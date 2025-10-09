/*
 * Objetivo: Programa que almacena las notas de 4 alumnos
 * en 5 asignaturas, introduciendo las notas por teclado,
 * mostrando la nota mínima, máxima y media de cada alumno.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 25/10/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		final int NUM_ALUMNOS = 4;
		final int NUM_MATERIAS = 5;
		double notas [][] = new double [NUM_ALUMNOS][NUM_MATERIAS];
		//Arrays para almacenar los valores de nota media, máxima y mínima de cada alumno en su posición correspondiente
		double suma[] = new double[NUM_ALUMNOS];
		double notaMax[] = new double[NUM_ALUMNOS];
		double notaMin[] = new double[NUM_ALUMNOS];
		
		for(int i = 0; i < NUM_ALUMNOS; i++)
		{
			for (int j = 0; j < NUM_MATERIAS; j++)
			{
				do
				{
					System.out.println("Introduzca la nota de: Alumno " + (i+1) + " Materia: " + (j+1) + " (De 0 a 10)");
					notas[i][j] = entradaTeclado.nextDouble();
					if(notas[i][j] < 0)
					{
						System.out.println("La nota introducida es menor que 0, no es válida.");
					}
					else if(notas[i][j] > 10)
					{
						System.out.println("La nota introcudia es mayor que 10, no es válida.");
					}
				}while((notas[i][j] < 0) || (notas[i][j] > 10));
			}
			System.out.println("-------------------");
		}
		
		for(int i = 0; i < NUM_ALUMNOS; i++)
		{
			notaMin[i] = notas[i][0];
			System.out.print("\nAlumno " + (i+1) + ": ");
			for (int j = 0; j < NUM_MATERIAS; j++)
			{
				System.out.print("Materia " + (j+1) + ": " + notas[i][j] + "      ");
				suma[i] += notas[i][j];
				if(notaMax[i] < notas[i][j])
				{
					notaMax[i] = notas[i][j];
				}
				if(notaMin[i] > notas[i][j])
				{
					notaMin[i] = notas[i][j];
				}
			}
			System.out.println("\n" +
					 		"\nLa nota máxima del Alumno " + (i+1) + " es " + notaMax[i] +
							"\nLa nota mínima del Alumno " + (i+1) + " es " + notaMin[i] +
							"\nLa media de las notas del Alumno " + (i+1) + " es " + ((float) suma[i] / NUM_MATERIAS));
			System.out.println("\n-------------------------");
		}
	}
}
