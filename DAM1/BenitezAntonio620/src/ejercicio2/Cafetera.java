/*
 * Clase que representa una Cafetera con
 * una capacidad máxima y una cantidad actual de café.
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/01/2025
 */
package ejercicio2;

public class Cafetera 
{
	//ATRIBUTOS ================================
	
	private double capacidadMaxima; //Capacidad máxima del objeto Cafetera
	private double cantidadActual; //Cantidad actual del objeto Cafetera
	
	// CONSTRUCTORES ===========================
	
	//	Constructor maestro (todos los atributos)
	public Cafetera(double capacidadMaxima, double cantidadActual) throws IllegalArgumentException
	{
		if(cantidadActual > capacidadMaxima)
		{
			this.capacidadMaxima = capacidadMaxima;
			this.cantidadActual = capacidadMaxima;
			throw new IllegalArgumentException ("Sobran " + (cantidadActual - capacidadMaxima) + " c.c." +
												"\nSe ha creado la cafetera llena con la capacidad máxima.");
		}
		else
		{
			this.capacidadMaxima = capacidadMaxima;
			this.cantidadActual = cantidadActual;
		}
	}
	
	//	Constructor por omisión
	public Cafetera()
	{
		this(1000, 0);
	}
	
	// GETTERS Y SETTERS =======================
	
	//GET - Devuelve la capacidad máxima como valor decimal
	public double getCapacidadMaxima()
	{
		return this.capacidadMaxima;
	}
	
	//SET - Recoge un valor decimal para establecerlo como la capacidad máxima
	public void setCapacidadMaxima(double capacidadMaxima)
	{
		this.capacidadMaxima = capacidadMaxima;
	}
	
	//GET - Devuelve la cantidad acutal como valor decimal
	public double getCantidadActual()
	{
		return this.cantidadActual;
	}
	
	//SET - Recoge un valor decimal para establecerlo como la cantidad actual
	public void setCantidadActual(double cantidadActual)
	{
		this.cantidadActual = cantidadActual;
	}
	
	// MÉTODOS =================================
	
	//Agrega una cantidad decimal a la cantidad actual
	public void llenarCafetera(double cantidad) throws IllegalArgumentException
	{
		if(cantidad < 0)
		{
			throw new IllegalArgumentException ("No se puede llenar una cantidad negativa.");
		}
		if((this.cantidadActual + cantidad) > this.capacidadMaxima)
		{
			throw new IllegalArgumentException ("No se puede llenar más que la capacidad máxima.");
		}
		this.cantidadActual = this.cantidadActual + cantidad;
	}
	
	//Simula el acto de servir una taza, restando una cantidad entera a la cantidadActual
	public void servirTaza(int cantidad)
	{
		if(this.cantidadActual - cantidad < 0)
		{
			vaciarCafetera();
			throw new IllegalArgumentException ("No hay suficiente café. Se ha servido el resto.");
		}
		this.cantidadActual = this.cantidadActual - cantidad;
	}
	
	//Establece la cantidad actual como 0
	public void vaciarCafetera()
	{
		this.cantidadActual = 0;
	}
	
	//Establece la cantidad acutal igual que la capacidad máxima
	public void llenarCafeteraEntera()
	{
		this.cantidadActual = this.capacidadMaxima;
	}
	
	//Devuelve el objeto Cafetera representado en formato String
	public String toString()
	{
		return String.format("Capacidad máxima: %.2f \nCantidad actual: %.2f", this.capacidadMaxima, this.cantidadActual);
	}
}
