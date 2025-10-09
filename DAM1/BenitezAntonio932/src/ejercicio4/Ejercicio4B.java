package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Clase principal que hace uso de las clases
 * File, FileWriter y Scanner para 
 * crear un programa que genera un número personas aleatorias
 * y las escribe en un archivo introducido por teclado
 * Exceptions: IOException, FileNotFoundException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 08/04/2025
 */
public class Ejercicio4B 
{
	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numPersonas = inputInt("Introduzca el número de personas aleatorias que quiere generar.",entradaTeclado);
		if(numPersonas > 0)
		{
			System.out.println("Introduzca la ruta de escritura.");
			String ruta = entradaTeclado.nextLine();
			generarPersonas(numPersonas, ruta);
		}else
		{
			System.out.println("El número de personas es menor que 0, apagando programa ...");
		}
	}
	
	//GENERAR PERSONAS - Generas personas aleatorias num veces y las escribe en una ruta pasada por parámetro
	private static void generarPersonas(int num, String ruta)
	{
		FileWriter writer = null;
		try 
		{
			writer = new FileWriter(ruta, true);
		} catch (IOException e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		if(writer != null)
		{
			for(int i=0; i<num; i++) 
			{
				String persona = String.format("%s %s\n",
						campoAleatorio("Documentos/usa_nombres.txt"), 
						campoAleatorio("Documentos/usa_apellidos.txt"));
				try 
				{
					writer.write(persona);
				} catch (IOException e) 
				{
					System.out.printf("%s\n", e.getMessage());
				}
			}
			System.out.println("Personas generadas correctamente.");
		}else
		{
			System.out.println("La ruta especificada no existe.");
		}
		try 
		{
			writer.close();
		} catch (IOException e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
	}
	
	//CAMPO ALEATORIO - Devuelve una línea aleatoria del archivo en la ruta pasada por parámetro
	private static String campoAleatorio(String ruta)
	{
		String nombre = "";
		File archivo = new File(ruta);
		
		ArrayList<String> lista = importarLineas(archivo);
		
		if(!lista.isEmpty())
		{
			int numAleatorio = (int) (Math.random() * lista.size());
			nombre = lista.get(numAleatorio);
		}else
		{
			System.out.println("No hay líneas que leer de la ruta indicada.");
		}
		
		return nombre;
	}
	
	//IMPORTAR LINEAS - Recoge un objeto Scanner y devuelve una lista de las lineas leidas con el objeto Scanner
	private static ArrayList<String> importarLineas(File archivo)
	{
		Scanner reader = null;
		ArrayList<String> lineas = null;
		try 
		{
			reader = new Scanner(archivo);
		} catch (FileNotFoundException e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		if(reader != null)
		{
			 lineas = new ArrayList<String>();
			while(reader.hasNextLine())
			{
				lineas.add(reader.nextLine());
			}
		}
		return lineas;
	}
	
	//INPUT INT - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
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
				entrada.nextLine(); // Depuración Scanner
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine(); // Depuración Scanner
			}
		}while(inputTrue == false);
		return num;
	}
}
