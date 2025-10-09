/*
 * Objetivo: Modificar el código del EjercicioA1 para hacer uso
 * de los nuevos constructores de objetos Punto.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 10/01/2025
 */
package ejercicioB1;

public class Main {

	public static void main(String[] args) 
	{
		//Declaración objetos Punto e instanciación mediante constructores creados
		Punto punto1 = new Punto(5, 0), punto2 = new Punto(10, 10), punto3 = new Punto(-3, 7);
		
		//Muestra por pantalla de atributos iniciales
		System.out.println("=== PUNTOS ===");
		System.out.println("= PUNTO 1 =" + 
						"\nX: " + punto1.x +
						"\nY: " + punto1.y);
		System.out.println("= PUNTO 2 =" + 
				"\nX: " + punto2.x +
				"\nY: " + punto2.y);
		System.out.println("= PUNTO 3 =" + 
				"\nX: " + punto3.x +
				"\nY: " + punto3.y);
		
		//Modificación de Atributos
		punto1.x = punto1.x + 5;
		punto1.y = punto1.y - 5;
		
		punto2.x = punto2.x * 5;
		punto2.y = punto2.y / 5;
		
		punto3.x = punto3.x % 2;
		punto3.y = punto3.y * (int) (Math.random() * 10);
		
		//Muestra por pantalla de atributos modificados
		System.out.println("\n=== PUNTOS ===");
		System.out.println("= PUNTO 1 =" + 
						"\nX: " + punto1.x +
						"\nY: " + punto1.y);
		System.out.println("= PUNTO 2 =" + 
				"\nX: " + punto2.x +
				"\nY: " + punto2.y);
		System.out.println("= PUNTO 3 =" + 
				"\nX: " + punto3.x +
				"\nY: " + punto3.y);
	}
}
