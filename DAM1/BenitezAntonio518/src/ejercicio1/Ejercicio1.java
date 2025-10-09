/*
 * Objetivo: Hacer uso de la clase Bombilla para
 * crear 3 bombillas y realizar operaciones sobre ellas
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/12/2024
 */
package ejercicio1;

import java.time.format.DateTimeFormatter;

import libtarea3.Bombilla;
import libtarea3.Utilidades;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Bombilla bombilla1 = null, bombilla2 = null, bombilla3 = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String estadoBombilla1;
		//1 CONSULTA INICIAL
		System.out.println("TRABAJO CON BOMBILLAS"+"\n---------------------" +"\n"+
						"\n1.-CONSULTA INICIAL DE VALORES GLOBALES"+"\n-----------------------------------------" + "\n");
		System.out.printf("Número de bombillas creadas hasta el momento: %d."+
						"\nNúmero de bombillas encendidas hasta el momento: %d.", 
						Bombilla.getBombillasCreadas(), Bombilla.getBombillasEncendidas());
		//2 CREACION Y USO BOMBILLAS
		System.out.println("\n"+"\n2.-CREACIÓN Y USO DE BOMBILLAS"+"\n---------------------------"+"\n"+
						"\nCreación de bombillas (constructores)"+"\n--------------------------------------");
		//Try-Catch - Intento creación bombilla potencia no válida
		try
		{
			System.out.println("Intentando crear una bombilla encendida con una potencia no válida.");
			bombilla1 = new Bombilla(true, 250);
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf("\nError: " + excepcion1.getMessage() + "\n");
		}
		
		//Try-Catch - Intento creación bombilla potencia no válida
		try
		{
			System.out.println("Intentando crear una bombilla con una potencia no válida.");
			bombilla1 = new Bombilla(5);
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf("\nError: " + excepcion1.getMessage() + "\n");
		}
		
		//Try-Catch - Creación Objetos Bombilla referenciados por bombilla1, bombilla2 y bombilla3
		try
		{
			System.out.println("Creando bombilla encendida con una potencia válida con un constructor con dos parámetros...");
			bombilla1 = new Bombilla(true, 100);
			System.out.println("Bombilla 1 creada, estado: " + bombilla1.toString() + "\n");
			System.out.println("Creando bombilla encendida con potencia por defecto usando un constructor con un parámetro...");
			bombilla2 = new Bombilla(true);
			System.out.println("Bombilla 2 creada, estado: " + bombilla2.toString() + "\n");
			System.out.println("Creando bombilla con valores por defecto usando un constructor sin parámetros...");
			bombilla3 = new Bombilla();
			System.out.println("Bombilla 3 creada, estado: " + bombilla3.toString() + "\n");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf("\nError: " + excepcion1.getMessage());
		}
		
		System.out.println("Manipulación de bombillas (métodos)"+"\n---------------------------------------");
		//Try-Catch - Encender Bombilla 1
		try
		{
			System.out.println("Encendiendo la primera bombilla.");
			bombilla1.encender();
		}catch(IllegalStateException excepcion1)
		{
			System.out.printf("\nError: " + excepcion1);
		}
		
		//BUCLE - For para Conmutar Bombilla 1 6 veces
		for(int i=0;i<6;i++)
		{
			System.out.println("\nConmutando estado de la Bombilla 1.");
			bombilla1.conmutar();
			System.out.println("Estado de Bombilla1 : " + bombilla1.toString()+
							"\nEsperando 1 segundo...");
			Utilidades.esperar(1);
		}
		
		//Try-Catch - Apagar Bombilla 2, Encender Bombilla 3
		try
		{
			System.out.println("\nApagando la Bombilla 2...");
			bombilla2.apagar();
			System.out.println("Encendiendo la Bombilla 3...");
			bombilla3.encender();
		}catch(IllegalStateException excepcion1)
		{
			System.out.printf("\nError: " + excepcion1);
		}
		
		//PRUEBA GETTERS
		System.out.println("\nPrueba de los getters de la primera bombilla creada:"+"\n---------------------------------------------------");
		//CONDICIÓN - Según el boolean getEstado() el String estadoBombilla1 será "Encedida" o "Apagada"
		if(bombilla1.getEstado() == true)
		{
			estadoBombilla1 = "Encendida";
		}
		else
		{
			estadoBombilla1 = "Apagada";
		}
		System.out.printf("Bombilla 1" + 
						"\n   Potencia: %.2f W" + 
						"\n   Estado: " + estadoBombilla1 +
						"\n   Última vez que se encendió: " + bombilla1.getUltimaVezEncendida().format(formato) +
						"\n   Número de veces encendida: %d veces" +
						"\n   Tiempo que lleva encendida: %.2f segundos" +
						"\n   Potencia consumida: %.2f Ws",
						bombilla1.getPotencia(), bombilla1.getVecesEncendida(), bombilla1.getTiempoEncendida(), bombilla1.getPotenciaConsumida());
		
		//3 CONSULTA FINAL
		System.out.println("\n" + "\n3.-CONSULTA FINAL DE VALORES GLOBALES"+"\n-----------------------------------------" + "\n");
		System.out.printf("Número de bombillas creadas hasta el momento: %d."+
		"\nNúmero de bombillas encendidas hasta el momento: %d.", 
		Bombilla.getBombillasCreadas(), Bombilla.getBombillasEncendidas());
	}

}
