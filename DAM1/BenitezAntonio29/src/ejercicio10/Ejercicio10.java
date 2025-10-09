/*
 * Objetivo: Programa que lee una secuencia
 * de notas (valores de 0 a 10) que termina
 * con el valor -1 y nos dice si hubo alguna
 * nota con valor 10.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 16/10/2024
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido, cantidadDiez = 0;
		
		do
		{
			System.out.println("Introduzca una nota del 0 al 10" +
							"\nSi introduce el número -1 el programa se apagará");
			numIntroducido = entradaTeclado.nextInt();
			if(numIntroducido != -1)
			{
				if((numIntroducido < 0) || (numIntroducido > 10))
				{
					System.out.println("La nota introducida no es válida");
				}
				else
				{
					if(numIntroducido == 10)
					{
						cantidadDiez++;
					}
				}
			}
		}while(numIntroducido != -1);
		
		System.out.println("La cantidad de 10 introducidos es: " + cantidadDiez);
		System.out.println("Apagando programa.");
	}

}
