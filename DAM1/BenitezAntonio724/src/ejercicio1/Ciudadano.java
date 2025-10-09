/*
 * Clase que representa un Ciudadano
 * Extends: Humano
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025 
 */
package ejercicio1;

public class Ciudadano extends Humano
{
	
// ATRIBUTOS ==================================================
	
	protected String documento;
	
// CONSTRUCTORES ==================================================
	
	//Constructor maestro (3 parámetros)
	public Ciudadano(String nombre, String apellidos, String documento)
	{
		super(nombre, apellidos);
		
		stringException(documento, "documento");
		
		this.documento = documento;
	}
	
	//Constructor por omisión
	public Ciudadano()
	{
		this(Humano.NOMBRE_DEFAULT, Humano.APELLIDOS_DEFAULT, "DNI");
	}
	
// MÉTODOS ==================================================
	
	//IDENTIFICACION - Devuelve un String con el nombre completo y el documento del objeto Ciudadano
	public String identificacion()
	{
		return String.format("%s, %s",super.getNombreCompleto(), this.documento);
	}
}
