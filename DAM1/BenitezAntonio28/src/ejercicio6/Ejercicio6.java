/*
 * Objetivo: Programa que lee un número y muestra
 * su cuadrado, repitiéndose hasta que se
 * introduzca un 0.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/10/2024
 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 
{

	public static void main(String[] args) 
	{
		//Declaración entrada y variable
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido;
		double numCuadrado;
		
		//Entrada numIntroducido
		System.out.println("Introduzca un número entero para comprobar su potencia" +
						"\n o introduzca un número negativo para apagar el programa.");
		numIntroducido = entradaTeclado.nextInt();
		
		//Bucle while
		while(numIntroducido >= 0) {
			numCuadrado = Math.pow(numIntroducido, 2);
			System.out.println("El cuadrado del número introducido es " + numCuadrado);
			System.out.println("Introduzca otro número entero para comprobar su potencia" +
					"\n o introduzca un número negativo para apagar el programa.");
			numIntroducido = entradaTeclado.nextInt();
		}
		
		//Conclusión / Apagado
		System.out.println("Número negativo introducido, apagando programa.");
	}

}
