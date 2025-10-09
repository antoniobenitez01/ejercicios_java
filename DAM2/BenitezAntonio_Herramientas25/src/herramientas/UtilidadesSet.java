package herramientas;

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
	public static HashSet<Object> importarDatosHashSet(String ruta)
	{
		HashSet<Object> importados = new HashSet<Object>();
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
	
	public static void exportarDatos(Set<Object> set, String ruta)
	{
		File archivo = new File(ruta);
		FileWriter escritor;
		try
		{
			escritor = new FileWriter(archivo);
			String texto = "";
			for(Object i: set)
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
}
