package herramientas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HerramientasString 
{
	//NUM VOWELS - Recoge un String para calcular el número de vocales que tiene
	public static int numVowels(String cadenas)
	{
		int cantidadVocales = 0;
			for(int i=0;i<cadenas.length();i++)
			{
				char charCheck;
				charCheck = cadenas.charAt(i);
				switch(charCheck)
				{
				case 'a', 'A':
					cantidadVocales++;
					break;
				case 'e', 'E':
					cantidadVocales++;
					break;
				case 'i', 'I':
					cantidadVocales++;
					break;
				case 'o', 'O':
					cantidadVocales++;
					break;
				case 'u', 'U':
					cantidadVocales++;
					break;
				}
			}
		return cantidadVocales;
	}
	
	//HAS DOT - Recoge un String para devolver true si tiene el carácter '.'
	public static boolean hasDot(String cadena)
	{
		boolean tienePunto = false;
		int contador=0;
		//Bucle do-while - Se detiene cuando encontramos el carácter '.'
		do
		{
			char charCheck;
			charCheck = cadena.charAt(contador);
			if(charCheck == '.')
			{
				tienePunto = true;
				contador = cadena.length();
			}
			contador++;
		}while(contador < cadena.length());	
		return tienePunto;
	}
	
	//BOOLEAN CHECK - Devuelve un boolean en base a la respuesta SI o NO introducida por teclado
	private static boolean booleanCheck(String mensaje, Scanner entradaTeclado)
	{
		boolean resultado = false, flag = false;
		
		do
		{
			System.out.println(mensaje);
			String respuesta = entradaTeclado.nextLine();
			
			if(respuesta.toLowerCase().equals("si") || respuesta.toLowerCase().equals("sí"))
			{
				resultado = true;
				flag = true;
			}
			else if(respuesta.toLowerCase().equals("no"))
			{
				resultado = false;
				flag = true;
			}
			else
			{
				System.out.println("Respuesta no válida. Inténtelo de nuevo.");
				flag = false;
			}
		}while(flag == false);
		
		return resultado;
	}

	//INPUT DNI - Recoge un mensaje String y un objeto Scanner para devolver un DNI válido
	public static String inputDNI(String mensaje, Scanner entradaTeclado)
	{
		Pattern patronDni = Pattern.compile("[0-9]{8}[A-Za-z]");
		String dni;
		boolean inputTrue = false;
		do
		{
			System.out.println(mensaje);
			dni = entradaTeclado.nextLine();
			Matcher dniMatch = patronDni.matcher(dni);
			if (dniMatch.matches())
			{
			    inputTrue = true;
			}
			else
			{
			    System.out.println("El DNI introducido no encaja con el formato estándar, inténtelo de nuevo.");
			    inputTrue = false;
			}
		}while(inputTrue != true);
		return dni;
	}
	
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected static String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
}
