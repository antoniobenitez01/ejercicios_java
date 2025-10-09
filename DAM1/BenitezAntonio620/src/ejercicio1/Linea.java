/*
 * Clase que representa una línea basada en
 * dos objetos Punto como coordenadas.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/01/2025
 */
package ejercicio1;

public class Linea 
{
	//ATRIBUTOS ================================
	
	private Punto puntoA; //Punto A de la Línea
	private Punto puntoB; //Punto B de la Línea
	
	// CONSTRUCTORES ===========================

	//	Constructor maestro (todos los atributos)
	public Linea(Punto puntoA, Punto puntoB)
	{
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}
	
	//	Constructor por omisión
	public Linea()
	{
		this.puntoA = new Punto(0,0);
		this.puntoB = new Punto(0,0);
	}
	
	// GETTERS Y SETTERS =======================
	
	//GET - Devuelve el objeto Punto puntoA del objeto Línea
	public Punto getPuntoA()
	{
		return this.puntoA;
	}
	
	//SET - Recoge valores double x e y para establecer el objeto Punto puntoA del objeto Línea
	public void setPuntoA(double x, double y)
	{
		this.puntoA.setX(x);
		this.puntoA.setY(y);
	}

	//GET - Devuelve el objeto Punto puntoB del objeto Línea
	public Punto getPuntoB()
	{
		return this.puntoB;
	}

	//SET - Recoge valores double x e y para establecer el objeto Punto puntoB del objeto Línea
	public void setPuntoB(double x, double y)
	{
		this.puntoB.setX(x);
		this.puntoB.setY(y);
	}
	
	// MÉTODOS ================================
	
	//Mueve las coordenadas de la línea hacia la derecha
	public void mueveDerecha(double distancia)
	{
		this.puntoA.setX(puntoA.getX() + distancia);
		this.puntoB.setX(puntoB.getX() + distancia);
	}
	
	//Mueve las coordenadas de la línea hacia la izquierda
	public void mueveIzquierda(double distancia)
	{
		this.puntoA.setX(puntoA.getX() - distancia);
		this.puntoB.setX(puntoB.getX() - distancia);
	}
	
	//Mueve las coordenadas de la línea hacia arriba
	public void mueveArriba(double distancia)
	{
		this.puntoA.setY(puntoA.getY() + distancia);
		this.puntoB.setY(puntoB.getY() + distancia);
	}
	
	//Mueve las coordenadas de la línea hacia abajo
	public void mueveAbajo(double distancia)
	{
		this.puntoA.setY(puntoA.getY() - distancia);
		this.puntoB.setY(puntoB.getY() - distancia);
	}
	
	//Muestra por pantalla el objeto Línea formateado
	public void escribirLinea()
	{
		System.out.println("[" + puntoA.toString() + "," + puntoB.toString() + "]");
	}
}
