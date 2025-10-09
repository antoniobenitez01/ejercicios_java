/*
 * Objetivo: Programa que calcula la nota
 * que hace falta para sacar el segundo exámen
 * de una asignatura, obteniendo la media deseada.
 * El primer exámen cuenta un 40% mientras que el
 * segundo exámen cuenta un 60%.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio21;

import java.util.Scanner;

public class Ejercicio21 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner (System.in);
		
		double notaPrimerExamen, notaSegundoExamen, media, valorPrimerExamen;
		
		System.out.println("¿Cuánto has sacado en el primer exámen?");
		notaPrimerExamen = entradaTeclado.nextDouble();
		System.out.println("¿Cuál es la media deseada?");
		media = entradaTeclado.nextDouble();
		
		valorPrimerExamen = notaPrimerExamen - ((notaPrimerExamen * 40) / 100);
		notaSegundoExamen = (media * 2) - valorPrimerExamen;
		System.out.println("La nota que necesitas sacar en el siguiente exámen para tener\n"
				+ "una media de " + media + " debes sacar una nota de " + notaSegundoExamen);
	}

}
