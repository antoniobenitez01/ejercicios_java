/*
 * Objetivo: Programa que crea un array de 10 números enteros
 * y luego muestre un menú con distintas opciones.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/10/2024
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		char opcion;
		int v, p;
		String entradaCaracter;
		
		//Array
		int[] numeros = new int [10];
		for(int i=0; i < numeros.length; i++)
		{
			numeros[i] = (int) (Math.random()* 11);	
		}
		System.out.println("Se ha creado un Array con números enteros del 1 al 10");
		
		//Menú
		do {
			System.out.println("---------------------------------------" +
					"\nTiene usted las siguientes opciones:" +
					"\n---------------------------------------" +
					"\n a. Mostrar valores" +
					"\n b. Introducir valor" +
					"\n c. Salir");
			entradaCaracter = entradaTeclado.nextLine();
			opcion = entradaCaracter.charAt(0);
			
			if(opcion == 'a')
			{
				for(int i=0; i < numeros.length; i++)
				{
					System.out.println("El valor en la posición " + i + " es " + numeros[i]);
				}
			}else if(opcion == 'b')
			{
				System.out.println("Introduzca un valor V (entero)");
				v = entradaTeclado.nextInt();
				entradaTeclado.nextLine();
				do
				{
					System.out.println("Introduzca el valor P (entre 0 y 9).");
					p = entradaTeclado.nextInt();
					entradaTeclado.nextLine();
					if(p < 0)
					{
						System.out.println("El número introducido es menor que 0, no es válido.");
					}
					else if (p > 9)
					{
						System.out.println("El número introducido es mayor que 9, no es válido.");
					}
				}while ((p < 0) || (p > 9));
				numeros[p] = v;		
			}else if(opcion == 'c')
			{
				System.out.println("Ha seleccionado apagar el programa.");
			}else
			{
				System.out.println("El comando introducido no es válido.");
			}
		}while(opcion != 'c');
		
		System.out.println("Apagando programa.");
	}
}
