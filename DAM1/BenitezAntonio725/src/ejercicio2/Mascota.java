/*
 * Clase que representa una Mascota
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/02/2025 
 */
package ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Mascota 
{
	
// ATRIBUTOS ======================================================================
	
	public static final String NOMBRE_DEFAULT = "Ninguno";
	public static final int EDAD_DEFAULT = 0;
	public static final LocalDate FECHA_DEFAULT = LocalDate.now();
	
	protected String nombre;
	protected int edad;
	protected boolean estado;
	protected LocalDate fechaNacimiento;
	
// CONSTRUCTORES ===================================================================
	
	//Constructor maestro (4 parámetros)
	public Mascota(String nombre, int edad, boolean estado, LocalDate fechaNacimiento) throws IllegalArgumentException
	{
		stringException(nombre, "nombre");
		minusValueException(edad, "edad");
		if(fechaNacimiento == null)
		{
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
		}
		this.nombre = nombre;
		this.edad = edad;
		this.estado = estado;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//Constructor por omisión	
	public Mascota()
	{
		this(NOMBRE_DEFAULT, EDAD_DEFAULT, false, FECHA_DEFAULT);
	}
	
// GETTERS =========================================================================
	
	//Devuelve el nombre de la Mascota como objeto String
	public String getNombre()
	{
		return this.nombre;
	}
	
// MÉTODOS ==========================================================================
	
	//IS CUMPLEAÑOS - Devuelve true si es el cumpleaños de la Mascota
	public boolean isCumpleanyos()
	{
		return LocalDate.now().getDayOfMonth() == this.fechaNacimiento.getDayOfMonth()
				&& LocalDate.now().getMonthValue() == this.fechaNacimiento.getMonthValue();
	}
	
	//MORIR - Cambiamos el estado de la Mascota
	public void morir() throws IllegalStateException
	{
		if(!this.estado)
		{
			throw new IllegalStateException ("La mascota ya está muerta.");
		}
		this.estado = false;
	}
	
	//HABLAR - Método abstracto de Hablar
	protected abstract String hablar(); 
	
	//TO STRING - Devuelve un String con la información detallada de la Mascota
	public String toString()
	{
		return String.format("Nombre: %s\nEdad: %d\nEstado: %s\nFecha de Nacimiento: %s",
				this.nombre, this.edad, this.estado ? "Vivo" : "Muerto", dateFormat(this.fechaNacimiento));
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
	
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
}
