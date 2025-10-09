/*
 * Objetivo: Modificar el código del EjercicioB1 para hacer uso
 * de los nuevos métodos getters y setters.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 13/01/2025
 */
package ejercicioC1;

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
	}
}
