package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int num;
		
		do
		{
			System.out.println("Introduzca un número entero.");
			num = entradaTeclado.nextInt();
		}while(num%2==0);
		
		System.out.println("Apagando programa...");
	}
}
