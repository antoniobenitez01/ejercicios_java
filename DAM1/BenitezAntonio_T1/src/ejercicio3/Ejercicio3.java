/*
 * Objetivo: Programa que registra una tabla con la pluviametría
 * registrada de cada día del 16 al 31 del mes pasado en 10 municipios;
 * utilizando métodos para hacer diversos cálculos sobre los valores de la tabla
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 26/11/2024
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int temperaturas [][] = {{0, 31, 1, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 33, 42, 22}, {24, 56, 7, 0, 0, 0, 0, 0, 0, 0, 2, 12, 2, 10, 30, 29}, 
				{17, 22, 5, 0, 0, 0, 0, 0, 0, 1, 2, 9, 1, 13, 36, 32}, {2, 41, 2, 0, 0, 0, 0, 0, 0, 0, 1, 7, 0, 11, 13, 32}, 
				{0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 11, 58, 3}, {18, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 11, 1, 7, 50, 36}, 
				{1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 17, 35, 64},{7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 5, 7, 0, 26, 23, 0}, 
				  {3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 4, 7, 130, 43},{4, 33, 1, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0, 10, 20, 31}};
		String [] nombreMunicipios = {"MIJAS", "JUBRIQUE", "PUJERRA", "OJEN", "MÁLAGA", "RONDA", "COÍN", "TORROX", "ARDALES", "MARBELLA"};
		int diasMasLluviosos[] = new int[10];
		String municipioIntroducido;
		int diaIntroducido, numeroMunicipioIntroducido = 0;
	
		//A) DÍA MÁS LLUVIOSO SEGÚN EL MUNICIPIO
		System.out.println("\n"+"=== DÍA MÁS LLUVIOSOS ==="+"\n");
		for(int municipio=0; municipio<nombreMunicipios.length;municipio++)
		{
			diasMasLluviosos[municipio] = diaMasLluvioso(temperaturas, municipio);
			System.out.println("El día más lluvioso para " + nombreMunicipios[municipio] + " fue " + diasMasLluviosos[municipio]);
		}
		
		//B) MUNICIPIO MÁS LLUVIOSO SEGÚN EL DÍA
		System.out.println("\n"+"=== MUNICIPIO CON MÁS LLUVIA SEGÚN EL DÍA ==="+"\n");
		for(int dia=0; dia<15; dia++)
		{
			System.out.println("El municipio más lluvioso para el día " + (dia+16) + " es " + nombreMunicipios[municipioMasLluvioso(temperaturas, dia)] + ".");
			
		}
		
		//C) DÍA MÁS LLUVIOSO ENTRE TODOS LOS MUNICIPIOS
		System.out.println("\n"+"=== DÍA MÁS LLUVIOSO ==="+"\n");
		System.out.println("El día más lluvioso de todos fue el día " + (diaMasLluviosoTodos(temperaturas)[0]+16) + " del municipio " + nombreMunicipios[diaMasLluviosoTodos(temperaturas)[1]] + ".");
		
		
		//D) SOLICITAR DIA Y MUNICIPIO
		System.out.println("\n"+"=== SOLICITAR UN DÍA Y MUNICIPIO ==="+
				"\nIntroduzca el municipio");
		municipioIntroducido = entradaTeclado.nextLine();
		municipioIntroducido = municipioIntroducido.toLowerCase();
		if(municipioIntroducido.equals("mijas"))
		{
			numeroMunicipioIntroducido = 0;
		}
		else if(municipioIntroducido.equals("jubrique"))
		{
			numeroMunicipioIntroducido = 1;
		}
		else if(municipioIntroducido.equals("pujerra"))
		{
			numeroMunicipioIntroducido = 2;
		}
		else if(municipioIntroducido.equals("ojen"))
		{
			numeroMunicipioIntroducido = 3;
		}
		else if(municipioIntroducido.equals("malaga"))
		{
			numeroMunicipioIntroducido = 4;
		}
		else if(municipioIntroducido.equals("ronda"))
		{
			numeroMunicipioIntroducido = 5;
		}
		else if(municipioIntroducido.equals("coin"))
		{
			numeroMunicipioIntroducido = 6;
		}
		else if(municipioIntroducido.equals("torrox"))
		{
			numeroMunicipioIntroducido = 7;
		}
		else if(municipioIntroducido.equals("ardales"))
		{
			numeroMunicipioIntroducido = 8;
		}
		else if(municipioIntroducido.equals("marbella"))
		{
			numeroMunicipioIntroducido = 9;
		}
		
		System.out.println("Introduzca el día");
		diaIntroducido = entradaTeclado.nextInt();
		diaIntroducido = diaIntroducido - 16;
			
		if(haLlovido(temperaturas, numeroMunicipioIntroducido, diaIntroducido) == true)
		{
			System.out.println("Ese día en " + nombreMunicipios[numeroMunicipioIntroducido] + " ha llovido.");
		}
		else
		{
			System.out.println("Ese día en " + nombreMunicipios[numeroMunicipioIntroducido] + " no ha llovido.");
		}
		
	}

	//MÉTODO - Recoge un array y una posición para calcular el día más lluvioso del municipio deseado
	public static int diaMasLluvioso(int temperaturas[][], int municipio)
	{
		int diaMasLluvioso = 0;
		for(int dia=1; dia<16; dia++)
		{
			if(temperaturas[municipio][diaMasLluvioso] < temperaturas[municipio][dia])
			{
				diaMasLluvioso = dia;
			}
		}
		return diaMasLluvioso;
	}
	
	//MÉTODO - Recoge un array y un día para calcular el municipio más lluvioso de ese día
	public static int municipioMasLluvioso(int temperaturas[][], int dia) 
	{
		int municipioMasLluvioso = 0;
		for(int municipio=1; municipio<temperaturas.length;municipio++)
		{
			if(temperaturas[municipioMasLluvioso][dia] < temperaturas[municipio][dia])
			{
				municipioMasLluvioso = municipio;
			}
		}
		return municipioMasLluvioso;
	}
	
	//MÉTODO - Recoge una matriz de temperaturas y devuelve un array con el dia mas lluviosos de todos y su municipio correspondiente
	public static int[] diaMasLluviosoTodos(int temperaturas[][])
	{
		int[] arrayDiaMunicipioMasLluvioso = new int[2];
		int municipioMasLluvioso = 0;
		int diaMasLluviosoTodos = 0;
		for(int municipio = 0;municipio<temperaturas.length;municipio++)
		{
			for(int dia = 0; dia<15; dia++)
			{
				if(temperaturas[municipioMasLluvioso][diaMasLluviosoTodos]<temperaturas[municipio][dia])
				{
					diaMasLluviosoTodos = dia;
					municipioMasLluvioso = municipio;
				}
			}
		}
		arrayDiaMunicipioMasLluvioso[0] = diaMasLluviosoTodos;
		arrayDiaMunicipioMasLluvioso[1] = municipioMasLluvioso;
		return arrayDiaMunicipioMasLluvioso;
	}
	
	//MÉTODO - Recoge un array, un municipio y un día y devuelve true si ha llovido
	public static boolean haLlovido(int temperaturas[][], int municipio, int dia)
	{
		boolean haLlovido = false;
		if(temperaturas[municipio][dia] != 0)
		{
			haLlovido = true;
		}
		else
		{
			haLlovido = false;
		}
		return haLlovido;
	}
}
