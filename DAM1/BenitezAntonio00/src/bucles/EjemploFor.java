package bucles;

import java.util.Scanner;

public class EjemploFor 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int numIntroducido, sumaNum = 0;
		
		for(int i=1; i<=10; i++ )
		{
			System.out.println("Introduzca un número");
			numIntroducido = entradaTeclado.nextInt();
			sumaNum += numIntroducido;
		}
		
		System.out.println(sumaNum);

	}

}
