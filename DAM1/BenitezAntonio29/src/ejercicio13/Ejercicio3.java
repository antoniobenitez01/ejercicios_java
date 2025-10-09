/*
 * Objetivo: Programa que intenta
 * adivinar un número  del 1 al 100 que el usuario 
 * piensa mediante comandos de "Mayor" o "Menor".
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/10/2024
 */
package ejercicio13;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numAdivinar;
		char charOperador;
		String entradaUsuario;
		
		numAdivinar = (int)(Math.random() * 101);
		
		do
		{
			System.out.println("¡Voy a adivinar su número!");
			System.out.println("¿Tu número es " + numAdivinar + "?" +
							"\nEscriba 'Y' para sí, 'M' para mayor o 'N' para menor");
			entradaUsuario = entradaTeclado.nextLine();
			charOperador = entradaUsuario.charAt(0);
			
			if(charOperador != 'Y')
			{
				if(charOperador == 'M')
				{
					numAdivinar++;
				}
				else if (charOperador == 'N')
				{
					numAdivinar--;
				}
				else
				{
					System.out.println("El comando introducido no es válido.");
				}
			}
			
		}while(charOperador != 'Y');
		
		System.out.println("¡Perfecto! He adivinado tu número.");
	}

}
