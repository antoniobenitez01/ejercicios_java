/*
 * Objetivo: Programa que muestra el ranking de puntuaciones
 * de un torneo de ajedrez con 8 jugadores, pidiéndole al
 * usuario las puntuaciones de todos los jugadores
 * (valores entre 1000 y 2800 de tipo entero) y luego muestre
 * las puntuaciones de orden descendente.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio19;

import java.util.Scanner;

public class Ejercicio19 
{
	public enum Dias {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO};
	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int puntIntroducida;
		int[] punts = new int [8];
		
		for(int i=0; i < punts.length; i++)
		{
			//Bucle do while para confirmar que la puntuación introducida está entre 1000 y 2800
			do {
				System.out.println("Introduzca una puntuación entera entre 1000 y 2800. para el jugador " + (i+1) + ".");
				puntIntroducida = entradaTeclado.nextInt();
				if(puntIntroducida < 1000)
				{
					System.out.println("La puntuación introducida es menor que 1000");
				}
				else if(puntIntroducida > 2800)
				{
					System.out.println("La puntuación introducida es mayor que 2800");
				}
			}while((puntIntroducida < 1000) || (puntIntroducida > 2800));
			
			punts[i] =  puntIntroducida;
		}
		
    	//Bucle for para ordenar números, recorriendo todas las posiciones
        for(int i=0; i < punts.length; i++)
        {
            for(int j = i + 1; j < punts.length; j++)
            {
                if(punts[i] < punts[j])
                {
                	int temp = punts[i];
                	punts[i] = punts[j];
                	punts[j] = temp;
                }
            }
        }
		
		System.out.println("------- RANKING AJEDREZ --------");
		for(int i=0; i < punts.length; i++)
		{
			System.out.println((i+1) + "º Jugador - " + punts[i] + " puntos.");
		}
	}
}
