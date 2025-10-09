/*
 * Clase que representa un Canario
 * Extends: Ave > Mascota
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/02/2025 
 */
package ejercicio2;

import java.time.LocalDate;

public class Canario extends Ave
{
	
// ATRIBUTOS =========================================================================
	
	public static final String COLOR_DEFAULT = "Ninguno";
	
	private String color;
	private boolean canta;
	
// CONSTRUCTORES =====================================================================
	
	//Constructor maestro (8 parámetros)
	public Canario(String nombre, int edad, boolean estado, LocalDate fechaNacimiento,String pico, boolean vuela, 
			String color, boolean canta)
	{
		super(nombre, edad, estado, fechaNacimiento, pico, vuela);
		
		stringException(color, "color");
		
		this.color = color;
		this.canta = canta;
	}
	
	//Constructor por omisión
	public Canario()
	{
		this(Mascota.NOMBRE_DEFAULT, Mascota.EDAD_DEFAULT, false, Mascota.FECHA_DEFAULT, Ave.PICO_DEFAULT, false,
				COLOR_DEFAULT, false);
	}
	
// MÉTODOS ============================================================================
	
	//HABLAR - Devuelve un String del Canario hablando
	@Override
	protected String hablar() throws IllegalStateException
	{
		if(!this.estado)
		{
			throw new IllegalStateException("La mascota está muerta");
		}
		if(!this.canta)
		{
			throw new IllegalStateException("El Canario no puede cantar");
		}
		return "Chew!";
	}
	
	//VOLAR - Imprime por pantalla un texto del Canario volando
	@Override
	public void volar() throws IllegalStateException
	{
		if(!this.vuela)
		{
			throw new IllegalStateException("El Canario no puede volar.");
		}
		System.out.println("El Canario está volando.");
	}
	
	//TO STRING - Devuelve un String con la información detallada del Canario
	@Override
	public String toString()
	{
		return String.format("%s\nOrigen: %s\nHabla: %s",
				super.toString(),this.color,this.canta ? "Sí" : "No");
	}
}
