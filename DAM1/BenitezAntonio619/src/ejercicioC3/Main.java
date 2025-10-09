/*
 * Objetivo: Modificar el código del EjercicioB3 para hacer uso
 * de los nuevos métodos getters y setters.
 * Excecpiones: IllegalArgumentException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 13/01/2025
 */
package ejercicioC3;

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
			//Utilizamos Math.abs para guardar resultados positivos sin importar las coordenadas introducidas
			perimetro1 = Math.abs((rectangulo1.getY1() - rectangulo1.getX1()) + (rectangulo1.getY1() - rectangulo1.getY2()) + (rectangulo1.getY2() - rectangulo1.getX2()) + (rectangulo1.getX1() - rectangulo1.getX2()));
			area1 = Math.abs((rectangulo1.getX1() - rectangulo1.getX2()) * (rectangulo1.getY1() - rectangulo1.getX1()));	
			
			//Muestra por pantalla de valores de atributos iniciales
			System.out.println("\n=== RECTÁNGULO 1 ===" +
								"\nCoordenadas: (" + rectangulo1.getX1() + "," + rectangulo1.getY1() + ")(" + rectangulo1.getX2() + "," + rectangulo1.getY2() + ")" +
								"\nPerímetro: " + perimetro1 +
								"\nÁrea: " + area1 + "\n");
			
			// ========== MODIFICACIÓN DE VALORES ==============
			//Declaración de valores de atributos modificados (LANZAN ERROR)
			System.out.println("Modificando los valores del Rectangulo 1...");
			rectangulo1.setX1(7);
			rectangulo1.setY1(9);
			rectangulo1.setX2(2);
			rectangulo1.setY2(3);
			
			//Utilizamos Math.abs para guardar resultados positivos sin importar las coordenadas introducidas
			perimetro1 = Math.abs((rectangulo1.getY1() - rectangulo1.getX1()) + (rectangulo1.getY1() - rectangulo1.getY2()) + (rectangulo1.getY2() - rectangulo1.getX2()) + (rectangulo1.getX1() - rectangulo1.getX2()));
			area1 = Math.abs((rectangulo1.getX1() - rectangulo1.getX2()) * (rectangulo1.getY1() - rectangulo1.getX1()));
			
			//Muestra por pantalla de valores de atributos modificados
			System.out.println("\n=== RECTÁNGULO 1 ===" +
								"\nCoordenadas: (" + rectangulo1.getX1() + "," + rectangulo1.getY1() + ")(" + rectangulo1.getX2() + "," + rectangulo1.getY2() + ")" +
								"\nPerímetro: " + perimetro1 +
								"\nÁrea: " + area1);
		}catch(NullPointerException excepcion1)
		{
			System.out.println(excepcion1);
		}
		catch(IllegalArgumentException excepcion2)
		{
			System.out.println(excepcion2);
		}
	}
}
