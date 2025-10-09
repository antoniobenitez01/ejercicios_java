package ejemploHoras;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class EjemploHoras 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		LocalTime horaHoy = LocalTime.now(), horaIntroducida = null;
		String horaString;
		boolean horaCorrecta = false;
		long horas, minutos, segundos;
		
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
		
		//CONDICIÓN - Comprobar si horaIntroducida va antes o después que horaHoy para evitar resultados negativos
		if(horaIntroducida.isBefore(horaHoy))
		{
			horas = ChronoUnit.HOURS.between(horaIntroducida, horaHoy);
			minutos = ChronoUnit.MINUTES.between(horaIntroducida, horaHoy) % 60;
			segundos = ChronoUnit.SECONDS.between(horaIntroducida, horaHoy) % 60;
		}
		else
		{
			horas = ChronoUnit.HOURS.between(horaHoy, horaIntroducida);
			minutos = ChronoUnit.MINUTES.between(horaHoy, horaIntroducida) % 60;
			segundos = ChronoUnit.SECONDS.between(horaHoy, horaIntroducida) % 60;
		}
		
		//RESULTADO
		System.out.printf("El tiempo entre las dos horas es: " + horas + " horas " + minutos + " minutos y " + segundos + " segundos.");
	}
}
