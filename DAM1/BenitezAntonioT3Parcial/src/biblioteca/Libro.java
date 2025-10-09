package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
/*
 * Clase que representa un Libro
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 01/04/2025
 */
public abstract class Libro 
{
// ATRIBUTOS ================================================================
	
	public enum Generos {CUENTO, NOVELA, FICCIÓN};
	
	public static final String TITULO_DEFAULT = "Sin título";
	public static final String AUTOR_DEFAULT = "Sin autor";
	public static final LocalDate FECHAPUB_DEFAULT = LocalDate.of(2000, 01, 01);
	public static final Generos GENERO_DEFAULT = Generos.CUENTO;
	
	protected static int[] contador;
	protected static int numLibrosDigitales;
	protected static int numLibrosFisicos;
	
	protected String id;
	protected String titulo;
	protected String autor;
	protected LocalDate fechaPub;
	protected Generos genero;
	protected boolean disponibilidad;
	
// INICIALIZACION ============================================================
	
	static
	{
		contador = new int[3];
		for(int i=0; i<contador.length; i++)
		{
			contador[i] = 1;
		}
		numLibrosDigitales = 0;
		numLibrosFisicos = 0;
	}
	
// CONSTRUCTORES =============================================================
	
	//Constructor maestro (6 parámetros)
	public Libro(String id, String titulo, String autor, LocalDate fechaPub, Generos genero, boolean disponibilidad) 
			throws IllegalArgumentException
	{
		if(fechaPub.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("La fecha de publicación no puede ser posterior a la fecha actual");
		}
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPub = fechaPub;
		this.genero = genero;
		this.disponibilidad = disponibilidad;
		
		contador[this.genero.ordinal()]++;
	}
	
// GETTERS ===================================================================
	
	public String getID()
	{
		return this.id;
	}
	
// SETTERS ====================================================================
	
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	public void setAutor(String autor)
	{
		this.autor = autor;
	}
	
	public void setFechaPub(LocalDate fechaPub)
	{
		if(fechaPub.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("La fecha de publicación no puede ser posterior a la fecha actual");
		}
		this.fechaPub = fechaPub;
	}
	
	public void setGenero(Generos genero)
	{
		this.genero = genero;
	}
	
// MÉTODOS ==============================================================================
	
	//CALCULAR PRECIO - Método abstracto que calcula el precio del Libro
	protected abstract double calcularPrecio();
	
	//AÑOS TRANSCURRIDOS - Calcula los años que han transcurrido desde la publicación del Libro
	public int anyosTranscurridos()
	{
		return (int) ChronoUnit.YEARS.between(this.fechaPub, LocalDate.now());
	}
	
	//CALCULAR TOTAL LIBROS - Devuelve el total de todos los objeto Libro
	public int calcularTotalLibros()
	{
		return numLibrosDigitales + numLibrosFisicos;
	}
	
	//HASH CODE - Método genéro que genera un Hash Code a través del atributo ID
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	//EQUALS - Método genérico que calcula cuando dos objetos Libro son iguales
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(id, other.id);
	}

	//TO STRING - Devuelve un objeto String con la información detallada del Libro
	public String toString()
	{
		return String.format("ID: %s - Título: %s - Autor: %s - Fecha de publicación: %s - Género: %s - Disponibilidad: %s",
				this.id, this.titulo, this.autor,dateFormat(this.fechaPub), 
				this.genero.toString(), this.disponibilidad ? "Disponible": "No disponible");
	}
	
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected static String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
}
