/*
 * Objetivo: Programa que utiliza un método
 * que recoge los datos de edad, nota académica, renta y nivel de idioma
 * para comprobar si el usuario es apto para acceder a una beca
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 15/11/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int edad;
		double notaAcademica, renta, notaIdioma;
		boolean nivelIdioma;
		
		System.out.println("Introduzca su edad.");
		edad = entradaTeclado.nextInt();
		System.out.println("Introduzca su nota académica.");
		notaAcademica = entradaTeclado.nextDouble();
		System.out.println("Introduzca su renta.");
		renta = entradaTeclado.nextDouble();
		
		System.out.println("Introduzca su nota de Idioma.");
		notaIdioma = entradaTeclado.nextDouble();
		if(notaIdioma >= 8)
		{
			nivelIdioma = true;
		}
		else
		{
			nivelIdioma = false;
		}
		
		System.out.println(accesoBecaUsa(edad, notaAcademica, renta, nivelIdioma));
	}
	
	public static String accesoBecaUsa(int edad, double notaAcademica, double renta, boolean nivelIdioma)
	{
		String apto = "";
		if(nivelIdioma == false)
		{
			apto = "No apto.";
		}
		else if(edad > 30)
		{
			apto = "No apto.";
		}
		else if(notaAcademica < 5)
		{
			apto = "No apto.";
		}
		else if(notaAcademica >= 5 && notaAcademica < 9)
		{
			if(renta < 20000)
			{
				apto = "Apto.";
			}
			else
			{
				apto = "No apto.";
			}
		}
		else if(notaAcademica >= 9)
		{
			apto = "Apto.";
		}
		
		return apto;
	}
}
