/*
 * Clase que representa un Rectángulo
 * Implements: Figura2D
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/02/2025 
 */
package ejercicio3;

public class Rectangulo implements Figura2D 
{
	
// ATRIBUTOS ============================================================
	
	private double ancho;
	private double alto;
	
// CONSTRUCTORES ========================================================
	
	//Constructor maestro (2 parámetros)
	public Rectangulo(double ancho, double alto) throws IllegalArgumentException
	{
		if(ancho < 0)
		{
			throw new IllegalArgumentException("El ancho del Rectángulo no puede ser menor que 0.");
		}
		if(alto < 0)
		{
			throw new IllegalArgumentException("El alto del Rectángulo no puede ser menor que 0.");
		}
		this.ancho = ancho;
		this.alto = alto;
	}
	
// MÉTODOS ===============================================================
	
	//PERIMETRO - Calcula y devuelve el perímetro del Rectángulo
	@Override
	public double perimetro() 
	{
		return (2 * this.alto) + (2 * this.ancho);
	}

	//ÁREA - Calcula y devuelve el área del Rectángulo
	@Override
	public double area() 
	{
		return this.alto * this.ancho;
	}

	//ESCALAR - Aumenta la escala del Rectángulo en torno a un valor parámetro
	@Override
	public void escalar(double escala) 
	{
		if(escala < 0)
		{
			throw new IllegalArgumentException("La escala no puede ser menor que 0.");
		}
		
		this.alto = this.alto * escala;
		this.ancho = this.ancho * escala;
	}

	//IMPRIMIR - Muestra por pantalla la información del Rectángulo en una sola línea
	@Override
	public void imprimir() 
	{
		System.out.printf("Ancho: %.2f cm - Alto: %.2f cm\n", this.ancho, this.alto);
	}
}
