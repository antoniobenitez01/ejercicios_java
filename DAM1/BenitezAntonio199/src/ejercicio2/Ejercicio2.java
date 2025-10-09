/*
 * Objetivo: Programa que solicita datos de
 * nombre, primer apellido, dia, mes y año de nacimiento,
 * género y luego almacena la información en sus
 * variables correspondientes, creando además un 
 * identificador personalizado.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 15/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner y Variables
		Scanner entradaTeclado = new Scanner(System.in);
		String nombre, primerApellido, genero, anyoNacimiento;
		char charNombre, charApellido1, charApellido2, charApellido3, charAnyo1, charAnyo2;
		int diaNacimiento, mesNacimiento;
		
		//Solicitud de datos
		System.out.println("Introduzca su nombre.");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduzca su primer apellido.");
		primerApellido = entradaTeclado.nextLine();
		System.out.println("Introduzca su día de nacimiento.");
		diaNacimiento = entradaTeclado.nextInt();
		System.out.println("Introduzca su mes de nacimiento.");
		mesNacimiento = entradaTeclado.nextInt();
		entradaTeclado.nextLine();
		System.out.println("Introduzca su año de nacimiento (formato AAAA).");
		anyoNacimiento = entradaTeclado.nextLine();
		System.out.println("Introduzca su género (M/F).");
		genero = entradaTeclado.nextLine();
		
		//Operación Creación Identificador
		charAnyo1 = anyoNacimiento.charAt(anyoNacimiento.length() - 2);
		charAnyo2 = anyoNacimiento.charAt(anyoNacimiento.length() - 1);
		charNombre = nombre.charAt(nombre.length() - 1);
		charApellido1 = primerApellido.charAt(primerApellido.length() - 3);
		charApellido2 = primerApellido.charAt(primerApellido.length() - 2);
		charApellido3 = primerApellido.charAt(primerApellido.length() - 1);
		
		//Resultado final
		System.out.println("Identificador de usuario" +
						"\n---------------------------" +
						"\nNombre: " + nombre +
						"\nPrimer apellido: " + primerApellido +
						"\nDía de nacimiento: " + diaNacimiento +
						"\nMes de nacimiento: " + mesNacimiento +
						"\nAño de nacimiento: " + anyoNacimiento +
						"\nGénero: " + genero +
						"\n" +
						"\nSu identificador de usuario es:" +
						"\n----------" +
						"\n" + charAnyo1 + charAnyo2 + genero + charNombre + charApellido1 + charApellido2 + charApellido3);
	}
}
