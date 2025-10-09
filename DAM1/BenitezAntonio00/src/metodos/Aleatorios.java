package metodos;

import java.util.Scanner;

public class Aleatorios 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double nota, notaDesplazada;
		int notaInt, max, min;
		
		System.out.println("Introduzca el número aleatorio mínimo.");
		min = entradaTeclado.nextInt();
		System.out.println("Introduzca el número aleatorio máximo.");
		max = entradaTeclado.nextInt();
		
		nota = notaAleatoria(max);
		notaInt = notaInt(max);
		notaDesplazada = notaAleatoriaDesplazamiento(max, min);
		
		System.out.printf("%.2f\n", nota);
		System.out.println(notaInt);
		System.out.println(notaDesplazada);
	}
	
	// Método devuelve notas aleatorias entre 0 y 10
	public static double notaAleatoria(int max)
	{
		double num;
		num = (Math.random() * max);
		return num;
	}
	
	//Método devuelve nota aleatoria entera entre 0 y 10
	public static int notaInt(int max)
	{
		int numInt;
		numInt = (int) Math.ceil(notaAleatoria(max));
		return numInt;
	}
	
	// Método devuelve notas aleatorias entre 0 y 10
	public static double notaAleatoriaDesplazamiento(int max, int min)
	{
		double numDes;
		numDes = notaAleatoria(max) + min;
		return numDes;
	}
}
