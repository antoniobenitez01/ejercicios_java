package bucles;

import java.util.Scanner;

public class BucleDoWhile 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int num1, contador = 1;
		
		do
		{
			System.out.println("Introduzca un número.");
			num1 = entradaTeclado.nextInt();

			if(num1 < 0)
			{
				System.out.println("Número positivo");
				
			} else if (num1 > 0){
				
				System.out.println("Número negativo.");
			}
			
		} while (num1 !=0);
		
		System.out.println("Apagando programa.");

	}

}
