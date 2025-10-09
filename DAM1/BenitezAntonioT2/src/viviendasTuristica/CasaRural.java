/*
 * Clase que representa una Casa Rural
 * Extends: Vivienda
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/03/2025
 */
package viviendasTuristica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CasaRural extends Vivienda
{

// ATRIBUTOS =========================================================================
	
	public static final double METROS_DEFAULT = 1000;
	public static final LocalDate FECHACON_DEFAULT = LocalDate.of(2000, 01, 01);
	
	private static int numUltimo;
	
	private double metrosCuadrados;
	private LocalDate fechaConstruccion;
	private boolean admiteMascotas;
	
// CONSTRUCTORES =========================================================================
	
	//Constructor maestro (6 parámetros)
	public CasaRural(String direccion, double precio, boolean disponible, 
			double metrosCuadrados, LocalDate fechaConstruccion, boolean admiteMascotas) throws IllegalArgumentException
	{
		super(String.format("CR-%03d", numUltimo), direccion, precio, disponible);
		
		if(metrosCuadrados < 0)
		{
			throw new IllegalArgumentException("Los metros cuadrados no pueden ser negativos.");
		}
		
		this.metrosCuadrados = metrosCuadrados;
		this.fechaConstruccion = fechaConstruccion;
		this.admiteMascotas = admiteMascotas;
		
		do
		{
			numUltimo++;
		}while(numUltimo % 5 != 0);
	}
	
	//Constructor por omisión
	public CasaRural()
	{
		this(Vivienda.DIRECCION_DEFAULT, Vivienda.PRECIO_DEFAULT, false, METROS_DEFAULT, FECHACON_DEFAULT, false);
	}
	
// GETTERS =========================================================================	
	
	public double getMetrosCuadrados()
	{
		return this.metrosCuadrados;
	}
	
	public LocalDate getFechaConstruccion()
	{
		return this.fechaConstruccion;
	}
	
	public boolean getAdmiteMascotas() 
	{
		return this.admiteMascotas;
	}
	
// SETTERS =========================================================================
	
	public void setMetrosCuadrados(double metrosCuadrados)
	{
		if(metrosCuadrados < 0)
		{
			throw new IllegalArgumentException("Los metros cuadrados no pueden ser negativos.");
		}
		this.metrosCuadrados = metrosCuadrados;
	}
	
	public void setFechaConstruccion(LocalDate fechaConstruccion)
	{
		this.fechaConstruccion = fechaConstruccion;
	}
	
	public void setAdmiteMascotas(boolean admiteMascotas)
	{
		this.admiteMascotas = admiteMascotas;
	}
	
// MÉTODOS =========================================================================
	
	//CALCULAR PRECIO - Método que calcula el precio de una estancia basada en un parámetro de días
	@Override
	protected double calcularPrecio(int dias) 
	{
		double resultado = 0;
		if(ChronoUnit.YEARS.between(this.fechaConstruccion, LocalDate.now()) < 10)
		{
			resultado = (this.precio + (this.precio * 0.10)) * dias;
		}else
		{
			resultado = this.precio * dias;
		}
		return resultado;
	}
	
	//ES PET FRIENDLY - Devuelve true si la Casa Rural tiene más de 100 metros cuadrados y admite mascotas
	public boolean esPetFriendly()
	{
		return this.metrosCuadrados > 100 && this.admiteMascotas;
	}
	
	//TO STRING - Devuelve un String con la información detallada de la Casa Rural
	@Override
	public String toString()
	{
		return String.format("%s - Metros cuadrados: %.2f m - Fecha construcción: %s - Admite mascotas: %s",
				super.toString(), this.metrosCuadrados, dateFormat(this.fechaConstruccion), this.admiteMascotas ? "Sí" : "No");
	}
}
