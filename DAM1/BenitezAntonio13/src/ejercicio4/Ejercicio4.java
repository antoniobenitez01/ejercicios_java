/*
 * Objetivo: Programa que solicita un valor double
 * al usuario y luego calcula las funciones Math
 * de ceil, floor y round con ese número.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/10/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración variables
		double num1, numCeil, numFloor, numRound;
		
		//Solicitud
		System.out.println("Introduzca un número");
		num1 = entradaTeclado.nextDouble();
		
		//Operaciones
		numCeil = Math.ceil(num1);
		numFloor = Math.floor(num1);
		numRound = Math.round(num1);
		
		//Resultado
		System.out.println("Dado el número introducido (" + num1 + "), el número redondeado al mayor es " + numCeil + "," 
						  +"\nel número redondeado al menor es " + numFloor + " y por último el redondeado del número es " + numRound);
	}

}
