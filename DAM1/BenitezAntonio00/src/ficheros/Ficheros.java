package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) 
	{
		File f = new File("src/ficheros/enteros.txt");
		Scanner lector = null;
		try 
		{
			 lector = new Scanner(f);
		} catch (FileNotFoundException e) 
		{
			System.out.printf("%s\n", e.getMessage());
		}
		do
		{
			int valor = lector.nextInt();
			System.out.printf("%d\n", valor);
		}while(lector.hasNext());
	}
}
