/*
 * Objetivo: Programa que sirve como
 * calculadora.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 09/10/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		double num1, num2, resultado = 0;
		int numOperacion;
		
		System.out.println("Introduzca un valor");
		num1 = entradaTeclado.nextDouble();
		System.out.println("Introduzca otro valor");
		num2 = entradaTeclado.nextDouble();
		
		System.out.println("Indique la operación que quiere realizar (Inserte un número)" +
						"\n" +
						"\n(1) Suma" +
						"\n(2) Resta" +
						"\n(3) Multiplicación" +
						"\n(4) División" + 
						"\n" +
						"\n------------------------");
		numOperacion = entradaTeclado.nextInt();
		
		switch(numOperacion)
		{
		case 1:
			resultado = num1 + num2;
			break;
		case 2:
			resultado = num1 - num2;
			break;
		case 3:
			resultado = num1 * num2;
			break;
		case 4:
			resultado = num1 / num2;
			break;
		default:
			System.out.println("El número introducido es incorrecto");
		}

		System.out.println("Resultado: " + resultado);
	}

}
