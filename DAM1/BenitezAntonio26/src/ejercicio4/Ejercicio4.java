/*
 * Objetivo: Programa que solicita datos de
 * nombre, apellidos y datos de importes gastados
 * para luego realizar una serie de acciones sobre ellos
 * para comprobar si el usuario es elegible para un
 * descuento de 50 euros tras haber comprado con 300 euros o más.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 08/10/2024
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		String nombre, apellidos;
		double importeGastado1, importeGastado2, importeGastado3, importeGastado4, totalImporte, importeMedio;
		
		System.out.println("Introduzca su nombre");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduzca sus apellidos");
		apellidos = entradaTeclado.nextLine();
		System.out.println("Introduzca el primer importe gastado");
		importeGastado1 = entradaTeclado.nextDouble();
		System.out.println("Introduzca el segundo importe gastado");
		importeGastado2 = entradaTeclado.nextDouble();
		System.out.println("Introduzca el tercer importe gastado");
		importeGastado3 = entradaTeclado.nextDouble();
		System.out.println("Introduzca el cuarto importe gastado");
		importeGastado4 = entradaTeclado.nextDouble();
		
		totalImporte = importeGastado1 + importeGastado2 + importeGastado3 + importeGastado4;
		importeMedio = totalImporte / 4;
		
		System.out.println("Nombre: " + nombre
						+ "\nApellidos: " + apellidos
						+ "\nImporte Gastado1: " + importeGastado1 + " euros"
						+ "\nImporte Gastado2: " + importeGastado2 + " euros"
						+ "\nImporte Gastado3: " + importeGastado3 + " euros"
						+ "\nImporte Gastado4: " + importeGastado4 + " euros"
						+ "\n"
						+ "\nImporte Medio: " + importeMedio + " euros"
						+ "\n");
		if(totalImporte >= 300)
		{
			System.out.println("¡Felicidades! Debido a su compra de 300€ o más, ha obtenido un vale de descuento de 50 euros.");
		}
		else
		{
			System.out.println("Lo sentimos, pero sus compras no han alcanzado los 300 euros este mes, no dispone de descuento.");
		}
	}

}
