/*
 * Objetivo: Crear objetos de la clase Punto que hemos creado
 * para crear objetos, modificar sus atributos y mostrarlos por pantalla
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/01/2025
 */
package ejercicioA1;

public class Main {

	public static void main(String[] args) 
	{
		Punto punto1 = new Punto(), punto2 = new Punto(), punto3 = new Punto();
		
		//Declaración de valores de atributos iniciales
		punto1.x = 5;
		punto1.y = 0;
		
		punto2.x = 10;
		punto2.y = 10;
		
		punto3.x = -3;
		punto3.y = 7;
		
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
