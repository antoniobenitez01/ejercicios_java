/*
 * Objetivo: Programa que pida al usuario un valor entero A
 * y luego muestre por pantalla un mensaje acorde a lo introducido.
 * Excepciones: InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 29/11/2024
 */
package ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int a = inputInt("Introduzca un valor entero.", entradaTeclado);
		System.out.println("Valor introducido: " + a);
	}
	
	//MÉTODO - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
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
}
