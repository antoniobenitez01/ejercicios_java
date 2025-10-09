/*
 * Objetivo: Programa que, al introducir
 * un número del 1 al 7, te dice el día
 * de la semana correspondiente al número.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido;
		do
		{
			System.out.println("Introduce un número del 1 al 7." +
							"\nO introduzca 0 para apagar el programa");
			numIntroducido = entradaTeclado.nextInt();
			if(numIntroducido < 0)
			{
				System.out.println("El número es negativo, no es válido.");
			}
			else if(numIntroducido > 7)
			{
				System.out.println("El número es mayor que 7, no es válido.");
			}
			else
			{
				switch (numIntroducido)
				{
				case 0:
					System.out.println("Ha seleccionado apagar el programa.");
					break;
				case 1:
					System.out.println("El día de la semana correspondiente a " + numIntroducido + " es Lunes.");
					break;
				case 2:
					System.out.println("El día de la semana correspondiente a " + numIntroducido + " es Martes.");
					break;
				case 3:
					System.out.println("El día de la semana correspondiente a " + numIntroducido + " es Miércoles.");
					break;
				case 4:
					System.out.println("El día de la semana correspondiente a " + numIntroducido + " es Jueves.");
					break;
				case 5:
					System.out.println("El día de la semana correspondiente a " + numIntroducido + " es Viernes.");
					break;
				case 6:
					System.out.println("El día de la semana correspondiente a " + numIntroducido + " es Sábado.");
					break;
				case 7:
					System.out.println("El día de la semana correspondiente a " + numIntroducido + " es Domingo.");
					break;
				}
			}
		}while(numIntroducido != 0);		
		
		System.out.println("Apagando programa.");
	}

}
