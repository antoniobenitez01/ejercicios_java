/*
 * Excepción personalizada AvisarHaciendaException
 * para las excepciones que se lanzan al crear un objeto CuentaBancaria
 * Extends: Exception
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/02/2025
 */
package ejercicio4;

public class AvisarHaciendaException extends Exception
{
	private String titular;
	private String iban;
	private String operacion;
	private double cantidad;
	
	AvisarHaciendaException(String titular, String iban, String operacion, double cantidad)
	{
		this.titular = titular;
		this.iban = iban;
		this.operacion = operacion;
		this.cantidad = cantidad;
	}
	
	public String toString()
	{
		return String.format("Titular: %s - IBAN: %s"
				+ "\nPara %s %.2f€ debe avisar a Hacienda.", this.titular, this.iban, this.operacion, this.cantidad);
	}
}
