package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TratamientoExcepciones 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int num = inputInt("Dame la edad", entradaTeclado);
		System.out.println("El número es: " + num + ".");
	}
	
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("No se ha introducido un número.");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
	
	public static double inputDouble(String mensaje, Scanner entrada)
	{
		double num = 0;
		boolean inputTrue = false;
		do
		{
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextDouble();
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("No se ha introducido un número.");
				entrada.nextLine();
			}
		}while(inputTrue == false);
		return num;
	}
}
