/*Pedir la edad para luego mostrarla en decimal
 * y pedir el peso para luego mostrarlo en entero
 */

package ejemploEdad;

import java.util.Scanner;

public class EjemploEdad 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner (System.in);
		
		int edad, pesoEntero;
		double peso, edadDecimal;
		
		System.out.println("Dime tu edad");
		edad = entradaTeclado.nextInt();
		
		System.out.println("Dime tu peso");
		peso = entradaTeclado.nextDouble();
		
		edadDecimal = edad;
		
		System.out.println("Tu edad es ");		
	
	}

}
