/*
 * Clase ProgramaFiguras que hace uso de 
 * las clases creadas a partir de la interfaz Figura 2D
 * Circulo, Cuadrado, Rectangulo y Triangulo
 * para hacer uso de sus constructores y métodos
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/02/2025
 */
package ejercicio3;

public class ProgramaFiguras 
{

	public static void main(String[] args) 
	{
		//1. Crea un Array de figuras.
		
		System.out.println("1. Creando array de figuras ...");
		Figura2D[] figuras = new Figura2D[10];
		
		System.out.println("\n2. Añadiendo figuras de varios tipos ...");
		for(int i=0; i < figuras.length; i++)
		{
			int opcion = (int) (Math.random() * 4 + 1);
			try
			{
				switch(opcion)
				{
				case 1:
					figuras[i] = new Circulo(Math.random() * 50);
					break;
				case 2:
					figuras[i] = new Cuadrado(Math.random() * 50);
					break;
				case 3:
					figuras[i] = new Rectangulo(Math.random() * 50, Math.random() * 50);
					break;
				case 4:
					figuras[i] = new Triangulo(Math.random() * 50, Math.random() * 50);
					break;
				}
			}catch(IllegalArgumentException ex)
			{
				System.out.printf("%s\n", ex.getMessage());
			}
		}
		
		System.out.println("\n3. Mostrando información de todas las figuras ...\n");
		
		for(int i=0; i<figuras.length; i++)
		{
			System.out.printf("Figura %d.- ", i+1);
			figuras[i].imprimir();
		}
		
		System.out.println("\n4. Escalando todas las figuras con escala = 2 ...");
		
		for(int i=0; i<figuras.length; i++)
		{
			try
			{
				figuras[i].escalar(2);
			}catch(IllegalArgumentException ex)
			{
				System.out.printf("%s\n", ex.getMessage());
			}
		}
		
		System.out.println("\n5. Mostrando información de todas las figuras de nuevo...\n");
		
		for(int i=0; i<figuras.length; i++)
		{
			System.out.printf("Figura %d.- ", i+1);
			figuras[i].imprimir();
		}
		
		System.out.println("\n6. Escalando todas las figuras con escala = 0.1 ...");
		
		for(int i=0; i<figuras.length; i++)
		{
			try
			{
				figuras[i].escalar(0.1);
			}catch(IllegalArgumentException ex)
			{
				System.out.printf("%s\n", ex.getMessage());
			}
		}
		
		System.out.println("\n7. Mostrando información de todas las figuras una última vez...\n");
		
		for(int i=0; i<figuras.length; i++)
		{
			System.out.printf("Figura %d.- ", i+1);
			figuras[i].imprimir();
		}
	}
}
