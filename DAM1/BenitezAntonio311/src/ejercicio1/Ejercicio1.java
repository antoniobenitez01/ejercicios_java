/*
 * Objetivo: Programa que muestra una matriz de
 * tamaño 5x5 que almacena los números del 1
 * al 25 y luego muestre la matriz por pantalla.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 23/10/2024
 */
package ejercicio1;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		int numeros[][] = new int[5][5];
		final int FILAS = 5;
		final int COLUMNAS = 5;
		int acumulador = 1;
		
		for(int i=0; i < FILAS; i++)
		{
			for(int j=0; j < COLUMNAS; j++)
			{
				numeros[i][j] = acumulador;
				acumulador++;
			}
		}
		
		for (int i=0; i< numeros.length; i++) {
		    for (int j=0;j< numeros[i].length;j++) {
		        System.out.print ("[" + i + "][" + j + "] = " + numeros[i][j] + "    ") ;
		    }
		    System.out.println() ;
		}
	}

}
