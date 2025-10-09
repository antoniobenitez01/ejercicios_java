/*
 * Clase que representa un Deportivo
 * Extends: Coche
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025 
 */
package ejercicio2;

public class Deportivo extends Coche
{
	
// ATRIBUTOS ==================================================
	
	private boolean traccion; //True = Total || False = Delantera
	
// CONSTRUCTORES ==================================================
	
	//Constructor maestro (5 parámetros)
	public Deportivo(String matricula, String nombrePropietario, double cilindrada, double potencia, boolean traccion)
	{
		super(matricula, nombrePropietario, cilindrada, potencia);
		this.traccion = traccion;
	}
	
// MÉTODOS ==================================================
	
	//TO STRING - Devuelve un String con la información detallada del Deportivo
	@Override
	public String toString()
	{
		return String.format("%s"
				+ "\nTraccion: %s",super.toString(),this.traccion ? "Total" : "Delantera");
	}
}
