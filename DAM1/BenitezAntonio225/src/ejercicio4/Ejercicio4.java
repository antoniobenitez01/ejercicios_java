/*
 * Objetivo: Programa que calcula el salario semanal
 * de un trabajador teniendo en cuenta que las primeras
 * 40 horas de trabajo pagan 12€/hora mientras que a partir
 * de las 41 pagan 16€/hora.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int horasSemanales;
		double totalOrdinario, totalSalario;
		
		//Comprobación Horas Positivas
		do
		{
			System.out.println("Introduzca las horas trabajadas esta semana.");
			horasSemanales = entradaTeclado.nextInt();
			if(horasSemanales < 0)
			{
				System.out.println("Las horas introducidas son negativas, no son válidas.");
			}
		}while(horasSemanales < 0);
		if(horasSemanales >= 41)
		{
			totalOrdinario = 40 * 12;
			totalSalario = totalOrdinario + ((horasSemanales - 40) * 16);
		}
		else
		{
			totalSalario = horasSemanales * 12;
		}
		System.out.println("Tu total de salario semanal es " + totalSalario + "€.");
	}
}
