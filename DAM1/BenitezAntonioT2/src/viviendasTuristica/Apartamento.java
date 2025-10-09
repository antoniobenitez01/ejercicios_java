/*
 * Clase que representa un Apartamento
 * Extends: Vivienda
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/03/2025
 */
package viviendasTuristica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Apartamento extends Vivienda
{
	
// ATRIBUTOS ==========================================================================
	
	public static final int HABITACIONES_DEFAULT = 50;
	public static final double DISTANCIA_DEFAULT = 500;
	public static final LocalDate FECHAREF_DEFAULT = LocalDate.of(2000, 01, 01);
	
	private static int numUltimo;
	
	private int numHabitaciones;
	private double distCiudad;
	private LocalDate fechaReforma;
	
// CONSTRUCTORES =======================================================================
	
	//Constructor maestro (6 parámetros)
	public Apartamento(String direccion, double precio, boolean disponible, 
			int numHabitaciones, double distCiudad, LocalDate fechaReforma) throws IllegalArgumentException
	{
		super(String.format("AA-%03d", numUltimo), direccion, precio, disponible);
		
		if(fechaReforma.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("La fecha de la última reforma debe ser anterior a la fecha actual.");
		}
		
		this.numHabitaciones = numHabitaciones;
		this.distCiudad = distCiudad;
		this.fechaReforma = fechaReforma;
		
		do
		{
			numUltimo++;
		}while(numUltimo % 5 != 0);
	}
	
	//Constructor por omisión
	public Apartamento()
	{
		this(Vivienda.DIRECCION_DEFAULT, Vivienda.PRECIO_DEFAULT, false, HABITACIONES_DEFAULT, DISTANCIA_DEFAULT, FECHAREF_DEFAULT);
	}
	
// GETTERS =========================================================================
	
	public int getHabitaciones()
	{
		return this.numHabitaciones;
	}
	
	public double getDistanciaCiudad()
	{
		return this.distCiudad;
	}
	
	public LocalDate getFechaReforma()
	{
		return this.fechaReforma;
	}
	
// SETTERS =========================================================================
	
	public void setHabitaciones(int numHabitaciones)
	{
		this.numHabitaciones = numHabitaciones;
	}
	
	public void setDistanciaCiudad(double distCiudad)
	{
		this.distCiudad = distCiudad;
	}
	
	public void setFechaReforma(LocalDate fechaReforma)
	{
		if(fechaReforma.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("La fecha de la última reforma debe ser anterior a la fecha actual.");
		}
		this.fechaReforma = fechaReforma;
	}
	
//MÉTODOS ==========================================================================

	//CALCULAR PRECIO - Método que calcula el precio de una estancia basada en un parámetro de días
	@Override
	protected double calcularPrecio(int dias) 
	{
		double resultado = 0;
		if(this.distCiudad < 1)
		{
			resultado = (this.precio + (this.precio * 0.20)) * dias;
		}else
		{
			resultado = this.precio * dias;
		}
		return resultado;
	}
	
	//DIAS RENOVACION - Calcula los días desde la última fecha de renovación
	public int diasRenovacion()
	{
		return (int) ChronoUnit.DAYS.between(this.fechaReforma, LocalDate.now());
	}
	
	//TO STRING - Devuelve un String con la información detallada del Apartamento
	@Override
	public String toString()
	{
		return String.format("%s - Número de habitaciones: %d - Distancia a la ciudad: %.2f m - Fecha de última reforma: %s",
				super.toString(), this.numHabitaciones, this.distCiudad, dateFormat(this.fechaReforma));
	}
}
