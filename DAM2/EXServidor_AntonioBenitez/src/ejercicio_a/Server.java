package ejercicio_a;

import java.io.*;
import java.net.*;

public class Server 
{	
	private Socket client = null;
	private ServerSocket serverSocket = null;
	
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Servidor conectado en Puerto " + port);
			while(true) {				
				
				System.out.println("Esperando a Cliente ...");
				client = serverSocket.accept();
				System.out.println("Conexión aceptada (" + client.getLocalAddress() + ")");
				
				//	---	PROGRAMA
				
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				out.println("Introduzca una frase a continuacion.");
				String input = in.readLine();
				if(guardarFrase(input)) {
					out.println("Frase guardada correctamente.");
				}else {
					out.println("Ha ocurrido un ERROR al guardar la frase.");
				}
				
				client.close();
			}		
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		Server server = new Server(6000);
	}
	
	//	GUARDAR FRASE - Guarda la frase introducida por parámetro en 'frases.txt'
	public static boolean guardarFrase(String frase) {
		boolean guardado = false;
		try {
			FileWriter writer = new FileWriter(new File("frases.txt"), true);
			writer.write(frase + "\n");
			guardado = true;
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return guardado;
	}
}
