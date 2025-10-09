/*
 * Objetivo: Programa que solicita datos
 * de nombre, apellidos, ciclo formativo y nota académica en entero
 * para denominar si la nota académica del usuario es
 * sobresaliente, notable, etc.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 08/10/2024
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		String nombre, apellidos, cicloFormativo;
		int notaAcademica;
		
		System.out.println("Introduzca su nombre");
		nombre = entradaTeclado.nextLine();
		System.out.println("Introduzca sus apellidos.");
		apellidos = entradaTeclado.nextLine();
		System.out.println("Introduzca su Ciclo Formativo");
		cicloFormativo = entradaTeclado.nextLine();
		System.out.println("Introduzca su nota académica (en número entero)");
		notaAcademica = entradaTeclado.nextInt();
		
		System.out.println("Nombre: " + nombre +
						"\nApellidos: " + apellidos +
						"\nCiclo Formativo: " + cicloFormativo);
		if ((0 <= notaAcademica) && (notaAcademica < 5))
		{
			System.out.println("Nota académica: " + notaAcademica + " (Suspenso)");					
		}
		else if(notaAcademica == 5)
		{
			System.out.println("Nota académica: " + notaAcademica + " (Aprobado)");					
		}
		else if (notaAcademica == 6)
		{
			System.out.println("Nota académica: " + notaAcademica + " (Bien)");		
		}
		else if ((notaAcademica == 7) || (notaAcademica == 8))
		{
			System.out.println("Nota académica: " + notaAcademica + " (Notable)");			
		}
		else if ((notaAcademica == 9) || (notaAcademica == 10))
		{
			System.out.println("Nota académica: " + notaAcademica + " (Sobresaliente)");					
		}
		else
		{
			System.out.println("La nota académica introducida no es válida.");
		}

	}

}
