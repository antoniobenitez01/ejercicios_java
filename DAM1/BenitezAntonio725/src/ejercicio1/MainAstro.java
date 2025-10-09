/*
 * Programa principal que hace uso de las clases creadas
 * Astro, Planeta y Satelite para hacer uso de sus
 * métodos y constructores
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 18/02/2025
 */
package ejercicio1;

import java.util.Scanner;

public class MainAstro 
{
	public static void main(String[] args) 
	{
		// VARIBLES ==================================================================================
		
		Scanner entradaTeclado = new Scanner(System.in);;
		Astro[] sistemaSolar = new Astro[10];
		
		// INSERTAR ASTROS ==========================================================================
		
		sistemaSolar[0] = new Planeta("Tierra", 500, 150, 24, 1000, 365, true);
		sistemaSolar[1] = new Planeta("Pluto", 50, 10, 5, 10000, 1500, false);
		sistemaSolar[2] = new Planeta("Marte", 400, 125, 12, 750, 250, false);
		sistemaSolar[3] = new Planeta("Saturno", 1000, 700, 60, 2500, 600, true);
		sistemaSolar[4] = new Planeta("Júpiter", 2000, 1250, 100, 5000, 1000, true);
		sistemaSolar[5] = new Satelite("Luna de Tierra", 25, 5, 5, 250, 1, "Tierra");
		sistemaSolar[6] = new Satelite("Luna de Saturno", 35, 10, 5, 250, 1, "Saturno");
		sistemaSolar[7] = new Satelite("Luna de Júpiter", 50, 25, 10, 500, 5, "Júpiter");
		sistemaSolar[8] = new Satelite("Asteroide", 1, 5, 2, 10, 1, "Ninguno");
		sistemaSolar[9] = new Satelite("Segunda Luna de Júpiter", 25, 15, 5, 100, 1, "Júpiter");
		
		//			No comprobamos excepciones porque están insertados de forma correcta y controlada
		
		// PROGRAMA ==================================================================================
		
		System.out.println("\n === SISTEMA SOLAR ===\n");
		
		// -- Mostramos el array Sistema Solar
		
		int lastPos = 0; //Última posición no nula del array
		for(int i=0; i<sistemaSolar.length && sistemaSolar[i] != null; i++)
		{
			System.out.printf("%d.	%s\n", i+1, sistemaSolar[i].getNombre());
			lastPos++;
		}
		
		// -- Menú principal
		int opcion;
		do
		{
			System.out.println("\nIntroduzca el astro que desea mostrar por pantalla"
					+ "\nIntroduzca 0 si desea apagar el programa.");
			opcion = entradaTeclado.nextInt();
			int opcionReal = opcion - 1;
			if(opcion < 0 || opcion > lastPos)
			{
				System.out.println("La opción introducida no es válida, por favor inténtelo de nuevo.");
			}
			else if(opcion == 0)
			{
				System.out.println("Apagando programa...");
			}
			else
			{
				if(sistemaSolar[opcionReal] instanceof Planeta)
				{
					System.out.printf("\n%s\n", sistemaSolar[opcionReal].toString());
					Planeta planeta = (Planeta) sistemaSolar[opcionReal];
					if(planeta.tieneSatelites())
					{
						Satelite[] satelites = comprobarSatelites(planeta, sistemaSolar);
						String string = arraySatelitesToString(satelites);
						if(!string.isEmpty())
						{
							System.out.println("\n -- SATÉLITES --\n");
							System.out.printf("%s", string);
						}
					}
				}
				else
				{
					System.out.printf("\n%s\n", sistemaSolar[opcionReal].toString());
				}
			}
		}while(opcion != 0);
		
		//FIN PROGRAMA
	}
	
// MÉTODOS =========================================================================================================

	/*COMPROBAR SATELITES - Recoge un objeto Planeta y un array de objetos Astro para comprobar los Satelites que
	pertenecen al objeto Planeta introducido*/
	private static Satelite[] comprobarSatelites(Planeta planeta, Astro[] sistemaSolar)
	{
		Satelite[] satelites = new Satelite[10];
		int lastPosSatelites = 0;
		for(int i=0; i<sistemaSolar.length && sistemaSolar[i] != null; i++)
		{
			if(sistemaSolar[i] instanceof Satelite)
			{
				Satelite satelite = (Satelite) sistemaSolar[i];
				if(satelite.getNombrePlaneta().equals(planeta.getNombre()))
				{
					satelites[lastPosSatelites] = satelite;
					lastPosSatelites++;
				}
			}
		}
		return satelites;
	}
	
	//ARRAY SATELITES TO STRING - Devuelve un String con todos los satélites de un array
	private static String arraySatelitesToString(Satelite[] satelites)
	{
		String string = "";
		for(int i = 0; i<satelites.length && satelites[i] != null; i++)
		{
			string += String.format("- %s\n",satelites[i].getNombre());
		}
		return string;
	}
}
