/*
 * Programa que hace uso de la clase creada Atleta
 * y de colecciones HashSet para realizar una serie de cálculos
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 20/03/2025
 */
package ejercicio1;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) 
	{
		//CREACIÓN DE COLECCIÓN --------------------------------------------------------------------------------------------------------
		
		HashSet<Atleta> colAtletas = new HashSet<Atleta>();
		colAtletas.add(new Atleta("Juan José", 15, 1.76));
		colAtletas.add(new Atleta("Maria Jesús", 19, 1.56));
		colAtletas.add(new Atleta("Antonio", 23, 1.87));
		colAtletas.add(new Atleta("Jorge", 12, 1.96));
		colAtletas.add(new Atleta("Claudia", 20, 1.65));
		colAtletas.add(new Atleta("Francisco", 17, 1.78));
		colAtletas.add(new Atleta("José", 45, 1.85));
		colAtletas.add(new Atleta("Lourdes", 24, 1.45));
		colAtletas.add(new Atleta("Ricardo", 15, 1.98));
		colAtletas.add(new Atleta("Eva", 19, 1.67));
		colAtletas.add(new Atleta("Juan José", 15, 1.76));
		colAtletas.add(new Atleta("Juan José", 15, 1.76));
		
		//PROGRAMA ---------------------------------------------------------------------------------------------------------------------
		
		System.out.println("\n=== COLECCIONES EJERCICIO 1: ATLETAS ===\n");
		
		System.out.println("1. Calculando promedio de edades y alturas ..."); // -------------------------------------------------------
		
		double avgEdad = 0, avgAltura = 0;
		
		for(Atleta i: colAtletas)
		{
			avgEdad += i.getEdad();
			avgAltura += i.getAltura();
		}
		
		avgEdad = avgEdad / colAtletas.size();
		avgAltura = avgAltura / colAtletas.size();
		
		System.out.printf("Edad promedio: %d | Altura promedio: %.2fm\n", (int) avgEdad, avgAltura);
		
		System.out.println("\n2. Calculando número de atletas menores y mayores de edad ..."); // -----------------------------------------
		int mayEdad = 0, menEdad = 0;
		for(Atleta i: colAtletas)
		{
			if(i.getEdad() >= 18)
			{
				mayEdad++;
			}else
			{
				menEdad++;
			}
		}
		
		System.out.printf("Personas mayores de edad: %d | Personas menores de edad: %d\n", mayEdad, menEdad);
		
		System.out.println("\n3. Calculando nombres de atletas más alto que el promedio ..."); // -----------------------------------------
		for(Atleta i: colAtletas)
		{
			if(i.getAltura() > avgAltura)
			{
				System.out.printf("- %s\n", i.getNombre());
			}
		}
		
		//FIN PROGRAMA -----------------------------------------------------------------------------------------------------------
	}
}
