/*
 * Objetivo: Programa que lea una fecha introducida,
 * leyendo dia, mes y año por separado y comprobando
 * si la fecha es correcta o no mediante una función
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/11/2024
 */
package ejercicio10;
import java.time.LocalDate;
import java.util.Scanner;

public class Ejercicio10 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int dia, mes, anyo;
        
		System.out.println("Introduzca el día.");
		dia = entradaTeclado.nextInt();
		System.out.println("Introduzca el mes.");
		mes = entradaTeclado.nextInt();
		System.out.println("Introduzca el año.");
		anyo = entradaTeclado.nextInt();	
		
		if(checkFecha(dia, mes, anyo) == true)
		{
			System.out.println("La fecha introducida es correcta.");
		}
		else
		{
			System.out.println("La fecha introducida es incorrecta.");
		}
	}

	//MÉTODO - Recoge los datos String de día, mes y año para luego comprobar si son válidos
	public static boolean checkFecha(int dia, int mes, int anyo)
	{

		boolean fechaCorrecta = false, bisiesto;
		
		//Cálculo año bisiesto
		if((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 100 == 0 && anyo % 400 == 0))
		{
			bisiesto = true;
		}
		else
		{
			bisiesto = false;
		}
		
		//Cálculo días según mes
		switch(mes)
		{
		case 1,3,5,7,8,10,12:
			if(dia < 1 || dia > 31)
			{
				fechaCorrecta = false;
			}
			else
			{
				fechaCorrecta = true;
			}
			break;
			
		case 4,6,9,11:
			if(dia < 1 || dia > 30)
			{
				fechaCorrecta = false;
			}
			else
			{
				fechaCorrecta = true;
			}
			break;
			
		case 2:
			if(bisiesto == true)
			{
				if(dia < 1 || dia > 29)
				{
					fechaCorrecta = false;
				}
				else
				{
					fechaCorrecta = true;
				}
			}
			else
			{
				if(dia < 1 || dia > 28)
				{
					fechaCorrecta = false;
				}
				else
				{
					fechaCorrecta = true;
				}
			}
			break;	
		}
		return fechaCorrecta;
	}
}
