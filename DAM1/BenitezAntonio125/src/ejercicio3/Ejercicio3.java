/*
 * Objetivo: Programa que muestra 10 palabras
 * en inglés con sus respectivas traducciones al
 * español, organizados en una lista alineados
 * hacia la izquierda.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio3;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{		
		/*
		 * Para conseguir el efecto de lista alineado hemos
		 * utilizado el formateado de "%-10s", el cual alinea
		 * los elementos string hacia la izquierda y los separa
		 * con una distancia establecida en el formateado (10s).
		 */
		System.out.printf("%-10s %-10s\n", "INGLÉS", "ESPAÑOL");
		System.out.printf("%-10s %-10s\n", "Hello", "Hola");
		System.out.printf("%-10s %-10s\n", "Love", "Amor");
		System.out.printf("%-10s %-10s\n", "Happiness", "Felicidad");
		System.out.printf("%-10s %-10s\n", "Cat", "Gato");
		System.out.printf("%-10s %-10s\n", "Dog", "Perro");
		System.out.printf("%-10s %-10s\n", "Smile", "Sonrisa");
		System.out.printf("%-10s %-10s\n", "English", "Inglés");
		System.out.printf("%-10s %-10s\n", "Yes", "Sí");
		System.out.printf("%-10s %-10s\n", "Thank you", "Gracias");
		System.out.printf("%-10s %-10s\n", "Goodbye", "Adiós");

	}

}
