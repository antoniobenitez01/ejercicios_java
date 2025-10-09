/*
 * Objetivo: Modificar el código del EjercicioC1 para hacer uso
 * de los nuevos métodos de la clase Punto
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/01/2025
 */
package ejercicioD1;

public class Main {

	public static void main(String[] args) 
	{
		//Declaración objetos Punto e instanciación mediante constructores creados
		Punto punto1 = new Punto(5, 0), punto2 = new Punto(10, 10), punto3 = new Punto(-3, 7);
		
		//Muestra por pantalla de atributos iniciales
		System.out.println("=== PUNTOS ===");
		System.out.println("= PUNTO 1 =" + 
						"\nX: " + punto1.getX() +
						"\nY: " + punto1.getY());
		System.out.println("= PUNTO 2 =" + 
				"\nX: " + punto2.getX() +
				"\nY: " + punto2.getY());
		System.out.println("= PUNTO 3 =" + 
				"\nX: " + punto3.getX() +
				"\nY: " + punto3.getY());
		
		//Modificación de Atributos
		punto1.setX(punto1.getX() + 5);
		punto1.setY(punto1.getY() - 5);
		
		punto2.setX(punto2.getX() * 5);
		punto2.setY(punto2.getY() / 5);
		
		punto3.setX(punto3.getX() % 5);
		punto3.setY(punto3.getY() * (int) (Math.random() * 10));
		
		//Muestra por pantalla de atributos modificados
		System.out.println("\n=== PUNTOS ===");
		System.out.println("= PUNTO 1 =" + 
						"\nX: " + punto1.getX() +
						"\nY: " + punto1.getY());
		System.out.println("= PUNTO 2 =" + 
				"\nX: " + punto2.getX() +
				"\nY: " + punto2.getY());
		System.out.println("= PUNTO 3 =" + 
				"\nX: " + punto3.getX() +
				"\nY: " + punto3.getY());
		
		// USO DE MÉTODOS ==================================
		
		System.out.println("\n==== USO DE MÉTODOS ====");
		
		System.out.println("\nUtilizando método 'imprime'...");
		punto1.imprime();
		
		System.out.println("\nUtilizando método 'setXY'...");
		punto2.setXY(5, 3);
		punto2.imprime();
		
		System.out.println("\nUtilizando método 'desplaza'...");
		punto2.desplaza(5, 2);
		punto2.imprime();
		
		System.out.println("\nUtilizando método 'distancia'...");
		System.out.println("Distancia de Punto 1 a Punto 2: " + punto1.distancia(punto2));
	}
}
