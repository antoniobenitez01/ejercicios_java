/*
 * Clase que representa un Atleta
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 20/03/2025
 */
package ejercicio1;

public class Atleta 
{
// ATRIBUTOS -------------------------------------------------------------
	
	private String nombre;
	private int edad;
	private double altura;
	
// CONSTRUCTORES ---------------------------------------------------------
	
	//Constructor maestro (3 parámetros)
	public Atleta(String nombre, int edad, double altura)
	{
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
	}
	
// GETTERS ----------------------------------------------------------------
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getEdad()
	{
		return this.edad;
	}
	
	public double getAltura()
	{
		return this.altura;
	}
	
// MÉTODOS ----------------------------------------------------------------
	
	//TO STRING - Devuelve un objeto String con la información detallada del Atleta
	public String toString()
	{
		return String.format("Nombre: %s | Edad: %d | Altura: %.2f", this.nombre, this.edad, this.altura);
	}
}
