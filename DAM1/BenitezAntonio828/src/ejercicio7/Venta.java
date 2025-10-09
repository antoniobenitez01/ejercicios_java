/*
 * Clase que representa una Venta de coches
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 24/03/2025
 */
package ejercicio7;

public class Venta 
{
	
// ATRIBUTOS ------------------------------------------------------------------------------------
	
	public enum mes{ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE};
	
	private mes mes;
	private int ventas;

// CONSTRUCTORES ---------------------------------------------------------------------------------
	
	//Constructor maestro (2 parámetros)
	public Venta(mes mes, int ventas)
	{
		this.mes = mes;
		this.ventas = ventas;
	}
	
// GETTERS ----------------------------------------------------------------------------------------
	
	public mes getMes()
	{
		return this.mes;
	}
	
	public int getVentas() 
	{
		return this.ventas;
	}
	
	public void setVentas(int ventas)
	{
		this.ventas = ventas;
	}
	
// MÉTODOS -----------------------------------------------------------------------------------------
	
	//TO STRING - Devuelve un objeto String con la información detallada de la Venta
	public String toString()
	{
		return String.format("%s: %d ventas", this.mes.toString(), this.ventas);
	}
}
