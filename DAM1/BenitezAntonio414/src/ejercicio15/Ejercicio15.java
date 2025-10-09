/*
 * Objetivo: Programa que crea un array tamaño 50
 * con los números naturales comprendidos entre 50
 * y 99 para luego mostrar la suma total y la media
 * mediante una función de suma y otra de media
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio15;

public class Ejercicio15 
{

	public static void main(String[] args) 
	{
		double[] numeros = new double [50];
		double suma;
		for(int i=0;i<numeros.length;i++)
		{
			numeros[i] = 50 + i;
		}
		
		suma = sumaArray(numeros);
		System.out.println("Suma de valores de 50 a 99: " + suma + 
						"\nMedia de valores de 50 a 99: " + mediaArray(suma));
	}
	
	//MÉTODO - Recoge un array y devuelve la suma de todos sus valores
	public static double sumaArray(double[] numeros)
	{
		double suma = 0;
		for(int i=0;i<numeros.length;i++)
		{
			suma += numeros[i];
		}
		return suma;
	}
	
	//MÉTODO - Recoge un valor de suma y calcula la media de cantidad 50
	public static double mediaArray(double suma)
	{
		double media;
		media = suma / 50;
		return media;
	}
}
