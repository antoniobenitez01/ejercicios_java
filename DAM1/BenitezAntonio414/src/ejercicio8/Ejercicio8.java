/*
 * Objetivo: Programa que pide un valor N entero
 * y luego muestra su sumatorio, productorio y el valor
 * intermedio entre 1 y N.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/11/2024
 */
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n;
		
		System.out.println("Introduzca un número entero");
		n = entradaTeclado.nextInt();
		
		System.out.println("La suma de enteros de 1 a " + n + " es " + suma1aN(n) + "." +
						"\nEl producto de enteros de 1 a " + n + " es " + producto1aN(n) + "." +
						"\nEl valor intermedio entre 1 y " + n + " es " + intermedio1aN(n) + ".");
	}

	//MÉTODO - Recoge el valor N y devuelve la suma de enteros del sumatorio de 1 a N
	public static int suma1aN(int n)
	{
		int suma = 0;
        for (int i = 1; i <= n; i++) 
        {
            suma += i;
        }
        return suma;
	}
	
	//MÉTODO - Recoge el valor N y devuelve el producto de enteros del sumatorio de 1 a N
	public static int producto1aN(int n)
	{
		int producto = 1;
        for (int i = 1; i <= n; i++) 
        {
            producto = producto * i;
        }
        return producto;
	}
	
	//MÉTODO - Recoge el valor N y calcula el valor intermedio entre 1 y N
	public static int intermedio1aN(int n)
	{
		int intermedio;
		intermedio = (1+n)/2;
		return intermedio;
	}
}
