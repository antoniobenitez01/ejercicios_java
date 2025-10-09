/*
 * longitud, mayusculas, minusculas
 * posiciones pares en mayusculas
 * posiciones impares en minusculas
 */
package string;

import java.util.Scanner;

public class StringEjemplo 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String mensaje;
		
		System.out.println("Introduzca un mensaje String.");
		mensaje = entradaTeclado.nextLine();
		
		System.out.println("La longitud del mensaje es " + mensaje.length()+
						"\nEl mensaje con letras mayúsculas sería: " + mensaje.toUpperCase()+
						"\nEl mensaje con letras minúsculas sería: " + mensaje.toLowerCase());
		for(int i=0; i<mensaje.length(); i++)
		{
			if(i%2 == 0)
			{
				System.out.print(Character.toUpperCase(mensaje.charAt(i)));
			}
			else
			{
				System.out.print(Character.toLowerCase(mensaje.charAt(i)));
			}
		}
	}
}
