/*
 * Programa que recoge un fichero de texto de objetos Vehículo
 * y trabaja el acceso a sus datos mediante métodos
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/09/2025
 */
package accesoficheros;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		File archivo = new File("coches.txt");
		LinkedList<Vehiculo> listaCoches = listar(archivo);
		for(Vehiculo v : listaCoches)
		{
			System.out.println(String.format("- %s", v.toString()));
		}	
	}
	
	//LISTAR - Convierte los elementos de un archivo de texto a un LinkedList
	public static LinkedList<Vehiculo> listar(File file)
	{
		LinkedList<Vehiculo> lista = new LinkedList<Vehiculo>();
		try
		{
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String[] datos = reader.nextLine().split(";");
				Vehiculo creado = new Vehiculo(datos[0],datos[1],Double.parseDouble(datos[2]));
				if(creado != null) lista.add(creado);
			}
			reader.close();
		}catch(IOException e)
		{
			System.out.println("Ha ocurrido un problema al leer el archivo.");
		}
		return lista;
	}
}
