package ejercicio_a;

import java.io.BufferedReader;
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
			Socket servidor = new Socket();
			servidor.connect(new InetSocketAddress("localhost",6000));
			
			BufferedReader in = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
			PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);
			System.out.println(in.readLine());
			out.println(entrada.nextLine());
			System.out.println(in.readLine());
			
			servidor.close();
			entrada.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
