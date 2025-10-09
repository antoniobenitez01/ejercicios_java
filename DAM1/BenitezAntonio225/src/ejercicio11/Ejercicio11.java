/*
 * Objetivo: Programa que dado un día de la semana
 * y una hora y minutos, calcula cuantos minutos falta
 * para el fin de semana (comienza el viernes a las 21:30.
 * La fecha y hora introducida debe ser anterior al viernes a las 15:30.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/10/2024
 */
package ejercicio11;

import java.util.Scanner;

public class Ejercicio11 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int hr, min, totalMin = 0, minMax = 7050, resultado, resultadoHr, resultadoMin;
		String diaSemana;
		
		System.out.println("Introduzca un día de la semana (de Lunes a Viernes)");
		diaSemana = entradaTeclado.nextLine();
		
		//Condicional if para asegurarse de que no se pasa del Viernes a las 15:00
		if(diaSemana.equals("Viernes") || diaSemana.equals("viernes"))
		{
			do
			{
				System.out.println("Introduzca una hora (de 0 a 14)");
				hr = entradaTeclado.nextInt();
				if(hr < 0 || hr > 14)
				{
					System.out.println("La hora introducida no es válida.");
				}
			}while(hr < 0 || hr > 14);
			do
			{
				System.out.println("Introduzca los minutos (de 0 a 59)");
				min = entradaTeclado.nextInt();
				if(min < 0 || min > 59)
				{
					System.out.println("Los minutos introducidos no son válidos");
				}
			}while(min < 0 || min > 59);
		}
		else
		{
			do
			{
				System.out.println("Introduzca una hora (de 0 a 23)");
				hr = entradaTeclado.nextInt();
				if(hr < 0 || hr > 23)
				{
					System.out.println("La hora introducida no es válida.");
				}
			}while(hr < 0 || hr > 23);
			do
			{
				System.out.println("Introduzca los minutos (de 0 a 59)");
				min = entradaTeclado.nextInt();
				if(min < 0 || min > 59)
				{
					System.out.println("Los minutos introducidos no son válidos");
				}
			}while(min < 0 || min > 59);
		}
		
		//Suma por días (1440 minutos por dia)
		if(diaSemana.equals("Martes") || diaSemana.equals("martes"))
		{
			totalMin += 1440;
		}
		else if(diaSemana.equals("Miércoles") || diaSemana.equals("miércoles") || diaSemana.equals("Miercoles") || diaSemana.equals("miercoles"))
		{
			totalMin += (1440 * 2);
		}
		else if(diaSemana.equals("Jueves") || diaSemana.equals("jueves"))
		{
			totalMin += (1440 * 3);
		}else if(diaSemana.equals("Viernes") || diaSemana.equals("viernes"))
		{
			totalMin+= (1440 * 4);
		}
		
		//Operación
		totalMin += (hr*60);
		totalMin += min;
		resultado = minMax - totalMin;
		
		//Conversión a horas y minutos
		resultadoHr = resultado / 60;
		resultadoMin = resultado % 60;
		System.out.println("Quedan " + resultadoHr + " horas y " + resultadoMin + " minutos para el fin de semana.");
	}
}
