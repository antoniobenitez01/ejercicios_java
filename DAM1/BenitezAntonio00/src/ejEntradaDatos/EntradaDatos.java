/*
 * Objetivo: Ejemplo de Entrada de Datos
 * Autor: Antonio Benítez
 * Fecha: 01/10/2024
 */
package ejEntradaDatos;

import java.util.Scanner;

public class EntradaDatos 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner (System.in);
		
		int num1, num2, suma;
		
		System.out.println("Escribe un número.");
		num1 = entradaTeclado.nextInt();
		
		System.out.println("Escribe otro número.");
		num2 = entradaTeclado.nextInt();
		
		suma = num1 + num2;
		System.out.println("La suma de los dos números es: " + suma);
	}

}
