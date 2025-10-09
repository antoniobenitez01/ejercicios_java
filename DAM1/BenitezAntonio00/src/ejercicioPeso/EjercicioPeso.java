package ejercicioPeso;

import java.util.Scanner;

public class EjercicioPeso 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double peso, alturacm, alturam, imc;
		
		do
		{
			System.out.println("Introduzca su peso (en kg). Si alguno de los valores es 0 se apagará el programa.");
			peso = entradaTeclado.nextDouble();
			System.out.println("Introduzca su altura (en cm). Si alguno de los valores es 0 se apagará el programa.");
			alturacm = entradaTeclado.nextDouble();
			
			if(peso != 0 && alturacm != 0)
			{
				alturam = alturacm / 100;
				imc = peso / Math.pow(alturam, 2);
				System.out.println("CÁLCULO DEL ÍNDICE DE MASA CORPORAL (IMC)" +
						"\n---------------------------------------------" + 
						"\nIntroduce el peso (en kg): " + peso +
						"\nIntroduce la altura (en cm): " + alturacm +
						"\nPara un peso de " + peso + " kilogramos y una altura de " + alturam + " metros:" +
						"\nEl índice de masa corporal es de: " + imc);
				if(imc<16)
				{
					System.out.println("Debe ser ingresado en un hospital inmediatamente.");
				}
				else if(imc<=17)
				{
					System.out.println("Usted tiene infrapeso.");
				}
				else if(imc<=18)
				{
					System.out.println("Usted tiene bajo peso.");
				}
				else if(imc<=25)
				{
					System.out.println("Usted tiene un peso normal (saludable).");
				}
				else if(imc<=30)
				{
					System.out.println("Usted tiene sobrepeso (obesidad de grado I).");
				}
				else if(imc<=35)
				{
					System.out.println("Usted tiene sobrepreso crónico (obesidad de grado II).");
				}
				else if(imc<=40)
				{
					System.out.println("Usted tiene obesidad pre-mórbida (obesidad de grado III)");
				}
				else
				{
					System.out.println("Usted tiene obesidad mórbida (obesidad de grado IV).");	
				}
			}	
		}while((peso != 0) && (alturacm != 0));
		
		System.out.println("Apagando programa.");

	}

}
