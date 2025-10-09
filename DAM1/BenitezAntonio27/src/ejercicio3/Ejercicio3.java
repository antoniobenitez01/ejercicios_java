/*
 * Objetivo: Programa que solicita
 * al usuario una nota en valor entero
 * y realiza comprobaciones con la nota
 * mediante un switch.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 09/10/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración variables
		int notaEntera;
		
		//Entrada variable nota
		System.out.println("Introduzca su nota entera");
		notaEntera = entradaTeclado.nextInt();
		
		//Condicional Switch
		switch(notaEntera)
		{
		case 0:
			System.out.println("Tiene una nota suspensa.");
			break;
		case 1:
			System.out.println("Tiene una nota suspensa.");
			break;
		case 2:
			System.out.println("Tiene una nota suspensa.");
			break;
		case 3:
			System.out.println("Tiene una nota suspensa.");
			break;
		case 4:
			System.out.println("Tiene una nota suspensa.");
			break;
		case 5:
			System.out.println("Tiene una nota aprobada.");
			break;
		case 6:
			System.out.println("Tiene una nota buena.");
			break;
		case 7:
			System.out.println("Tiene una nota notable.");
			break;
		case 8:
			System.out.println("Tiene una nota notable.");
			break;
		case 9:
			System.out.println("Tiene una nota sobresaliente.");
			break;
		case 10:
			System.out.println("Tiene una nota sobresaliente.");
			break;
		default:
			System.out.println("El número introducido es inválido.");
		}
	}

}
