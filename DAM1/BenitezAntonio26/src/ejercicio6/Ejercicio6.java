/*
 * Objetivo: Variación del Ejercicio 5
 * que detecte los números por debajo del 0
 * y por encima del 10 y que añado un caso
 * en el que la nota 10 te de un resultado 
 * de Matrícula de Honor
 * Autor: Antonio Benítez Rodríguez
 * Fecha:08/10/2024 
 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 
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
		else if (notaAcademica == 9)
		{
			System.out.println("Nota académica: " + notaAcademica + " (Sobresaliente)");					
		}
		else if (notaAcademica == 10)
		{
			System.out.println("Nota académica: " + notaAcademica + " (Matrícula de Honor)");
		}
		else
		{
			System.out.println("La nota académica introducida no es válida.");
		}
	}

}
