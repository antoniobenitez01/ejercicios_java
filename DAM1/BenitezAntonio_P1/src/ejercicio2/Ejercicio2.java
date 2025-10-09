/*
 * Objetivo: Programa que solicite al usuario
 * dos caracteres y compruebe si son iguales o no.
 * Si se escribe "n" o "N" en el primer caracter y
 * "o" o "O" en el segundo caracter el programa se apagará.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 29/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		char char1, char2;
		String entrada;
		do
		{
			System.out.println("------------------------------------------------------------------------" +
							"\nIntroduzca el primer carácter (se cogerá el primer carácter del mensaje introducido)." +
							"\nIntroduzca 'n' o 'N' para apagar el programa.");
			entrada = entradaTeclado.nextLine();
			char1 = entrada.charAt(0);
			
			System.out.println("Introduzca el segundo carácter (se cogerá el primer carácter del mensaje introducido)." +
							"\nIntroduzca 'o' o 'O' para apagar el programa.");
			entrada = entradaTeclado.nextLine();
			char2 = entrada.charAt(0);
			
			if((char1 == 'n' || char1 == 'N') && (char2 == 'o' || char2 == 'O'))
			{
				System.out.println("Ha seleccionado apagar el programa.");
			}
			else if (char1 == char2)
			{
				System.out.println("Los dos caracteres introducidos son iguales.");
			}
			else
			{
				System.out.println("Los dos caracteres introducidos no son iguales.");
			}
		}while((char1 != 'n' && char1 != 'N') && (char2 != 'o' && char2 != 'O'));
		System.out.println("Apagando programa...");
	}
}
