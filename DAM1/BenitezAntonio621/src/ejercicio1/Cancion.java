/*
 * Clase que representa una Canción, con 
 * un título y un autor
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 24/01/2025
 */
package ejercicio1;

public class Cancion 
{
	
//ATRIBUTOS ================================
	
	private String titulo; //Título de la Canción
	private String autor; //Autor de la Canción
	
//CONSTRUCTORES ================================
	
	//Constructor maestro (todos los parámetros)
	public Cancion(String titulo, String autor)
	{
		if(titulo.isEmpty() || titulo == null)
		{
			throw new IllegalArgumentException ("El título no puede ser nulo.");
		}
		if(autor.isEmpty() || autor == null)
		{
			throw new IllegalArgumentException ("El autor no puede ser nulo.");
		}
		this.titulo = titulo;
		this.autor = autor;
	}
	
	//Constructor por omisión
	public Cancion()
	{
		this("Vacío", "Vacío");
	}
	
	//Constructor copia
	public Cancion(Cancion c)
	{
		this(c.titulo, c.autor);
	}
	
//MÉTODOS ================================
	
	//Devuelve el objeto String del atributo titulo
	public String dameTitulo()
	{
		return this.titulo;
	}
	
	//Devuelve el objeto String del atributo autor
	public String dameAutor()
	{
		return this.autor;
	}
	
	//Establece el valor del atributo titulo mediante un parámetro String
	public void ponTitulo(String titulo) throws IllegalArgumentException
	{
		if(titulo.isEmpty() || titulo == null)
		{
			throw new IllegalArgumentException ("El título no puede ser nulo.");
		}
		this.titulo = titulo;
	}
	
	//Establece el valor del atributo autor mediante un parámetro String
	public void ponAutor(String autor) throws IllegalArgumentException
	{
		if(autor.isEmpty() || autor == null)
		{
			throw new IllegalArgumentException ("El autor no puede ser nulo.");
		}
		this.autor = autor;
	}
	
	//Devuelve el objeto Cancion representado en formato String
	public String toString()
	{
		return String.format("Título: %s, Autor: %s", this.titulo, this.autor);
	}
}
