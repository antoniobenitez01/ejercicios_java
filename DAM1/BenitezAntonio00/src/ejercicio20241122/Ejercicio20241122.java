/*
 * Objetivo: Programa que solicite cadenas de texto
 * hasta que se introduzca "fin" o se hayan introducido
 * 10 cadenas de texto. A continuación, se mostrará
 * la cantidad de vocales que tienen las cadenas,
 * la cadena de texto más larga y
 * las cadenas de texto que contengan el carácter "."
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/11/2024
 */
package ejercicio20241122;

import java.util.Scanner;

public class Ejercicio20241122 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int contador = 0, numeroCadenas = 0, cantidadVocales=0;
		String cadenaIntroducida;
		String [] cadenas = new String[10];
		
		//Bucle introducción cadenas de caracteres
		do
		{
			System.out.println("Introduzca una cadena de caractéres."+
							"\nSi introduce 'fin', se finalizará la entrada de datos.");
			cadenaIntroducida = entradaTeclado.nextLine();
			//Condición "fin"
			if(cadenaIntroducida.equals("fin"))
			{
				//Contador = 10 para que se termine el bucle.
				contador = 10;
			}
			else
			{
				cadenas[contador] = cadenaIntroducida;
				contador++;
				numeroCadenas++;
			}
		}while(contador < 10);
		
		//Condición que comprueba si se han introducido
		if(numeroCadenas == 0)
		{
			System.out.println("No se ha introducido ninguna cadena.");
		}
		else
		{
			//Mostrar todas las cadenas introducidas
			System.out.println("\n" + "====== CADENAS =======" + "\n");
			for(int i=0; i<numeroCadenas;i++)
			{
				System.out.print("'" + cadenas[i] + "' ");
				if(i == 5)
				{
					System.out.println(" ");
				}
			}
			
			//Bucle cálculo número de vocales
			for(int i=0;i<numeroCadenas;i++)
			{
				cantidadVocales += calculoVocales(cadenas[i]);
			}
			
			//Resultados de cálculos mediante métodos
			System.out.println("" + "\n" + "\n---- RESULTADOS ----" + "\n" +
							"\nCantidad de vocales: " + cantidadVocales +
							"\nCadena más larga: '" + cadenas[calculoCadenaMax(cadenas, numeroCadenas)] + "'");
			//Bucle que muestra las cadenas que tienen punto
			System.out.println("Cadenas que contienen el carácter '.': ");
			for(int i=0; i < numeroCadenas;i++)
			{
				if(comprobarTienePunto(cadenas[i]) == true)	
				{
					System.out.print("'" + cadenas[i] + "' ");
				}
			}
		}
	}
	
	//MÉTODO - Recoge un String para calcular el número de vocales que tiene
	public static int calculoVocales(String cadenas)
	{
		int cantidadVocales = 0;
			for(int i=0;i<cadenas.length();i++)
			{
				char charCheck;
				charCheck = cadenas.charAt(i);
				switch(charCheck)
				{
				case 'a', 'A':
					cantidadVocales++;
					break;
				case 'e', 'E':
					cantidadVocales++;
					break;
				case 'i', 'I':
					cantidadVocales++;
					break;
				case 'o', 'O':
					cantidadVocales++;
					break;
				case 'u', 'U':
					cantidadVocales++;
					break;
				}
			}
		return cantidadVocales;
	}
	
	//MÉTODO - Que recoge un Array de String para calcular la cadena más larga dentro del array
	public static int calculoCadenaMax(String [] cadenas, int numeroCadenas)
	{
		int posicionCadenaMax = 0;
		for(int i=1;i<numeroCadenas;i++)
		{
			if(cadenas[i].length()>cadenas[posicionCadenaMax].length())
			{
				posicionCadenaMax = i;
			}
		}
		return posicionCadenaMax;
	}
	
	//MÉTODO - Recoge un String para devolver true si tiene el carácter '.'
	public static boolean comprobarTienePunto(String cadena)
	{
		boolean tienePunto = false;
		int contador=0;
		//Bucle do-while - Se detiene cuando encontramos el carácter '.'
		do
		{
			char charCheck;
			charCheck = cadena.charAt(contador);
			if(charCheck == '.')
			{
				tienePunto = true;
				contador = cadena.length();
			}
			contador++;
		}while(contador < cadena.length());	
		return tienePunto;
	}
}
