/*
 * Objetivo: Modificar el código del EjercicioA3 para hacer uso
 * de los nuevos constructores de objetos Rectangulo, el cual
 * debe dar error en este caso.
 * Excecpiones: IllegalArgumentException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 10/01/2025
 */
package ejercicioD3;

public class Main {

	public static void main(String[] args) 
	{
		//Declaración e Instanciación de objetos Rectangulo mediante constructor creado
		Rectangulo rectangulo1 = null, rectangulo2 = null;
		double perimetro1, perimetro2, area1, area2;
		
		// ========== VALORES INICIALES ==============
		
		try
		{
			System.out.println("Creando Rectángulo 1 ...");
			rectangulo1 = new Rectangulo(0,0,5,5);
			System.out.println("Creado con éxito."+
							"\nCreando Rectángulo 2 ...");
			rectangulo2 = new Rectangulo(7,9,2,3);
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{	
			
			//Muestra por pantalla de valores de atributos iniciales
			System.out.println("\n=== RECTÁNGULO 1 ===" +
								"\nCoordenadas: (" + rectangulo1.getX1() + "," + rectangulo1.getY1() + ")(" + rectangulo1.getX2() + "," + rectangulo1.getY2() + ")" +
								"\nPerímetro: " + rectangulo1.getPerimetro() +
								"\nÁrea: " + rectangulo1.getArea() + "\n");
			
			// ========== MODIFICACIÓN DE VALORES ==============
			//Declaración de valores de atributos modificados (LANZAN ERROR)
			System.out.println("Modificando los valores del Rectangulo 1...");
			rectangulo1.setX1(7);
			rectangulo1.setY1(9);
			rectangulo1.setX2(2);
			rectangulo1.setY2(3);
			
			//Muestra por pantalla de valores de atributos modificados
			System.out.println("\n=== RECTÁNGULO 1 ===" +
								"\nCoordenadas: (" + rectangulo1.getX1() + "," + rectangulo1.getY1() + ")(" + rectangulo1.getX2() + "," + rectangulo1.getY2() + ")" +
								"\nPerímetro: " + rectangulo1.getPerimetro() +
								"\nÁrea: " + rectangulo1.getArea());
		}catch(NullPointerException excepcion1)
		{
			System.out.println(excepcion1);
		}
		catch(IllegalArgumentException excepcion2)
		{
			System.out.println(excepcion2);
		}
		
		//USO DE MÉTODOS =============
		
		System.out.println("\n==== USO DE MÉTODOS ====");
		
		System.out.println("\nUtilizando método 'imprimir'...");
		rectangulo1.imprime();
		
		try
		{
			System.out.println("\nUtilizando método 'setX1Y1'...");
			rectangulo1.setX1Y1(0, 0);
			System.out.println("Utilizando método 'setX2Y2'...");
			rectangulo1.setX2Y2(5, 5);
			rectangulo1.imprime();
		}catch(IllegalArgumentException excepcion1)
		{
			
		}
		
		System.out.println("\nUtilizando método 'setAll'...");
		rectangulo1.setAll(0, 0, 5, 5);
		rectangulo1.imprime();
		
		System.out.println("\nUtilizando métodos 'getPerimetro' y 'getArea'...");
		System.out.println("=== RECTÁNGULO 1 ===" +
				"\nCoordenadas: (" + rectangulo1.getX1() + "," + rectangulo1.getY1() + ")(" + rectangulo1.getX2() + "," + rectangulo1.getY2() + ")" +
				"\nPerímetro: " + rectangulo1.getPerimetro() +
				"\nÁrea: " + rectangulo1.getArea());
	}
}
