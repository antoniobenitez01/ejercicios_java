/*
 * Objetivo: Juego donde Wally se esconde
 * en una matriz de 5 filas y 4 columnas y donde tu trabajo
 * es encontrar donde se encuentra Wally, 
 * introduciendo las coordenadas por teclado.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/11/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int x,y, randomx, randomy, numIntentos = 3;
		final int FILAS = 5;
		final int COLUMNAS = 4;
		String casillas [][] = new String [FILAS][COLUMNAS];
		
		//Rellenamos la matriz de 0 (espacios vacíos)
		for(int i=0; i<FILAS; i++)
		{
			for(int j=0; j<COLUMNAS; j++)
			{
				casillas[i][j] = "- Vacío -";
			}
		}
		
		//Introducimos a Wally (Número 1) en la matriz de forma aleatoria
		randomx = (int) (Math.random()*5);
		randomy = (int) (Math.random()*4);
		//Código para debug, muestra las coordenadas de Wally => System.out.println(randomx + " " + randomy);
		casillas[randomx][randomy] = "= Wally =";
		
		//Mensaje inicial
		System.out.println("---- ¿DÓNDE ESTÁ WALLY? ----" +
						"\nEncuentra a Wally introduciendo las coordenadas correctas!");
		
		//Bucle intentos
		do
		{
			System.out.println("Introduzca la coordenada X (del 0 al 4)");
			x = entradaTeclado.nextInt();
			System.out.println("Introduzca la coordenada Y (del 0 al 3)");
			y = entradaTeclado.nextInt();
			
			//Condición comprueba si las coordenadas introducidas son iguales que las coordenadas de Wally
			if(x == randomx && y == randomy)
			{
				numIntentos = 0;
				System.out.println("¡Felicidades! Ha encontrado a Wally.");
			}
			else
			{
				numIntentos--;
				if(numIntentos != 0)
				{
					//Detalle mensaje cambia según número de intentos
					System.out.println("¡Has fallado! Inténtalo de nuevo.");
					if(numIntentos == 1)
					{
						System.out.println(numIntentos + " intento restante.");
					}
					else
					{
						System.out.println(numIntentos + " intentos restantes.");
					}
				}
				else
				{
					System.out.println("Lo sentimos, ha perdido el juego.");
				}
			}
		}while(numIntentos != 0);
		
		//Mostrar todas las casillas
		System.out.println("---------- CASILLAS ---------");
		
		for(int i=0; i<FILAS; i++)
		{
			for(int j=0; j<COLUMNAS; j++)
			{
				System.out.print("[" + i + "][" + j + "] = " + casillas[i][j] + "  ") ;
			}
			System.out.println("");
		}
	}
}
