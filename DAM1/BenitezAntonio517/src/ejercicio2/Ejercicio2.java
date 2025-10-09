/*
 * Objetivo: Hacer uso de la Clase LocalDate y LocalDateFormatter
 * para realizar una serie de cálculos basados en cumpleaños
 * Excepciones: DateTimeException, InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/12/2024
 */
package ejercicio2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		LocalDate fechaActual = LocalDate.now(), fechaTeclado = null, fechaTemp;
		Locale espanyol = Locale.of("es","ES");
		int anyoTeclado=0, mesTeclado=0, diaTeclado=0, anyoActual = fechaActual.getYear(), numCoincidencias = 0;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean diaCorrecto = false;
		String diaSemana;
		
		System.out.print("DÍA DE CUMPLEAÑOS"+"\n-----------------"+"\n");
		//BUCLE - Do while validación entre anyoTeclado
		do
		{
			String mensaje = "Introduzca año de nacimiento (1900-" + anyoActual + ")";
			anyoTeclado = inputInt(mensaje, entradaTeclado);
			if(anyoTeclado < 1900 || anyoTeclado > anyoActual)
			{
				System.out.println("Año introducido incorrecto.");
			}
		}while(anyoTeclado < 1900 || anyoTeclado > anyoActual);
		
		//BUCLE - Do while validación entre mesTeclado
		do
		{
			mesTeclado = inputInt("Introduzca mes de nacimiento (1-12):", entradaTeclado);
			if(mesTeclado < 1 || mesTeclado > 12)
			{
				System.out.println("Mes introducido incorrecto.");
			}
		}while(mesTeclado < 1 || mesTeclado > 12);
		
		//BUCLE - Do while validación entre diaTeclado
		do
		{
			diaTeclado = inputInt("Introduzca dia de nacimiento", entradaTeclado);
			try
			{
				fechaTeclado = LocalDate.of(anyoTeclado, mesTeclado, diaTeclado);
				diaCorrecto = true;
			}catch(DateTimeException excepcion1)
			{
				System.out.println("Fecha inválida.");
			}
		}while(diaCorrecto == false);
		
		//Recogemos el resultado de getDayOfWeek y getDisplayName en una variable String
		diaSemana = fechaTeclado.getDayOfWeek().getDisplayName(TextStyle.FULL, espanyol);
		System.out.println("El día que naciste fue " + diaSemana + "." + "\n" + 
						"\n¿Cuántas veces tu cumpleaños ha caído en " + diaSemana + "?" +
						"\n---------------------------------------------------------");
		//Inicializamos una fecha temporal con la fecha que hemos introducido por teclado
		fechaTemp = fechaTeclado;
		//BUCLE - Do while que muestra las fechas que coinciden mientras que fechaTemp sea menor que fechaActual
		do
		{
			//CONDICIÓN - Si el día de la semana coincide, se muestra por pantalla
			if(fechaTemp.getDayOfWeek() == fechaTeclado.getDayOfWeek())
			{
				numCoincidencias++;
				System.out.println(numCoincidencias + ". " + fechaTemp.format(formato));
			}
			//CONDICIÓN - Caso especial 29 Febrero, sumamos años hasta encontrar el siguiente año bisiesto
			if(fechaTemp.getDayOfMonth() == 29 && fechaTemp.getMonthValue() == 2)
			{
				//BUCLE - Do while que añade años hasta encontrar un año bisiesto
				do
				{
					fechaTemp = fechaTemp.plusYears(1);
				}while(fechaTemp.isLeapYear() == false);
				fechaTemp = fechaTemp.plusDays(1); //Añadimos un día a la fecha porque se configura como 28 automáticamente en años no bisiestos
			}
			else //Si no se cumple el caso especial, simplemente añadimos un año más
			{
				fechaTemp = fechaTemp.plusYears(1);
			}
		}while(fechaTemp.isBefore(fechaActual));
		
		System.out.printf("\nNúmero total de coincidencias: %d", numCoincidencias);
	}
	
	//MÉTODO - Recoge un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
}
