package ejercicio_b;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) 
	{
		try {
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduzca el nombre del archivo de frases.");
			File archivo = new File(entrada.nextLine().trim());
			if(!archivo.exists()) {
				System.out.println("El archivo introducido no existe.");
			}else {
				Scanner reader = new Scanner(archivo);
				
				Socket servidor = new Socket();
				servidor.connect(new InetSocketAddress("localhost",6000));
				
				BufferedReader in = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
				PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				
				while(reader.hasNextLine()) {
					System.out.println(in.readLine());
					String frase = reader.nextLine();
					System.out.println(frase);
					out.println(frase);
				}
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				reader.close();
				servidor.close();
			}
			entrada.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
