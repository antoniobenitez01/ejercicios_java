/*
 * Clase abstracta que representa un Vehiculo
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025 
 */
package vehiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Vehiculo 
{
	
// ATRIBUTOS =====================================================================
	
	public static final String MODELO_DEFAULT = "Ninguno";
	public static final LocalDate FECHAFAB_DEFAULT = LocalDate.of(2000, 1, 1);
	
	protected final String matricula;
	protected final String modelo;
	protected final String patronString;
	protected LocalDate fechaFabricacion;
	
// CONSTRUCTORES =================================================================
	
	//Constructor maestro (3 parámetros)
	public Vehiculo(String matricula, String modelo, String patronString, LocalDate fechaFabricacion) throws IllegalArgumentException
	{
		if(patronString.isEmpty() || patronString == null)
		{
			throw new IllegalArgumentException("El patrón no puede ser nulo o vacío.");
		}
		this.patronString = patronString;
		Pattern patron = Pattern.compile(patronString);
		Matcher match = patron.matcher(matricula);
		if(!match.matches())
		{
			throw new IllegalArgumentException(String.format("El patrón de la matrícula es incorrecto."
					+ "\nDebe seguir la siguiente expresión regular: %s", this.patronString));
		}
		
		if(matricula.isEmpty() || matricula == null)
		{
			throw new IllegalArgumentException("La matrícula no puede ser nula o vacía.");
		}
		if(modelo.isEmpty() || modelo == null)
		{
			throw new IllegalArgumentException("El modelo no puede ser nulo o vacío.");
		}
		
		this.matricula = matricula;
		this.modelo = modelo;
		this.fechaFabricacion = fechaFabricacion;
	}
	
// GETTERS ========================================================================
	
	//Devuelve la matrícula del Vehiculo en formato String
	public String getMatricula()
	{
		return this.matricula;
	}
	
	//Devuelve el modelo del Vehículo en formato String
	public String getModelo()
	{
		return this.modelo;
	}
	
// MÉTODOS ========================================================================
	
	//TO STRING - Devuelve un String con la información del Vehiculo
	public String toString()
	{
		return String.format("Matrícula: %s\nModelo: %s\nFecha de fabricación: %s", this.matricula, this.modelo, dateFormat(this.fechaFabricacion));
	}
	
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected static String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
}
