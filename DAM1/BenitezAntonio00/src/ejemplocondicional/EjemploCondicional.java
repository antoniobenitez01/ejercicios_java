/*
 * Objetivo: Pedir un numero para decirte si
 * es impar o par
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/10/2024
 */
package ejemplocondicional;

import java.util.Scanner;

public class EjemploCondicional 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int num1, resto;
		String mensajeFinal;
		
		System.out.println("Introduzca un número entero");
		num1 = entradaTeclado.nextInt();
		
		resto = num1%2;
		mensajeFinal = (resto == 0) ? "El número es par" : "El número es impar";
		System.out.println(mensajeFinal);
	}

}
