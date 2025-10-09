/*
 * Clase que representa a una Persona
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025
 */
package ejercicio4;

public class Persona 
{
	
// ATRIBUTOS ------------------------------------------------------------------------------------------
	
	public enum estadoCivil{SOLTERO, CASADO, VIUDO, DIVORCIADO};
	
	private String nombre;
	private boolean sexo;
	private estadoCivil estadoCivil;
	private int edad;
	
// CONSTRUCTORES ---------------------------------------------------------------------------------------
	
	//Constructor maestro (4 parámetros)
	public Persona(String nombre, boolean sexo, estadoCivil estadoCivil, int edad)
	{
		this.nombre = nombre;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.edad = edad;
	}
	
// GETTERS ----------------------------------------------------------------------------------------------
	
	public boolean esHombre()
	{
		return this.sexo;
	}
	
	public estadoCivil getEstadoCivil()
	{
		return this.estadoCivil;
	}
	
	public int getEdad()
	{
		return this.edad;
	}
	
// MÉTODOS -----------------------------------------------------------------------------------------------
	
	//TO STRING - Devuelve un objeto String con la información detallada de la Persona
	public String toString()
	{
		return String.format("Nombre: %s - Sexo: %s - Estado civil: %s - Edad: %d",
				this.nombre, this.sexo ? "Masculino" : "Femenino", this.estadoCivil.toString(), this.edad);
	}
}
