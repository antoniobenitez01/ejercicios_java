package quote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Server 
{
	public static final int MAXIMUM_THREADS = 50;
	
	private Socket client = null;
	private ServerSocket serverSocket = null;
	private ArrayList<Thread> threads;
	
	public Server(int port, ArrayList<String> quotes) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Servidor conectado en Puerto " + port);
			threads = new ArrayList<Thread>();
			while(true) {				
				System.out.println("Esperando a Cliente ...");
				client = serverSocket.accept();
				System.out.println("Conexión aceptada (" + client.getLocalAddress() + ")");
				if(threads.size() < MAXIMUM_THREADS) {
					SocketThread thread = new SocketThread(client);
					threads.add(thread);
					thread.run();
					thread.join();
					threads.remove(thread);
				}else {
					System.out.println("ERROR: Límite excedido, por favor inténtelo de nuevo.");
				}
			}		
		}catch(IOException | InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) 
	{
		File archivo = new File("quotes.txt");
		if(archivo.exists()) {
			ArrayList<String> quotes = importarQuotes(archivo);
			if(quotes.size() > 0) {
				SocketThread.quotes = quotes;
				Server server = new Server(2017,quotes);
			}else {
				System.out.println("ERROR: La longitud de Quotes es 0.");
			}
		}else {
			System.out.println("ERROR: El archivo 'quotes.txt' no existe.");
		}
	}
	
	// IMPORTAR QUOTES - Importa y devuelve las Quotes of the Day a partir de un archivo
	private static ArrayList<String> importarQuotes(File archivo){
		ArrayList<String> quotes = new ArrayList<String>();
		try {
			Scanner reader = new Scanner(archivo);
			while(reader.hasNextLine()) {
				String quote = reader.nextLine();
				if(!quote.isEmpty()) {
					quotes.add(quote);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return quotes;
	}
}
