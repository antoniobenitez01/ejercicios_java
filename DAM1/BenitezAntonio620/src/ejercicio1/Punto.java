/*
 * Clase que representa un Punto en un plano
 * mediante dos coordenadas X e Y
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/01/2025
 */
package ejercicio1;

public class Punto 
{
	//ATRIBUTOS ================================
	
	private double x; //Coordenada X del objeto Punto
	private double y; //Coordenada Y del objeto Punto
	
	// CONSTRUCTORES ===========================
	
	//	Constructor maestro (todos los atributos)
	public Punto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	//	Constructor por omisión
	public Punto()
	{
		this(0,0);
	}
	
	// GETTERS Y SETTERS =======================
	
	//GET - Devuelve la coordenada X del objeto Punto
	public double getX()
	{
		return this.x;
	}
	
	//SET - Recoge un valor decimal para establecerlo como la coordenada X del objeto Punto
	public void setX(double x)
	{
		this.x = x;
	}
	
	//GET - Devuelve la coordenada Y del objeto Punto
	public double getY()
	{
		return this.y;
	}
	
	//SET - Recoge un valor decimal para establecerlo como la coordenada Y del objeto Punto
	public void setY(double y)
	{
		this.y = y;
	}
	
	// MÉTODOS ================================
	
	//Devuelve el objeto Punto representado en formato String
	public String toString()
	{
		return String.format("(%.1f _ %.1f)", this.x, this.y);
	}
}
