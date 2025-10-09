/*
 * Clase que representa un Coche
 * Extends: VehiculoTerrestre
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025 
 */
package vehiculo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Coche extends VehiculoTerrestre implements Alquilable
{
	
// ATRIBUTOS ===========================================================
	
	private boolean tieneAc;
	
// CONSTRUCTORES =======================================================
	
	//Constructor maestro (4 parámetros)
	public Coche(String matricula, String modelo, LocalDate fechaFabricacion, short numeroRuedas, boolean tieneAc)
	{
		super(matricula, modelo, fechaFabricacion, numeroRuedas);
		
		this.tieneAc = tieneAc;
	}
	
// GETTERS =============================================================
	
	//Devuelve true si el Coche tiene aire acondicionado
	public boolean tieneAc()
	{
		return this.tieneAc;
	}
	
// SETTERS =============================================================
	
	//Establece el booleano de tieneAc
	public void setTieneAc(boolean tieneAc)
	{
		this.tieneAc = tieneAc;
	}

// MÉTODOS =============================================================
	
	//TO STRING - Devuelve un String con la información del Coche
	@Override
	public String toString()
	{
		return String.format("%s\nTiene Aire acondicionado: %s", super.toString(), this.tieneAc ? "Sí" : "No");
	}

	//CALCULAR ALQUILER - Devuelve el valor del alquiler basado en días
	@Override
	public double calcularAlquiler(int dias) 
	{
		double resultado = 0;
		if(ChronoUnit.YEARS.between(this.fechaFabricacion, LocalDate.now()) > 10)
		{
			resultado = 40 * dias;
		}else
		{
			resultado = 50 * dias;
		}
		return resultado;
	}
}
