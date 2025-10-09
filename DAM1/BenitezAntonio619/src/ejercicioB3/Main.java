/*
 * Objetivo: Modificar el código del EjercicioA3 para hacer uso
 * de los nuevos constructores de objetos Rectangulo, el cual
 * debe dar error en este caso.
 * Excecpiones: IllegalArgumentException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 10/01/2025
 */
package ejercicioB3;

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
			perimetro1 = Math.abs((rectangulo1.y1 - rectangulo1.x1) + (rectangulo1.y1 - rectangulo1.y2) + (rectangulo1.y2 - rectangulo1.x2) + (rectangulo1.x1 - rectangulo1.x2));
			area1 = Math.abs((rectangulo1.x1 - rectangulo1.x2) * (rectangulo1.y1 - rectangulo1.x1));	
			
			//Utilizamos Math.abs para guardar resultados positivos sin importar las coordenadas introducidas
			perimetro2 = Math.abs((rectangulo2.y1 - rectangulo2.x1) + (rectangulo2.y1 - rectangulo2.y2) + (rectangulo2.y2 - rectangulo2.x2) + (rectangulo2.x1 - rectangulo2.x2));
			area2 = Math.abs((rectangulo2.x1 - rectangulo2.x2) * (rectangulo2.y1 - rectangulo2.x1));
			
			//Muestra por pantalla de valores de atributos iniciales
			System.out.println("=== RECTÁNGULOS ===" + "\n" +
							"\n= RECTÁNGULO 1 =" +
							"\nCoordenadas: (" + rectangulo1.x1 + "," + rectangulo1.y1 + ")(" + rectangulo1.x2 + "," + rectangulo1.y2 + ")" +
							"\nPerímetro: " + perimetro1 +
							"\nÁrea: " + area1 + "\n" +
							"\n= RECTÁNGULO 2 =" +
							"\nCoordenadas: (" + rectangulo2.x1 + "," + rectangulo2.y1 + ")(" + rectangulo2.x2 + "," + rectangulo2.y2 + ")" +
							"\nPerímetro: " + perimetro2 +
							"\nÁrea: " + area2);
			
			// ========== MODIFICACION DE VALORES ==============
			//Declaración de valores de atributos modificados
			rectangulo1.x1 = rectangulo1.x1 + (int) (Math.random() * 10);
			rectangulo1.y1 = rectangulo1.y1 - (int) (Math.random() * 10);
			rectangulo1.x2 = rectangulo1.x2 * (int) (Math.random() * 10);
			rectangulo1.y2 = rectangulo1.y2 / (int) ((Math.random() * 9) + 1);
			
			//Utilizamos Math.abs para guardar resultados positivos sin importar las coordenadas introducidas
			perimetro1 = Math.abs((rectangulo1.y1 - rectangulo1.x1) + (rectangulo1.y1 - rectangulo1.y2) + (rectangulo1.y2 - rectangulo1.x2) + (rectangulo1.x1 - rectangulo1.x2));
			area1 = Math.abs((rectangulo1.x1 - rectangulo1.x2) * (rectangulo1.y1 - rectangulo1.x1));	
			
			rectangulo2.x1 = rectangulo2.x1 + (int) (Math.random() * 10);
			rectangulo2.y1 = rectangulo2.y1 - (int) (Math.random() * 10);
			rectangulo2.x2 = rectangulo2.x2 * (int) (Math.random() * 10);
			rectangulo2.y2 = rectangulo2.y2 / (int) ((Math.random() * 9) + 1);
			
			//Utilizamos Math.abs para guardar resultados positivos sin importar las coordenadas introducidas
			perimetro2 = Math.abs((rectangulo2.y1 - rectangulo2.x1) + (rectangulo2.y1 - rectangulo2.y2) + (rectangulo2.y2 - rectangulo2.x2) + (rectangulo2.x1 - rectangulo2.x2));
			area2 = Math.abs((rectangulo2.x1 - rectangulo2.x2) * (rectangulo2.y1 - rectangulo2.x1));
			
			//Muestra por pantalla de valores de atributos modificados
			System.out.println("\n=== RECTÁNGULOS MODIFICADOS ===" + "\n" +
							"\n= RECTÁNGULO 1 =" +
							"\nCoordenadas: (" + rectangulo1.x1 + "," + rectangulo1.y1 + ")(" + rectangulo1.x2 + "," + rectangulo1.y2 + ")" +
							"\nPerímetro: " + perimetro1 +
							"\nÁrea: " + area1 + "\n" +
							"\n= RECTÁNGULO 2 =" +
							"\nCoordenadas: (" + rectangulo2.x1 + "," + rectangulo2.y1 + ")(" + rectangulo2.x2 + "," + rectangulo2.y2 + ")" +
							"\nPerímetro: " + perimetro2 +
							"\nÁrea: " + area2);
		}catch(NullPointerException excepcion1)
		{
			System.out.println(excepcion1);
		}
	}
}
