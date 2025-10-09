/*
 * Clase que representa una Moto
 * Extends: VehiculoTerrestre
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025 
 */
package vehiculo;

import java.time.LocalDate;

public class Moto extends VehiculoTerrestre
{
	
// ATRIBUTOS ===========================================================
	
	public static final String COLOR_DEFAULT = "Negro";
		
	private String color;
		
// CONSTRUCTORES =======================================================
		
	//Constructor maestro (4 parámetros)
	public Moto(String matricula, String modelo, LocalDate fechaFabricacion, short numeroRuedas, String color) throws IllegalArgumentException
	{
		super(matricula, modelo, fechaFabricacion, numeroRuedas);
		
		if(color.isEmpty() || color == null)
		{
			throw new IllegalArgumentException("El color no puede ser nulo o vacío.");
		}
		this.color = color;
	}
	
	//Constructor por omisión
	public Moto()
	{
		this(VehiculoTerrestre.MATRICULA_TERRE_DEFAULT, Vehiculo.MODELO_DEFAULT, Vehiculo.FECHAFAB_DEFAULT,
				VehiculoTerrestre.RUEDAS_DEFAULT, COLOR_DEFAULT);
	}
		
// GETTERS =============================================================
		
	//Devuelve el color de la Moto en formato String
	public String getColor()
	{
		return this.color;
	}
		
// SETTERS =============================================================
		
	//Establece el color de la Moto
	public void setColor(String color)
	{
		this.color = color;
	}

// MÉTODOS =============================================================
		
	//TO STRING - Devuelve un String con la información de la Moto
	@Override
	public String toString()
	{
		return String.format("%s\nColor: %s", super.toString(), this.color);
	}
}
