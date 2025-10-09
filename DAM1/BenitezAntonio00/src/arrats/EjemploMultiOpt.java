package arrats;

import java.util.Scanner;

public class EjemploMultiOpt 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		final int NUM_ALUMNOS = 5;
		final int NUM_MATERIAS = 3;
		int notas [][] = new int [5][3];
		int suma[] = new int [5];
		String [] nombreAlumnos = new String[NUM_ALUMNOS];
		String [] nombreMaterias = {"Matemáticas", "Lengua", "Inglés"};
		
		for(int i = 0; i < NUM_ALUMNOS; i++)
		{
			System.out.println("Introduzca el nombre del alumno " + i);
			nombreAlumnos[i] = entradaTeclado.nextLine();
		}
		
		for(int i = 0; i < NUM_ALUMNOS; i++)
		{
			for (int j = 0; j < NUM_MATERIAS; j++)
			{
				notas[i][j] = (int) (Math.random()*11);
			}
		}
		
		for(int i = 0; i < NUM_ALUMNOS; i++)
		{
			System.out.print(nombreAlumnos[i] + ": ");
			for (int j = 0; j < NUM_MATERIAS; j++)
			{
				System.out.print(nombreMaterias[j] + ": " + notas[i][j] + "      ");
				suma[i] += notas[i][j];
			}
			System.out.println("La media de las notas del Alumno " + i + " es " + ((float) suma[i] / NUM_MATERIAS));
			System.out.println();
		}
	}
}
