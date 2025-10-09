package concurrencia;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Main 
{
	public static void main(String[] args) 
	{
		try 
		{
			Scanner reader = new Scanner(new File("lista.txt"));
			LinkedList<Process> procesos = new LinkedList<Process>();
			String jarpath = new File("clientemusical.jar").getAbsolutePath();
			while(reader.hasNextLine())
			{
				String linea = reader.nextLine();
				System.out.println(String.format("Artista encontrado = %s",linea));
				
				ProcessBuilder pb = new ProcessBuilder("java","-jar",jarpath,linea);
				System.out.print("Empezando proceso ...");
				Process p = pb.start();
				
				InputStream is = p.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String str;
				while((str=br.readLine())!= null)
				{
					System.out.println(str);
				}
				
				procesos.add(p);
				System.out.println("Proceso añadido a lista de procesos.\n");
			}
			reader.close();
			for(Process p : procesos)
			{
				p.waitFor();
			}
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}catch(InterruptedException ie)
		{
			System.out.println(ie.getMessage());
		}
	}
}
