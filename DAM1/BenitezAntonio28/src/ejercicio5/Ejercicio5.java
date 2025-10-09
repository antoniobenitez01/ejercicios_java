/*
 * Objetivo: Programa que pide 10 números
 * y muestra la media de los números positivos,
 * la media de los números negativos y
 * la cantidad de ceros.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/10/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		//Declaración entrada y variables
		Scanner entradaTeclado = new Scanner(System.in);
		double mediaPositivo = 0, mediaNegativo = 0;
		int numIntroducido, cantidadCero = 0, cantidadPositivo = 0, cantidadNegativo = 0, totalPositivo = 0, totalNegativo = 0, contador = 1;
		
		//Bucle do-while
		do
		{
			System.out.println("Introduzca un número entero (positivo, negativo o 0)");
			numIntroducido = entradaTeclado.nextInt();
			if(numIntroducido < 0) {
				totalNegativo = totalNegativo + numIntroducido;
				cantidadNegativo++;
			}
			else if(numIntroducido > 0) {
				totalPositivo = totalPositivo + numIntroducido;
				cantidadPositivo++;
			}
			else {
				cantidadCero++;
			}
			contador++;
		}while(contador <= 10);
		
		//Operación final y resultado
		mediaPositivo = totalPositivo / cantidadPositivo;
		mediaNegativo = totalNegativo / cantidadNegativo;
		System.out.println("La media de números positivos es " + mediaPositivo +
						"\nLa media de números negativos es " + mediaNegativo +
						"\nLa cantidad de ceros introducidos es " + cantidadCero);

	}

}
