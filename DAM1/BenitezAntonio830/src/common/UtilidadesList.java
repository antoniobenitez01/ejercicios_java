package common;

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
	public static Notas buscarNombre(List<Notas> lista, String nombre) throws NullPointerException
	{
		Notas encontrado = null;
		for(Notas i: lista)
		{
			if(i.getNombre().equals(nombre))
			{
				encontrado = i;
			}
		}
		if(encontrado == null)
		{
			throw new NullPointerException("Registro no encontrado");
		}
		return encontrado;
	}
	
	public static void exportarLista(List<Notas> lista, String ruta)
	{
		File archivo = new File(ruta);
		FileWriter escritor;
		try
		{
			escritor = new FileWriter(archivo);
			String texto = "";
			for(Notas i: lista)
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
	
	public static ArrayList<Notas> importarDatosArrayList(String ruta)
	{
		ArrayList<Notas> importados = new ArrayList<Notas>();
		File archivo = new File(ruta);
		Scanner lector;
		try 
		{
			lector = new Scanner(archivo);
			while(lector.hasNext())
			{
				String[] datos = lector.nextLine().split(";");
				importados.add(new Notas(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), 
						Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Integer.parseInt(datos[6])));
			}
			lector.close();
		}catch(Exception e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		return importados;
	}
	
	public static LinkedList<Notas> importarDatosLinkedList(String ruta)
	{
		LinkedList<Notas> importados = new LinkedList<Notas>();
		File archivo = new File(ruta);
		Scanner lector;
		try 
		{
			lector = new Scanner(archivo);
			while(lector.hasNext())
			{
				String[] datos = lector.nextLine().split(";");
				importados.add(new Notas(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), 
						Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Integer.parseInt(datos[6])));
			}
			lector.close();
		}catch(Exception e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		return importados;
	}
}
