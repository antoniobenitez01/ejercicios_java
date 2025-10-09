/*
 * Clase que representa un Astro
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/02/2025 
 */
package ejercicio1;

public abstract class Astro
{
	
// ATRIBUTOS =====================================================================
	
	public static final String NOMBRE_DEFAULT = "Asteroide";
	public static final double MASA_DEFAULT = 1500;
	public static final double DIAMETRO_DEFAULT = 500;
	public static final double HORASROT_DEFAULT = 5;
	
	protected String nombre;
	protected double masa;
	protected double diametro;
	protected double horasRotacion;
	
// CONSTRUCTORES =================================================================
	
	//Constructor maestro (4 parámetros)
	public Astro(String nombre, double masa, double diametro, double horasRotacion)
	{
		stringException(nombre, "nombre");
		minusValueException(masa, "masa");
		minusValueException(diametro, "diámetro");
		minusValueException(horasRotacion, "horas de rotación");
		
		this.nombre = nombre;
		this.masa = masa;
		this.diametro = diametro;
		this.horasRotacion = horasRotacion;
	}
	
	//Constructor por omisión
	public Astro()
	{
		this(NOMBRE_DEFAULT, MASA_DEFAULT, DIAMETRO_DEFAULT, HORASROT_DEFAULT);
	}
	
// GETTERS =================================================================
	
	//Devuelve el nombre como objeto String
	public String getNombre()
	{
		return this.nombre;
	}
	
	//Devuelve la masa en valor decimal double
	public double getMasa()
	{
		return this.masa;
	}
	
	//Devuelve el diámetro en valor decimal double
	public double getDiametro()
	{
		return this.diametro;
	}
	
	//Devuelve las horas de rotación en valor decimal double
	public double getHorasRotacion()
	{
		return this.horasRotacion;
	}
	
// SETTERS ================================================================
	
	//Establece el nombre
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	//Establece la masa
	public void setMasa(double masa)
	{
		this.masa = masa;
	}
	
	//Establece el diámetro
	public void setDiametro(double diametro)
	{
		this.diametro = diametro;
	}
	
	//Establece las horas de rotación
	public void setHorasRotacion(double horasRotacion)
	{
		this.horasRotacion = horasRotacion;
	}
	
// MÉTODOS ================================================================
	
	//TO STRING - Devuelve un String con la información detallada del Astro
	public String toString()
	{
		return String.format("Nombre: %s\nMasa: %.2f kg\nDiámetro: %.2f m2\nHoras rotación sobre su eje: %.2f horas",
				this.nombre, this.masa, this.diametro, this.horasRotacion);
	}
	
	//STRING EXCEPTION - Lanza excepción si el string introducido es vacío o nulo
	protected void stringException(String str, String nombre) throws IllegalArgumentException
	{
		if(str.isEmpty() || str == null)
		{
			throw new IllegalArgumentException(String.format("El campo %s no puede estar vacío o ser nulo.",nombre));
		}
	}
	
	//MINUS VALUE EXCEPTION - Lanza excepción si el valor double introducido es menor que 0
	protected void minusValueException(double value, String nombre) throws IllegalArgumentException
	{
		if(value < 0)
		{
			throw new IllegalArgumentException(String.format("El campo %s no puede ser menor que 0.",nombre));
		}
	}
}
