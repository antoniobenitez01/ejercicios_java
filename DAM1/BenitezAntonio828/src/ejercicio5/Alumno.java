/*
 * Clase que representa a un Alumno
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025
 */
package ejercicio5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alumno 
{
	
// ATRIBUTOS -----------------------------------------------------------------------------------------------
	
	public static final String CODIGOCICLO_DEFAULT = "AAA00";
	private static int ultimoNum;
	
	private String codigo;
	private String apellidos;
	private String nombre;
	private String direccion;
	private String telefono;
	private String codigoCiclo;
	private int cantAprobado;
	private LocalDate fecIngreso;
	
// INICIALIZACIÓN -------------------------------------------------------------------------------------------
	
	static
	{
		ultimoNum = 0;
	}
	
// CONSTRUCTORES ---------------------------------------------------------------------------------------------
	
	//Constructor maestro (5 parámetros)
	public Alumno(String apellidos, String nombre, String direccion, String telefono, LocalDate fecIngreso)
	{
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigoCiclo = CODIGOCICLO_DEFAULT;
		this.cantAprobado = 0;
		this.fecIngreso = fecIngreso;
		
		this.codigo = String.format("%s%03d",this.nombre.substring(0, 3), ultimoNum);
		ultimoNum++;
	}
	
// GETTERS ----------------------------------------------------------------------------------------------------
	
	public String getCodigo()
	{
		return this.codigo;
	}
	
	public String getApellidos()
	{
		return this.apellidos;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
// SETTERS ----------------------------------------------------------------------------------------------------------
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public void setCodigoCiclo(String codigoCiclo)
	{
		this.codigoCiclo = codigoCiclo;
	}
	
	public void setCantAprobado(int cantAprobado)
	{
		this.cantAprobado = cantAprobado;
	}
	
// MÉTODOS -----------------------------------------------------------------------------------------------------------
	
	//TO STRING - Devuelve un objeto String con la información detallada del Alumno
	public String toString()
	{
		return String.format("Código: %s - Nombre completo: %s %s - Dirección: %s - Teléfono: %s"
				+ " - Código ciclo: %s - Cantidad material aprobado: %d - Fecha de ingreso: %s", 
				this.codigo, this.nombre, this.apellidos, this.direccion, this.telefono,
				this.codigoCiclo, this.cantAprobado, dateFormat(this.fecIngreso));
	}
	
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
}
