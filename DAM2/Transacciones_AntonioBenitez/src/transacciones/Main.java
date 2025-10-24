package transacciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		// VARIABLES ------------------------------||
		int codigo;
		int cantidad;
		int numTablas = 0;
		boolean buyable = false;
		Scanner entrada = new Scanner(System.in);
		Properties props = new Properties();
		// PROGRAMA -------------------------------||
		try {
			props.load(new FileInputStream("mysql.cnf"));
			String url = String.format("jdbc:mysql://%s:%s/%s",
					props.getProperty("ip"),props.getProperty("port"),props.getProperty("dbname"));
			String user = "transacciones";
			String password = "12345";
			Connection conn = Common.connectionSQL(url,user,password);
			if(conn != null) 
			{
				try // MAIN TRY -----------------------------------------------------
				{
					System.out.println("=== ARTÍCULOS DISPONIBLES ===");
					
					// MOSTRAR LISTA DE ARTÍCULOS DISPONIBLES
					PreparedStatement select = conn.prepareStatement("SELECT * FROM articulos");
					ResultSet rs = select.executeQuery();
					numTablas = 0;
					while(rs.next())
					{
							System.out.println(String.format("ARTICULO Nº%d - Nombre:%s - Existencias:%d - Precio:%.2f€",
									rs.getInt("id"),rs.getString("nombre"),rs.getInt("existencias"),rs.getDouble("precio")));
							numTablas++;
					}
					if(numTablas == 0)
					{
						System.out.println("No se ha encontrado ningún artículo disponible.");
					}
					rs.close();
					
					// COMPRA
					while(buyable == false) 
					{
						codigo = Common.inputInt("Introduzca el código del artículo que desea comprar.", entrada);
						try {
							select = conn.prepareStatement("SELECT * FROM articulos WHERE id = ?");
							select.setInt(1, codigo);
							rs = select.executeQuery();
							numTablas = 0;
							while(rs.next())
							{
									System.out.println(String.format("ARTICULO Nº%d - Nombre:%s - Existencias:%d - Precio:%.2f€",
											rs.getInt("id"),rs.getString("nombre"),rs.getInt("existencias"),rs.getDouble("precio")));
									numTablas++;
									cantidad = Common.inputInt("Introduzca la cantidad que desea comprar.", entrada);
									if(cantidad <= rs.getInt("existencias")) // CANTIDAD CORRECTA
									{
										conn.setAutoCommit(false);
										
										String venta = "INSERT INTO ventas(id_articulo,cantidad,fecha) VALUES (?,?,NOW())";
										PreparedStatement stmt = conn.prepareStatement(venta);
										stmt.setInt(1, codigo);
										stmt.setInt(2, cantidad);
										stmt.executeUpdate();
										
										String sql2 = "UPDATE articulos SET existencias = existencias - ? WHERE id = ?";
										PreparedStatement stmt2 = conn.prepareStatement(sql2);
										stmt2.setInt(1, cantidad);
										stmt2.setInt(2, codigo);
										stmt2.executeUpdate();
										
										conn.commit();
										System.out.println("Transacción completada: Venta registrada y existencias actualizadas.");
										buyable = true;
									}else {
										System.out.println("La cantidad introducida supera el número de existencias, inténtelo de nuevo.");
									}
							}
							if(numTablas == 0)
							{
								System.out.println("No se ha encontrado ningún artículo disponible con ese código, inténtelo de nuevo.");
							}
						}catch(SQLException ex) {
							System.out.println(ex.getMessage());
						}
					}
				} catch (SQLException sqle) { // CATCH (SQL EXCEPTION) --------------
					try {
						conn.rollback();
						System.out.println("Transacción revertida debido a un error.\n" + sqle.getMessage());
					} catch (SQLException rollbackEx) {
						System.out.println(rollbackEx.getMessage());
					}
				} finally { // FINALLY ----------------------------------------------
					try {
						conn.setAutoCommit(true);
						conn.close();
					} catch (SQLException sqle2) {
						System.out.println(sqle2.getMessage());
					}
				}
			}else {
				System.out.println("Se ha detectado un problema al conectar con el servidor SQL.");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		entrada.close();
	}
}
