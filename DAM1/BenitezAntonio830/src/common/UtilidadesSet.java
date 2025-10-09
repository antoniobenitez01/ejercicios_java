package common;

import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * Clase de Utilidades para
 * colecciones de tipo Set
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/03/2025
 */
public class UtilidadesSet
{
	public static HashSet<Notas> importarDatosHashSet(String ruta)
	{
		HashSet<Notas> importados = new HashSet<Notas>();
		File archivo = new File(ruta);
		Scanner lector;
		try 
		{
			lector = new Scanner(archivo);
			while(lector.hasNext())
			{
				String[] datos = lector.nextLine().split(";");
				Notas notas = new Notas(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), 
						Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
				importados.add(notas);
			}
			lector.close();
		}catch(Exception e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		return importados;
	}
	
	public static void exportarDatos(Set<Notas> set, String ruta)
	{
		File archivo = new File(ruta);
		FileWriter escritor;
		try
		{
			escritor = new FileWriter(archivo);
			String texto = "";
			for(Notas i: set)
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
	
	public static Notas buscarNombre(Set<Notas> lista, String nombre) throws NullPointerException
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
}
