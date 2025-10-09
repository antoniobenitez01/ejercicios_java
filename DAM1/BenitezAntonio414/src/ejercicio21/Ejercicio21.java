/*
 * Objetivo: Programa que
 */
package ejercicio21;

import java.util.Scanner;

public class Ejercicio21 
{

	public static void main(String[] args) 
	{
		double radio;
		int opcion;
		
		do
		{
			opcion = menu();
			if(opcion == 5)
			{
				System.out.println("Apagando programa...");
			}
			else
			{
				radio = pideRadio();
				switch(opcion)
				{
				case 1:
					System.out.println("La circunferencia del círculo dado el radio " + radio + " es " + circunferencia(radio) + " m.");
					break;
				case 2:
					System.out.println("El área del círculo dado del radio " + radio + " es " + area(radio) + " m2.");
					break;
				case 3:
					System.out.println("El volumen de la esfera dado el radio " + radio + " es " + volumen(radio) + " m3.");
					break;
				case 4:
					System.out.println("La circunferencia del círculo dado el radio " + radio + " es " + circunferencia(radio) + " m.");
					System.out.println("El área del círculo dado del radio " + radio + " es " + area(radio) + " m2.");
					System.out.println("El volumen de la esfera dado el radio " + radio + " es " + volumen(radio) + " m3.");
					break;
				}
			}
		}while (opcion != 5);
	}

	//MÉTODO - Muestra un menú y devuelve la opción elegida
	public static int menu()
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int opcion;
		System.out.println("----- MENÚ -----" +
						"\n1. Circunferencia" +
						"\n2. Área" +
						"\n3. Volumen" +
						"\n4. Todas" +
						"\n5. Salir");
		do
		{
			System.out.println("Introduzca una opción.");
			opcion = entradaTeclado.nextInt();
			if(opcion < 1 || opcion > 5)
			{
				System.out.println("La opción introducida no existe.");
			}
		}while (opcion < 1 || opcion > 5);
		
		return opcion;
	}
	
	//MÉTODO - Pide al usuario el radio y lo devuelve
	public static double pideRadio()
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double radio;
		
		System.out.println("Introduzca el radio.");
		radio = entradaTeclado.nextDouble();
		
		return radio;
	}
	
	//MÉTODO - Recoge el dato de radio y calcula la circunferencia
	public static double circunferencia(double r)
	{
		double resultado;
		resultado = (2 * Math.PI) * r;
		return resultado;
	}
	
	//MÉTODO - Recoge el dato de radio y calcula el área
	public static double area(double r)
	{
		double resultado;
		resultado = Math.PI * (Math.pow(r, 2));
		return resultado;
	}
	
	//MÉTODO - Recoge el dato de radio y calcula la volumen
	public static double volumen(double r)
	{
		double resultado;
		resultado = (Math.pow(r, 3) * 4/3) * Math.PI;
		return resultado;
	}
}
