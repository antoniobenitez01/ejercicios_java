/*
 * Clase que representa un Humano
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025 
 */
package ejercicio1;

public class Humano 
{

// ATRIBUTOS ==================================================
	
	public static final String NOMBRE_DEFAULT = "Juan";
	public static final String APELLIDOS_DEFAULT = "García";
	
	protected String nombre;
	protected String apellidos;
	
// CONSTRUCTORES ==================================================
	
	//Constructor maestro (2 parámetros)
	public Humano(String nombre, String apellidos)
	{
		stringException(nombre, "nombre");
		stringException(apellidos, "apellidos");
		
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	//Constructor por omisión
	public Humano()
	{
		this(NOMBRE_DEFAULT, APELLIDOS_DEFAULT);
	}
	
// MÉTODOS ==================================================	

	//GET NOMBRE COMPLETO - Devuelve un String con el nombre y el apellido del objeto Humano
	public String getNombreCompleto()
	{
		return String.format("%s, %s",this.apellidos,this.nombre);
	}
	
	//STRING EXCEPTION - Lanza excepción cuando el String está vacío o es nulo
	protected void stringException(String str, String nombre) throws IllegalArgumentException
	{
		if(str.isEmpty() || str == null)
		{
			throw new IllegalArgumentException(String.format("El campo %s no puede estar vacío o ser nulo.",nombre));
		}
	}
}
