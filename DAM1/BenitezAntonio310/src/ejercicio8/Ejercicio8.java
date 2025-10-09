/*
 * Objetivo: Programa que crea un array con 100 números reales aleatorios
 * entre 0.0 y 1.0, utilizando Math.random() para luego pedirle un valor
 * real (R) al usuario, mostrando cuántos valores son igual o superiores que R
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double r;
		int sumaValores = 0;
		double[] numeros = new double [100];
		
		//Bucle do while para confirmar que la entrada R es un valor entre 0,1 y 1,0.
		do
		{
			System.out.println("Introduzca el valor R, siendo un valor entre 0,1 y 1,0.");
			r = entradaTeclado.nextDouble();
			if(r < 0.1)
			{
				System.out.println("El número introducido es menor que 0,1, no es válido.");
			}
			else if(r > 1.0)
			{
				System.out.println("El número introducido es mayor que 1,0, no es válido.");
			}
		}while ((r < 0.1) || (r > 1.0));
		
		
		for(int i=0; i < numeros.length; i++)
		{
			numeros[i] = Math.random();
			if(numeros[i] >= r)
			{
				sumaValores++;
			}
		}
		System.out.println("La cantidad total de valores mayor que R es " + sumaValores);
	}

}
