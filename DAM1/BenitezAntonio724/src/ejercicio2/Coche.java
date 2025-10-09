/*
 * Clase que representa un Coche
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025 
 */
package ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coche 
{

// ATRIBUTOS ==================================================
	
	private static final Pattern PATRON_MATRICULA = Pattern.compile("[0-9]{4}[A-Z]{3}");
	public static final String MATRICULA_DEFAULT = "9999AAA";
	public static final String NOMBRE_DEFAULT = "Sin dueño";
	public static final double CILINDRADA_DEFAULT = 2000;
	public static final double POTENCIA_DEFAULT = 150;
	
	private final LocalDate fechaMatriculacion;
	
	private String matricula;
	private String nombrePropietario;
	private double cilindrada;
	private double potencia;
	
// CONSTRUCTORES ==================================================
	
	//Constructor maestro (4 parámetros)
	public Coche(String matricula, String nombrePropietario, double cilindrada, double potencia)
	{
		matriculaException(matricula);
		stringException(nombrePropietario, "nombre de propietario");
		minusValueException(cilindrada, "cilindrada");
		minusValueException(potencia, "potencia");
		
		this.matricula = matricula;
		this.nombrePropietario = nombrePropietario;
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.fechaMatriculacion = LocalDate.now();
	}
	
	//Constructor 2 parámetros
	public Coche(double cilindrada, double potencia)
	{
		this(MATRICULA_DEFAULT, NOMBRE_DEFAULT, cilindrada, potencia);
	}
	
	//Constructor por omisión
	public Coche()
	{
		this(MATRICULA_DEFAULT, NOMBRE_DEFAULT, CILINDRADA_DEFAULT, POTENCIA_DEFAULT);
	}
	
// GETTERS ==================================================
	
	//Devuelve la matrícula del Coche en formato String
	public String getMatricula()
	{
		return this.matricula;
	}
	
	//Devuelve el nombre del propietario del Coche en formato String
	public String getNombrePropietario()
	{
		return this.nombrePropietario;
	}
	
	//Devuelve la cilindrada del Coche como un valor decimal double
	public double getCilindrada()
	{
		return this.cilindrada;
	}
	
	//Devuelve la potencia del Coche como un valor decimal double
	public double getPotencia()
	{
		return this.potencia;
	}
	
	//Devuelve la fecha de matriculación del Coche como un objeto LocalDate
	public LocalDate getFechaMatriculacion() 
	{
		return this.fechaMatriculacion;
	}
	
// SETTERS ==================================================
	
	//Establece la matrícula del Coche
	public void setMatricula(String matricula)
	{
		matriculaException(matricula);
		this.matricula = matricula;
	}
	
	//Establece el nombre del propietario del Coche
	public void setNombrePropietario(String nombrePropietario)
	{
		stringException(nombrePropietario, "nombre de propietario");
		this.nombrePropietario = nombrePropietario;
	}
	
	//Establece la cilindrada del Coche
	public void setCilindrada(double cilindrada)
	{
		minusValueException(cilindrada, "cilindrada");
		this.cilindrada = cilindrada;
	}
	
	//Establece la potencia del Coche
	public void setPotencia(double potencia)
	{
		minusValueException(potencia, "potencia");
		this.potencia = potencia;
	}
	
// MÉTODOS ==================================================

	//TO STRING - Devuelve un String con la información detallada del Coche
	public String toString()
	{
		return String.format("Matrícula: %s"
						+ "\nNombre del propietario: %s"
						+ "\nCilindrada: %.2f"
						+ "\nPotencia: %.2f"
						+ "\nFecha de matriculación: %s",
						this.matricula, this.nombrePropietario,
						this.cilindrada, this.potencia, dateFormat(this.fechaMatriculacion));
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
	
	//MATRICULA EXCEPTION - Lanza excepción y el string introducido no sigue el formato de la matrícula del Coche
	protected void matriculaException(String matricula) throws IllegalArgumentException
	{
		stringException(matricula, "matrícula");
		Matcher matMatcher = PATRON_MATRICULA.matcher(matricula);
		if(!matMatcher.matches())
		{
			throw new IllegalArgumentException("La matrícula no es válida. Debe seguir el formato 9999 AAA.");
		}
	}
	
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
}
