package procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgendaApp 
{
	private static final String URL = "jdbc:mysql://192.168.10.112:3306/procedimientos";
	private static final String USER = "procedimientos";
	private static final String PASSWORD = "12345";
	
	public static void main(String[] args) 
	{
		String nombre = "Juan Pérez";
		String contrasena = "mi_secreta_contraseña";
		String telefono = "555-1234";
		insertarEnAgenda(nombre, contrasena, telefono);
	}
	
	public static void insertarEnAgenda(String nombre, String contrasena, String telefono) 
	{
		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD))
		{
			String sql = "{CALL insertar_en_agenda(?,?,?)}";
			try(CallableStatement stmt = conn.prepareCall(sql))
			{
				stmt.setString(1, nombre);
				stmt.setString(2, contrasena);
				stmt.setString(3, telefono);
				stmt.execute();
				System.out.println("Registro insertado correctamente.");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
