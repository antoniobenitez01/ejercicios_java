package formatoFechaHorahoy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class FormatoFechaHoraHoy 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		LocalDateTime fechaHoraHoy = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("'Hoy es 'dd' del mes 'MM' del año 'yyyy' y son las 'HH' horas 'mm' minutos.'");
		try
		{
			System.out.printf(fechaHoraHoy.format(formato));
		}
		catch(DateTimeParseException excepcion1)
		{
				System.out.println("La fecha introducida no es válida.");
		}
	}
}
