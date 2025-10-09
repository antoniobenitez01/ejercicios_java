/*
 * Objetivo: Modificar el código del EjercicioA2 para hacer uso
 * de los nuevos constructores de objetos Persona.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 10/01/2025
 */
package ejercicioD2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		Persona persona1, persona2;
		String dniTeclado, nombreTeclado, apellidosTeclado;
		int edadTeclado;
		
		// ==== PERSONA 1 ====
		
		System.out.println("==== INTRODUCCIÓN DE DATOS PERSONA 1 ====");
		
		System.out.println("Introduzca el dni de la Persona 1");
		dniTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca el nombre de la Persona 1");
		nombreTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca los apellidos de la Persona 1");
		apellidosTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca la edad de la Persona 1");
		edadTeclado = entradaTeclado.nextInt();
		entradaTeclado.nextLine(); //Depuración Scanner
		
		//Instanciación objeto mediante constructor creado
		persona1 = new Persona(dniTeclado, nombreTeclado, apellidosTeclado, edadTeclado);
		
		// ==== PERSONA 2 ====
		
		System.out.println("==== INTRODUCCIÓN DE DATOS PERSONA 2 ====");
		
		System.out.println("Introduzca el dni de la Persona 2");
		dniTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca el nombre de la Persona 2");
		nombreTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca los apellidos de la Persona 2");
		apellidosTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca la edad de la Persona 2");
		edadTeclado = entradaTeclado.nextInt();
		entradaTeclado.nextLine(); //Depuración Scanner
		
		//Instanciación objeto mediante constructor creado
		persona2 = new Persona(dniTeclado, nombreTeclado, apellidosTeclado, edadTeclado);
		
		// === MODIFICACIÓN VALORES ===
		
		persona1.setApellidos("García Jiménez");
		persona1.setEdad(25);
		persona2.setNombre("Juanito");
		persona2.setDni("2626784154R");
		
		// === RESULTADO FINAL ===
		
		System.out.println("\n==== RESULTADO FINAL ====");
		
		System.out.print("\n" + persona1.getNombre() + " " + persona1.getApellidos() + " con DNI " + persona1.getDni());
		if(persona1.getEdad() > 18) //CONDICIÓN - Devuelve true si la edad de la persona es mayor que 18
		{
			System.out.print(" es mayor de edad.");
		}
		else
		{
			System.out.print(" no es mayor de edad.");
		}
		
		System.out.print("\n" + persona2.getNombre() + " " + persona2.getApellidos() + " con DNI " + persona2.getDni());
		if(persona2.getEdad() > 18) //CONDICIÓN - Devuelve true si la edad de la persona es mayor que 18
		{
			System.out.print(" es mayor de edad.");
		}
		else
		{
			System.out.print(" no es mayor de edad.");
		}
		
		// === USO DE MÉTODOS ===
		
		System.out.println("\n\n==== USO DE MÉTODOS ====");
		
		System.out.println("\nUtilizando método 'imprime'...");
		persona1.imprime();
		
		System.out.println("\nUtilizando método 'esMayorEdad'...");
		if(persona1.esMayorEdad())
		{
			System.out.println(persona1.getNombre() + " es mayor de edad.");
		}
		else
		{
			System.out.println(persona1.getNombre() + " no es mayor de edad.");
		}
		
		System.out.println("\nUtilizando método 'esJubilado'...");
		if(persona1.esJubilado())
		{
			System.out.println(persona1.getNombre() + " está jubilado.");
		}
		else
		{
			System.out.println(persona1.getNombre() + " no está jubilado..");
		}
		
		System.out.println("\nUtilizando método 'diferenciaEdad'...");
		System.out.println("Diferencia de edad entre " + persona1.getNombre() + " y " + persona2.getNombre() + ": " + persona1.diferenciaEdad(persona2));
	}
}
