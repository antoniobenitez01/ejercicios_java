/*
 * Clase que representa un Profesor
 * Extends: Personal
 * Excepciones: IllegalArgumentException, NullPointerException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025 
 */
package ejercicio3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Profesor extends Personal
{
	
// ATRIBUTOS ==================================================
	
	public static final String TITULACION_DEFAULT = "Sin titulación";
	public static final String ASIGNATURA_DEFAULT = "Sin asignatura";
	
	private String titulacion;
	private String asignatura1;
	private String asignatura2;
	private boolean tutor;
	private int anyosExperiencia;
	
// CONSTRUCTORES ==================================================
	
	//Constructor maestro (13 parámetros)
	public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String genero, double salario,
			int telefono, String email, String titulacion, String asignatura1, String asignatura2, boolean tutor, int anyosExperiencia)
	{
		super(dni, nombre, apellidos, fechaNacimiento, genero, salario, telefono, email);
		
		stringException(titulacion, "titulacion");
		stringException(asignatura1, "asignatura1");
		stringException(asignatura2, "asignatura2");
		minusValueException(anyosExperiencia, "años de experiencia");
		
		this.titulacion = titulacion;
		this.asignatura1 = asignatura1;
		this.asignatura2 = asignatura2;
		this.tutor = tutor;
		this.anyosExperiencia = anyosExperiencia;
	}
	
	//Constructor por omisión
	public Profesor()
	{
		this(Personal.DNI_DEFAULT, Personal.NOMBRE_DEFAULT, Personal.APELLIDOS_DEFAULT, Personal.FECHANAC_DEFAULT,
				Personal.GENERO_DEFAULT, Personal.SALARIO_DEFAULT, Personal.TELEFONO_DEFAULT, Personal.EMAIL_DEFAULT,
				TITULACION_DEFAULT, ASIGNATURA_DEFAULT, ASIGNATURA_DEFAULT, false, 0);
	}
	
// MÉTODOS ==================================================
	
	//AUMENTO SALARIO - Aumenta el salario del Profesor basado en sus años de experiencia
	public void aumentoSalario() throws IllegalArgumentException
	{
		if(this.anyosExperiencia >= 5)
		{
			super.aumentoSalario(5);
		}else if(this.anyosExperiencia >= 3)
		{
			super.aumentoSalario(3);
		}else if(this.anyosExperiencia >= 1)
		{
			super.aumentoSalario(1);
		}
		else
		{
			throw new IllegalArgumentException("Necesita de más de un año de experiencia para recibir un aumento.");
		}
	}
	
	//AÑOS JUBILACIÓN - Calcula y devuelve los años hasta que el Profesor pueda jubilarse
	public int anyosJubilacion() throws IllegalStateException
	{
		int edad = (int) ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
		if(edad > 65)
		{
			throw new IllegalStateException("El personal ya debería estar jubilado.");
		}
		int anyosRestantes = 65 - edad;
		return anyosRestantes;
	}
	
	//TO STRING - Devuelve un String con la información detallada del Profesor
	@Override
	public String toString()
	{
		return String.format("%s\nTitulacion: %s\nAsignatura 1: %s\nAsignatura 2: %s\nTutor: %s\nAños de Experiencia: %d",
				super.toString(), this.titulacion, this.asignatura1, this.asignatura2, this.tutor ? "Sí" : "No", this.anyosExperiencia);
	}
}
