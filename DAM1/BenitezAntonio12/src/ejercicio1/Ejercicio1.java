/*
 * Objetivo: Programa que recoge tus datos mediante
 * el sistema de Scanner y luego
 * los muestra de forma ordenada.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 01/10/2024
 */
package ejercicio1;

//Importación de la función Scanner de la librería "util" de Java
import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		//Declaración de Scanner
		Scanner entradaTeclado = new Scanner (System.in);
		
		//Declaración de variables
		String nombre, apellidos, direccion;
		byte edad;
		double altura, peso;
		
		//Entrada de variables
		System.out.println("¿Cuál es tu nombre?");
		nombre = entradaTeclado.nextLine();
		
		System.out.println("¿Cuáles son tus apellidos?");
		apellidos = entradaTeclado.nextLine();
		
		System.out.println("¿Cuántos años tienes?");
		edad = entradaTeclado.nextByte();
		
		entradaTeclado.nextLine(); //Entrada para eliminar datos intermedios
		System.out.println("¿Cuál es tu dirección?");
		direccion = entradaTeclado.nextLine();
		
		System.out.println("¿Cuánto mides de altura?");
		altura = entradaTeclado.nextDouble();
		
		System.out.println("¿Cuánto pesas?");
		peso = entradaTeclado.nextDouble();
		
		//Resultado
		System.out.println("Nombre: " + nombre
							+ "\nApellidos: " + apellidos
							+ "\nEdad: " + edad
							+ "\nDirección: " + direccion
							+ "\nAltura: " + altura
							+ "\nPeso: " + peso);

	}

}
