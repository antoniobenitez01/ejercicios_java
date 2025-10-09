/*
 * Objetivo: Programa que crea una matrix 10x10 
 * e introduce los valores de las tablas de multiplicar
 * del 1 al 10, mostrando la matriz por pantalla.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 23/10/2024
 */
package ejercicio2;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		int numeros[][] = new int[10][10];
		final int FILAS = 10;
		final int COLUMNAS = 10;
		
		for(int i=0; i < FILAS; i++)
		{
			for(int j=0; j < COLUMNAS; j++)
			{
				numeros[i][j] = (i+1) * j;
			}
		}
		
		for (int i=0; i< numeros.length; i++) {
		    for (int j=0;j< numeros[i].length;j++) {
		        System.out.print ("[" + (i+1) + "][" + j + "] = " + numeros[i][j] + "    ") ;
		    }
		    System.out.println() ;
		}
	}

}
