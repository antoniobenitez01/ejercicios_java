/*
 * Objetivo: Programa que calcula
 * el salario semanal de un empleado en
 * base a las horas trabajadas en razón
 * de 12 euros la hora, en este caso.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int horasTrabajadas;
		float salarioSemanal;
		
		System.out.println("¿Cuántas horas trajabas cada día?");
		horasTrabajadas = entradaTeclado.nextInt();
		
		salarioSemanal = (horasTrabajadas * 12) * 5;
		System.out.println("Al trabajar " + horasTrabajadas + " horas a la semana," 
						+"\ntu salario semanal será de " + salarioSemanal + " euros.");		

	}

}
