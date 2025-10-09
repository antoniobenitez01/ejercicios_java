/*
 * Objetivo: Programa que hace uso de la clase LocalDate
 * para calcular la cantidad de domingos que hay en un
 * año introducido por teclado.
 * Excepciones: InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/12/2024
 */
package ejercicio3;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		LocalDate fechaInicial = null;
		Locale espanyol = Locale.of("es","ES");
		int anyoTeclado = 0;
		int sumaTotalDomingos = 0, sumaDomingos = 0;
		
		System.out.println("CONTADOR DE DOMINGOS" + "\n--------------------");
		//BUCLE - Do while hasta que el año esté introducido correctamente
		do
		{
			anyoTeclado = inputInt("Introduzca año (1900-2100):", entradaTeclado);
		}while(anyoTeclado < 1900 || anyoTeclado > 2100);
		
		System.out.printf("\nCANTIDAD DE DOMINGOS DEL AÑO %d" + "\n---------------------------------", anyoTeclado);
		//BUCLE - For, recorre los meses del año
		for(int mes=1;mes<13;mes++)
		{
			sumaDomingos = 0; //Reiniciamos valor sumaDomingos
			fechaInicial = LocalDate.of(anyoTeclado, mes, 1);
			//Mostramos mes traducido al lenguaje declarado en la variable Locale
			System.out.print("\n" + fechaInicial.getMonth().getDisplayName(TextStyle.FULL, espanyol) + " : ");
			//BUCLE - For, recorre los días del mes actual
			for(int dia=1;dia<(fechaInicial.lengthOfMonth()+1);dia++)
			{
				fechaInicial = LocalDate.of(anyoTeclado, mes, dia);
				if(fechaInicial.getDayOfWeek().toString().equals("SUNDAY")) //Comprobación en String
				{
					sumaDomingos++;
				}
			}
			sumaTotalDomingos += sumaDomingos;
			System.out.print(sumaDomingos);
		}
		
		//Resultado número total de domingos
		System.out.printf("\nNúmero total de domingos: %d",sumaTotalDomingos);
	}
	
	//MÉTODO - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
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
				System.out.println("Error de lectura: no es un número entero válido.");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
}
