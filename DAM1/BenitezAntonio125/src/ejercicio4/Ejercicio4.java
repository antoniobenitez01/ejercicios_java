/*
 * Objetivo: Programa que muestra el horario
 * de 1ºDAM, separado por columnas y espacios.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio4;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		//Hemos utilizado la misma técnica que en Ejercicio3 junto al uso de espacios para alinear todo correctamente.
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "             ", "LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "15:15 - 16:15", "Sos  ", "SiDAM ", "SiDAM    ", "Ipei  ", "DigFP  ");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "16:15 - 17:15", "EdDAM", "SiDAM ", "SiDAM    ", "Ipei  ", "BdDAM  ");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "17:15 - 18:15", "BdDAM", "Prog  ", "EdDAM    ", "Ipei  ", "BdDAM  ");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "18:30 - 19:30", "BdDAM", "Prog  ", "EdDAM    ", "LmDAM ", "SiDAM  ");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "19:30 - 20:30", "Prog ", "BdDAM ", "Prog     ", "LmDAM ", "Prog   ");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "20:30 - 21:30", "Prog ", "BdDAM ", "Prog     ", "LmDAM ", "Prog   ");
	}

}
