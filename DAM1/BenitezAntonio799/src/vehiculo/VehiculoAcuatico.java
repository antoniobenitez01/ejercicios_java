/*
 * Clase que representa un Vehiculo Acuático
 * Extends: Vehiculo
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025 
 */
package vehiculo;

import java.time.LocalDate;

public class VehiculoAcuatico extends Vehiculo
{
	
// ATRIBUTOS ===============================================================
	
	public static final String MATRICULA_ACUA_DEFAULT = "AAAAA";
	public static final double ESLORA_DEFAULT = 10;
		
	private final double eslora;
		
// CONSTRUCTORES ===========================================================
	
	//Constructor maestro (3 parámetros)
	public VehiculoAcuatico(String matricula, String modelo, LocalDate fechaFabricacion, double eslora) throws IllegalArgumentException
	{
		super(matricula, modelo, "[A-Z]{3,10}", fechaFabricacion);
			
		if(eslora < 0)
		{
			throw new IllegalArgumentException("La eslora no puede ser menor que 0.");
		}
			
		this.eslora = eslora;
	}
		
// GETTERS ==================================================================
		
	//Devuelve el número de ruedas del Vehículo Terrestre como entero short
	public double getEslora()
	{
		return this.eslora;
	}
		
// MÉTODOS ==================================================================
		
	//TO STRING - Devuelve un String con la información del Vehículo Terrestre
	@Override
	public String toString()
	{
		return String.format("%s\nEslora: %.2f m", super.toString(), this.eslora);
	}
}
