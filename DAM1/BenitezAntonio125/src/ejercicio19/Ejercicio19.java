/*
 * Objetivo: Programa que muestra un tiempo
 * expresado en horas, minutos y segundos dada
 * una variable "t" que contiene el tiempo en segundos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 7/10/2024
 */
package ejercicio19;

import java.util.Scanner;

public class Ejercicio19 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int t, segundos, minutos, horas;
		
		System.out.println("Introduce una cantidad de segundos.");
		t = entradaTeclado.nextInt();
		
		segundos = t % 60; //Calculamos los segundos restantes
		horas = t / 60; //Calculamos los minutos que tenemos hasta ahora
		minutos = horas % 60; //Calculamos los minutos restantes
		horas = horas / 60; //Calculamos las horas a partir de los minutos
		System.out.println(horas + ":" + minutos + ":" + segundos);
	}

}
