/*
 * Objetivo: Programa que hace uso de la clase Dado mediante
 * la cual realizamos una serie de lanzamientos y cálculos basados
 * en los lanzamientos realizados de cada jugador
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/12/2024
 */
package ejercicio1;

import libtarea3.Dado;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{	
		final int NUM_DADOS = 3;
		final int NUM_LANZAMIENTOS = 15;
		long sumaGlobal = 0, valorMaximo = (int) ((Math.random()*31)+30);
		int dadoGanador = 0, ultimoLanzarGanador = 0;
		Dado jugador1 = new Dado(), jugador2 = new Dado(), jugador3 = new Dado();
		int [][] lanzamientos = new int[NUM_DADOS][NUM_LANZAMIENTOS];
		int [] sumaLanzamientos = new int[NUM_DADOS];
		
		System.out.printf("LANZAMIENTO DE DADOS"+"\n---------------------------------------------" + "\n");
		System.out.printf("Número máximo de puntos: %d"+"\n"+"\n", valorMaximo);
		//BUCLE - Do While para lanzar los dados y añadir los valores tanto a la sumaGlobal como al array de lanzamientos
		do
		{
			sumaGlobal += lanzamientos [0][(int) jugador1.getNumeroLanzamientos()] = jugador1.lanzar();
			sumaGlobal += lanzamientos [1][(int) jugador2.getNumeroLanzamientos()] = jugador2.lanzar();
			sumaGlobal += lanzamientos [2][(int) jugador3.getNumeroLanzamientos()] = jugador3.lanzar();
		}while(sumaGlobal < valorMaximo);
		
		//BUCLE - For para mostrar todos los lanzamientos de cada dado
		System.out.println("		  DADO1  DADO2  DADO3" + "\n");
		for(int lanzar=0; lanzar<jugador1.getNumeroLanzamientos(); lanzar++)
		{
			System.out.printf("Lanzamiento nº %d:   ", (lanzar+1));
			for(int dado=0; dado<NUM_DADOS; dado++)
			{
				System.out.print(lanzamientos[dado][lanzar] + "      ");
			}
			System.out.println("");
		}
		
		//BUCLE - For para recoger valores de suma de lanzamientos de cada dado
		for(int dado=0; dado<NUM_DADOS; dado++)
		{
			for(int lanzar=0; lanzar<jugador1.getNumeroLanzamientos(); lanzar++)
			{
				sumaLanzamientos[dado] += lanzamientos[dado][lanzar];
			}
		}
		
		//Declaramos los valores en variables para utilizarlos múltiples veces para evitar llamar a los objetos y métodos múltiples veces
		dadoGanador = dadoGanador(sumaLanzamientos);
		ultimoLanzarGanador = lanzamientos[dadoGanador][(int) (jugador1.getNumeroLanzamientos() - 1)];
		
		//RESULTADOS 
		System.out.printf("\nJuego Terminado. La suma de los lanzamientos es: %d", sumaGlobal);
		System.out.printf("\nEl ganador es el dado %d con %d puntos en la última jugada.",(dadoGanador + 1),ultimoLanzarGanador);
		System.out.printf("\nEl valor %d ha salido %d veces en todo el juego y se han realizado un total de %d lanzamientos.",
				ultimoLanzarGanador, Dado.getNumeroVecesCaraGlobal(ultimoLanzarGanador),Dado.getNumeroLanzamientosGlobal());
		System.out.printf("\nTodos los lanzamientos del dado %d: ",(dadoGanador+1));
		//SWITCH - Comprueba que objeto Dado debemos mostrar basado en el valor entero de dadoGanador
		switch(dadoGanador)
		{
		case 0:
			System.out.print(jugador1.getSerieHistoricaLanzamientos());
			break;
		case 1:
			System.out.print(jugador2.getSerieHistoricaLanzamientos());
			break;
		case 2:
			System.out.print(jugador3.getSerieHistoricaLanzamientos());
			break;
		}
	}

	//MÉTODO - Recoge el array de sumaLanzamientos para devolver el valor entero del dado con la mayor suma
	public static int dadoGanador(int [] sumaLanzamientos)
	{
		int dadoMayor = 0;
		for(int dado = 1; dado<3;dado++)
		{
			if(sumaLanzamientos[dadoMayor] < sumaLanzamientos[dado])
			{
				dadoMayor = dado;
			}
		}
		return dadoMayor;
	}
}
