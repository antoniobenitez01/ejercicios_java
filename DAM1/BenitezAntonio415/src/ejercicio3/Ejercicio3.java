/*
 * Objetivo: Programa que, dado un número 
 * entero entre 1 y 12, te dice cuántos días
 * tiene el mes que se corresponde al número introducido.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 15/11/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num;
		
		System.out.println("Introduzca un número entero (entre 1 y 12)");
		num = entradaTeclado.nextInt();
		
		System.out.println(indicaMesDias(num));
	}

	public static String indicaMesDias(int num)
	{
		String resultado;
		switch(num)
		{
		case 1:
			resultado = "Enero, 31 días.";
			break;
		case 2:
			resultado = "Febrero, 28 días. 29 días en años bisiestos.";
			break;
		case 3:
			resultado = "Marzo, 31 días.";
			break;
		case 4:
			resultado = "Abril, 30 días";
			break;
		case 5:
			resultado = "Mayo, 31 días.";
			break;
		case 6:
			resultado = "Junio, 30 días.";
			break;
		case 7:
			resultado = "Julio, 31 días.";
			break;
		case 8:
			resultado = "Agosto, 31 días.";
			break;
		case 9:
			resultado = "Septiembre, 30 días.";
			break;
		case 10:
			resultado = "Octubre, 31 días.";
			break;
		case 11:
			resultado = "Noviembre, 30 días.";
			break;
		case 12:
			resultado = "Diciembre, 31 días.";
			break;
		default:
			resultado = "El mes introducido no es válido.";
			break;
		}
		
		return resultado;
	}
}
