/*
 * Objetivo: Programa que solicita números entre 1 y 50
 * y calcula los primeros múltiplos de ambos números, el programa
 * solo se detiene al introducir 0.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 26/11/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num1,num2, contadorBucle = 0, contadorNumero = 1;
		int[] multiplos = new int [5];
		
		do
		{
			//Bucle num1
			do
			{
				System.out.println("Introduzca un número del 1 al 50."+
						"\nSi introduce 0 el programa se apagará.");
				num1 = entradaTeclado.nextInt();
				
				if(num1 < 0 || num1 > 50)
				{
					System.out.println("El número introducido no es válido.");
				}
			}while(num1 < 0 || num1 > 50);
			
			//Bucle num2
			do
			{
				System.out.println("Introduzca un número del 1 al 50."+
						"\nSi introduce 0 el programa se apagará.");
				num2 = entradaTeclado.nextInt();
				
				if(num2 < 0 || num2 > 50)
				{
					System.out.println("El número introducido no es válido.");
				}
			}while(num2 < 0 || num2 > 50);
			
			if(num1 == 0 || num2 == 0)
			{
				System.out.println("Ha introducido un 0, apagando programa.");
			}
			else
			{
				while(contadorBucle < 5)
				{
					if((contadorNumero%num1==0) && (contadorNumero%num2==0))
					{
						multiplos[contadorBucle] = contadorNumero;
						contadorBucle++;
					}
					contadorNumero++;
				}
				
				System.out.println("Los 5 primeros múltiplos de los números " + num1 + " y " + num2 + " son:");
				for(int i=0; i<multiplos.length;i++)
				{
					System.out.print(multiplos[i] + " ");
				}
				System.out.println("\n---------------");
			}	
		}while(num1 != 0 && num2 != 0);
	}
}
