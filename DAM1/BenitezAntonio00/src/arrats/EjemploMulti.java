/*
 * Objetivo: Aplicacion pedir notas de matematicas, lengua e ingles
 * de 5 alumnos al usuario para luego mostrarlas
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package arrats;

import java.util.Scanner;

public class EjemploMulti 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		final int FILAS = 5;
		final int COLUMNAS = 3;
		int notaIntroducida;
		
		int[][] notasAlumnos = new int [FILAS][COLUMNAS];
		
		for (int i = 0; i < FILAS; i++ )
		{
			for (int j = 0; j < COLUMNAS; j++)
			{
				do
				{
					switch(j)
					{
					case 0:
						System.out.println("Introduzca la nota de Matemáticas del alumno " + (i+1) + " (del 0 al 10).");
						break;
					case 1:
						System.out.println("Introduzca la nota de Lengua del alumno " + (i+1) + " (del 0 al 10).");
						break;
					case 2:
						System.out.println("Introduzca la nota de Inglés del alumno " + (i+1) + " (del 0 al 10).");
						break;
					}
					notaIntroducida = entradaTeclado.nextInt();
					
					if(notaIntroducida < 0)
					{
						System.out.println("La nota introducida es menor de 0, no es válida.");
					}
					else if(notaIntroducida > 10)
					{
						System.out.println("La nota introducida es mayor de 10, no es válida.");
					}
					else
					{
						notasAlumnos[i][j] = notaIntroducida;
					}
				}while(notaIntroducida < 0 || notaIntroducida > 10);
			}
		}
		
		//Resultado Mostrar
		for (int i = 0; i < FILAS; i++) 
		{
		    for (int j = 0; j < COLUMNAS; j++) 
		    {
				switch(j)
				{
				case 0:
					System.out.print ("[" + i + "][Matemáticas] = " + notasAlumnos[i][j] + "    ") ;
					break;
				case 1:
					System.out.print ("[" + i + "][Lengua] = " + notasAlumnos[i][j] + "    ") ;
					break;
				case 2:
					System.out.print ("[" + i + "][Inglés] = " + notasAlumnos[i][j] + "    ") ;
					break;
				} 
		    }
		}
	}
}
