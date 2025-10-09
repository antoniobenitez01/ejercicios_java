/*
 * Objetivo: Programa que hace uso de la Clase Bombo
 * para crear dos objetos de bombo y realizar una serie
 * de operaciones sobre ellos.
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/12/2024
 */
package ejercicio2;

import libtarea3.Bombo;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Bombo bombo = null, bombo15 = null;
		
		System.out.println("USO DE BOMBOS" +
							"\n---------------" + "\n" + 
							"\n------------------------------------" +
							"\nCREACIÓN DE BOMBOS (CONSTRUCTORES)" +
							"\n------------------------------------");
		//TRY-CATCH - Intento creación Bombo con capacidad inferior a la permitida
		try
		{
			System.out.println("Intentado crear bombo con capacidad inferior a la permitida...");
			bombo = new Bombo(Bombo.MINIMA_CAPACIDAD - 1);
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf("Error: " + excepcion1.getMessage());
		}
		//TRY-CATCH - Intento creación Bombo con capacidad superior a la permitida
		try
		{
			System.out.println("\n"+"\nIntentado crear bombo con capacidad superior a la permitida...");
			bombo = new Bombo(Bombo.MAXIMA_CAPACIDAD + 1);
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf("Error: " + excepcion1.getMessage());
		}
		
		//TRY-CATCH - Creación bombo por omisión y bombo de 15 elementos
		try
		{
			System.out.println("\n"+"\nCreando bombo por omisión...");
			bombo = new Bombo();
			System.out.printf("Correcto, creado bombo de %d elementos.",bombo.getCapacidad());
			System.out.printf("\nEstado inicial del bombo: " + bombo.toString());
			
			System.out.println("\n"+"\nIntentando crear bombo de 15 elementos...");
			bombo15 = new Bombo(15);
			System.out.printf("Correcto, creado bombo de %d elementos.", bombo15.getCapacidad());
			mostrarEstadoBombo(bombo15);
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf("Error: " + excepcion1.getMessage());
		}	
		
		System.out.println("\n"+"\n-----------------------" +
								"\nPRUEBAS DE EXTRACCIÓN:" +
								"\n---------------------------" +
								"\nPRUEBA 1: EXTRACCIÓN DE TODAS LAS BOLAS DE UN BOMBO:" +
								"\n--------------------------------------------------");
		
		System.out.printf("Extrayendo todas las bolas del bombo...");
		//BUCLE - Do while hasta que el objeto bombo15 esté vacío
		do
		{
			System.out.printf("\nExtraída la bola: %d", bombo15.extraerBola());
		}while(bombo15.isVacio() == false);
		mostrarEstadoBombo(bombo15);
		
		System.out.println("\n"+"\nPRUEBA 2: REINICIO DEL BOMBO:"+
		"\n----------------------------------------------------------------------");
		
		System.out.println("Rellenamos de nuevo el bombo con la misma capacidad...");
		bombo15.reset();
		System.out.println("Se han añadido 15 bolas." + "\nEstado del bombo tras rellenar: " + bombo15.toString());
		
		System.out.println("\nPRUEBA 3: EXTRACCIÓN DE UN NÚMERO ALEATORIO DE BOLAS DE UN BOMBO:" +
		"\n----------------------------------------------------------------------" + 
		"\nExtrayendo un número aleatorio de bolas...");
		
		int numAleatorio = (int) (Math.random()*(bombo15.getCapacidad()+1));
		System.out.printf("Vamos a extraer %d bolas.", numAleatorio);
		//BUCLE - For basado en el numAleatorio anteriormente declarado
		for(int i=0; i<numAleatorio; i++)
		{
			System.out.printf("\nExtraída la bola: %d", bombo15.extraerBola());
		}
		mostrarEstadoBombo(bombo15);
	}
	
	//MÉTODO - Recoge un objeto Bombo para mostrar su estado y sus parámetros por pantalla
	public static void mostrarEstadoBombo(Bombo bombo)
	{
		/*Por lo general, no se usan los métodos para mostrar cosas por pantalla,
		 * pero en este caso especial podemos ver que el mismo código se repite 3 veces;
		 * por lo que he decidido crear un método aparte con tal de optimizar el código. 
		 */
		System.out.printf("\nEstado del bombo tras sacar todas las bolas: " + bombo.toString() +
				"\nBolas extraídas: " + bombo.getBolasExtraidas() +
				"\nCantidad de bolas extraídas: %d" +
				"\nBolas restantes: " + bombo.getBolasRestantes() +
				"\nCantidad de bolas restantes: %d",
				bombo.getCantidadBolasExtraidas(), bombo.getCantidadBolasRestantes());
	}
}
