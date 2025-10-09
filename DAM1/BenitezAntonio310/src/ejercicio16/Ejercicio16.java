/*
 * Objetivo: Programa que crea un array de enteros
 * una secuencia de valores hasta introducir 10 veces,
 * utilizando el método Arrays.fill() y
 * mostrando los valores por pantalla
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 22/10/2024
 */
package ejercicio16;

import java.util.Arrays;

public class Ejercicio16 
{

	public static void main(String[] args) 
	{
		int vectorNumeros[]=new int [55];
		
		int longitud=vectorNumeros.length;
		
		int inicio=0, fin=0;
		
		for( int i=1;i<11;i++) 
		{
			
			fin=inicio+i;//Calculamos la primera posición que indicaremos en la funcion Arrays.fill
			
			Arrays.fill(vectorNumeros,inicio,fin,i);//Utilizamos la funcion Arrays.fill para ir dando valores  a las posiciones
			
			inicio=fin; //Le damos ese valor a inicio para que los valores vayan aumentando y se pueda realizar la secuencia
		}
		
		for( int i=0;i<longitud;i++) 
		{ 
			//Imprimimos por pantalla los valores del array
			System.out.println(vectorNumeros[i]);
		}
	}

}
