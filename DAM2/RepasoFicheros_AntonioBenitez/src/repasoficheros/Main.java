package repasoficheros;

import java.io.*;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		// ============== CREACIÓN ARCHIVOS =================
		File nombres = new File("nombres.txt");
		if(nombres.exists()) nombres.delete(); //Si el archivo existe lo borra y lo crea de nuevo
		try
		{
			nombres.createNewFile();
		}catch(IOException e)
		{
			System.out.println("Ha ocurrido un problema al crear el archivo 'nombres.txt'");
		}
		// ================= PROGRAMA =======================
		Scanner entrada = new Scanner(System.in);
		String respuesta;
		FileWriter writer;
		do 
		{
			System.out.println("Introduzca un nombre por teclado."
					+ "\nIntroduzca 'fin' para apagar el programa.");
			respuesta = entrada.nextLine();
			if(!respuesta.toLowerCase().equals("fin"))
			{
				try
				{
					writer = new FileWriter(nombres, true);
					writer.write(respuesta + String.format("%n"));
					writer.close();
				}catch(IOException e)
				{
					System.out.println("Ha ocurrido un problema escribiendo el nombre.");
				}
			}
		}while(!respuesta.toLowerCase().equals("fin"));
		entrada.close();
		System.out.println("Apagando programa ...");
	}
}
