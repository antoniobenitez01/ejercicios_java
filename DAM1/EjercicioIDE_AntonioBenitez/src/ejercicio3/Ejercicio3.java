package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double nota;
		
		System.out.println("Introduzca la nota del último examen.");
		nota = entradaTeclado.nextDouble();
		
		if(nota >= 5)
		{
			System.out.println("Enhorabuena, ha aprobado el examen.");
		}
		else
		{
			System.out.println("Te deseo ánimo para que superes el siguiente examen.");
		}
	}
}
