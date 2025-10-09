package condicional;

import java.util.Scanner;

public class Condicional 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int num1, resto, contador = 1;
		
		while (contador <= 5)
		{
			System.out.println("Introduzca el número " + contador + ".");
			num1 = entradaTeclado.nextInt();
			resto = num1%2;

			if(num1 < 0)
			{
				if(resto == 0)
				{
					System.out.println("El número es negativo y par.");
				}
				else
				{
					System.out.println("El número es negativo e impar.");
				}
			}
			else
			{
				if (resto == 0)
				{
					System.out.println("El número es positivo y par");
				}
				else
				{
					System.out.println("El número es positivo e impar");
				}
			}
			
			contador++;
		}
		
		System.out.println("Apagando programa.");

	}

}
