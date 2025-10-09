/*
 * Clase que representa un Personal
 * Excepciones: IllegalArgumentException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025 
 */
package ejercicio3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Personal 
{
	
// MÉTODOS ==================================================	
	
	public static final String DNI_DEFAULT = "99999999A";
	public static final String NOMBRE_DEFAULT = "Sin nombre";
	public static final String APELLIDOS_DEFAULT = "Sin apellidos";
	public static final LocalDate FECHANAC_DEFAULT = LocalDate.of(1999, 01, 01);
	public static final String GENERO_DEFAULT = "Sin género";
	public static final double SALARIO_DEFAULT = 1024;
	public static final int TELEFONO_DEFAULT = 999999999;
	public static final String EMAIL_DEFAULT = "Sin email";
	
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected LocalDate fechaNacimiento;
	protected String genero;
	protected double salario;
	protected int telefono;
	protected String email;
	
// CONSTRUCTORES ==================================================
	
	//Constructor maestro (8 parámetros)
	public Personal(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String genero, double salario,
			int telefono, String email)
	{
		stringException(dni,"dni");
		stringException(nombre,"nombre");
		stringException(apellidos, "apellidos");
		if(fechaNacimiento == null)
		{
			throw new NullPointerException("La fecha de nacimiento no puede ser nula.");
		}
		if(fechaNacimiento.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser superior al día de hoy.");
		}
		stringException(genero, "genero");
		minusValueException(salario,"salario");
		if(telefono < 0)
		{
			throw new IllegalArgumentException("El campo telefono no puede ser menor que 0.");
		}
		stringException(email, "email");
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.salario = salario;
		this.telefono = telefono;
		this.email = email;
	}
	
	//Constructor por omisión
	public Personal()
	{
		this(DNI_DEFAULT, NOMBRE_DEFAULT, APELLIDOS_DEFAULT, FECHANAC_DEFAULT, 
				GENERO_DEFAULT, SALARIO_DEFAULT, TELEFONO_DEFAULT, EMAIL_DEFAULT);
	}
	
// MÉTODOS ==================================================
	
	//AUMENTO SALARIO - Aumenta el salario del Personal el porcentaje introducido
	public void aumentoSalario(double porcentaje) throws IllegalArgumentException
	{
		minusValueException(porcentaje, "porcentaje de aumento");
		this.salario += this.salario * (porcentaje / 100);
	}
	
	//TO STRING - Devuelve un String con la información detallada del Personal
	public String toString()
	{
		return String.format("DNI: %s\nNombre: %s\nApellidos: %s\nFecha de nacimiento: %s"
				+ "\nGénero: %s\nSalario: %.2f€\nTelefono: %d\nEmail: %s",
				this.dni, this.nombre, this.apellidos, fechaFormato(this.fechaNacimiento), this.genero, this.salario,
				this.telefono, this.email);
	}
	
	//STRING EXCEPTION - Lanza excepción cuando el String está vacío o es nulo
	protected void stringException(String str, String nombre) throws IllegalArgumentException
	{
		if(str.isEmpty() || str == null)
		{
			throw new IllegalArgumentException(String.format("El campo %s no puede estar vacío o ser nulo.",nombre));
		}
	}
	
	//FECHA FORMATO - Devuelve la fecha introducida por parámetro como un String formateado
	protected String fechaFormato(LocalDate fecha)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fecha.format(formato);
	}
	
	//MINUS VALUE EXCEPTION - Lanza excepción si el valor double introducido es menor que 0
	protected void minusValueException(double value, String nombre)
	{
		if(value < 0)
		{
			throw new IllegalArgumentException(String.format("El campo %s no puede ser menor que 0.",nombre));
		}
	}
}
