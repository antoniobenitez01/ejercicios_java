/*
 * Objetivo: Programa que nos diga el 
 * horóscopo a partir del día y el mes de nacimiento
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int dia, mes;
		
		do
		{
			System.out.println("Introduce tu mes de nacimiento (del 1 al 12).");
			mes = entradaTeclado.nextInt();
			if(mes<0 || mes>12)
			{
				System.out.println("El mes introducido no es válido.");
			}
		}while(mes<0 || mes>12);

		switch(mes)
		{
		case 1, 3, 5, 7, 8, 10, 12:
			do
			{
				System.out.println("Introduce tu día de nacimiento (Del 1 al 31).");
				dia = entradaTeclado.nextInt();
				if(dia<=0 || dia>31)
				{
					System.out.println("El día introducido no es válido.");
				}
			}while(dia<=0 || dia>31);
			break;
		case 4, 6, 9, 11:
			do
			{
				System.out.println("Introduce tu día de nacimiento (Del 1 al 30).");
				dia = entradaTeclado.nextInt();
				if(dia<=0 || dia>30)
				{
					System.out.println("El día introducido no es válido.");
				}
			}while(dia<=0 || dia>30);
			break;
		case 2:
			do
			{
				System.out.println("Introduce tu día de nacimiento (Del 1 al 29).");
				dia = entradaTeclado.nextInt();
				if(dia<=0 || dia>29)
				{
					System.out.println("El día introducido no es válido.");
				}
			}while(dia<=0 || dia>29);
			break;
		default:
			dia = 0;
			break;
		}
		System.out.println("Datos introducidos correctamente, calculando horóscopo ...");

		switch(mes)
		{
		case 1:
			if(dia >= 1 && dia <= 19)
			{
				System.out.println("Tu horóscopo es Capricornio");
			}
			else
			{
				System.out.println("Tu horóscopo es Acuario");
			}
			break;
		case 2:
			if(dia >= 1 && dia <= 18)
			{
				System.out.println("Tu horóscopo es Acuario");
			}
			else
			{
				System.out.println("Tu horóscopo es Piscis");
			}
			break;
		case 3:
			if(dia >= 1 && dia <= 20)
			{
				System.out.println("Tu horóscopo es Piscis");
			}
			else
			{
				System.out.println("Tu horóscopo es Aries");
			}
			break;
		case 4:
			if(dia >= 1 && dia <= 19)
			{
				System.out.println("Tu horóscopo es Aries");
			}
			else
			{
				System.out.println("Tu horóscopo es Tauro");
			}
			break;
		case 5:
			if(dia >= 1 && dia <= 20)
			{
				System.out.println("Tu horóscopo es Tauro");
			}
			else
			{
				System.out.println("Tu horóscopo es Géminis");
			}
			break;
		case 6:
			if(dia >= 1 && dia <= 20)
			{
				System.out.println("Tu horóscopo es Géminis");
			}
			else
			{
				System.out.println("Tu horóscopo es Cáncer");
			}
			break;
		case 7:
			if(dia >= 1 && dia <= 22)
			{
				System.out.println("Tu horóscopo es Cáncer");
			}
			else
			{
				System.out.println("Tu horóscopo es Leo");
			}
			break;
		case 8:
			if(dia >= 1 && dia <= 22)
			{
				System.out.println("Tu horóscopo es Leo");
			}
			else
			{
				System.out.println("Tu horóscopo es Virgo");
			}
			break;
		case 9:
			if(dia >= 1 && dia <= 22)
			{
				System.out.println("Tu horóscopo es Virgo");
			}
			else
			{
				System.out.println("Tu horóscopo es Libra");
			}
			break;
		case 10:
			if(dia >= 1 && dia <= 22)
			{
				System.out.println("Tu horóscopo es Libra");
			}
			else
			{
				System.out.println("Tu horóscopo es Escorpio");
			}
			break;
		case 11:
			if(dia >= 1 && dia <= 21)
			{
				System.out.println("Tu horóscopo es Escorpio");
			}
			else
			{
				System.out.println("Tu horóscopo es Sagitario");
			}
			break;
		case 12:
			if(dia >= 1 && dia <= 21)
			{
				System.out.println("Tu horóscopo es Sagitario");
			}
			else
			{
				System.out.println("Tu horóscopo es Capricornio");
			}
			break;
		}
	}
}
