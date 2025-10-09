/*
 * Excepción personalizada CuentaException
 * para las excepciones que se lanzan al crear un objeto CuentaBancaria
 * Extends: Exception
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/02/2025
 */
package ejercicio4;

public class CuentaException extends Exception
{
	private String string;
	private String nombre;
	
	CuentaException(String string, String nombre)
	{
		this.string = string;
		this.nombre = nombre;
	}
	
	public String toString()
	{
		return String.format("El campo %s no puede estar vacío o ser nulo.", this.nombre);
	}
}
