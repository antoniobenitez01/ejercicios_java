/*
 * Objetivo: Programa que crea un vector double de tamaño 5 y
 * mediante un bucle pide cinco valores por teclado y los introduce en el vector
 * Excepciones: InputMismatchException, IndexOutOfBoundsException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 29/11/2024
 */
package ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double[] numerosDecimales = new double[5];
		
		//EXCEPCIÓN - IndexOutOfBoundsException, si se introduce un valor fuera del rango del array como la longitud del bucle For, te avisa
		try
		{
			for(int i=0; i<numerosDecimales.length;i++) 
			{
				numerosDecimales[i] = inputDouble("Introduzca un valor decimal.", entradaTeclado);
			}
		}catch (IndexOutOfBoundsException excepcion2)
		{
			System.out.println("Se ha introducido un valor fuera del rango establecido del array.");
		}
		
		//Mostramos el array vectorDouble
		System.out.println("");
		for(int i=0; i<numerosDecimales.length;i++)
		{
			//DETALLE - Deja de imprimir guiones en el último valor del array
			if(i == (numerosDecimales.length-1))
			{
				System.out.print(numerosDecimales[i]);
			}
			else
			{
				System.out.print(numerosDecimales[i] + " || ");
			}
		}
	}
	
	//MÉTODO - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Double correctamente
	public static double inputDouble(String mensaje, Scanner entrada)
	{
		double num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextDouble();
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
