/*
 * Clase que representa un Ave
 * Extends: Mascota
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/02/2025 
 */
package ejercicio2;

import java.time.LocalDate;

public abstract class Ave extends Mascota
{
	
//ATRIBUTOS ===============================================================================
	
	public static final String PICO_DEFAULT = "Ninguno";
	
	protected String pico;
	protected boolean vuela;
	
// CONSTRUCTORES ===========================================================================
	
	//Constructor maestro (6 parámetros)
	public Ave(String nombre, int edad, boolean estado, LocalDate fechaNacimiento,
			String pico, boolean vuela)
	{
		super(nombre, edad, estado, fechaNacimiento);
		
		stringException(pico, "pico");
		
		this.pico = pico;
		this.vuela = vuela;
	}
	
	//Constructor por omisión
	public Ave()
	{
		this(Mascota.NOMBRE_DEFAULT, Mascota.EDAD_DEFAULT, false, Mascota.FECHA_DEFAULT, PICO_DEFAULT, false);
	}
	
// MÉTODOS ==================================================================================
	
	//VOLAR - Método abstracto Volar
	public abstract void volar();
	
	//TO STRING - Devuelve un String con la información detallada del Ave
	@Override
	public String toString()
	{
		return String.format("%s\nPico: %s\nVuela: %s",
				super.toString(), this.pico, this.vuela ? "Sí" : "No");
	}
}
