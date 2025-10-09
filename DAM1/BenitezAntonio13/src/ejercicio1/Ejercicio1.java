/*
 * Objetivo: Programa que solicite datos al usuario
 * para luego calcular el salario neto del usuario
 * y el aumento del mismo por cada año.
 * Autor: Antonio Benítez Rodríguez
 * Fecha:04/10/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner
		Scanner entradaTeclado = new Scanner(System.in);
		
		//Declaración variables
		String nombre, apellidos, fechaNacimiento;
		int anyosTrabajando;
		float salarioBruto, salarioNeto, aumento, salarioTotal;
		
		//Solicitud de datos del usuario
		System.out.println("Introduzca su nombre.");
		nombre = entradaTeclado.nextLine();
		
		System.out.println("Introduzca sus apellidos.");
		apellidos = entradaTeclado.nextLine();
		
		System.out.println("Introduzca su fecha de nacimiento (DD/MM/AAAA)");
		fechaNacimiento = entradaTeclado.nextLine();
		
		System.out.println("Introduzca su salario bruto");
		salarioBruto = entradaTeclado.nextFloat();
		
		System.out.println("Introduza los años que lleva trabajando en la empresa.");
		anyosTrabajando = entradaTeclado.nextInt();
		
		//Operación de porcentajes
		salarioNeto = (salarioBruto - ((salarioBruto*15)/100));
		aumento = (salarioBruto*(2*anyosTrabajando))/100;
		salarioTotal = salarioNeto + aumento;
		
		//Resultado y texto
		System.out.println("Estimad@ " + nombre + " " + apellidos + ", su salario bruto es " + salarioBruto + ", teniendo en"
						  +"\ncuenta un IRPF del 15% su salario neto es de " + salarioNeto + ".");
		
		System.out.println("Debido a sus " + anyosTrabajando + " años trabajando en la empresa su salario se "
				          +"\nincrementará en un 2% por cada año. El aumento es de"
						  +"\n" + aumento + " y el salario total es " + salarioTotal);
		

	}

}
