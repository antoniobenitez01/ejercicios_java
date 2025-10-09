/*
 * Objetivo: Programa que 3 valores enteros se 
 * ajustan a la ecuación de Pitágoras (x2 + y2 = z2),
 * solicitando los valores X, Y y Z; utilizando una
 * función que compruebe la ecuación con esos valores
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio19;

import java.util.Scanner;

public class Ejercicio19 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int x,y,z;
		
		System.out.println("Introduzca el valor X.");
		x = entradaTeclado.nextInt();
		System.out.println("Introduzca el valor Y.");
		y = entradaTeclado.nextInt();
		System.out.println("Introduzca el valor Z.");
		z = entradaTeclado.nextInt();
		
		if(ecuacionPitagoras(x, y, z) == true)
		{
			System.out.println("Los números introducidos son iguales.");
		}
		else
		{
			System.out.println("Los números introducidos no son iguales.");
		}
	}
	
	//MÉTODO - Recoge 3 números y realizar la ecuación de Pitágoras para determinars si son iguales o no
	public static boolean ecuacionPitagoras(int x, int y, int z)
	{
		boolean esIgual;
		if(Math.pow(x,2) + Math.pow(y, 2) == (Math.pow(z, 2)))
		{
			esIgual = true;
		}
		else
		{
			esIgual = false;
		}
		return esIgual;
	}
}
