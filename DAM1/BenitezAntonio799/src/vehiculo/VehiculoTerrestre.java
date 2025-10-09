/*
 * Clase que representa un Vehiculo Terrestre
 * Extends: Vehiculo
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025  
 */
package vehiculo;

import java.time.LocalDate;

public class VehiculoTerrestre extends Vehiculo
{
	
// ATRIBUTOS ===============================================================
	
	public static final String MATRICULA_TERRE_DEFAULT = "9999AAA";
	public static final short RUEDAS_DEFAULT = 4;
	
	private final short numeroRuedas;
	
// CONSTRUCTORES ===========================================================
	
	//Constructor maestor (3 parámetros)
	public VehiculoTerrestre(String matricula, String modelo,LocalDate fechaFabricacion, short numeroRuedas) throws IllegalArgumentException
	{
		super(matricula, modelo, "[0-9]{4}[A-Z]{3}", fechaFabricacion);
		
		if(numeroRuedas < 1)
		{
			throw new IllegalArgumentException("El número de ruedas no puede ser menor que 1.");
		}
		
		this.numeroRuedas = numeroRuedas;
	}
	
// GETTERS ==================================================================
	
	//Devuelve el número de ruedas del Vehículo Terrestre como entero short
	public short getNumeroRuedas()
	{
		return this.numeroRuedas;
	}
	
// MÉTODOS ==================================================================
	
	//TO STRING - Devuelve un String con la información del Vehículo Terrestre
	@Override
	public String toString()
	{
		return String.format("%s\nNúmero de ruedas: %d", super.toString(), this.numeroRuedas);
	}
}
