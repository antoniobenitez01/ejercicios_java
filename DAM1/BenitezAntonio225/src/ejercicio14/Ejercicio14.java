/*
 * Objetivo: Programa que presente un número X
 * al usuario y diga si es primo o no.
 */
package ejercicio14;

public class Ejercicio14 
{

	public static void main(String[] args) 
	{
		int num, m, check=0;
		num = (int) (Math.random()*100);
		System.out.println(num);
		m = num/2;
		
		if(num == 0 || num == 1)
		{
			System.out.println(num + " no es un número primo.");
		}
		else
		{
			for(int i=2; i<=m;i++)
			{
				if(num%i==0)
				{
					check++;
				}
			}
			if(check == 0)
			{
				System.out.println(num + " es un número primo.");
			}
			else
			{
				System.out.println(num + " no es un número primo.");
			}
		}
	}
}
