package mavencrud;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminMain 
{
	public static void main(String[] args) 
	{
		Properties props = new Properties();
		int codigo;
		String select;
		try 
		{
			props.load(new FileInputStream("mysql.cnf"));
			String url = String.format("jdbc:mysql://%s:%s/%s",
					props.getProperty("ip"),props.getProperty("port"),props.getProperty("dbname"));
			String user = "reparador";
			String password = "1234";
			Connection conn = Common.connectionSQL(url,user,password);
			if(conn != null)
			{
				Scanner entrada = new Scanner(System.in);
				int respuesta = 0;
				while(respuesta != 6)
				{	
					respuesta = Common.menu("=== FUNCIONES SQL - Tabla Cliente ==="+
							"\n 1. SELECT - Búsqueda por nombre"
							+		"\n 2. INSERT - Insertar nuevo cliente"
							+		"\n 3. UPDATE - Actualizar cliente por código"
							+		"\n 4. DELETE - Borrar cliente por código"
							+		"\n 5. SELECT ALL - Mostrar todos los clientes"
							+		"\n 6. Apagar programa",entrada,1,6);
					switch(respuesta)
					{
					case 1: // SELECT ----------
						System.out.println("Introduzca el nombre del cliente a buscar.");
						String nombre = entrada.nextLine();
						select = String.format("SELECT * FROM cliente WHERE nombre LIKE ?");
						try
						{
							PreparedStatement stmt = conn.prepareStatement(select);
							stmt.setString(1, "%" + nombre + "%");
							ResultSet rs = stmt.executeQuery();
							int numTablas = 0;
							while(rs.next())
							{
								System.out.println(String.format("CLIENTE Nº%d\nNombre: %s\nTeléfono: %d"
										+ "\nSaldo: %.2f€\n",
										rs.getInt("codigo"),rs.getString("nombre"),
										rs.getInt("telefono"),rs.getDouble("saldo")));
								numTablas++;
							}
							if(numTablas == 0)
							{
								System.out.println("No se ha encontrado ninguna fila.");
							}
							rs.close();
							stmt.close();
						}catch(SQLException ex)
						{
							System.out.println("SQL Exception: " + ex.getMessage());
						}
						break;
					case 2: // INSERT ----------
						String insert = "INSERT INTO cliente (nombre, telefono, saldo) VALUES (?,?,?)";
						try
						{
							PreparedStatement stmt = conn.prepareStatement(insert);
							System.out.println("Introduzca el nombre del cliente a insertar.");
							stmt.setString(1,entrada.nextLine());
							stmt.setInt(2,Common.inputPhone("Introduzca el teléfono del cliente a insertar.",entrada));
							stmt.setDouble(3, Common.inputDouble("Introduzca el saldo del cliente a insertar.",entrada));
							int filas = stmt.executeUpdate();
							System.out.println("Filas insertadas : " + filas);
							stmt.close();
						}catch(SQLException ex)
						{
							System.out.println("SQL Exception: " + ex.getMessage());
						}
						break;
					case 3: // UPDATE ----------
						codigo = Common.inputInt("Introduzca el código de cliente.",entrada);
						select = "SELECT * FROM cliente WHERE codigo = ?";
						try
						{
							PreparedStatement stmt = conn.prepareStatement(select);
							stmt.setInt(1, codigo);
							ResultSet rs = stmt.executeQuery();
							int numTablas = 0;
							while(rs.next())
							{
								System.out.println(String.format("CLIENTE Nº%d\nNombre: %s\nTeléfono: %d"
										+ "\nSaldo: %.2f€\n",
										rs.getInt("codigo"),rs.getString("nombre"),
										rs.getInt("telefono"),rs.getDouble("saldo")));
								numTablas++;
							}
							if(numTablas > 0) 
							{
								System.out.println("Entrada encontrada, introduzca a continuación los datos a actualizar.");
								String update = "UPDATE cliente SET nombre = ?,telefono = ?,saldo = ? WHERE codigo = ?";
								stmt = conn.prepareStatement(update);
								System.out.println("Introduzca el nombre del cliente a actualizar.");
								stmt.setString(1,entrada.nextLine());
								stmt.setInt(2,Common.inputPhone("Introduzca el teléfono del cliente a actualizar.",entrada));
								stmt.setDouble(3, Common.inputDouble("Introduzca el saldo del cliente a actualizar.", entrada));
								stmt.setInt(4, codigo);
								int filas = stmt.executeUpdate();
								System.out.println("Filas actualizadas : " + filas);
							}else
							{
								System.out.println("No se ha encontrado ningún cliente con ese código.");
							}
							rs.close();
							stmt.close();
						}catch(SQLException ex)
						{
							System.out.println("SQL Exception: " + ex.getMessage());
						}
						break;
					case 4: // DELETE ----------
						codigo = Common.inputInt("Introduzca el código de cliente.",entrada);
						select = "SELECT * FROM cliente WHERE codigo = ?";
						try
						{
							PreparedStatement stmt = conn.prepareStatement(select);
							stmt.setInt(1, codigo);
							ResultSet rs = stmt.executeQuery();
							int numTablas = 0;
							while(rs.next())
							{
								System.out.println(String.format("CLIENTE Nº%d\nNombre: %s\nTeléfono: %d"
										+ "\nSaldo: %.2f€\n",
										rs.getInt("codigo"),rs.getString("nombre"),
										rs.getInt("telefono"),rs.getDouble("saldo")));
								numTablas++;
							}
							if(numTablas > 0) 
							{
								boolean toDelete = Common.booleanCheck("Entrada encontrada, ¿borrar los datos? (SI / NO).", entrada);
								if(toDelete)
								{
									String update = "DELETE FROM cliente WHERE codigo = ?";
									stmt = conn.prepareStatement(update);
									stmt.setInt(1, codigo);
									int filas = stmt.executeUpdate();
									System.out.println("Filas actualizadas : " + filas);
								}else 
								{
									System.out.println("Operación cancelada, volviendo al menú principal ...");
								}
							}else
							{
								System.out.println("No se ha encontrado ningún cliente con ese código.");
							}
							rs.close();
							stmt.close();
						}catch(SQLException ex)
						{
							System.out.println("SQL Exception: " + ex.getMessage());
						}
						break;
					case 5: // SELECT ALL ------
						try
						{
							select = "SELECT * FROM cliente";
							PreparedStatement stmt = conn.prepareStatement(select);
							ResultSet rs = stmt.executeQuery();
							int numTablas = 0;
							while(rs.next())
							{
								System.out.println(String.format("CLIENTE Nº%d\nNombre: %s\nTeléfono: %d"
										+ "\nSaldo: %.2f€\n",
										rs.getInt("codigo"),rs.getString("nombre"),
										rs.getInt("telefono"),rs.getDouble("saldo")));
								numTablas++;
							}
							if(numTablas == 0)
							{
								System.out.println("No se ha encontrado ninguna fila.");
							}
							rs.close();
							stmt.close();
						}catch(SQLException ex)
						{
							System.out.println("SQL Exception: " + ex.getMessage());
						}
						break;
					case 6: // APAGAR ----------
						System.out.println("Apagando programa ...");
						break;
					}
				}
				entrada.close();
			}
			conn.close();
		} catch (IOException e) 
		{
			System.out.println("Input-Output Error: " + e.getMessage());
		} catch (SQLException ex) {
			System.out.println("SQL Error: " + ex.getMessage());;
		}
	}
}

