/*
 * Objetivos: Programa que hace uso de la Clase LocalDate y Period para 
 * calcular la diferencia de días entre la fecha de hoy y una fecha introducida por teclado
 * Excepciones: DateTimeParseException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 03/12/2024
 */
package fecha;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Fecha 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		LocalDate fechaHoy = LocalDate.now(), fechaIntroducida = null;
		String fechaString;
		Period period;
		boolean fechaCorrecta = false;
		
		//BUCLE - Do While para asegurarse de que se introduce la fecha correctamente por teclado
		do
		{
			//EXCEPCIÓN - DateTimeParseException - Devuelve un error cuando se introduce un fecha fuera del formato ISO
			try
			{
				System.out.println("Introduzca una fecha por teclado (formato: YYYY-MM-DD)");
				fechaString = entradaTeclado.nextLine();
				fechaIntroducida = LocalDate.parse(fechaString);
				fechaCorrecta = true;
			}
			catch(DateTimeParseException excepcion1)
			{
				System.out.println("La fecha introducida no es válida."+
									"\nAsegúrese de que está siguiendo el formato correctamente.");
			}
		}while(fechaCorrecta == false);
		
		//CONDICIÓN - Comprobar si fechaIntroducida va antes o después que fechaHoy para evitar resultados negativos
		if(fechaIntroducida.isBefore(fechaHoy))
		{
			period = Period.between(fechaIntroducida, fechaHoy);
		}
		else
		{
			period = Period.between(fechaHoy, fechaIntroducida);
		}
		
		//RESULTADO
		System.out.printf("El tiempo entre fecha y fecha son " + period.getDays() + " días ");
	}
}
