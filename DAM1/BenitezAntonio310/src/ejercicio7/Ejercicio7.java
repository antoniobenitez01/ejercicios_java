/*
 * Objetivo: Programa que pide dos valores enteros P y Q,
 * creando un array que contenga todos los valores desde P hasta Q
 * y mostrándolos por pantalla a continuación
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int p, q;		
		
			System.out.println("Introduzca el valor entero P.");
			p = entradaTeclado.nextInt();
		
		//Bucle do while para confirmar que la entrada Q es mayor que P.
		do
		{
			System.out.println("Introduzca el valor entero Q (mayor que P).");
			q = entradaTeclado.nextInt();
			if(q < p)
			{
				System.out.println("El número introducido es menor que P, no es válido.");
			}
		}while (q < p);
		
		//Creación Array con Valores Q y P
		int[] numeros = new int [(q - p) + 1];
		for(int i = 0; i < numeros.length; i++)
		{
			numeros[i] = p;
			p++;
		}
		
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("El valor de la posición " + i + " es " + numeros[i]);
		}
	}

}
