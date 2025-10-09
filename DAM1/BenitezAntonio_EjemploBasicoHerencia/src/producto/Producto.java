/*
 * Clase que representa un Producto
 * Esta clase contiene los siguientes atributos:
 * 		- codigo: Código del Producto en formato 0000
 * 		- nombre: Nombre del Producto
 * 		- fechaCaducidad: Fecha de caducidad del Producto en formato LocalDate
 * 		- numeroLote: Número de Lote del Producto
 * 
 * Además contiene atributos de clase como:
 * 		- numUltimoProducot: Último número usado del código de la clase Producto
 * 		- NUM_MAXIMO_PRODUCTO: Número máximo de código de la clase Producto
 * 
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/02/2025 
 */
package producto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Producto 
{
	
// ATRIBUTOS ---------------------------------------------
	
	private static int numUltimoProducto;
	public static final int NUM_MAXIMO_PRODUCTO = 9999;
	
	private String codigo;
	private String nombre;
	private LocalDate fechaCaducidad;
	private int numeroLote;
	
// CONSTRUCTORES ---------------------------------------------
	
	//Constructor maestro (3 parámetros)
	protected Producto(String nombre, LocalDate fechaCaducidad, int numeroLote) throws IllegalArgumentException
	{
		stringException(nombre, "Nombre");
		localDateException(fechaCaducidad, "Fecha de caducidad");
		minusValueException(numeroLote, "Número de lote");
		
		if(numUltimoProducto > NUM_MAXIMO_PRODUCTO)
		{
			throw new IllegalArgumentException("Se ha alcanzado el máximo de productos.");
		}
		
		this.nombre = nombre;
		this.fechaCaducidad = fechaCaducidad;
		this.numeroLote = numeroLote;
		
		this.codigo = String.format("%04d", numUltimoProducto);
		numUltimoProducto++;
	}
	
// GETTERS ---------------------------------------------
	
	//Devuelve el código del Producto en String
	public String getCodigo()
	{
		return this.codigo;
	}
	
	//Devuelve el nombre del Producto en String
	public String getNombre()
	{
		return this.nombre;
	}
	
	//Devuelve la fechaCaducidad del Producto en formato LocalDate
	public LocalDate getFechaCaducidad()
	{
		return this.fechaCaducidad;
	}
	
	//Devuelve el numeroLote del Producto como valor entero int
	public int getNumeroLote()
	{
		return this.numeroLote;
	}
	
	//Devuelve el numUltimoProducto de la clase Producto como valor entero int
	public static int getNumUltimoProducto()
	{
		return numUltimoProducto;
	}
	
// SETTERS ---------------------------------------------
	
	//Establece el nombre del Producto pasado por parámetro
	public void setNombre(String nombre)
	{
		stringException(nombre, "nombre");
		this.nombre = nombre;
	}
	
	//Establece la fechaCaducidad del Producto pasada por parámetro
	public void setFechaCaducidad(LocalDate fechaCaducidad)
	{
		localDateException(fechaCaducidad, "Fecha de caducidad");
		this.fechaCaducidad = fechaCaducidad;
	}
	
	//Establece el numeroLote del Producto pasado por parámetro
	public void setNumeroLote(int numeroLote)
	{
		minusValueException(numeroLote, "Número de Lote");
		this.numeroLote = numeroLote;
	}
	
// MÉTODOS --------------------------------------------- (Los métodos '*' son métodos privados o protected)
	
	//ESTA CADUCADO - Devuelve true si el prodcuto está caducado
	public boolean estaCaducado()
	{
		boolean caducado = false;
		if(LocalDate.now().isAfter(this.fechaCaducidad))
		{
			caducado = true;
		}
		return caducado;
	}
	
	//DÍAS HASTA CADUCAR - Calcula y devuelve los días que quedan hasta que el producto esté caducado
	public int diasHastaCaducar() throws IllegalStateException
	{
		if(estaCaducado())
		{
			throw new IllegalStateException("El producto ya está caducado.");
		}
		
		int dias = (int) ChronoUnit.DAYS.between(LocalDate.now(), this.fechaCaducidad);
		return dias;
	}
	
	//TO STRING - Devuelve un String que representa la información del Producto
	public String toString()
	{
		return String.format("Código: %s \nNombre: %s \nFecha caducidad: %s \nNúmero de Lote: %010d",
				this.codigo, this.nombre, fechaFormato(this.fechaCaducidad), this.numeroLote);
	}
	
	//*FECHA FORMATO - Devuelve la fecha introducida por parámetro como un String formateado
	protected String fechaFormato(LocalDate fecha)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fecha.format(formato);
	}
	
	//*EXCEPTION STRING - Lanza excepciones de objetos String vacíos o nulos
	protected void stringException(String text, String nombre) throws IllegalArgumentException
	{
		if(text.isEmpty() || text == null)
		{
			throw new IllegalArgumentException(String.format("%s no puede ser vacío o nulo", nombre));
		}
	}
	
	//*EXCEPTION LOCALDATE - Lanza excepciones de objetos LocalDate anteriores a la fecha de hoy
	protected void localDateException(LocalDate date, String nombre) throws IllegalArgumentException
	{
		if(date == null)
		{
			throw new IllegalArgumentException(String.format("%s no puede ser nulo", nombre));
		}
		if(date.isBefore(LocalDate.now()))
		{
			throw new IllegalArgumentException(String.format("%s no puede ser anterior a la fecha de hoy", nombre));
		}
	}
	
	//*EXCEPCION MINUSVALUE - Lanza excepción si el valor entero es menor que 0
	protected void minusValueException(int value, String nombre)
	{
		if(value < 0)
		{
			throw new IllegalArgumentException(String.format("%s no puede ser menor que 0", nombre));
		}
	}
}
