package ejercicio_b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;
import java.net.*;

public class Server 
{
	public static final int MAXIMUM_THREADS = 50;
	private static final ExecutorService executor = Executors.newFixedThreadPool(MAXIMUM_THREADS);
	
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
				
				out.println("A continuacion, introduzca varias frases");
				out.println("o introduzca 'END' para terminar el programa.");
				String fullText = "";
				String input = "";
				do {
					out.println("Introduzca una frase a continuacion.");
					input = in.readLine();
					if(input.trim().toLowerCase().equals("end")) {
						out.println("Guardando frases ...");
					}else {
						fullText += input + "\n";
					}
				}while(!input.trim().toLowerCase().equals("end"));
				if(guardarFrase(fullText)) {
					out.println("Frases guardadas correctamente.");
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
		Server.executor.shutdown();
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
