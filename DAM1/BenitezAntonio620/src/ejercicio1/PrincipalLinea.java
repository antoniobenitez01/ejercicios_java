/*
 * Objetivo: Crear objetos de la clase creada Linea
 * y hacer uso de sus constructores y métodos
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/01/2025
 */
package ejercicio1;

public class PrincipalLinea 
{

	public static void main(String[] args) 
	{
		//USO DE CONSTRUCTORES ====================
		
		//	Objetos Punto
		Punto punto1 = new Punto(5, 6);
		Punto punto2 = new Punto();
		
		//	Objetos Línea
		Linea linea1 = new Linea();
		Linea linea2 = new Linea(punto1, punto2);
		
		//USO DE GETTERS AND SETTERS ==============
		
		System.out.println("Usando métodos Set y Get del objeto Punto...");
		punto1.setX(10);
		punto1.setY(15);
		System.out.printf("Coordenada X: %.2f \nCoordenada Y: %.2f", punto1.getX(), punto1.getY());
		System.out.println("\n" + punto1.toString());
		
		System.out.println("\nUsando métodos Set y Get del objeto Línea...");
		linea1.setPuntoA(50, 32);
		linea1.setPuntoB(23.23, 5.5);
		linea1.escribirLinea();	
		
		//USO DE MÉTODOS ==========================
		
		System.out.println("\nUsando método mueveDerecha del objeto Linea...");
		linea1.mueveDerecha(15);
		linea1.escribirLinea();
		
		System.out.println("\nUsando método mueveIzquierda del objeto Linea...");
		linea1.mueveIzquierda(15);
		linea1.escribirLinea();
		
		System.out.println("\nUsando método mueveArriba del objeto Linea...");
		linea1.mueveArriba(15);
		linea1.escribirLinea();
		
		System.out.println("\nUsando método mueveAbajo del objeto Linea...");
		linea1.mueveAbajo(15);
		linea1.escribirLinea();
	}
}
