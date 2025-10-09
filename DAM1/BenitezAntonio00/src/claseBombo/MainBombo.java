package claseBombo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBombo {

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		boolean bomboCreado = false;
		
		System.out.println("BOMBO DE UN BINGO \n--------------------");
		
		System.out.println("Prueba del constructor sin parámetros:");
		Bombo bombo = new Bombo();
		System.out.printf("Creado objeto: %s\n", bombo.toString());
		
		System.out.println("\nPrueba el constructor con parámetros:");
		Bombo bomboTeclado = null;
		do
		{
			int capacidadTeclado = inputInt("Introduzca el número de bolas (9-90)", entradaTeclado);
			try
			{
				bomboTeclado = new Bombo(capacidadTeclado);
				System.out.printf("Creado objeto: %s\n", bombo.toString());
				bomboCreado = true;
			}catch(IllegalArgumentException ex)
			{
				System.out.printf("%s\n",ex.getMessage());
			}
		}while(bomboCreado == false);
		
		System.out.printf("Prueba del getCapacidadBombo: %d\n", bomboTeclado.getCapacidadBombo());
		System.out.printf("Prueba del getCantidadBolasExtraidas: %d\n", bomboTeclado.getCantidadBolasExtraidas());
		System.out.printf("Prueba del getCantidadBolasRestantes: %d\n", bomboTeclado.getCantidadBolasRestantes());
		System.out.printf("Prueba del toString: %s", bomboTeclado.toString());
	}
	
	//INPUT INT - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				entrada.nextLine(); // Depuración Scanner
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine(); // Depuración Scanner
			}
		}while(inputTrue == false);
		return num;
	}
}
