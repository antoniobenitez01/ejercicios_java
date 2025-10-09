/*
 * Objetivo: Programa que ordene
 * 3 números enteros introducidos por teclado
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 25/10/2024
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num1, num2, num3, temp;
		
		System.out.println("Introduzca un primer número entero");
		num1 = entradaTeclado.nextInt();
		System.out.println("Introduzca un segundo número entero");
		num2 = entradaTeclado.nextInt();
		System.out.println("Introduzca un tercer número entero");
		num3 = entradaTeclado.nextInt();
		
		if(num1 > num3)
		{
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if(num1 > num2)
		{
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if(num2 > num3)
		{
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		System.out.println(num1 + "   " + num2 + "   " + num3);
	}

}
