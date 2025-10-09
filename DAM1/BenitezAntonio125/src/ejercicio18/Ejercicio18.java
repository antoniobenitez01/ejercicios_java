/*
 * Objetivo: Programa que lee el antiguo
 * horario de salida y llegada de una 
 * empresa de transporte y calcula el
 * nuevo horario de 15% de reducción.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio18;

import java.util.Scanner;

public class Ejercicio18 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int horaSalida, horaLlegadaAntigua, horaLlegadaNueva;
		int hhSalida, mmSalida, hhLlegadaAntigua, mmLlegadaAntigua, hhLlegadaNueva, mmLlegadaNueva, duracion;
		
		System.out.println("Introduzca la hora de salida.");
		horaSalida = entradaTeclado.nextInt();

		mmSalida = horaSalida % 100;
		hhSalida = horaSalida / 100;
		
		System.out.println("Introduzca la hora de llegada antigua.");
		horaLlegadaAntigua = entradaTeclado.nextInt();
		
		mmLlegadaAntigua = horaLlegadaAntigua % 100;
		hhLlegadaAntigua = horaLlegadaAntigua / 100;
		
		//Cálculo nueva hora llegada
		
		duracion = mmLlegadaAntigua + (hhLlegadaAntigua * 60); //Traducimos los minutos y horas antiguos a minutos totales
		duracion = duracion - ((duracion * 15) / 100); //Calculamos el 15% del total antiguo
		hhLlegadaNueva = duracion / 60;
		mmLlegadaNueva = duracion - (hhLlegadaNueva * 60);

		System.out.println("El horario antigua era de las " + hhSalida + " horas y " + mmSalida + " minutos a las " + hhLlegadaAntigua + " horas y " + mmLlegadaAntigua + " minutos.");
		System.out.println("El nuevo horario es de las " + hhSalida + " horas y " + mmSalida + " minutos a las  " + hhLlegadaNueva + " horas y " + mmLlegadaNueva + " minutos."); 

	}

}
