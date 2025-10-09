/*
 * Clase que representa un Cuadrado
 * Implements: Figura2D
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/02/2025 
 */
package ejercicio3;

public class Cuadrado implements Figura2D
{
	
// ATRIBUTOS ===============================================================
	
	private double longLado;
	
// CONSTRUCTORES ===========================================================
	
	//Constructor maestro (1 parámetro)
	public Cuadrado(double longLado) throws IllegalArgumentException
	{
		if(longLado < 0)
		{
			throw new IllegalArgumentException ("La longitud de los lados no puede ser menor que 0.");
		}
		this.longLado = longLado;
	}
	
// MÉTODOS ==================================================================

	//PERIMETRO - Calcula y devuelve el perímetro del Cuadrado
	@Override
	public double perimetro() 
	{
		return this.longLado * 4;
	}

	//ÁREA - Calcula y devuelve el área del Cuadrado
	@Override
	public double area() 
	{
		return this.longLado * this.longLado;
	}

	//ESCALAR - Aumenta la escala del Cuadrado en torno a un valor parámetro
	@Override
	public void escalar(double escala) 
	{
		if(escala < 0)
		{
			throw new IllegalArgumentException("La escala no puede ser menor que 0.");
		}
		this.longLado = this.longLado * escala;
	}

	//IMPRIMIR - Muestra por pantalla la información del Cuadrado en una sola línea
	@Override
	public void imprimir() 
	{
		System.out.printf("Longitud de los lados: %.2f cm\n", this.longLado);
	}
}
