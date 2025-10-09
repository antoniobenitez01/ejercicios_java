/*
 * Clase que representa una Vivienda
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/03/2025
 */
package viviendasTuristica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Vivienda 
{

// ATRIBUTOS =========================================================================
	
	public static final String DIRECCION_DEFAULT = "Ninguna";
	public static final double PRECIO_DEFAULT = 100;
	
	private static int numeroViviendas;
	
	private final String id;
	
	protected String direccion;
	protected double precio;
	protected boolean disponible;
	
// INICIALIZACION =========================================================================
	
	static
	{
		numeroViviendas = 0;
	}
	
// CONSTRUCTORES =========================================================================
	
	//Constructor maestro (4 parámetros)
	public Vivienda(String id, String direccion, double precio, boolean disponible)
	{
		this.direccion = direccion;
		this.precio = precio;
		this.disponible = disponible;
		this.id = id;
		
		numeroViviendas++;
	}

// GETTERS =========================================================================
	
	public String getId()
	{
		return this.id;
	}
	
	public String getDireccion()
	{
		return this.direccion;
	}
	
	public double getPrecio()
	{
		return this.precio;
	}
	
	public boolean getDisponible()
	{
		return this.disponible;
	}
	
	public static int getNumeroViviendas()
	{
		return numeroViviendas;
	}
	
// SETTERS =========================================================================
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public void setPrecio(double precio)
	{
		this.precio = precio;
	}
	
	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}
	
// MÉTODOS =========================================================================
	
	//CALCULAR PRECIO - Método que calcula el precio de una estancia basada en un parámetro de días
	protected abstract double calcularPrecio(int dias);
	
	//TO STRING - Devuelve un String con la información detallada de la Vivienda
	public String toString()
	{
		return String.format("ID: %s - Dirección: %s - Precio: %.2f - Disponible: %s",
				this.id, this.direccion,this.precio, this.disponible ? "Sí" : "No");
	}
	
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
}
