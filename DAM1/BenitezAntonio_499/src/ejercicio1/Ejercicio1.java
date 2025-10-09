/*
 * Objetivo: Programa que hace uso de una tabla de pluviometría
 * para realizar una serie de cálculos sobre ella haciendo uso
 * de varios métodos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 13/12/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
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
		int diaInicio, diaFin, numeroMunicipio;
		boolean diasCorrectos = false;
		
		//A) MUNICIPIO MÁS LLUVIOSO PARA CADA DÍA
		System.out.println("\n"+"=== MUNICIPIO CON MÁS LLUVIA SEGÚN EL DÍA ==="+"\n");
		for(int dia=0; dia<16; dia++)
		{
			System.out.println("El municipio más lluvioso para el día " + (dia+16) + " es " + nombreMunicipios[municipioMasLluvioso(temperaturas, dia)] + ".");
		}
		
		//B) CALCULA LA MEDIA PLUVIOMÉTRICA DE TODOS LOS MUNICIPIOS EN TODOS LOS DÍAS
		System.out.println("\n"+"=== MEDIA PLUVIOMETRÍA ==="+"\n"+
							"\nLa media de pluviometría de todos los municipios en todos los días es: " + mediaPluviometria(temperaturas));
		
		//C) SOLICITUD DE DATOS PARA CALCULAR ACUMULACIÓN DE LLUVIA
		System.out.println("\n"+"=== SOLICITUD DIA INICIO, FIN Y MUNICIPIO ===" + "\n");
		
		//Bucle do-while para validar que el diaInicio es menor que el díaFin
		do
		{
			diaInicio = validacionDia("Introduzca el día de inicio (del 16 al 31).", entradaTeclado);
			diaFin = validacionDia("Introduzca el día de fin (del 16 al 31).", entradaTeclado);
			if(diaInicio < diaFin)
			{
				diasCorrectos = true;
			}
			else
			{
				System.out.println("El día de inicio es menor que el día de fin, introduzca los días de nuevo.");
			}
		}while(diasCorrectos == false);
		entradaTeclado.nextLine(); //Depuración Scanner
		numeroMunicipio = municipioNumero("Introduzca el municipio.", entradaTeclado);
		//Resultado lluvia acumulada
		System.out.println("La lluvia acumulada del municipio " + nombreMunicipios[numeroMunicipio] + " es de: " + 
							lluviaAcumulada(temperaturas,diaInicio, diaFin, numeroMunicipio) + ".");
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
	
	//MÉTODO - Recoge un array para devolver la media total de todos sus valores
	public static double mediaPluviometria(int temperaturas[][])
	{
		double media = 0;
		long suma = 0;
		
		for(int municipio=0; municipio<temperaturas.length; municipio++)
		{
			for(int dia=0; dia<16; dia++)
			{
				suma += temperaturas[municipio][dia];
			}
		}
		
		media = suma/160;
		return media;
	}
	
	//MÉTODO - Recoge un mensaje String y un objeto Scanner para devolver el número de municipio si se introduce de forma correcta
	public static int municipioNumero(String mensaje, Scanner entradaTeclado)
	{
		int numeroMunicipio = 0;
		String municipioTeclado;
		boolean municipioCorrecto = false;
		do
		{
			System.out.println(mensaje);
			municipioTeclado = entradaTeclado.nextLine();
			municipioTeclado = municipioTeclado.toLowerCase();
			if(municipioTeclado.equals("mijas"))
			{
				numeroMunicipio = 0;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("jubrique"))
			{
				numeroMunicipio = 1;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("pujerra"))
			{
				numeroMunicipio = 2;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("ojen") || municipioTeclado.equals("ojén"))
			{
				numeroMunicipio = 3;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("malaga") || municipioTeclado.equals("málaga"))
			{
				numeroMunicipio = 4;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("ronda"))
			{
				numeroMunicipio = 5;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("coin") || municipioTeclado.equals("coín"))
			{
				numeroMunicipio = 6;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("torrox"))
			{
				numeroMunicipio = 7;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("ardales"))
			{
				numeroMunicipio = 8;
				municipioCorrecto = true;
			}
			else if(municipioTeclado.equals("marbella"))
			{
				numeroMunicipio = 9;
				municipioCorrecto = true;
			}
			else
			{
				System.out.println("El municipio introducido no es válido.");
			}
		}while(municipioCorrecto == false);
		
		return numeroMunicipio;
	}
	
	//MÉTODO - Recoge un Array, un dia de inicio, un dia de fin y un número de municipio para devolver la suma de lluvia acumulada
	public static double lluviaAcumulada(int temperaturas[][], int diaInicio, int diaFin, int municipioTeclado)
	{
		long lluviaAcumulada = 0;
		diaInicio = diaInicio - 16;
		diaFin = diaFin - 15;
		for(int dia=diaInicio; dia<diaFin; dia++)
		{
			lluviaAcumulada += temperaturas[municipioTeclado][dia];
		}
		return lluviaAcumulada;
	}
	
	//MÉTODO - Recoge un mensaje String y el objeto Scanner para devolver el día introducido si se introduce de forma correcta (entre 16 y 31)
	public static int validacionDia(String mensaje, Scanner entradaTeclado)
	{
		int diaIntroducido = 0;
		do
		{
			System.out.println(mensaje);
			diaIntroducido = entradaTeclado.nextInt();
			if(diaIntroducido < 16 || diaIntroducido > 31)
			{
				System.out.println("El día introducido no es válido."+
									"\nAsegúrese de que el día se encuentra entre 16 y 31.");
			}
		}while(diaIntroducido < 16 || diaIntroducido > 31);
		return diaIntroducido;
	}
}
