/*
 * Clase que representa un Barco
 * Extends: VehiculoAcuatico
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025 
 */
package vehiculo;

import java.time.LocalDate;

public class Barco extends VehiculoAcuatico implements Alquilable
{

// ATRIBUTOS ===========================================================================
	
	private boolean tieneMotor;
	
// CONSTRUCTORES =======================================================================
	
	//Constructor maestro (4 parámetros)
	public Barco(String matricula, String modelo, LocalDate fechaFabricacion, double eslora, boolean tieneMotor)
	{
		super(matricula, modelo, fechaFabricacion, eslora);
		
		this.tieneMotor = tieneMotor;
	}
	
// GETTERS ==============================================================================
	
	//Devuelve true si el Barco tiene motor
	public boolean tieneMotor()
	{
		return this.tieneMotor;
	}

// SETTERS ==============================================================================
	
	//Establece el booleano tieneBarco
	public void setTieneMotor(boolean tieneMotor)
	{
		this.tieneMotor = tieneMotor;
	}
	
// MÉTODOS ==============================================================================
	
	//TO STRING - Devuelve un String con la información del Barco
	@Override
	public String toString()
	{
		return String.format("%s\nTiene motor: %s",super.toString(), this.tieneMotor ? "Sí" : "No");
	}
	
	//CALCULAR ALQUILER - Devuelve el valor del alquiler basado en días
	@Override
	public double calcularAlquiler(int dias) 
	{
		double resultado = 0;
		resultado = 200 * dias;
		if(this.tieneMotor())
		{
			resultado += 50;
		}
		return resultado;
	}
}
