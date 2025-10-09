/*
 * Clase que representa un Loro
 * Extends: Ave > Mascota
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/02/2025 
 */
package ejercicio2;

import java.time.LocalDate;

public class Loro extends Ave
{
	
// ATRIBUTOS ====================================================================
	
	public static final String ORIGEN_DEFAULT = "Ninguno";
	
	private String origen;
	private boolean habla;
	
// CONSTRUCTORES ======================================================================
	
	//Constructor maestro (8 parámetros)
	public Loro(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String pico, boolean vuela, 
			String origen, boolean habla)
	{
		super(nombre, edad, estado, fechaNacimiento, pico, vuela);
		
		stringException(origen, "origen");
		
		this.origen = origen;
		this.habla = habla;
	}
	
	//Constructor por omisión
	public Loro()
	{
		this(Mascota.NOMBRE_DEFAULT, Mascota.EDAD_DEFAULT, false, Mascota.FECHA_DEFAULT, Ave.PICO_DEFAULT, false,
				ORIGEN_DEFAULT, false);
	}
	
// MÉTODOS =============================================================================
	
	//HABLAR - Devuelve un String del Loro hablando
	@Override
	protected String hablar() throws IllegalStateException
	{
		if(!this.estado)
		{
			throw new IllegalStateException("La mascota está muerta");
		}
		if(!this.habla)
		{
			throw new IllegalStateException("El Loro no puede hablar.");
		}
		return "Sqwak!";
	}
	
	//VOLAR - Imprime por pantalla un texto del Loro volando
	@Override
	public void volar() throws IllegalStateException
	{
		if(!this.vuela)
		{
			throw new IllegalStateException("El ave no puede volar.");
		}
		System.out.println("El Loro está volando.");
	}
	
	//TO STRING - Devuelve un String con la información detallada del Loro
	@Override
	public String toString()
	{
		return String.format("%s\nOrigen: %s\nHabla: %s",
				super.toString(),this.origen,this.habla ? "Sí" : "No");
	}
}
