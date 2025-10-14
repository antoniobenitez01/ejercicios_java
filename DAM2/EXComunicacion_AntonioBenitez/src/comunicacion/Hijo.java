package comunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo 
{
	public static void main(String[] args) 
	{
		System.out.println("HOLA SOY EL PROCESO HIJO");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			String linea = reader.readLine();
			System.out.println("RECIBIDO = " + linea);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
