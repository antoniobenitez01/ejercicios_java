/*
 * DNI y Telefono
 */
package expresiones_regulares;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		String dni, telefono;
		Byte check1, check2;
		Pattern patronDni = Pattern.compile("[0-9]{8}[A-Za-z]");
		Pattern patronTelefono = Pattern.compile("[679][0-9]{8}");
		
		do
		{
			System.out.println("Introduzca su DNI (00000000A).");
			dni = entradaTeclado.nextLine();
			Matcher dniMatch = patronDni.matcher(dni);
			if (dniMatch.matches())
			{
			    check1 = 1;
			}
			else
			{
			    System.out.println("El DNI introducido no encaja con el formato estándar, inténtelo de nuevo.");
			    check1 = 0;
			}
		}while(check1 == 0);
		
		do
		{
			System.out.println("Introduzca su teléfono ([6, 7 o 9]00000000).");
			telefono = entradaTeclado.nextLine();
			Matcher telMatch = patronTelefono.matcher(telefono);
			if (telMatch.matches())
			{
			    check2 = 1;
			}
			else
			{
			    System.out.println("El teléfono introducido no encaja con el formato estándar, inténtelo de nuevo.");
			    check2 = 0;
			}
		}while(check2 == 0);
	}
}
