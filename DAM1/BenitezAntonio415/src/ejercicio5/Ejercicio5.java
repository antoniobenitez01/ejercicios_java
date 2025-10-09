/*
 * Objetivo: Programa que utiliza un método
 * que recoge un número entero para calcular
 * la posición de un jugador de fútbol
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 15/11/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num;
		String nombre;
		
		do
		{
			System.out.println("Introduzca su dorsal (del 1 al 16).");
			num = entradaTeclado.nextInt();
			if(num < 1 || num > 16)
			{
				System.out.println("Número introducido incorrecto.");
			}
		}while(num < 1 || num > 16);
		entradaTeclado.nextLine();
		System.out.println("Introduzca su nombre.");
		nombre = entradaTeclado.nextLine();
		
		System.out.println(nombre + ", con el dorsal " + num + " juega el próximo partido como " + posicionJugador(num) + ".");
	}
	
	public static String posicionJugador(int num)
	{
		String posicion = "";
		switch(num)
		{
		case 1:
			posicion = "portero";
			break;
		case 2,3,4,5:
			posicion = "defensa";
			break;
		case 6,7,8:
			posicion = "centrocampista";
			break;
		case 9,10,11:
			posicion = "delantero";
			break;
		case 12,13,14,15,16:
			posicion = "suplente";
			break;
		}
		return posicion;
	}
}
