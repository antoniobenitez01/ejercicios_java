package procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgendaTelefonica 
{
	private static final String URL = "jdbc:mysql://192.168.10.112:3306/procedimientos";
	private static final String USER = "procedimientos";
	private static final String PASSWORD = "12345";
	
	public static void main(String[] args) 
	{
		String nombre = "Pepe";
		String telefono = "956545454";
		insertarContacto(nombre,telefono);
	}
	
	public static void insertarContacto(String nombre, String telefono)
	{
		Connection conn = null;
		CallableStatement cstmt = null;
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			String sql = "{CALL insertarContacto(?,?)}";
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, nombre);
			cstmt.setString(2, telefono);
			
			cstmt.execute();
			System.out.println("Contacto insertado con éxito.");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (cstmt != null) cstmt.close();
				if (conn != null) conn.close();
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
