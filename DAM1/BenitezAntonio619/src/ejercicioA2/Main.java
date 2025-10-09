/*
 * Objetivo: Hacer uso de la clase Persona que hemos creado
 * para crear objetos introduciendo los atributos por teclado y 
 * mostrarlos posteriormente por pantalla.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/01/2025
 */
package ejercicioA2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		Persona persona1 = new Persona(), persona2 = new Persona();
		String dniTeclado, nombreTeclado, apellidosTeclado;
		int edadTeclado;
		
		// ==== PERSONA 1 ====
		
		System.out.println("==== INTRODUCCIÓN DE DATOS PERSONA 1 ====");
		
		System.out.println("Introduzca el dni de la Persona 1");
		dniTeclado = entradaTeclado.nextLine();
		persona1.dni = dniTeclado;
		
		System.out.println("Introduzca el nombre de la Persona 1");
		nombreTeclado = entradaTeclado.nextLine();
		persona1.nombre = nombreTeclado;
		
		System.out.println("Introduzca los apellidos de la Persona 1");
		apellidosTeclado = entradaTeclado.nextLine();
		persona1.apellidos = apellidosTeclado;
		
		System.out.println("Introduzca la edad de la Persona 1");
		edadTeclado = entradaTeclado.nextInt();
		entradaTeclado.nextLine(); //Depuración Scanner
		persona1.edad = edadTeclado;
		
		// ==== PERSONA 2 ====
		
		System.out.println("==== INTRODUCCIÓN DE DATOS PERSONA 2 ====");
		
		System.out.println("Introduzca el dni de la Persona 2");
		dniTeclado = entradaTeclado.nextLine();
		persona2.dni = dniTeclado;
		
		System.out.println("Introduzca el nombre de la Persona 2");
		nombreTeclado = entradaTeclado.nextLine();
		persona2.nombre = nombreTeclado;
		
		System.out.println("Introduzca los apellidos de la Persona 2");
		apellidosTeclado = entradaTeclado.nextLine();
		persona2.apellidos = apellidosTeclado;
		
		System.out.println("Introduzca la edad de la Persona 2");
		edadTeclado = entradaTeclado.nextInt();
		entradaTeclado.nextLine(); //Depuración Scanner
		persona2.edad = edadTeclado;
		
		// === RESULTADO FINAL ===
		
		System.out.println("\n==== RESULTADO FINAL ====");
		
		System.out.print("\n" + persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.dni);
		if(persona1.edad > 18) //CONDICIÓN - Devuelve true si la edad de la persona es mayor que 18
		{
			System.out.print(" es mayor de edad.");
		}
		else
		{
			System.out.print(" no es mayor de edad.");
		}
		
		System.out.print("\n" + persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.dni);
		if(persona2.edad > 18) //CONDICIÓN - Devuelve true si la edad de la persona es mayor que 18
		{
			System.out.print(" es mayor de edad.");
		}
		else
		{
			System.out.print(" no es mayor de edad.");
		}
	}
}
