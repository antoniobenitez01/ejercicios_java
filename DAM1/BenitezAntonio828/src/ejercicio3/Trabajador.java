/*
 * Clase que representa un Trabajador
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025
 */
package ejercicio3;

public class Trabajador 
{
	
//ATRIBUTOS -------------------------------------------------------------------------------------
	
	public enum estadoCivil {CASADO, VIUDO, COMPROMETIDO, SEPARADO, SOLTERO}
	
	private String nombre;
	private int edad;
	private boolean sexo;
	private estadoCivil estadoCivil;
	private double salarioBase;
	
// CONSTRUCTORES ---------------------------------------------------------------------------------
	
	//Constructor maestro (5 parámetros)
	public Trabajador(String nombre, int edad, boolean sexo, estadoCivil estadoCivil, double salarioBase)
	{
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.salarioBase = salarioBase;
	}
	
// GETTERS ----------------------------------------------------------------------------------------
	
	public double getSalarioBase()
	{
		return this.salarioBase;
	}
	
	public estadoCivil getEstadoCivil()
	{
		return this.estadoCivil;
	}
	
	public boolean esHombre()
	{
		return this.sexo;
	}
	
//MÉTODOS ------------------------------------------------------------------------------------------
	
	//TO STRING - Devuelve un objeto String con la información detalla del Trabajador
	public String toString()
	{
		return String.format("Nombre: %s - Edad: %d - Sexo: %s - Estado civil: %s - Salario base: %.2f€",
				this.nombre, this.edad, this.sexo ? "Hombre" : "Mujer", this.estadoCivil.toString(), this.salarioBase);
	}
}
