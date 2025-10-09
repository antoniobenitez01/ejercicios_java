/*
 * Objetivo: Programa que crea un array de tamaño 30
 * y lo rellena con valores aleatorios entre 0 y 9 para
 * luego ordenar los valores y mostrarlos por pantalla.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio18;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio18 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int[] numeros = new int [10];
		
		for(int i=0; i < numeros.length; i++)
		{
			numeros[i] = (int) (Math.random()* 10);
		}
		
		
    	//Bucle for para ordenar números, recorriendo todas las posiciones
		Arrays.sort(numeros);
        
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("El valor de la posición " + i + " es " + numeros[i] + ".");
		}
	}

}
