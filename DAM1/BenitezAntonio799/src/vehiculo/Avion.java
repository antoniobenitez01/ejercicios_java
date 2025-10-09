/*
 * Clase que representa un Avion
 * Extends: VehiculoAereo
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025 
 */
package vehiculo;

import java.time.LocalDate;

public class Avion extends VehiculoAereo implements Alquilable
{
	
// ATRIBUTOS ================================================================
	
	public static final int TIEMPOVUELO_DEFAULT = 100;
	
	private int maxTiempoVuelo; //En minutos
	
// CONSTRUCTORES ============================================================
	
	//Constructor maestro (4 parámetros)
	public Avion(String matricula, String modelo, LocalDate fechaFabricacion, short numAsientos, int maxTiempoVuelo) throws IllegalArgumentException
	{
		super(matricula, modelo, fechaFabricacion, numAsientos);
		if(maxTiempoVuelo < 0)
		{
			throw new IllegalArgumentException("El tiempo máximo de vuelo no puede ser menor que 0.");
		}
		this.maxTiempoVuelo = maxTiempoVuelo;
	}
	
	//Constructor por omisión
	public Avion()
	{
		this(VehiculoAereo.MATRICULA_AEREO_DEFAULT, Vehiculo.MODELO_DEFAULT, 
				Vehiculo.FECHAFAB_DEFAULT,VehiculoAereo.NUMASIENTOS_DEFAULT, TIEMPOVUELO_DEFAULT);
	}
	
// GETTERS ==================================================================
	
	//Devuelve el tiempo máximo de vuelo del Avion como valor entero int
	public int getMaxTiempoVuelo()
	{
		return this.maxTiempoVuelo;
	}
	
// SETTERS ==================================================================
	
	//Establece el tiempo máximo de vuelo del Avion
	public void setMaxTiempoVuelo(int maxTiempoVuelo)
	{
		if(maxTiempoVuelo < 0)
		{
			throw new IllegalArgumentException("El tiempo máximo de vuelo no puede ser menor que 0.");
		}
		this.maxTiempoVuelo = maxTiempoVuelo;
	}
	
// MÉTODOS ==================================================================
	
	//TO STRING - Devuelve un String con la información del Avion
	@Override
	public String toString()
	{
		return String.format("%s\nTiempo máximo de vuelo: %d minutos", super.toString(), this.maxTiempoVuelo);
	}
	
	//CALCULAR ALQUILER - Devuelve el valor del alquiler basado en días
	@Override
	public double calcularAlquiler(int dias) 
	{
		double resultado = 0;
		if(this.maxTiempoVuelo > 10)
		{
			resultado = 700 * dias;
		}else
		{
			resultado = 500 * dias;
		}
		return resultado;
	}
}
