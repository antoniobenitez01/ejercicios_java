/*
 * Objetivo: Programa que convierte euros
 * en billetes y monedas que podemos utilizar
 * para obtener la cantidad deseada.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/10/2024
 */
package ejercicio20;

import java.util.Scanner;

public class Ejercicio20 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		double importeEuros; //ENTRADA DE IMPORTE DE EUROS
		double billete500, billete200, billete100, billete50, billete20, billete10, billete5; //VARIABLES BILLETES
		double moneda200, moneda100, moneda01, moneda02, moneda05, moneda10, moneda20, moneda50; //VARIABLES MONEDAS
		
		System.out.println("Introduzca un número de euros");
		importeEuros = entradaTeclado.nextDouble();
		
		importeEuros = Math.round(importeEuros * 100); //Pasamos la cantidad de euros introducida a céntimos para facilitarnos la operación
		
		//Cálculo Billetes ===================
		
		billete500 = importeEuros / 50000;
		billete200 = importeEuros % 50000;
		billete100 = billete200 % 20000;
		billete50 = billete100 % 10000;
		billete20 = billete50 % 5000;
		billete10 = billete20 % 2000;
		billete5 = billete10 % 1000;
		
		//Cálculo Monedas ====================
		
		moneda200 = billete5 % 500;
		moneda100 = moneda200 % 200;
		moneda50 = moneda100 % 100;
		moneda20 = moneda50 % 50;
		moneda10 = moneda20 % 20;
		moneda05 = moneda10 % 10;
		moneda02 = moneda05 % 5;
		moneda01 = moneda02 % 2;
		
		//Resultado de conversión
		
		System.out.println("BILLETES:\n"
				+ (int)Math.floor(billete500) + " billetes de 500 euros.\n"
				+ (int)(billete200 / 20000) + " billetes de 200 euros.\n"
				+ (int)(billete100 / 10000) + " billetes de 100 euros.\n"
				+ (int)(billete50 / 5000) + " billetes de 50 euros.\n"
				+ (int)(billete20 / 2000) + " billetes de 20 euros.\n"
				+ (int)(billete10 / 1000) + " billetes de 10 euros.\n"
				+ (int)(billete5 / 500) + " billetes de 5 euros.\n"
				+ "\n"
				+ "MONEDAS:\n"
				+ (int)(moneda200 / 200) + " monedas de 2 euros.\n"
				+ (int)(moneda100 / 100) + " monedas de 1 euro.\n"
				+ (int)(moneda50 / 50) + " monedas de 50 céntimos.\n"
				+ (int)(moneda20 / 20) + " monedas de 20 céntimos.\n"
				+ (int)(moneda10 / 10) + " monedas de 10 céntimos.\n"
				+ (int)(moneda05 / 5) + " monedas de 5 céntimos.\n"
				+ (int)(moneda02 / 2) + " monedas de 2 céntimos.\n"
				+ (int)(moneda01 / 1) + " monedas de 1 céntimo.\n");
	}

}
