package net.hibernate;

import java.io.*;
import java.net.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.hibernate.dao.UsuarioDAO;
import net.hibernate.entity.Usuario;
import net.hibernate.util.HibernateUtil;

public class Server 
{
	public static final int MAXIMUM_THREADS = 50;
	
	private Socket client = null;
	private ServerSocket serverSocket = null;
	
	public Server(int port, Session session, Transaction transaction) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Servidor conectado en Puerto " + port);
			while(true) {				
				
				System.out.println("Esperando a Cliente ...");
				client = serverSocket.accept();
				System.out.println("Conexion aceptada (" + client.getLocalAddress() + ")");
				
				// ----------------------------------------------- PROGRAMA
				
				// PREPARACIÓN VARIABLES
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				List<Usuario> usuarios = UsuarioDAO.selectContacto();
				String input = "";
				
				System.out.println("\n--- USUARIOS REGISTRADOS ---\n");
				for(Usuario u : usuarios) {
					System.out.println(u);
				}
				System.out.println();
				
				// VALIDACIÓN INPUT VACÍO O NULO
				boolean validInput = false;
				while(!validInput) {
					out.println("Introduzca su nombre a continuacion.");
					input = in.readLine().strip();
					
					if(input.isEmpty() || input == null) {
						out.println("ERROR: El campo 'nombre' no puede estar vacio. Intentelo de nuevo.");
					}else {
						validInput = true;
					}
				}
				System.out.println("INPUT RECIBIDO : " + input);
				
				// VALIDACIÓN USUARIO YA REGISTRADO
				Usuario usuario = new Usuario(input);
				System.out.println("USUARIO CREADO : " + usuario.toString());
				boolean isIn = false;
				for(Usuario u : usuarios) {
					if(u.getNombre().toLowerCase().equals(usuario.getNombre().toLowerCase())) {
						System.out.println("USUARIO ENCONTRADO EN BASE DE DATOS !");
						isIn = true;
					}
				}
				
				// OPERACIÓN PRINCIPAL : REGISTRAR USUARIO
				if(isIn) {
					out.println("El cliente " + input + " ya esta registrado.");
				}else {
					try {
						transaction = session.beginTransaction();
						session.persist(usuario);
						transaction.commit();
						out.println("USUARIO REGISTRADO - " + usuario.toString());
					}catch(Exception e) {
						out.println("ERROR: " + e.getMessage());
						System.out.println(e.getMessage());
					}
				}
				
				// CERRAR CONEXIÓN CLIENTE
				client.close();
				
				// -----------------------------------------------
			}		
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("\n--- SERVIDOR USUARIOS ---\n");
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Server server = new Server(1234, session, transaction);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
