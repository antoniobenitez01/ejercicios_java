package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Clase principal que hace uso de las
 * clases File y Scanner para encontrar
 * los números máximos y mínimos de un archivo
 * Exceptions: FileNotFoundException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 08/04/2025
 */
public class EjercicioB1 
{
	public static void main(String[] args) 
	{
		System.out.println("\n-- Números máximo y mínimo del archivo numeros.txt --\n");
		System.out.printf("Número máximo del archivo: %d"
				+ "\nNúmero mínimo del archivo: %d",
				max("Documentos/numeros.txt"), min("Documentos/numeros.txt"));
	}
	
	//MIN - Recoge el número mínimo de un archivo pasado por parámetro
	private static int min(String ruta)
	{
		File archivo = new File(ruta);
		Scanner reader = null;
		int numMin = 999999999;
		
		try 
		{
			reader = new Scanner(archivo);
		} catch (FileNotFoundException e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		if(reader != null)
		{
			while(reader.hasNextInt())
			{
				int numero = reader.nextInt();
				if(numero < numMin)
				{
					numMin = numero;
				}
			}
		}
		return numMin;
	}
	
	//MAX - Recoge el número máximo de un archivo pasado por parámetro
	private static int max(String ruta)
	{
		File archivo = new File(ruta);
		Scanner reader = null;
		int numMax = 100;
		
		try 
		{
			reader = new Scanner(archivo);
		} catch (FileNotFoundException e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		if(reader != null)
		{
			while(reader.hasNextInt())
			{
				int numero = reader.nextInt();
				if(numero > numMax)
				{
					numMax = numero;
				}
			}
		}
		return numMax;
	}
}
