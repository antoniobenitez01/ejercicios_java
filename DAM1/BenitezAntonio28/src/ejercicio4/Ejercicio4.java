/*
 * Objetivo: Programa que solicita al usuario
 * valores positivos dentro de un bucle y almacena
 * la suma de todos los valores y la cantidad
 * de números introducidos. El bucle se detendrá
 * cuando se introduzca un 0 y mostrará la cantidad
 * de números mayores de 0 y la media de los mismos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/10/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		//Declaración entrada y variables
		Scanner entradaTeclado = new Scanner(System.in);
		int numeroIntroducido, sumaNumeros = 0, cantidadNumeros = 0;
		double mediaNumeros;
		
		//Entrada valor inicial
		System.out.println("Introduzca un número positivo o 0 para apagar el programa.");
		numeroIntroducido = entradaTeclado.nextInt();
		
		//Bucle while y comprobacion número positivo
		while(numeroIntroducido != 0)
		{
			if(numeroIntroducido < 0)
			{
				System.out.println("El número es negativo y no se ha añadido.");
			}
			else
			{
				cantidadNumeros++;
				sumaNumeros = sumaNumeros + numeroIntroducido;	
				System.out.println("Número añadido.");
			}
			
			System.out.println("Introduzca otro número positivo o 0 para apagar el programa.");		
			numeroIntroducido = entradaTeclado.nextInt();
		}
		
		//Resultado cantidad y media
		mediaNumeros = sumaNumeros / cantidadNumeros;
		System.out.println("La cantidad de números introducidos es: " + cantidadNumeros +
						"\nLa media de todos los números introducidos es: " + mediaNumeros);
		


	}

}
