package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num = 0, numPositivos = 0;
		
		System.out.println("Introduzca un número entero.");
		num = entradaTeclado.nextInt();
		while(num >= 0)
		{
			if(num > 0)
			{
				numPositivos++;
			}
			System.out.println("Introduzca un número entero.");
			num = entradaTeclado.nextInt();
		}while(num >= 0);
		System.out.println("Cantidad de números positivos: " + numPositivos);
		System.out.println("Apagando programa...");
	}
}
