/*
 * Objetivo: Programa que utiliza un método booleano
 * para determinar si el usuario pasa la auditoría
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 15/11/2024
 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String respuesta;
		double salarioJefe, salarioEncargado, salarioOficinistas, presupuestoEmpresa;
		int numeroOficinistas;
		boolean proyectosTerminados;
		
		//Entrada de datos
		System.out.println("Introduzca el salario del jefe.");
		salarioJefe = entradaTeclado.nextDouble();
		System.out.println("Introduzca el salario del encargado.");
		salarioEncargado = entradaTeclado.nextDouble();
		System.out.println("Introduzca el salario de los oficinistas.");
		salarioOficinistas = entradaTeclado.nextDouble();
		System.out.println("Introduzca el número de oficinistas.");
		numeroOficinistas = entradaTeclado.nextInt();
		System.out.println("Introduzca el presupuesto de la empresa");
		presupuestoEmpresa = entradaTeclado.nextDouble();
		//Depuración comando Scanner
		entradaTeclado.nextLine();
		
		//Entrada dato booleano de proyectos terminados
		System.out.println("¿Se han terminado los proyectos acordados? (Sí o No)");
		respuesta = entradaTeclado.nextLine();
		if(respuesta.equals("Sí") || respuesta.equals("Si") || respuesta.equals("si") || respuesta.equals("sí"))
		{
			proyectosTerminados = true;
		}
		else
		{
			proyectosTerminados = false;
		}
		
		//Resultado booleano
		if(auditoriaEmpresa(salarioJefe, salarioEncargado, salarioOficinistas, numeroOficinistas, proyectosTerminados, presupuestoEmpresa) == true)
		{
			System.out.println("Ha pasado la auditoría.");
		}
		else
		{
			System.out.println("No ha pasado la auditoría.");
		}
	}
	
	public static boolean auditoriaEmpresa(double salarioJefe, double salarioEncargado, double salarioOficinistas, int numeroOficinistas, boolean proyectosTerminados, double presupuestoEmpresa)
	{
		boolean auditoria = false;
		if(proyectosTerminados = false)
		{
			auditoria = false;
			System.out.println("No ha pasado la auditoría ya que no ha terminado los proyectos acordados.");
		}
		else if((salarioJefe + salarioEncargado + (salarioOficinistas * numeroOficinistas)) > 20000)
		{
			auditoria = false;
			System.out.println("No ha pasado la auditoría ya que el gasto en personal es de excede el límite mensual de 20.000 euros.");
		}
		else if (presupuestoEmpresa > 100000)
		{
			auditoria = false;
			System.out.println("No ha pasado la auditoría ya que el presupuesto asignado de .... excede el límite establecido de 100.000 euros.");
		}
		else
		{
			auditoria = true;
			System.out.println("Enhorabuena!! Ha pasado la auditoría, nos vemos el año que viene.");
		}
		return auditoria;
	}
}
