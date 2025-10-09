/*
 * Objetivo: Programa que solicita una serie de datos
 * al principio y luego solicita datos de 5 caminatas
 * para luego realizar operaciones sobre los datos y
 * mostrar los resultados de forma organizada.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/10/2024
 */
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 
{

	public static void main(String[] args) 
	{
		//Delaración entrada y variables
		Scanner entradaTeclado = new Scanner(System.in);
		String nombre, apellidos, ciudad, ciudadLarga = "Ninguna.";
		int edad, numRutas, contador = 1, numParticipantes;
		double distUltimaRuta, dist, distLarga = 0, distMedia, distTotal = 0;
		
		//Entrada inicial
		System.out.println("Introduzca su nombre");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduzca sus apellidos");
		apellidos = entradaTeclado.nextLine();
		System.out.println("Introduzca su edad");
		edad = entradaTeclado.nextInt();
		
		//Comprobación mayor de 17 y menor de 45
		while ((edad < 17) && (edad > 45))
		{
			System.out.println("La edad introducida no es correcta");
			System.out.println("Introduzca su edad");
			edad = entradaTeclado.nextInt();
		}
		
		System.out.println("Introduzca el número de rutas realizadas");
		numRutas = entradaTeclado.nextInt();
		System.out.println("Introduzca la distancia de la última ruta");
		distUltimaRuta = entradaTeclado.nextDouble();
		
		//Introducción datos 5 últimas caminatas mediante bucle do while
		System.out.println("A continuación deberá introducir los datos de las 5 últimas caminatas.");
		do
		{
			System.out.println("Introduzca la distancia de la ruta " + contador);
			dist = entradaTeclado.nextDouble();
			System.out.println("Introduzca el número de participantes");
			numParticipantes = entradaTeclado.nextInt();
			entradaTeclado.nextLine();
			System.out.println("Introduzca la ciudad de la ruta " + contador);
			ciudad = entradaTeclado.nextLine();
			
			//Cálculo ruta más larga
			if((dist > distUltimaRuta) || distLarga > (distUltimaRuta))
			{
				if(dist > distLarga)
				{
					distLarga = dist;
					ciudadLarga = ciudad;
				}
			}
			
			distTotal = distTotal + dist;
			contador++;
			System.out.println(contador);
			
		}while(contador <=5);
		
		//Cálculo media y resultado
		distMedia = distTotal / 5;
		System.out.println("---------------------------------------------------------" +
						"\nNombre: " + nombre +
						"\nEdad: " + edad +
						"\nNúmero de rutas realizadas: " + numRutas +
						"\n" +
						"\nDistancia media (5 últimas rutas): " + distMedia +
						"\nDistancia más larga de las últimas 5 rutas: " + distLarga +
						"\nCiudad de la ruta más larga: " + ciudadLarga +
						"\n---------------------------------------------------------");
	}

}
