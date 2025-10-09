/*
 * Clase que representa un Triángulo
 * Implements: Figura2D
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/02/2025 
 */
package ejercicio3;

public class Triangulo implements Figura2D
{
	
// ATRIBUTOS ===============================================================
	
	private double base;
	private double altura;
	
// CONSTRUCTORES ============================================================
	
	//Constructor maestro (2 parámetros)
	public Triangulo(double base, double altura) throws IllegalArgumentException
	{
		if(base < 0)
		{
			throw new IllegalArgumentException("La base no puede ser menor que 0.");
		}
		if(altura < 0)
		{
			throw new IllegalArgumentException("La altura no puede ser menor que 0.");
		}
		this.base = base;
		this.altura = altura;
	}
	
// MÉTODOS ===================================================================
	
	//PERIMETRO - Calcula y devuelve el perímetro del Triángulo
	@Override
	public double perimetro() 
	{
		return (1/2) * this.base * this.altura;
	}

	//ÁREA - Calcula y devuelve el área del Triángulo
	@Override
	public double area() 
	{
		return (this.base * this.altura) / 2;
	}

	//ESCALAR - Aumenta la escala del Triángulo en torno a un valor parámetro
	@Override
	public void escalar(double escala) 
	{
		if(escala < 0)
		{
			throw new IllegalArgumentException("La escala no puede ser menor que 0.");
		}
		
		this.base = this.base * escala;
		this.altura = this.altura * escala;
	}

	//IMPRIMIR - Muestra por pantalla la información del Triángulo en una sola línea
	@Override
	public void imprimir() 
	{
		System.out.printf("Base: %.2f cm - Altura: %.2f cm\n", this.base, this.altura);
	}
}
