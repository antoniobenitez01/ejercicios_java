/*
 * Clase que representa un Perro
 * Extends: Mascota
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/02/2025 
 */
package ejercicio2;

import java.time.LocalDate;

public class Perro extends Mascota
{
	
// ATRIBUTOS ==============================================================================
	
	public static final String RAZA_DEFAULT = "Ninguna";
	
	private String raza;
	private boolean pulgas;
	
// CONSTRUCTORES ==========================================================================
	
	//Constructor maestro (6 parámetros)
	public Perro(String nombre, int edad, boolean estado, LocalDate fechaNacimiento,
			String raza, boolean pulgas)
	{
		super(nombre, edad, estado, fechaNacimiento);
		
		stringException(raza, "raza");
		
		this.raza = raza;
		this.pulgas = pulgas;
	}
	
	//Constructor por omisión
	public Perro()
	{
		this(Mascota.NOMBRE_DEFAULT, Mascota.EDAD_DEFAULT, false, Mascota.FECHA_DEFAULT, RAZA_DEFAULT, false);
	}

// MÉTODOS ==================================================================================
	
	//TO STRING - Devuelve un String con la información detallada del Perro
	@Override
	public String toString()
	{
		return String.format("%s\nRaza: %s\nPulgas: %s",
				super.toString(), this.raza, this.pulgas ? "Sí" : "No");
	}
	
	//HABLAR - Devuelve un String del Perro hablando
	@Override
	protected String hablar() throws IllegalStateException
	{
		if(!this.estado)
		{
			throw new IllegalStateException("La mascota está muerta");
		}
		return "Woof!";
	}
}
