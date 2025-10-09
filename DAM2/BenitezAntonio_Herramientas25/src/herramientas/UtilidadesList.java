package herramientas;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
 * Clase de Utilidades para
 * colecciones de tipo List
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/03/2025
 */
public class UtilidadesList 
{
	public static void exportarLista(List<Object> lista, String ruta)
	{
		File archivo = new File(ruta);
		FileWriter escritor;
		try
		{
			escritor = new FileWriter(archivo);
			String texto = "";
			for(Object i: lista)
			{
				texto += String.format("%s\n", i.toString());
			}
			escritor.write(texto);
			escritor.close();
		}catch(Exception e)
		{
			System.out.printf("%s\n", e.getMessage());
		}
	}
	
	public static ArrayList<Object> importarDatosArrayList(String ruta)
	{
		ArrayList<Object> importados = new ArrayList<Object>();
		File archivo = new File(ruta);
		Scanner lector;
		try 
		{
			lector = new Scanner(archivo);
			while(lector.hasNext())
			{
				String[] datos = lector.nextLine().split(";");
				Object obj = new Object(/*INSERT OBJECT PARAMS HERE USING ARRAY*/);
				importados.add(obj);
			}
			lector.close();
		}catch(Exception e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		return importados;
	}
	
	public static LinkedList<Object> importarDatosLinkedList(String ruta)
	{
		LinkedList<Object> importados = new LinkedList<Object>();
		File archivo = new File(ruta);
		Scanner lector;
		try 
		{
			lector = new Scanner(archivo);
			while(lector.hasNext())
			{
				String[] datos = lector.nextLine().split(";");
				Object obj = new Object(/*INSERT OBJECT PARAMS HERE USING ARRAY*/);
				importados.add(obj);
			}
			lector.close();
		}catch(Exception e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		return importados;
	}
}
