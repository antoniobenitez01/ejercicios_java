/*
 * Objetivo: Programa que hace uso de la Clase Dado
 * para crear objetos de datos y utilizarlos en una serie de cálculos
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 03/12/2024
 */
package ejercicio02;

import libtarea3.Dado;

public class Ejercicio02 
{

	public static void main(String[] args) 
	{
		Dado dado;
		System.out.println("LANZANDO LOS DADOS"+"\n----------------"+"\n"+
							"\n1.-CONSULTA INICIAL DE VALORES GLOBALES"+"\n--------------------------------"+"\n");
		
		System.out.printf("Número de total de dados creados hasta el momento: " + Dado.getNumeroDadosCreados()+"."+
				"\nNúmero de total de lanzamientos llevados a cabo hasta el momento: " + Dado.getNumeroLanzamientosGlobal()+".");
		try
		{
			System.out.printf("\nNúmero de veces que se ha obtenido 1 entre todos los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(1)+
			"\nNúmero de veces que se ha obtenido 2 entre todos los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(2)+
			"\nNúmero de veces que se ha obtenido 3 entre todos los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(3)+
			"\nNúmero de veces que se ha obtenido 4 entre todos los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(4));	
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}	
		
		System.out.println("\n"+"\n2.- CREACIÓN Y LANZAMIENTO DE DADOS" + "\n--------------------------------"+"\n");
		
		//BUCLE CREACIÓN DE DADOS
		for(int i=0; i<10; i++)
		{
			try
			{
				int numAleatorio = (int) (Math.random()*9);
				System.out.printf("Intento " + (i+1) + ": Intentando crear dado aleatorio de " + numAleatorio + " caras.");
				dado = new Dado(numAleatorio);
				System.out.printf(" Correcto. Creado dado de " + numAleatorio + " caras."+"\n");
				
				System.out.printf("Lo lanzamos " + numAleatorio + " veces: ");
				for(int j=0; j<numAleatorio; j++)
				{
					System.out.printf(dado.lanzar() + " ");
				}
				System.out.printf("\nSuma total de los lanzamientos del dado: " + dado.getSumaPuntuacionHistorica() + "\n");
			}catch(IllegalArgumentException excepcion1)
			{
				//ERROR - CARAS DEL DADO NO VÁLIDAS
				System.out.printf(" Error: " + excepcion1 +"\n");
			}
		}
		
		System.out.println("\n" + "\n3. - ANÁLISIS DE RESULTADOS FINALES" + "\n---------------------------");
		
		System.out.printf("Número de total de dados creados hasta el momento: " + Dado.getNumeroDadosCreados()+"."+
				"\nNúmero de total de lanzamientos llevados a cabo hasta el momento: " + Dado.getNumeroLanzamientosGlobal()+".");
		try
		{
			System.out.printf("\nNúmero de veces que se ha obtenido 1 entre todos los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(1)+
			"\nNúmero de veces que se ha obtenido 2 entre todos los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(2)+
			"\nNúmero de veces que se ha obtenido 3 entre todos los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(3)+
			"\nNúmero de veces que se ha obtenido 4 entre todos los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(4));	
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}	
	}

}
