package herramientas;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Herramientas
{
	
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
	
	//INPUT DOUBLE - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Double correctamente
	public static double inputDouble(String mensaje, Scanner entrada)
	{
		double num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextDouble();
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
	
	//KM TO MILES - Devuelve en millas los kilómetros introducidos
	public static double kmToMiles(double km)
	{
		double resultado;
		resultado = km/1.60934;
		return resultado;
	}
	
	//MILES TO KM - Devuelve en kilómetros las millas introducidas
	public static double milesToKm(int millas)
	{
		double resultado;
		resultado = 1.60934 * millas;
		return resultado;
	}
	
	//DISCOUNT CALCULATOR - Recoge los precios sin y con descuento y devuelve el porcentaje de descuento
	public static double discountCalculator(double precioSin, double precioCon)
	{
		double cantidadDescuento, porcentaje;
		cantidadDescuento = precioSin - precioCon;
		porcentaje = (cantidadDescuento * 100)/precioSin;
		return porcentaje;
	}
	
	//NIF CALCULATOR - Recoge el número del DNI y devuelve el carácter correspondiente	
	public static char calculoNif(int dni)
	{
		char nif = 'a';
			
		switch(dni%23)
		{
		case 0:
			nif = 'T';
			break;
		case 1:
			nif = 'R';
			break;
		case 2:
			nif = 'W';
			break;
		case 3:
			nif = 'A';
			break;
		case 4:
			nif = 'G';
			break;
		case 5:
			nif = 'M';
			break;
		case 6:
			nif = 'Y';
			break;
		case 7:
			nif = 'F';
			break;
		case 8:
			nif = 'P';
			break;
		case 9:
			nif = 'D';
			break;
		case 10:
			nif = 'X';
			break;
		case 11:
			nif = 'B';
			break;
		case 12:
			nif = 'N';
			break;
		case 13:
			nif = 'J';
			break;
		case 14:
			nif = 'Z';
			break;
		case 15:
			nif = 'S';
			break;
		case 16:
			nif = 'Q';
			break;
		case 17:
			nif = 'V';
			break;
		case 18:
			nif = 'H';
			break;
		case 19:
			nif = 'L';
			break;
		case 20:
			nif = 'C';
			break;
		case 21:
			nif = 'K';
			break;
		case 22:
			nif = 'E';
			break;
		}
		return nif;
	}
	
	//WAIT - Espera un número entero de milisegundos
	public static void wait(int num)
	{
		try 
		{
			Thread.sleep(num);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
