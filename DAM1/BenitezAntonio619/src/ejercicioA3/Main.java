/*
 * Objetivo: Hacer uso de la clase Rectangulo que hemos creado
 * para crear objetos, modificar sus atributos y mostrarlos por pantalla
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/01/2025
 */
package ejercicioA3;

public class Main {

	public static void main(String[] args) 
	{
		Rectangulo rectangulo1 = new Rectangulo(), rectangulo2 = new Rectangulo();
		double perimetro1, perimetro2, area1, area2;
		
		// ========== VALORES INICIALES ==============
		//Declaración de valores de atributos iniciales
		rectangulo1.x1 = 0;
		rectangulo1.y1 = 0;
		rectangulo1.x2 = 5;
		rectangulo1.y2 = 5;
		
		//Utilizamos Math.abs para guardar resultados positivos sin importar las coordenadas introducidas
		perimetro1 = Math.abs((rectangulo1.y1 - rectangulo1.x1) + (rectangulo1.y1 - rectangulo1.y2) + (rectangulo1.y2 - rectangulo1.x2) + (rectangulo1.x1 - rectangulo1.x2));
		area1 = Math.abs((rectangulo1.x1 - rectangulo1.x2) * (rectangulo1.y1 - rectangulo1.x1));	
		
		rectangulo2.x1 = 7;
		rectangulo2.y1 = 9;
		rectangulo2.x2 = 2;
		rectangulo2.y2 = 3;
		
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
	}
}
