/*
 * Objetivo: Programa que pida la usuario dos valores entero A y B,
 * calculándo su división a continuación y mostrando el resultado por pantalla.
 * Excepciones: InputMismatchException, ArithmeticException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 29/11/2024
 */
package ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int a = inputInt("Introduzca el primer número entero.", entradaTeclado);
		int b = inputInt("Introduzca el segundo número entero.", entradaTeclado);
		System.out.println("El resultado de la división es: " + divisionCheck(a,b)); 
	}
	
	//MÉTODO - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor entero
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
	
	//MÉTODO - Recoge dos valores enteros, devuelve el resultado de la división y comprueba si la división es posible
	public static double divisionCheck(int a, int b)
	{
		double resultado = 0;
		//EXCEPCIÓN - ArithmeticException - Nos aseguramos de que la división es posible
		try
		{
			resultado = (a/b);
		}
		catch(ArithmeticException excepcion2)
		{
			System.out.println("La operación es inválida.");
		}
		return resultado;
	}
}
