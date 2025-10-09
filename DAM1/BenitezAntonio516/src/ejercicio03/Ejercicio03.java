/*
 * Objetivo: Programa que hace uso de la clase LocalTime
 * y realiza una serie de cálculos basados en un horario de clases
 * Excepciones: InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 03/12/2024
 */
package ejercicio03;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Ejercicio03 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		//DECLARACIÓN HORAS LOCALTIME
		LocalTime horaInicio = LocalTime.of(8,0), horaTeclado;
		int horaIntroducida, minutoIntroducido;
		
		System.out.println("HORARIO DE CLASES" + "\n-------------------" + "\nIntroducción del horario que desea comprobar:");
		
		//BUCLE - Do While para comprobar que se introduce las horas correctamente
		do
		{
			horaIntroducida = inputInt("Introduzca hora (00-23): ", entradaTeclado);
			if(horaIntroducida < 0 || horaIntroducida > 23)
			{
				System.out.println("La hora introducida no se encuentra en el rango establecido.");
			}
 		}while(horaIntroducida < 0 || horaIntroducida > 23);
		
		//BUCLE - Do While para comprobar que se introduce los minutos correctamente
		do
		{
			minutoIntroducido = inputInt("Introduzca minuto (00-59): ", entradaTeclado);
			if(minutoIntroducido < 0 || minutoIntroducido > 59)
			{
				System.out.println("El minuto introducido no se encuentra en el rango establecido.");
			}
 		}while(minutoIntroducido < 0 || minutoIntroducido > 59);
		
		//RESULTADO - Hora Introducida
		horaTeclado = LocalTime.of(horaIntroducida, minutoIntroducido);
		System.out.printf("Hora introducida: " + horaTeclado);
		
		//CONDICIÓN - Nidos If Else para comprobar en que rango horario está la horaTeclado introducida por teclado
		if(horaTeclado.isBefore(horaInicio))
		{
			//Utilizamos la Clase ChronoUnit para calcular los minutos entre horas
			long minutosEntreHoras = ChronoUnit.MINUTES.between(horaTeclado, horaInicio);
			System.out.println("\nClase correspondiente: Aún no ha comenzado la jornada. "+
								"Faltan " + minutosEntreHoras + " minutos para comenzar.");
		}
		else if(horaTeclado.isBefore(horaInicio.plusHours(2)))
		{
			System.out.println("\nClase correspondiente: Programación.");
		}
		else if(horaTeclado.isBefore(horaInicio.plusHours(4)))
		{
			System.out.println("\nClase correspondiente: Sistemas Informáticos.");
		}
		else if(horaTeclado.isBefore(horaInicio.plusHours(6)))
		{
			System.out.println("\nClase correspondiente: Entornos de Desarrollo.");
		}
		else
		{
			//Utilizamos la Clase ChronoUnit para calcular los minutos entre horas
			long minutosEntreHoras = ChronoUnit.MINUTES.between(horaInicio.plusHours(6), horaTeclado);
			System.out.println("\nClase correspondiente: La jornada ya ha finalizado. "+
								"Han pasado " + minutosEntreHoras + " minutos desde el fin.");
		}
	}

	//MÉTODO - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor entero
			try 
			{
				System.out.printf(mensaje);
				num = entrada.nextInt();
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.printf("Error de lectura: no es un número entero válido." + "\n");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
}
