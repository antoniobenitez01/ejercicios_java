/*
 * Clase que representa un Círculo
 * Implements: Figura2D
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/02/2025 
 */
package ejercicio3;

public class Circulo implements Figura2D
{
	
// ATRIBUTOS =====================================================================
	
	private double radio;
	
// CONSTRUCTORES =================================================================
	
	//Constructor maestro (1 parámetro)
	public Circulo(double radio) throws IllegalArgumentException
	{
		if(radio < 0)
		{
			throw new IllegalArgumentException("El radio no puede ser menor que 0.");
		}
		
		this.radio = radio;
	}
	
// MÉTODOS =======================================================================
	
	//PERIMETRO - Calcula y devuelve el perímetro del Círculo
	@Override
	public double perimetro() 
	{
		return 2 * Math.PI * this.radio;
	}

	//ÁREA - Calcula y devuelve el área del Círculo
	@Override
	public double area() 
	{
		return Math.PI * Math.pow(this.radio, 2);
	}

	//ESCALAR - Aumenta la escala del Círculo en torno a un valor parámetro
	@Override
	public void escalar(double escala) 
	{
		if(escala < 0)
		{
			throw new IllegalArgumentException("La escala no puede ser menor que 0.");
		}
		
		this.radio = this.radio * escala;
	}

	//IMPRIMIR - Muestra por pantalla la información del Círculo en una sola línea
	@Override
	public void imprimir() 
	{
		System.out.printf("Radio: %.2f cm\n", this.radio);
	}
}
