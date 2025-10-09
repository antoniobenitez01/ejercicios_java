/*
 * Objetivo: Programa para realizar cálculos de los metros 
 * de las personas; pidiendo un valor N y luego almacena
 * en un array de tamaño N las alturas introducidas por teclado,
 * mostrando la altura media, máxima y mínima así como cuántas 
 * personas miden por encima y por debajo de la media.
 * Fecha: 21/10/2024
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int n, numEncima = 0, numDebajo = 0;
		double alturaIntroducida, mediaAlturas, sumaAlturas = 0, alturaMax = 0, alturaMin;
		
		//Bucle do while para confirmar que la entrada N es un valor positivo y diferente de 0.
		do
		{
			System.out.println("Introduzca el valor n (entero y positivo).");
			n = entradaTeclado.nextInt();
			if(n < 0)
			{
				System.out.println("El número introducido es negativo, no es válido.");
			}
			else if (n == 0)
			{
				System.out.println("El número introducido es cero, no es válido.");
			}
		}while (n <= 0);	
		
		//Array Alturas (tamaño n)
		double[] numeros = new double [n];
		for(int i=0; i < numeros.length; i++)
		{
			System.out.println("Introduzca la altura de la persona " + i + ".");
			alturaIntroducida = entradaTeclado.nextDouble();
			numeros[i] =  alturaIntroducida;
			sumaAlturas += numeros[i];
		}
		
		//Cálculo Media Alturas
		mediaAlturas = sumaAlturas / n;
		
		//Bucle cálculo Altura Máxima y  Altura Mínima
		alturaMin = numeros[1];
		for(int i=0; i < numeros.length; i++)
		{
			//Condicional Altura Máxima
			if(alturaMax < numeros[i])
			{
				alturaMax = numeros[i];
			}
			//Condicional Altura Mínima
			if(alturaMin > numeros[i])
			{
				alturaMin = numeros[i];
			}
		}
		
		//Bucle cálculo Alturas Encima y Debajo de Media
		for(int i=0; i < numeros.length; i++)
		{
			if(numeros[i] >= mediaAlturas)
			{
				numEncima++;
			}
			else
			{
				numDebajo++;
			}
		}
		
		//Resultado
		System.out.println("La altura media es: " + mediaAlturas +
						"\nLa altura máxima es: " + alturaMax +
						"\nLa altura mínima es: " + alturaMin +
						"\nEl número de personas que miden por encima de la media es: " + numEncima +
						"\nEl número de personas que miden por debajo de la media es: " + numDebajo);
	}

}
