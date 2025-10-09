/*
 * Objetivo: Programa que convierte expresiones
 * algebraicas en expresiones algoritmicas, solicitando
 * tres números reales y almacenándolos en variables X,Y y Z.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 15/10/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{

	public static void main(String[] args) 
	{
		//Entrada Scanner y Variables
		Scanner entradaTeclado = new Scanner(System.in);
		int numOperacion;
		double X,Y,Z, operacion1, operacion2, operacion3;
		
		//Solicitud de datos
		System.out.println("Introduzca el valor de X");
		X = entradaTeclado.nextDouble();
		System.out.println("Introduzca el valor de Y");
		Y = entradaTeclado.nextDouble();
		System.out.println("Introduzca el valor de Z");
		Z = entradaTeclado.nextDouble();
		
		//Operaciones
		operacion1 = (X/3) + 8;
		operacion2 = ((Math.pow(X, 2)) / (Math.pow(Y, 2))) + ((Math.pow(Y, 2)) / (Math.pow(Z, 2)));
		operacion3 = (Math.pow(X, 2) + (3*X*Y) + Math.pow(Y, 2)) / (1 / Math.pow(X, 2));
		
		//Resultado final
		System.out.println("CÁLCULOS ARITMÉTICOS" +
						"\n--------------------------" +
						"\nIntroduzca tres números reales:" +
						"\nValor para la X: " + X +
						"\nValor para la Y: " + Y +
						"\nValor para la Z: " + Z +
						"\n" +
						"\nRESULTADO" +
						"\n----------" +
						"\nOPERACION_1: " + operacion1 +
						"\nOPERACION_2: " + operacion2 +
						"\nOPERACION_3: " + operacion3);
	}
}
