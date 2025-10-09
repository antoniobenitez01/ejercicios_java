/*
 * Objetivo: Programa que muestre por pantalla
 * cuantas vocales de cada tipo hay en una frase
 * introducida por teclado sin diferenciar entre
 * mayúsculas y minúsculas.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/11/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String frase;
		int a=0, e=0, i=0, o=0, u=0;
		
		System.out.println("Introduzca una frase.");
		frase = entradaTeclado.nextLine();
		
		frase = frase.toLowerCase();
		
		//Bucle cálculo vocales
		for(int j=0; j<frase.length();j++)
		{
			switch(frase.charAt(j))
			{
			case 'a':
				a++;
				break;
			case 'e':
				e++;
				break;
			case 'i':
				i++;
				break;
			case 'o':
				o++;
				break;
			case 'u':
				u++;
				break;
			}
		}	
		
		//Resultado
		System.out.println("Nº de A's: " + a +
						"\nNº de E's: " + e +
						"\nNº de I's: " + i +
						"\nNº de O's: " + o +
						"\nNº de U's: " + u);
	}
}
