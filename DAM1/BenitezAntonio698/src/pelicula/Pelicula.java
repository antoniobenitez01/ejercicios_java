package pelicula;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class Pelicula 
{
	public enum Genero {ACCION, COMEDIA, DRAMA, SUSPENSE};
	
	public static final String NOMBRE_DEFAULT = "Defecto";
	public static final LocalDate FECHA_DEFAULT = LocalDate.now();
	public static final Genero GENERO_DEFAULT = Genero.SUSPENSE;
	public static final int DURACION_DEFAULT = 100;
	public static final int CALIFICACION_DEFAULT = 5;
	
	public static final int NUMPELICULAS_MAX = 300;
	public static final int DURACION_MAX = 180;
	public static final int CALIFICACION_MIN = 0;
	public static final int CALIFICACION_MAX = 10;
	
	private static int numeroPeliculas;
	private static int duracionPeliculasTotal;
	private static int duracionPeliculasSuspense;
	private static int ultimoCodigo;
	
	private final String codigo;
	
	private String nombre;
	private LocalDate fechaRealizacion;
	private Genero genero;
	private int duracion;
	private int calificacion;
	
	static
	{
		ultimoCodigo = 999;
	}
	
	public Pelicula(String nombre, LocalDate fechaRealizacion, Genero genero, int duracion, int calificacion)
	{
		if(numeroPeliculas >= NUMPELICULAS_MAX)
		{
			throw new IllegalStateException("No se pueden crear más películas.");
		}
		stringException(nombre, "nombre");
		if(duracion > DURACION_MAX)
		{
			throw new IllegalArgumentException(String.format("La duración no puede superar los %d minutos.\n", DURACION_MAX));
		}
		calificacionException(calificacion);
		
		this.nombre = nombre;
		this.fechaRealizacion = fechaRealizacion;
		this.genero = genero;
		this.duracion = duracion;
		this.calificacion = calificacion;
		
		this.codigo = String.format("%s-%03d",this.genero.toString().substring(0, 3), calcularCodigo());
		
		numeroPeliculas++;
		duracionPeliculasTotal += this.duracion;
		
		if(this.genero == Genero.SUSPENSE)
		{
			duracionPeliculasSuspense += this.duracion;
		}
	}
	
	public Pelicula()
	{
		this(NOMBRE_DEFAULT, FECHA_DEFAULT, GENERO_DEFAULT, DURACION_DEFAULT, CALIFICACION_DEFAULT);
	}
	
	public String getCodigo()
	{
		return this.codigo;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public LocalDate getFechaRealizacion()
	{
		return this.fechaRealizacion;
	}
	
	public String getGenero()
	{
		return this.genero.toString();
	}
	
	public int getDuracion()
	{
		return this.duracion;
	}
	
	public int getCalificacion()
	{
		return this.calificacion;
	}
	
	public static int getDuracionPeliculasTotal()
	{
		return duracionPeliculasTotal;
	}
	
	public static int getDuracionPeliculasSuspense()
	{
		return duracionPeliculasSuspense;
	}
	
	public void setCalificacion(int calificacion)
	{
		calificacionException(calificacion);
		this.calificacion = calificacion;
	}
	
	public int getAntiguedad() 
	{
		return LocalDate.now().getYear() - this.fechaRealizacion.getYear();
	}
	
	public boolean isRecomendable()
	{
		boolean recomendable = false;
		if(this.getAntiguedad() < 5 && this.calificacion > 5)
		{
			recomendable = true;
		}
		return recomendable;
	}
	
	public String toString()
	{
		return String.format("Código: %s\nNombre: %s\nFecha de realización: %s\nGénero: %s\nDuración: %d minutos\nCalificación: %d",
				this.codigo, this.nombre, dateFormat(this.fechaRealizacion),this.getGenero(), this.duracion,this.calificacion);
	}
	
	//STRING EXCEPTION - Lanza excepción si el string introducido es vacío o nulo
	private void stringException(String str, String nombre) throws IllegalArgumentException
	{
		if(str.isEmpty() || str == null)
		{
			throw new IllegalArgumentException(String.format("El campo %s no puede estar vacío o ser nulo.",nombre));
		}
	}
	
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
	
	private void calificacionException(int calificacion) throws IllegalArgumentException
	{
		if(calificacion < CALIFICACION_MIN || calificacion > CALIFICACION_MAX)
		{
			throw new IllegalArgumentException(String.format("La calificación debe estar entre %d y %d.",
					CALIFICACION_MIN, CALIFICACION_MAX));
		}
	}
	
	private static int calcularCodigo()
	{
		int codigo = ultimoCodigo;
		if(codigo%2 == 0)
		{
			ultimoCodigo--;
			codigo = ultimoCodigo;
		}
		ultimoCodigo--;
		return codigo;
	}
}
