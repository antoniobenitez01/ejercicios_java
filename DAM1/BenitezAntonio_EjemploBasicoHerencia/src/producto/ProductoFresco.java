/*
 * Clase que representa un Producto Fresco
 * Esta clase contiene los siguientes atributos:
 * 		- codigo: Código del Producto en formato 0000
 * 		- nombre: Nombre del Producto
 * 		- fechaCaducidad: Fecha de caducidad del Producto en formato LocalDate
 * 		- numeroLote: Número de Lote del Producto
 * 		- fechaEnvasado: Fecha en la que se ha envasado el Producto en formato LocalDate
 * 		- paisOrigen: País de origen del Producto
 * 
 * Además contiene atributos de clase como:
 * 		- numUltimoProducot: Último número usado del código de la clase Producto
 * 		- NUM_MAXIMO_PRODUCTO: Número máximo de código de la clase Producto
 * 
 * Herencia: Producto
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/02/2025 
 */
package producto;

import java.time.LocalDate;

public class ProductoFresco extends Producto
{
	
// ATRIBUTOS ---------------------------------------------
	
	private LocalDate fechaEnvasado;
	private String paisOrigen;
	
// CONSTRUCTORES ---------------------------------------------
	
	//Constructor maestro (cinco parámetros)
	public ProductoFresco(String nombre, LocalDate fechaCaducidad, int numeroLote, 
			LocalDate fechaEnvasado, String paisOrigen) throws IllegalArgumentException
	{	
		super(nombre, fechaCaducidad, numeroLote);
		
		if(fechaEnvasado.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("La fecha de envasado no puede ser posterior a la fecha de hoy");
		}
		stringException(paisOrigen, "País de origen");
		
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}
	
	//Constructor por omisión
	public ProductoFresco()
	{
		this("Defecto", LocalDate.of(2999, 12, 28), 999999, LocalDate.of(1999, 12, 28), "Defecto");
	}
	
// GETTERS ---------------------------------------------
	
	//Devuelve la fechaEnvasado del ProductoFresco en formato LocalDate
	public LocalDate getFechaEnvasado()
	{
		return this.fechaEnvasado;
	}
	
	//Devuelve el paisOrigen del ProductoFresco en formato String
	public String getPaisOrigen()
	{
		return this.paisOrigen;
	}
	
// SETTERS ---------------------------------------------
	
	//Establece la fecha de envasado del ProductoFresco pasado por parámetro
	public void setFechaEnvasado(LocalDate fechaEnvasado)
	{
		this.fechaEnvasado = fechaEnvasado;
	}
	
	//Establece el país de origen del ProductoFresco pasado por parámetro
	public void setPaisOrigen(String paisOrigen)
	{
		stringException(paisOrigen, "País de origen");
		this.paisOrigen = paisOrigen;
	}
	
// MÉTODOS ---------------------------------------------
	
	//TO STRING - Devuelve un String que representa la información del ProductoFresco
	@Override
	public String toString()
	{
		return String.format("%s \nFecha de envasado: %s \nPaís de Origen: %s",
				super.toString(), fechaFormato(this.fechaEnvasado),this.paisOrigen);
	}
}
