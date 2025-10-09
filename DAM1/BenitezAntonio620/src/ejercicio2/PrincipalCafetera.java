/*
 * Objetivo: Crear objetos de la clase creada Cafetera
 * y hacer uso de sus constructores y métodos
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/01/2025
 */
package ejercicio2;

public class PrincipalCafetera {

	public static void main(String[] args) 
	{
		//1. Crea una cafetera vacía que se llene con 250cc y que sirva tazas de café hasta que se agote.
		
		// === Creación Cafetera 1 ===
		System.out.println("\n=== CREACIÓN CAFETERA 1 === \n \nCreando objeto Cafetera1...");
		Cafetera cafetera1 = null;
		
		try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al construir el objeto Cafetera
		{
			cafetera1 = new Cafetera();
			System.out.println("Creado con éxito.\nLlenando 250cc a cafetera1...");
			cafetera1.llenarCafetera(250);
			System.out.println("cafetera1 llenada con éxito.\n");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		// === Servir tazas Cafetera 1 ===
		System.out.println("=== SIRVIENDO TAZAS ===\n\n   --- Inicio --- \n");
		System.out.println(cafetera1.toString() + "\n");
		
		do //BUCLE - Do-while, sirve tazas de café hasta que cafetera1 esté vacía
		{
			try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al usar el método servirTaza
			{
				System.out.println("Sirviendo taza de café de 50cc...");
				cafetera1.servirTaza(50);
			}catch(IllegalArgumentException excepcion1)
			{
				System.out.println(excepcion1);
			}
		}while(cafetera1.getCantidadActual() > 0);
		
		System.out.println("\n   --- Final --- \n\n" + cafetera1.toString());
		
		// =======================================================================================
		
		/*2. Crea una cafetera llena y que sirva 50 cafés de 50 cc cada uno. 
		 * Llenar la cafetera cada vez que haga falta informando al usuario.*/
		
		// === Creación Cafetera 2 ===
		System.out.println("\n=== CREACIÓN CAFETERA 2 === \n");
		Cafetera cafetera2 = null;
		
		try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al construir el objeto Cafetera
		{
			System.out.println("Creando cafetera2...");
			cafetera2 = new Cafetera();
			System.out.println("Creado con éxito.\nLlenando cafetera2 entera...");
			cafetera2.llenarCafeteraEntera();
			System.out.println("cafetera2 llenada con éxito.\n");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		// === Servir tazas Cafetera 1 ===
		System.out.println("=== SIRVIENDO TAZAS ===\n\n   --- Inicio --- \n");
		System.out.println(cafetera2.toString() + "\n");
		
		for(int i=0;i<50; i++) //BUCLE - For, sirve 50 tazas de café
		{
			try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al usar el método servirTaza
			{
				System.out.println("Sirviendo taza de café de 50cc...\n");
				cafetera2.servirTaza(50);
			}
			catch(IllegalArgumentException excepcion1)
			{
				System.out.println(excepcion1);
				System.out.println("Llenando cafetera entera...\n");
				cafetera2.llenarCafeteraEntera();
			}
		}
		
		System.out.println("   --- Final --- \n\n" + cafetera2.toString());
	}
}
