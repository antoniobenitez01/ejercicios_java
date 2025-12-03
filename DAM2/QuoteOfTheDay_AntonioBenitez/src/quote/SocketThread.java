package quote;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SocketThread extends Thread{
	
	public static ArrayList<String> quotes;
	
	private final Socket socket;
	private DataOutputStream out = null;
	
	public SocketThread(Socket socket) {
		this.socket = socket;
		try {
			this.out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		try {
			out = new DataOutputStream(socket.getOutputStream());
			String randomQuote = quotes.get((int) (Math.random() * quotes.size()));
			out.writeBytes(randomQuote);
			socket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
