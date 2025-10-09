/*
 * Clase que representa un Ingrediente
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 23/03/2025
 */
package ejercicio6;

public class Ingrediente 
{

// ATRIBUTOS ------------------------------------------------------------------------------------------------
	
	private static int ultNum;
	
	private String codigo;
	private String nombre;
	private int cantidad;
	private int minStock;
	
// INICIALIZACIÓN ---------------------------------------------------------------------------------------------
	
	static 
	{
		ultNum = 1;
	}
	
// CONSTRUCTORES ----------------------------------------------------------------------------------------------
	
	//Constructor maestro (3 parámetros)
	public Ingrediente(String nombre, int cantidad, int minStock)
	{
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.minStock = minStock;
		
		this.codigo = String.format("%s%03d", this.nombre.substring(0, 3).toUpperCase(), ultNum);
		ultNum++;
	}
	
// GETTERS ------------------------------------------------------------------------------------------------------
	
	public String getCodigo()
	{
		return this.codigo;
	}
	
// MÉTODOS -------------------------------------------------------------------------------------------------------
	
	//ACTUALIZAR STOCK - Recibe una cantidad entera y la resta de la cantidad del Ingrediente
	public void actualizarStock(int cantidad) throws IllegalArgumentException
	{
		if(this.cantidad - cantidad < this.minStock)
		{
			int leftover = this.cantidad - this.minStock;
			this.cantidad = this.minStock;
			throw new IllegalArgumentException(String.format("El ingrediente no tiene suficiente stock."
					+ " Se han devuelto %d %s del Ingrediente", leftover, leftover == 1 ? "unidad" : "unidades"));
		}
		this.cantidad -= cantidad;
	}
	
	//TO STRING - Devuelve un objeto String con la información detallada del Ingrediente
	public String toString()
	{
		return String.format("Código: %s - Ingrediente: %s - Cantidad: %d - Stock mínimo: %d",
				this.codigo, this.nombre, this.cantidad, this.minStock);
	}
}
