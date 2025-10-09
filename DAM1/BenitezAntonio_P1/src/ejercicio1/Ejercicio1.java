/*
 * Objetivo: Programa que pida hora y minutos y te 
 * muestre un mensaje dependiendo de la hora y minutos introducidos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 29/10/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int horaInt, minInt, minTotal = 0;
		String nombre;
		
		System.out.println("Introduzca su nombre.");
		nombre = entradaTeclado.nextLine();
		
		//Comprobación de entrada correcta de datos de hora y minutos
		do
		{
			System.out.println("Introduzca la hora (de 0 a 24).");
			horaInt = entradaTeclado.nextInt();
			if(horaInt < 0 || horaInt > 24)
			{
				System.out.println("La hora introducida no es válida.");
			}
		}while(horaInt < 0 || horaInt > 24);

		do
		{
			System.out.println("Introduzca los minutos (de 0 a 60).");
			minInt = entradaTeclado.nextInt();
			if(minInt < 0 || minInt > 60)
			{
				System.out.println("Los minutos introducidos no son válidos.");
			}
		}while(minInt < 0 || minInt > 60);
		
		//Cálculo de minutos totales y resultado final
		minTotal+= (horaInt*60);
		minTotal+= minInt;
		if(minTotal <= 720)
		{
			System.out.println("Buenos días, " + nombre + ".");
		}
		else if(minTotal >= 721 && minTotal <= 990)
		{
			System.out.println("Buena sobremesa, " + nombre + ".");
		}
		else if(minTotal >= 991 && minTotal <= 1230)
		{
			System.out.println("Buenas tardes, " + nombre + ".");
		}
		else
		{
			System.out.println("Buenas noches, " + nombre + ".");
		}
	}
}
