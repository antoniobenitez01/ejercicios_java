/*
 * Clase que representa un Submarino
 * Extends: VehiculoAcuatico
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025 
 */
package vehiculo;

import java.time.LocalDate;

public class Submarino extends VehiculoAcuatico
{
	
// ATRIBUTOS ================================================================
	
	public static final double MAXPROFUNDIDAD_DEFAULT = 100;
	
	private double maxProfundidad;
	
// CONSTRUCTORES ============================================================
	
	//Constructor maestro (4 parámetros)
	public Submarino(String matricula, String modelo, LocalDate fechaFabricacion, double eslora, double maxProfundidad) throws IllegalArgumentException
	{
		super(matricula, modelo, fechaFabricacion, eslora);
		
		if(maxProfundidad < 0)
		{
			throw new IllegalArgumentException("La profundida máxima no puede ser menor que 0.");
		}
		
		this.maxProfundidad = maxProfundidad;
	}
	
	//Constructor por omisión
	public Submarino()
	{
		this(VehiculoAcuatico.MATRICULA_ACUA_DEFAULT, Vehiculo.MODELO_DEFAULT, Vehiculo.FECHAFAB_DEFAULT,
				VehiculoAcuatico.ESLORA_DEFAULT, MAXPROFUNDIDAD_DEFAULT);
	}
	
// GETTERS ===================================================================
	
	//Devuelve la profundidad máxima del Submarino como valor decimal double
	public double getMaxProfundidad()
	{
		return this.maxProfundidad;
	}
	
// SETTERS ===================================================================
	
	//Establece la profunidad máxima del Submarino
	public void setMaxProfundidad(double maxProfundidad)
	{
		if(maxProfundidad < 0)
		{
			throw new IllegalArgumentException("La profundida máxima no puede ser menor que 0.");
		}
		this.maxProfundidad = maxProfundidad;
	}
	
// MÉTODOS ====================================================================
	
	//TO STRING - Devuelve un String con la información del Submarino
	@Override
	public String toString()
	{
		return String.format("%s\nProfundidad máxima: %.2f m",super.toString(), this.maxProfundidad);
	}
}
