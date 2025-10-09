package condicional;

import java.util.Scanner;

public class DiasSemana 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		int num1;
		
		System.out.println("Dígame un número de la semana");
		num1 = entradaTeclado.nextInt();
		
		switch (num1)
		{
		case 1:
			System.out.println("Es Lunes");
			break;
		case 2:
			System.out.println("Es Martes");
			break;
		case 3:
			System.out.println("Es Miércoles");
			break;
		case 4: 
			System.out.println("Es Jueves");
			break;
		case 5:
			System.out.println("Es Viernes");
			break;
		case 6:
			System.out.println("Es Sábado");
			break;
		case 7:
			System.out.println("Es Domingo");
			break;
		default:
			System.out.println("El número que has introducido no es un día de la semana.");
		}

	}

}
