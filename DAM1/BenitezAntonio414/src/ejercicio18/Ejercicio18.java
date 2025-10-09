/*
 * Objetivo: Programa que pide el DNI y muestre
 * por pantalla la letra asociada mediante una función
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio18;

import java.util.Scanner;

public class Ejercicio18 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int dni;
		
		System.out.println("Introduzca los números del DNI.");
		dni = entradaTeclado.nextInt();
		
		System.out.println("Para el DNI " + dni + " el NIF es " + calculoNif(dni));
	}
	
	//MÉTODO - Recoge el valor DNI para devolver el carácter NIF correspondiente	
	public static char calculoNif(int dni)
	{
		char nif = 'a';
		
		switch(dni%23)
		{
		case 0:
			nif = 'T';
			break;
		case 1:
			nif = 'R';
			break;
		case 2:
			nif = 'W';
			break;
		case 3:
			nif = 'A';
			break;
		case 4:
			nif = 'G';
			break;
		case 5:
			nif = 'M';
			break;
		case 6:
			nif = 'Y';
			break;
		case 7:
			nif = 'F';
			break;
		case 8:
			nif = 'P';
			break;
		case 9:
			nif = 'D';
			break;
		case 10:
			nif = 'X';
			break;
		case 11:
			nif = 'B';
			break;
		case 12:
			nif = 'N';
			break;
		case 13:
			nif = 'J';
			break;
		case 14:
			nif = 'Z';
			break;
		case 15:
			nif = 'S';
			break;
		case 16:
			nif = 'Q';
			break;
		case 17:
			nif = 'V';
			break;
		case 18:
			nif = 'H';
			break;
		case 19:
			nif = 'L';
			break;
		case 20:
			nif = 'C';
			break;
		case 21:
			nif = 'K';
			break;
		case 22:
			nif = 'E';
			break;
		}
		return nif;
	}
}
