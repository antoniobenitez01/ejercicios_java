/*
 * Clase que representa un Día y su Temperatura Media
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 24/03/2025
 */
package ejercicio8;

public class DiaTemperatura 
{	
	
// ATRIBUTOS -------------------------------------------------------------------------
	
	private int numDia;
	private String dia;
	private double tempMedia;
	
// CONSTRUCTORES ----------------------------------------------------------------------
	
	//Constructor maestro (3 parámetros)
	public DiaTemperatura(int numDia, String dia, double tempMedia)
	{
		this.numDia = numDia;
		this.dia = dia;
		this.tempMedia = tempMedia;
	}
	
// GETTERS -----------------------------------------------------------------------------
	
	public double getTempMedia()
	{
		return this.tempMedia;
	}
	
// MÉTODOS -----------------------------------------------------------------------------
	
	//TO STRING - Devuelve un objeto String con la información detallada del Día y su Temperatura Media
	public String toString()
	{
		return String.format("%2d - %s - %.2fºC", this.numDia, this.dia, this.tempMedia);
	}
}
