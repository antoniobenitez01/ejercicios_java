/*
 * Clase que representa un Producto Congelado
 * Esta clase contiene los siguientes atributos:
 * 		- codigo: Código del Producto en formato 0000
 * 		- nombre: Nombre del Producto
 * 		- fechaCaducidad: Fecha de caducidad del Producto en formato LocalDate
 * 		- numeroLote: Número de Lote del Producto
 * 		- tempCongelacion: Temperatura de congelación del Producto
 * 		- mesesConservacion: Meses que se puede conservar el Producto
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

public class ProductoCongelado extends Producto 
{
	
// ATRIBUTOS ---------------------------------------------
	
	private double tempCongelacion;
	private int mesesConservacion;
	
// CONSTRUCTORES ---------------------------------------------
	
	//Constructor maestro (cinco parámetros)
	public ProductoCongelado(String nombre, LocalDate fechaCaducidad, int numeroLote, 
			double tempCongelacion, int mesesConservacion) throws IllegalArgumentException
	{
		super(nombre, fechaCaducidad, numeroLote);
		
		minusValueException(mesesConservacion, "Meses de conservación");
		
		this.tempCongelacion = tempCongelacion;
		this.mesesConservacion = mesesConservacion;
	}
	
	//Constructor por omisión
	public ProductoCongelado()
	{
		this("Defecto", LocalDate.of(2999, 12, 28), 999999, -999, 0);
	}
	
// GETTERS ---------------------------------------------
	
	//Devuelve la tempCongelacion del ProductoCongelado como valor decimal double
	public double getTemperaturaCongelacion()
	{
		return this.tempCongelacion;
	}
	
	//Devuelve los mesesConservacion del ProductoCongelado como valor entero int
	public int getMesesConservacion()
	{
		return this.mesesConservacion;
	}
	
// SETTERS ---------------------------------------------
	
	//Establece la tempCongelacion del ProductoCongelado pasada por parámetro
	public void setTemperaturaCongelacion(double tempCongelacion)
	{
		this.tempCongelacion = tempCongelacion;
	}
	
	//Establece los mesesConservacion del ProductoCongelado pasados por parámetro
	public void setMesesConservacion(int mesesConservacion)
	{
		minusValueException(mesesConservacion, "Meses de Conservación");
		this.mesesConservacion = mesesConservacion;
	}
	
// MÉTODOS ---------------------------------------------
	
	//TO STRING - Devuelve un String que representa la información del ProductoCongelado
	@Override
	public String toString()
	{
		return String.format("%s \nTemperatura Congelación: %.2fºC \nMeses conservación: %d %s",
				super.toString(), this.tempCongelacion, this.mesesConservacion, this.mesesConservacion > 1 ? "meses" : "mes");
	}
}
