package server;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.*;

public class Server 
{
	public static final int MAXIMUM_THREADS = 50;
	
	private Socket client = null;
	private ServerSocket serverSocket = null;
	
	public Server(int port, Connection conn) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Servidor conectado en Puerto " + port);
			while(true) {				
				System.out.println("Esperando a Cliente ...");
				client = serverSocket.accept();
				System.out.println("Conexión aceptada (" + client.getLocalAddress() + ")");
				// ----------------------------------------------- PROGRAMA
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM refrescos");
						ResultSet rs = stmt.executeQuery()){
					
					int lines = 0;
					boolean canTake = true, fin = false;
					String password = "12345";
					Pattern patRecarga = Pattern.compile("RECARGA;[0-9]+;[0-9]+;[a-zA-Z0-9]+");
					Pattern patPide = Pattern.compile("PIDE [a-zA-Z0-9]* [a-zA-Z0-9]*");
					
					while(!fin) {
						
						out.println("\n--- MAQUINA DE REFRESCOS ---\n");
						while(rs.next()) {
							out.println("REFRESCO " + rs.getString("nombre").toUpperCase() + " - Existencias: " + rs.getInt("existencias"));
							lines++;
						}
						if(lines == 0) {
							canTake = false;
							out.println("AVISO: La MÁQUINA de REFRESCOS se encuentra vacia. Por favor contacte un administrador.");
						}
						
						out.println("Introduzca la orden a continuacion:");
						out.println("AVISO: Debe escribirlo sin error, pues utilizar Backspace causa erorres.\n");
						out.println("- RECARGAR => 'RECARGA;{id};{cantidad};{password}'");
						if(canTake) {
							out.println("- PEDIR => PIDE {refresco} {nombre}");
						}
						out.println("- FINALIZAR => FIN");
						
						String input = in.readLine();
						if(patRecarga.matcher(input).matches()){
							String[] dataRecarga = input.split(";");
							if(dataRecarga[3].equals(password)) {
								if(Server.recargar(Integer.parseInt(dataRecarga[1]),Integer.parseInt(dataRecarga[2]),conn)) {
									out.println("Se ha recargado la MAQUINA con exito.");
								}else {
									out.println("ERROR: Ha ocurrido un error al procesar la orden, intentelo de nuevo.");
								}
							}else {
								out.println("ERROR: Contrasena introducida no valida. Contacte un administrador e intentelo de nuevo.");
							}
						}else if(patPide.matcher(input).matches()) {
							String[] dataPide = input.split(" ");
							if(Server.pedir(dataPide[1],dataPide[2], conn)) {
								out.println("Extrayendo " + dataPide[1].toUpperCase() + " ...");
							}else {
								out.println("ERROR: Ha ocurrido un error al procesar la orden, intentelo de nuevo.");
							}
						}else if(input.equals("FIN")) {
							fin = true;
						}else {
							out.println("ERROR: Input invalido. Intentelo de nuevo.");
						}
					}
					out.println("Gracias por usar MAQUINA de REFRESCOS. Tenga un buen dia.");
				}catch(SQLException ex) {
					out.println("ERROR:" + ex.getMessage());
				}finally {
					client.close(); // Cerrar conexión
				}
				// -----------------------------------------------
			}		
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("\n--- SERVIDOR REFRESCOS ---\n");
		String url = "jdbc:mysql://localhost:3306/maquina";
		Connection conn = Common.connectionSQL(url, "hibernate","123");
		if(conn != null) {
			Server server = new Server(2025,conn);
		}else {
			System.out.println("ERROR: Connection is NULL");
		}
	}
	
	public static boolean recargar(int refresco, int cantidad, Connection conn) {
		boolean done = false;
		try(PreparedStatement stmt = conn.prepareStatement("UPDATE refrescos SET existencias = existencias + ? WHERE id = ?")){
			stmt.setInt(1, cantidad);
			stmt.setInt(2, refresco);
			int filas = stmt.executeUpdate();
			System.out.println("SQL - Filas actualizadas = " + filas);
			if(filas != 0) {
				done = true;
			}
		}catch(SQLException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return done;
	}
	
	public static boolean pedir(String refresco, String nombre, Connection conn) {
		boolean done = false;
		int id = Server.getRefrescoID(refresco, conn);
		if(id != -1) {
			try(PreparedStatement stmt = conn.prepareStatement("UPDATE refrescos SET existencias = existencias - 1 WHERE nombre = ?")){
				stmt.setString(1, refresco.toLowerCase());
				int filas = stmt.executeUpdate();
				System.out.println("SQL - Filas actualizadas = " + filas);
				if(filas != 0) {
					try(PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO pedidos VALUES (NULL,?,?)")){
						stmt2.setInt(1,id);
						stmt2.setString(2, nombre);
						filas = stmt2.executeUpdate();
						System.out.println("SQL - Filas actualizadas = " + filas);
						if(filas != 0) {
							done = true;
						}
					}catch(SQLException e) {
						System.out.println("ERROR: " + e.getMessage());
					}
				}else {
					System.out.println("ERROR: Ha ocurrido un error al actualizar los datos.");
				}
			}catch(SQLException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}else {
			System.out.println("ERROR: No se ha encontrado un REFRESCO con ese nombre");
		}
		return done;
	}
	
	public static int getRefrescoID(String refresco, Connection conn) {
		int id = -1;
		try(PreparedStatement stmt = conn.prepareStatement("SELECT id FROM refrescos WHERE nombre = ?")){
			stmt.setString(1, refresco);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return id;
	}
}
