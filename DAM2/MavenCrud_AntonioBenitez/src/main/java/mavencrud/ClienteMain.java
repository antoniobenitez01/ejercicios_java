package mavencrud;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class ClienteMain 
{
	public static void main(String[] args) 
	{
		// VARIABLES =============================================================================
		Scanner entrada = new Scanner(System.in);
		int respuesta = 0;
		int codigo = -1;
		String select;
		Properties props = new Properties();
		int numTablas = 0;
		ResultSet rs;
		String name = "";
		// PROGRAMA ==============================================================================
		try{
			props.load(new FileInputStream("mysql.cnf"));
			String url = String.format("jdbc:mysql://%s:%s/%s",
					props.getProperty("ip"),props.getProperty("port"),props.getProperty("dbname"));
			String user = "reparador";
			String password = "1234";
			Connection conn = Common.connectionSQL(url,user,password);
			
			if(conn != null)
			{
				System.out.println("=== BASE DE DATOS: REPARACIONES ===");
				while(codigo == -1) 
				{
					System.out.println("Introduzca su nombre de cliente.");
					name = entrada.nextLine();
					select = "SELECT * FROM cliente WHERE nombre LIKE ?";
					try
					{
						PreparedStatement stmt = conn.prepareStatement(select);
						stmt.setString(1, "%" + name + "%");
						rs = stmt.executeQuery();
						numTablas = 0;
						while(rs.next())
						{
							codigo = rs.getInt("codigo");
							numTablas++;
						}
						if(numTablas == 0)
						{
							System.out.println("No se ha encontrado ningun cliente con ese nombre.");
						}else
						{
							System.out.println(String.format("Cliente encontrado. Bienvenido cliente '%s' con código '%d'",name,codigo));
						}
						rs.close();
						stmt.close();
					}catch(SQLException ex)
					{
						System.out.println("SQL Exception: " + ex.getMessage());
					}
				}
				while(respuesta != 3)
				{	
					respuesta = Common.menu("=== REPARACIONES - Cliente ==="+
							  "\n 1. SELECT - Mostrar incidencias por nombre de cliente"
							+ "\n 2. INSERT - Insertar nueva incidencia"
							+ "\n 3. Apagar programa",entrada,1,3);
					switch(respuesta)
					{
					case 1: // SELECT ----------
						try
						{
							select = "SELECT * FROM ordenes WHERE codigocliente = ?";
							PreparedStatement stmt = conn.prepareStatement(select);
							stmt.setInt(1, codigo);
							rs = stmt.executeQuery();
							numTablas = 0;
							while(rs.next())
							{
								System.out.println(String.format("INCIDENCIA Nº%d\nAsunto: %s\nDescripción: %s"
										+ "\nFecha de Apertura: %s\nFecha de cierre: %s\nImporte: %.2f€\n",
										rs.getInt("codigo"),rs.getString("asunto"),rs.getString("descripcion"),
										rs.getString("fecha_apertura"),rs.getString("fecha_cierre") == null ? "Abierto." : rs.getString("fecha_cierre"),
										rs.getDouble("importe")));
								numTablas++;
							}
							if(numTablas == 0)
							{
								System.out.println("No se ha encontrado ninguna incidencia bajo ese nombre.");
							}
							rs.close();
							stmt.close();
						}catch(SQLException ex)
						{
							System.out.println("SQL Exception: " + ex.getMessage());
						}
						break;
					case 2: // INSERT ----------
						String insert = "INSERT INTO ordenes (asunto, descripcion, fecha_apertura, codigocliente) VALUES (?,?,?,?)";
						try
						{
							PreparedStatement stmt = conn.prepareStatement(insert);
							System.out.println("Introduzca el asunto de la incidencia.");
							stmt.setString(1,entrada.nextLine());
							System.out.println("Introduzca la descripción de la incidencia.");
							stmt.setString(2,entrada.nextLine());
							stmt.setString(3, Common.dateFormat(LocalDate.now()));
							stmt.setInt(4, codigo);
							int filas = stmt.executeUpdate();
							System.out.println("Filas insertadas : " + filas);
							stmt.close();
						}catch(SQLException ex)
						{
							System.out.println("SQL Exception: " + ex.getMessage());
						}
						break;
					case 3: // APAGAR ----------
						System.out.println("Apagando programa ...");
						break;
					}
				}
			}
		}catch(IOException e) { System.out.println(e.getMessage()); }
	}
}
