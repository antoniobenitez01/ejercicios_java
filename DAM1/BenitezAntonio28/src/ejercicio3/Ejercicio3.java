/*
 * Objetivo: Programa que hace uso de
 * do while para mostrar todos los números
 * desde el 100 hasta el 1.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/10/2024
 */
package ejercicio3;

public class Ejercicio3 
{

	public static void main(String[] args)
	{
		//Declaración variable
		int num1 = 100;
		
		//Bucle do-while
		do {
			System.out.println(num1);
			num1--;
		}while (num1 >=1);
	}

}
