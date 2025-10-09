package formatoFechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FormatoFechas 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		LocalDate fechaIntroducida = null;
		LocalTime horaIntroducida = null;
		LocalDateTime fechaHoraHoy = LocalDateTime.now(), fechaHoraIntroducida;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("'Hoy es 'dd' del mes 'MM' del año 'yyyy' y son las 'HH' horas 'mm' minutos.'");
		String fechaString, horaString;
		boolean fechaCorrecta = false, horaCorrecta = false;
		
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
		
		//BUCLE - Do While para asegurarse de que se introduce la hora correctamente por teclado
		do
		{
			//EXCEPCIÓN - DateTimeParseException - Devuelve un error cuando se introduce una hora fuera del formato ISO
			try
			{
				System.out.println("Introduzca una fecha por teclado (formato: HH:MM:SS)");
				horaString = entradaTeclado.nextLine();
				horaIntroducida = LocalTime.parse(horaString);
				horaCorrecta = true;
			}
			catch(DateTimeParseException excepcion1)
			{
				System.out.println("La hora introducida no es válida."+
									"\nAsegúrese de que está siguiendo el formato correctamente.");
			}
		}while(horaCorrecta == false);
		
		fechaHoraIntroducida = LocalDateTime.of(fechaIntroducida, horaIntroducida);
		System.out.printf(fechaHoraHoy.format(formato));
		//System.out.printf("\n"+fechaHoraIntroducida.format(formato));
	}
}
