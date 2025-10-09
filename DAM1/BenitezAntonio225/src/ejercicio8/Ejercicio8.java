/*
 * Objetivo: Mini cuestionario tipo test de 10 preguntas
 * sobre Sistemas Informáticos, cada pregunta suma un punto
 * y muestra al final la puntuación obtenida.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 25/10/2024
 */
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		int respuesta, sumaPuntos=0;
		
		System.out.println("=====================================" +
						"\n CUESTIONARIO SISTEMAS INFORMÁTICOS" +
						"\n=====================================");
		for(int i=0; i<10; i++)
		{
			switch(i)
			{
			case 0:
				System.out.println("Pregunta 1º: Un sistema informático está compuesto por:"+
								"\n 1) Hardware, Software, Freeware"+
								"\n 2) Hardware, Malware, Software"+
								"\n 3) Hardware, Software, Usuarios");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 3)
				{
					sumaPuntos++;
				}
				break;
			case 1:
				System.out.println("Pregunta 2º: El Software puede ser de dos tipos:"+
						"\n 1) Software de Aplicación y Software de Malware"+
						"\n 2) Software de Sistema y Software de Aplicación"+
						"\n 3) Software de Sistema y Software de Movil");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 2)
				{
					sumaPuntos++;
				}
				break;
			case 2:
				System.out.println("Pregunta 3º: Un byte está compuesta por: "+
						"\n 1) 2 bits"+
						"\n 2) 6 bits"+
						"\n 3) 8 bits");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 3)
				{
					sumaPuntos++;
				}
				break;
			case 3:
				System.out.println("Pregunta 4º: Un byte puede representar:"+
						"\n 1) 256 valores"+
						"\n 2) 265 valores"+
						"\n 3) 285 valores");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 1)
				{
					sumaPuntos++;
				}
				break;
			case 4:
				System.out.println("Pregunta 5º: La arquitectura Harvard:"+
						"\n 1) Usa una única memoria para datos e instrucciones"+
						"\n 2) Usa memorias separadas para datos e instrucciones"+
						"\n 3) Está conectada por un bus");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 2)
				{
					sumaPuntos++;
				}
				break;
			case 5:
				System.out.println("Pregunta 6º: La ALU es:"+
						"\n 1) Unidad de Control"+
						"\n 2) Unidad de Entrada/Salida"+
						"\n 3) Unidad Aritmético-Lógica");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 3)
				{
					sumaPuntos++;
				}
				break;
			case 6:
				System.out.println("Pregunta 7º: La CPU... :"+
						"\n 1) Ejecuta una serie de instrucciones en código relacional"+
						"\n 2) Ejecuta una serie de instrucciones en código máquina"+
						"\n 3) Ejecuta una serie de instrucciones en código software");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 2)
				{
					sumaPuntos++;
				}
				break;
			case 7:
				System.out.println("Pregunta 8º: Los tipos de ISAs son:"+
						"\n 1) CISC y RISC"+
						"\n 2) CISK y RISK"+
						"\n 3) ICSC y IRSC");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 1)
				{
					sumaPuntos++;
				}
				break;
			case 8:
				System.out.println("Pregunta 9º: Una máquina de 32 bits accede a un máximo de:"+
						"\n 1) 8 Gigabytes de RAM"+
						"\n 2) 6 Gigabytes de RAM"+
						"\n 3) 4 Gigabytes de RAM");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 3)
				{
					sumaPuntos++;
				}
				break;
			case 9:
				System.out.println("Pregunta 10º: Los tipos de Zócalos son:"+
						"\n 1) PGA, BGA, LGA"+
						"\n 2) PGA, KGA, BGA"+
						"\n 3) BGA, PGA, MGA");
				do
				{
					System.out.println("Introduzca su respuesta (del 1 al 3)");
					respuesta = entradaTeclado.nextInt();
					if(respuesta<1 || respuesta>3)
					{
						System.out.println("Respuesta no válida.");
					}
				}while(respuesta<1 || respuesta>3);
				if(respuesta == 1)
				{
					sumaPuntos++;
				}
				break;
			}
			System.out.println("------------------------------------");
		}
		System.out.println("¡Felicidades! Ha completado el cuestionario."+
						"\nSu nota final es: " + sumaPuntos + "/10.");
	}

}
