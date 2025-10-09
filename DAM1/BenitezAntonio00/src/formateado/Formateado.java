/*
 * nombre, edad, altura
 */
package formateado;

import java.util.Scanner;

public class Formateado 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String nombre;
		int edad;
		double altura;
		
		System.out.println("Introduzca su nombre.");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduzca su edad.");
		edad = entradaTeclado.nextInt();
		System.out.println("Introduzca su altura (en metros).");
		altura = entradaTeclado.nextDouble();
		
		System.out.printf("Nombre: %s\nEdad: %d\nAltura: %.2f m", nombre, edad, altura);
	}
}
