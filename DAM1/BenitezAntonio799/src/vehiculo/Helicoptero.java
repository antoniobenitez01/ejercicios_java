/*
 * Clase que representa un Helicoptero
 * Extends: VehiculoAereo
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025 
 */
package vehiculo;

import java.time.LocalDate;

public class Helicoptero extends VehiculoAereo
{
	
// ATRIBUTOS ======================================================
	
	public static final short NUMHELICES_DEFAULT = 2;
	
	private short numHelices;

// CONSTRUCTORES ==================================================
	
	//Constructor maestro (5 parámetros)
	public Helicoptero(String matricula, String modelo, LocalDate fechaFabricacion, short numAsientos, short numHelices) throws IllegalArgumentException
	{
		super(matricula, modelo, fechaFabricacion, numAsientos);
		
		if(numHelices < 1)
		{
			throw new IllegalArgumentException("El número de hélices no puede ser menor que 1");
		}
		
		this.numHelices = numHelices;
	}
	
	//Constructor por omisión
	public Helicoptero()
	{
		this(VehiculoAereo.MATRICULA_AEREO_DEFAULT, Vehiculo.MODELO_DEFAULT, Vehiculo.FECHAFAB_DEFAULT,
				VehiculoAereo.NUMASIENTOS_DEFAULT, NUMHELICES_DEFAULT);
	}
	
// GETTERS ========================================================
	
	//Devuelve el número de hélices del Helicoptero como valor entero short
	public short getNumHelices()
	{
		return this.numHelices;
	}
	
// SETTERS =========================================================
	
	//Establece el número de hélices del Helicoptero
	public void setNumHelices(short numHelices)
	{
		if(numHelices < 1)
		{
			throw new IllegalArgumentException("El número de hélices no puede ser menor que 1");
		}
		this.numHelices = numHelices;
	}
	
// MÉTODOS =========================================================
	
	//TO STRING - Devuelve un String con la información del Helicoptero
	public String toString()
	{
		return String.format("%s\nNúmero de hélices: %d", super.toString(), this.numHelices);
	}
}
