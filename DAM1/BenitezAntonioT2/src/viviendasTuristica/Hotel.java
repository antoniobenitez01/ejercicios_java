/*
 * Clase que representa un Hotel
 * Extends: Vivienda
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/03/2025
 */
package viviendasTuristica;

public class Hotel extends Vivienda
{

// ATRIBUTOS =========================================================================
	
	public static final int ESTRELLAS_DEFAULT = 0;
	public static final int HABITACIONES_DEFAULT = 50;
	
	private static int numUltimo;
	
	private int estrellas;
	private int numHabitaciones;
	private boolean tieneSpa;
	
// CONSTRUCTORES =========================================================================
	
	//Constructor maestro (6 parámetros)
	public Hotel(String direccion, double precio, boolean disponible, 
			int estrellas, int numHabitaciones, boolean tieneSpa)
	{
		super(String.format("HO-%03d", numUltimo), direccion, precio, disponible);
		
		this.estrellas = estrellas;
		this.numHabitaciones = numHabitaciones;
		this.tieneSpa = tieneSpa;
		
		do
		{
			numUltimo++;
		}while(numUltimo % 5 != 0);
	}
	
	//Constructor por omisión
	public Hotel()
	{
		this(Vivienda.DIRECCION_DEFAULT, Vivienda.PRECIO_DEFAULT, false, ESTRELLAS_DEFAULT, HABITACIONES_DEFAULT, false);
	}
	
// GETTERS =========================================================================
	
	public int getEstrellas()
	{
		return this.estrellas;
	}
	
	public int getNumHabitaciones()
	{
		return this.numHabitaciones;
	}
	
	public boolean getTieneSpa()
	{
		return this.tieneSpa;
	}
	
// SETTERS =========================================================================
	
	public void setEstrellas(int estrellas)
	{
		this.estrellas = estrellas;
	}
	
	public void setNumHabitaciones(int numHabitaciones)
	{
		this.numHabitaciones = numHabitaciones;
	}
	
	public void setTieneSpa(boolean tieneSpa)
	{
		this.tieneSpa = tieneSpa;
	}

// MÉTODOS =========================================================================
	
	//CALCULAR PRECIO - Método que calcula el precio de una estancia basada en un parámetro de días
	@Override
	protected double calcularPrecio(int dias) 
	{
		double resultado = 0;
		
		if(this.estrellas >= 3)
		{
			resultado = (this.precio + (this.precio * 0.05)) * dias;
		}else
		{
			resultado = this.precio * dias;
		}
		
		if(this.tieneSpa)
		{
			resultado += 30; 
		}
		
		return resultado;
	}

	//ES LUJOSO - Devuelve true si el Hotel tiene 5 estrellas y tiene spa
	public boolean esLujoso()
	{
		return this.estrellas == 5 && this.tieneSpa;
	}
	
	//TO STRING - Devuelve un String con la información detallada del Hotel
	@Override
	public String toString()
	{
		return String.format("%s - Estrellas: %d - Número de habitaciones: %d - Tiene Spa: %s",
				super.toString(), this.estrellas, this.numHabitaciones, this.tieneSpa ? "Sí" : "No");
	}
}
