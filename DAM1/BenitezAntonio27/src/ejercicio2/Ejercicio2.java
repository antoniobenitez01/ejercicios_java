/*
 * Objetivo: Variación mejorada de
 * Ejercicio 1 donde añadiremos
 * una nueva comprobación.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 09/10/2024
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración variables
		String nombre, apellidos;
		int edad, anyosExperiencia, numeroProyectos;
		double salarioDeseado;
		
		//Entrada variables
		System.out.println("Introduzca su nombre.");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduzca sus apellidos.");
		apellidos = entradaTeclado.nextLine();
		System.out.println("Introduzca su edad.");
		edad = entradaTeclado.nextInt();
		System.out.println("Introduzca su salario deseado.");
		salarioDeseado = entradaTeclado.nextDouble();
		
		//Condicional y resultado
		if(salarioDeseado <= 30000)
		{
			System.out.println("¿Cuántos años de experiencia tiene?");
			anyosExperiencia = entradaTeclado.nextInt();
			System.out.println("¿En cuántos proyectos ha trabajado?");
			numeroProyectos = entradaTeclado.nextInt();
			
			if((anyosExperiencia >=2) && (numeroProyectos >= 3))
			{
				System.out.println("Enhorabuena, ha sido contratado.");
				if((anyosExperiencia >= 5) || (numeroProyectos >= 5))
				{
					System.out.println("Su salario será de 30.000 euros");
				}
				else
				{
					System.out.println("Su salario será de 25.000 euros.");
				}
			}
			else
			{
				System.out.println("Lo sentimos, pero no cumple nuestro perfil");
			}
			
		}
		else
		{
			System.out.println("Lo sentimos, pero no cumple nuestro perfil");
		}

	}

}
