/*
 * Objetivo: Programa que pide una hora
 * por teclado para luego mostrar el mensaje
 * correspondiente a la hora introducida.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int horaIntroducida;
		
		do
		{
			System.out.println("Introduce una hora (de 0 a 23)." +
							"\nO introduzca -1 para apagar el programa");
			horaIntroducida = entradaTeclado.nextInt();
			if(horaIntroducida == -1)
			{
				System.out.println("Ha seleccionado apagar el programa.");
			}
			else if(horaIntroducida < 0)
			{
				System.out.println("La hora introducida es negativa, no es válida.");
			}
			else if(horaIntroducida > 23)
			{
				System.out.println("La hora introducida supera la cifra 23, no es válida");
			}
			else
			{
				switch(horaIntroducida)
				{
				case 6, 7, 8, 9, 10, 11, 12:
					System.out.println("Buenos días.");
					break;
				case 13, 14, 15, 16, 17, 18, 19, 20:
					System.out.println("Buenas tardes.");
					break;
				case 21, 22, 23, 0, 1, 2, 3, 4, 5:
					System.out.println("Buenas noches.");
					break;					
				}
			}
		}while(horaIntroducida != -1);		
		
		System.out.println("Apagando programa.");
	}
}
