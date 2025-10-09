/*
 * Objetivo: Programa que hace uso de
 * do while para mostrar todos los números
 * desde el 1 hasta el 100.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/10/2024
 */
package ejercicio2;

public class Ejercicio2
{

	public static void main(String[] args)
	{
		//Declaración variable
		int num1 = 1;
		
		//Bucle do-while
		do {
			System.out.println(num1);
			num1++;
		}while (num1 <=100);
	}

}
