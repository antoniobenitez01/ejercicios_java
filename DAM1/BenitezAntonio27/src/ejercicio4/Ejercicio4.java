/*
 * Objetivo: Programa que olicita al usuario la
 * nota media obtenida en 4 asignaturas
 * para luego realizar cálculos sobre ellas.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 09/10/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		double notaMedia1, notaMedia2, notaMedia3, notaMedia4, notaMediaTotal, notaMediaCeil, notaMediaFloor;
		
		System.out.println("Escriba la primera nota media");
		notaMedia1 = entradaTeclado.nextDouble();
		System.out.println("Escriba la segunda nota media");
		notaMedia2 = entradaTeclado.nextDouble();
		System.out.println("Escriba la tercera nota media");
		notaMedia3 = entradaTeclado.nextDouble();
		System.out.println("Escriba la cuarta nota media");
		notaMedia4 = entradaTeclado.nextDouble();
		
		notaMediaTotal = (notaMedia1 + notaMedia2 + notaMedia3 + notaMedia4) / 4;
		System.out.println("Tu nota media total es " + notaMediaTotal);
		notaMediaCeil = Math.ceil(notaMediaTotal);
		System.out.println("Tu nota media total redondeada hacia arriba es " + notaMediaCeil);
		notaMediaFloor = Math.floor(notaMediaTotal);
		System.out.println("Tu nota media total redondeada hacia abajo es " + notaMediaFloor);
		
		if(notaMediaTotal >= 8)
		{
			System.out.println("Enhorabuena, puede acceder a los estudios superiores.");
		}
		else
		{
			System.out.println("Lo sentimos, no puede acceder a los estudios superiores");
		}
	}

}
