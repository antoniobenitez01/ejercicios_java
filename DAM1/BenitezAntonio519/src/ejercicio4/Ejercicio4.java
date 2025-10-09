/*
 * Objetivo: Programa que crea un vector de enteros de tamaño N
 * (N siendo un número aleatorio entre 1 y 100) con valores aleatorios
 * entre 1 y 10, preguntando qué posición del array se quiere mostrar en bucle
 * hasta que se introduzca un valor negativo.
 * Excepciones: InputMismatchException, IndexOutOfBoundsException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 29/11/2024
 */
package ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n = (int) ((Math.random()*100)+1), numIntroducido = 0;		//Declaración de valor entero N de valor aleatorio entre 1 y 100
		int[] numerosEnteros = new int[n];		//Declaración de Array de longitud N
		
		//Bucle For para rellenar el array con valores aleatorios del 1 a 10
		for(int i=0; i<numerosEnteros.length; i++)
		{
			numerosEnteros[i] = (int) ((Math.random()*10)+1);
		}
		
		do
		{
			//EXCEPCIÓN - IndexOutOfBoundException, si numIntroducido sobrepasa el rango del Array, te avisa y te obliga a introducir otro valor
			try
			{
				numIntroducido = inputInt("-------------------------"+
										  "\nIntroduzca la posición del array que quiere mostrar por pantalla.", entradaTeclado);
				if(numIntroducido < 0)
				{
					System.out.println("Valor negativo introducido, apagando programa...");
				}
				else
				{
					System.out.println("El valor almacenado en la posición " + numIntroducido + " es " + numerosEnteros[numIntroducido]);
				}			
			}catch(IndexOutOfBoundsException excepcion2)
			{
				System.out.println("El valor introducido no es un rango válido del array, introduzca otro valor.");
			}catch(NullPointerException excepcion3)
			{
				System.out.println("La posición contiene un valor nulo.");
			}
		}while(numIntroducido > 0);
	}
	
	//MÉTODO - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor entero
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
}
