/*
 * Objetivo: Programa de control automático de café,
 * informando al usuario de las bebidas de las que dispone así
 * como su precio a través de un menú de opciones; solicitando
 * el número del menú al usuario.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 08/11/2024
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 
{
	public enum Cafes {SOLO, CON_LECHE, NUBE, MANCHADO, IRLANDES};
	
	public static void main(String[] args) 
	{
		Cafes cafeSolo = Cafes.SOLO;
		Cafes cafeConLeche = Cafes.CON_LECHE;
		Cafes cafeNube = Cafes.NUBE;
		Cafes cafeManchado = Cafes.MANCHADO;
		Cafes cafeIrlandes = Cafes.IRLANDES;
		
		Scanner entradaTeclado = new Scanner(System.in);
		int eleccion, numeroIntentos = 3;
		double cantidadPagar = 0, cantidadIntroducida, total = 0;
		
		do
		{
			do
			{
				System.out.println("------------------------------"
						+ "\nBienvenido a la Máquina de Café." +
						"\nSeleccione una bebida: " +
						"\n1. " + cafeSolo + " - 1.50€" +
						"\n2. " + cafeConLeche + " - 1.60€" +
						"\n3. " + cafeNube + " - 1.75€" +
						"\n4. " + cafeManchado + " - 1.70€" +
						"\n5. " + cafeIrlandes + " - 2.50€" +
						"\n0. Salir" +
						"\nSeleccione una opción:");
				eleccion = entradaTeclado.nextInt();
				
				if(eleccion < 0 || eleccion > 5)
				{
					System.out.println("El número introducido no es válido, inténtelo de nuevo.");
				}
			}while(eleccion < 0 || eleccion > 5);
			
			if(eleccion == 0)
			{
				System.out.println("Gracias por usar la Máquina automática. ¡Hasta luego!");
			}
			else
			{
				switch(eleccion)
				{
				case 1:
					System.out.println("Ha seleccionado " + cafeSolo + ". El precio es 1.50€");
					cantidadPagar = 1.50;
					break;
				case 2:
					System.out.println("Ha seleccionado " + cafeConLeche + ". El precio es 1.60€");
					cantidadPagar = 1.60;
					break;
				case 3:
					System.out.println("Ha seleccionado " + cafeNube + ". El precio es 1.75€");
					cantidadPagar = 1.75;
					break;
				case 4:
					System.out.println("Ha seleccionado " + cafeManchado + ". El precio es 1.70€");
					cantidadPagar = 1.70;
					break;
				case 5:
					System.out.println("Ha seleccionado " + cafeIrlandes + ". El precio es 2.50€");
					cantidadPagar = 2.50;
					break;
				}
				
				for(int i=0; i<3;i++)
				{
					System.out.println("Ingrese la cantidad en euros:");
					cantidadIntroducida = entradaTeclado.nextDouble();
					if(cantidadIntroducida < cantidadPagar)
					{
						numeroIntentos--;
						System.out.println("Dinero insuficiente. Su dinero será devuelto.");
						if(numeroIntentos == 1)
						{
							System.out.println("Tiene " + numeroIntentos + " intento.");
						}
						else if(numeroIntentos == 0)
						{
							System.out.println("No tiene más intentos, reiniciando programa.");
						}
						else
						{
							System.out.println("Tiene " + numeroIntentos + " intentos");
						}
					}
					else
					{
						i = 3;
						total = cantidadIntroducida - cantidadPagar;
						if(total == 0)
						{
							System.out.println("Compra exitosa. Ha introducido la cantidad exacta.");
						}
						else
						{
							System.out.println("Compra exitosa. Su cambio es: " + total + "€.");
						}
						switch(eleccion)
						{
						case 1:
							System.out.println("Disfrute de su café " + cafeSolo + ".");
							break;
						case 2:
							System.out.println("Disfrute de su café " + cafeConLeche + ".");
							break;
						case 3:
							System.out.println("Disfrute de su café " + cafeNube + ".");
							break;
						case 4:
							System.out.println("Disfrute de su café " + cafeManchado + ".");
							break;
						case 5:
							System.out.println("Disfrute de su café " + cafeIrlandes + ".");
							break;
						}
					}
				}
			}
		}while(eleccion != 0);
	}
}
