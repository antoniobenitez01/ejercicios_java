/*
 * Objetivo: Programa que pide por teclado
 * un día de la semana y dice que asignatura
 * toca a primera hora ese día
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int apagar = 0;
		String diaIntroducido;
		
		do
		{
			System.out.println("----------------------------------------------------" +
							"\nIntroduce un día de la semana (Ejemplo: 'Lunes' o 'lunes')" +
							"\nO escribe 'Apagar' para apagar el programa." +
							"\n----------------------------------------------------");
			diaIntroducido = entradaTeclado.nextLine();
			
			if(diaIntroducido.equals("Lunes") || diaIntroducido.equals("lunes"))
			{
				System.out.println("A primera hora del Lunes hay Sostenibilidad,");
			}
			else if(diaIntroducido.equals("Martes") || diaIntroducido.equals("martes"))
			{
				System.out.println("A primera hora del Martes hay Sistemas Informáticos.");
			}
			else if(diaIntroducido.equals("Miércoles") || diaIntroducido.equals("Miercoles") || diaIntroducido.equals("miercoles") || diaIntroducido.equals("miércoles"))
			{
				System.out.println("A primera hora del Miércoles hay Sistemas Informáticos.");
			}
			else if(diaIntroducido.equals("Jueves") || diaIntroducido.equals("jueves"))
			{
				System.out.println("A primera hora del Jueves hay Itinerario Personal para la Empleabilidad.");
			}
			else if(diaIntroducido.equals("Viernes") || diaIntroducido.equals("viernes"))
			{
				System.out.println("A primera hora del Viernes hay Digitalización.");
			}
			else if(diaIntroducido.equals("Apagar") || diaIntroducido.equals("apagar"))
			{
				System.out.println("Ha seleccionado apagar el programa.");
				apagar++;
			}
			else
			{
				System.out.println("El día introducido no es válido.");
			}
		}while(apagar != 1);

		System.out.println("Apagando programa.");
	}

}
