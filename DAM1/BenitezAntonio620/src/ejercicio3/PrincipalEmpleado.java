/*
 * Objetivo: Crear objetos de la clase creada Empleado
 * y hacer uso de sus constructores y métodos
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/01/2025
 */
package ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalEmpleado {

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		Empleado empleado1 = null, empleado2 = null;
		
		try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al construir el objeto Empleado
		{
			//1. Crear un empleado con la información mínima (empleado1)
			System.out.println("Creando empleado1 con la información mínima...");
			empleado1 = new Empleado("26267841R","Antonio","Benítez Rodríguez");
			System.out.println("empleado1 creado con éxito.");
			
			//2. Crear un empleado con toda la información (empleado2)
			System.out.println("Creando empleado1 con toda la información...");
			empleado2 = new Empleado("26267854V", "Eva", "Salas García", 1200.00, 5, 9.75, true, 2);
			System.out.println("empleado2 creado con éxito. \n");
			
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		/*3. Para el empleado1, solicitar por teclado el sueldo base y horas extra realizadas en el mes.
		Modificar dicha información en el objeto teniendo en cuenta que no puede ser negativa
		(excepciones) y calcular su sueldo mostrando el resultado detallado.*/
		
		try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al usar el método setSueldoBase
		{
			empleado1.setSueldoBase(inputDouble("Introduzca el Sueldo base de empleado1.", entradaTeclado));
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al usar el método setHorasExtrasMes
		{
			empleado1.setHorasExtrasMes(inputInt("Introduzca las horas extras realizadas en el mes de empleado1.", entradaTeclado));
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		System.out.printf("Sueldo base: %.2f \nHoras extras en el mes: %d \nSueldo bruto: %.2f \n\n",
						empleado1.getSueldoBase(), empleado1.getHorasExtrasMes(), empleado1.sueldoBruto());
		
		//4. Clonar el empleado2 (empleado3)
		Empleado empleado3 = Empleado.copia(empleado2);
		/*En este caso no hacemos try-catch porque si se ha creado el objeto empleado2
		 * de forma correcta, no hace falta comprobar los mismos datos otra vez.*/
		
		/*5. Para el empleado3, solicitar por teclado el sueldo base, horas extra realizadas en el mes y
		mostrar su información económica.*/
		
		try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al usar el método setSueldoBase
		{
			empleado1.setSueldoBase(inputDouble("Introduzca el Sueldo base del empleado3.", entradaTeclado));
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try //EXCEPCIÓN - IllegalArgumentException - Trata excepciones lanzadas al usar el método setHorasExtrasMes
		{
			empleado1.setHorasExtrasMes(inputInt("Introduzca las Horas extras realizadas en el mes del empleado3.", entradaTeclado));
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		empleado3.verTodoEmpleado(); //Mostramos la información completa del empleado3.
		
		//6. Mostrar todos los empleados y su número total.
		System.out.println("=== EMPLEADOS ===\n");
		empleado1.verTodoEmpleado();
		empleado2.verTodoEmpleado();
		empleado3.verTodoEmpleado();
		System.out.printf("Número total de empleados: %d", Empleado.getCantidadEmpleados());
	}
	
	//MÉTODOS =========================
	
	//MÉTODO - Recoge un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
	
	//MÉTODO - Recoge un objeto Scanner, comprueba si se introduce un valor Double correctamente
	public static double inputDouble(String mensaje, Scanner entrada)
	{
		double num = 0;
		boolean inputTrue = false;
		do
		{
			//InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextDouble();
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
}
