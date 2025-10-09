/*
 * Objetivo:  Programa que genere 30 números aleatorios de 0 a 100,
 * mostrándolos a continuación y haciendo cálculos mediante métodos
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 20/11/2024
 */
package proyecto1;

import java.util.Scanner;

public class Proyecto1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int numIntroducido;
		int[] numerosAleatorios = new int [30];
		
		//RELLENAR ARRAY CON NÚMEROS ALEATORIOS y MOSTRAR NÚMEROS ARRAY
		for(int i=0; i<numerosAleatorios.length; i++)
		{
			numerosAleatorios[i] = (int) (Math.random()*101);
			System.out.print(numerosAleatorios[i] + " ");
		}
		
		//CÁLCULOS --------------------------------------
		System.out.println(""+
						"\n"+
						"\nEl número mayor en el array es: " + numeroMayor(numerosAleatorios)+
						"\nEl número menor en el array es: " + numeroMenor(numerosAleatorios)+
						"\nLa cantidad de números pares en el array es: " + numerosPares(numerosAleatorios));
		
		//Entrada Número a Introducir
		System.out.println(""+
						"\nIntroduzca un número entero a continuación.");
		numIntroducido = entradaTeclado.nextInt();
		//Resultado cálculo booleano estaEnArray
		if(estaEnArray(numerosAleatorios, numIntroducido) == true)
		{
			System.out.println("El número introducido sí está en el array.");
		}
		else
		{
			System.out.println("El número introducido no está en el array.");
		}
	}
	
	//========================= MÉTODOS ==============================
	
	//MÉTODO - Recoge un array de enteros para mostrarte el mayor valor
	public static int numeroMayor(int[] numerosAleatorios)
	{
		int mayor = numerosAleatorios[0];
		for(int i=1; i<numerosAleatorios.length; i++)
		{
			if(numerosAleatorios[i] > mayor)
			{
				mayor = numerosAleatorios[i];
			}
		}
		return mayor;
	}

	//MÉTODO - Recoge un array de enteros para mostrarte el menor valor
	public static int numeroMenor(int[] numerosAleatorios)
	{
		int menor = numerosAleatorios[0];
		for(int i=1; i<numerosAleatorios.length; i++)
		{
			if(numerosAleatorios[i] < menor)
			{
				menor = numerosAleatorios[i];
			}
		}
		return menor;
	}
	
	//MÉTODO - Recoge un array de enteros para mostrarte la cantidad de números pares
	public static int numerosPares(int[] numerosAleatorios)
	{
		int numerosPares = 0;
		for(int i=0; i<numerosAleatorios.length; i++)
		{
			if(numerosAleatorios[i]%2==0)
			{
				numerosPares++;
			}
		}
		return numerosPares;
	}
	
	//MÉTODO - Recoge un array de enteros y el número introducido para comprobar si el número introducido está en el array
	public static boolean estaEnArray(int[] numerosAleatorios, int numIntroducido)
	{
		boolean estaEnArray = false;
		for(int i=0; i<numerosAleatorios.length; i++)
		{
			if(numerosAleatorios[i] == numIntroducido)
			{
				estaEnArray = true;
			}
		}
		return estaEnArray;
	}
}
