/*
 * Clase que representa un Vehiculo Aéreo
 * Extends: Vehiculo
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025  
 */
package vehiculo;

import java.time.LocalDate;

public class VehiculoAereo extends Vehiculo
{
	
// ATRIBUTOS ===============================================================
	
	public static final String MATRICULA_AEREO_DEFAULT = "AAAA999999";
	public static final short NUMASIENTOS_DEFAULT = 2;
			
	private final short numAsientos;
			
// CONSTRUCTORES ===========================================================
		
	//Constructor maestro (3 parámetros)
	public VehiculoAereo(String matricula, String modelo, LocalDate fechaFabricacion, short numAsientos) throws IllegalArgumentException
	{
		super(matricula, modelo, "[A-Z]{4}[0-9]{6}", fechaFabricacion);
				
		if(numAsientos < 1)
		{
			throw new IllegalArgumentException("El número de asientos no puede ser menor que 1.");
		}
				
		this.numAsientos = numAsientos;
	}
			
// GETTERS ==================================================================
			
	//Devuelve el número de ruedas del Vehículo Terrestre como entero short
	public short getNumeroAsientos()
	{
		return this.numAsientos;
	}
			
// MÉTODOS ==================================================================
			
	//TO STRING - Devuelve un String con la información del Vehículo Terrestre
	@Override
	public String toString()
	{
		return String.format("%s\nNúmero de asientos: %d", super.toString(), this.numAsientos);
	}
}
