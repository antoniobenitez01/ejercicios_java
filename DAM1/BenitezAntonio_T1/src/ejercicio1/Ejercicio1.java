/*
 * Objetivo: Programa que muestra un menú de opciones
 * para luego pedir 4 números sobre los que se harán
 * una serie de cálculos dependiendo de la opción seleccionada
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 26/11/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double num1,num2,num3,num4, numMenor;
		int opcion;
		
		do
		{
			System.out.println("=== CÁLCULOS MATEMÁTICOS ==="+
								"\nElija una opción introduciendo el número correspondiente."+
								"\n 0) Salir" +
								"\n 1) Multiplicar" +
								"\n 2) Calcular media" + 
								"\n 3) Calcular el número menor");
			opcion = entradaTeclado.nextInt();
			if(opcion > 3 || opcion < 0)
			{
				System.out.println("Valor introducido no válido, inténtelo de nuevo.");
			}
		}while(opcion > 3 || opcion < 0);
		
		if(opcion == 0)
		{
			System.out.println("Saliendo del programa...");
		}
		else
		{
			System.out.println("Introduzca el primer número.");
			num1 = entradaTeclado.nextDouble();
			System.out.println("Introduzca el segundo número.");
			num2 = entradaTeclado.nextDouble();
			System.out.println("Introduzca el tercer número.");
			num3 = entradaTeclado.nextDouble();
			System.out.println("Introduzca el cuarto número.");
			num4 = entradaTeclado.nextDouble();
				
			switch(opcion)
			{
			case 1:
				System.out.println("La multiplicación de los valores introducidos es: " + multiplicacion(num1, num2, num3, num4));
				break;
			case 2:
				System.out.println("La media de los valores introducidos es: " + media(num1, num2, num3, num4));
				break;
			case 3:
				numMenor = numeroMenor(num1,num2);
				numMenor = numeroMenor(numMenor, num3);
				numMenor = numeroMenor(numMenor, num4);
				System.out.println("El número menor entre los números introducidos es: " + numMenor);
				break;
			}
		}
	}
	
	
	//MÉTODO - Recoge números para devolver el resultado de la multiplicación
	public static double multiplicacion(double num1, double num2, double num3, double num4)
	{
		double resultado = 0;
		resultado = num1 * num2 * num3 * num4;
		return resultado;
	}
	
	//MÉTODO - Recoge números para devolver la media del total
	public static double media(double num1, double num2, double num3, double num4)
	{
		double media = 0, suma = 0;
		suma = num1 + num2 + num3 + num4;
		media = suma/4;
		return media;
	}
	
	//MÉTODO - Recoge números para devolver el número menor
	public static double numeroMenor(double num1, double num2)
	{
		double numMenor = num1;
		if(numMenor > num2)
		{
			numMenor = num2;
		}
		return numMenor;
	}
}
