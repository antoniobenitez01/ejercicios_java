package metodos;

import java.util.Scanner;

public class ActividadFunciones 
{

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		double a, b, resultado;
		String entrada;
		char operador;
		
		//Entrada de datos
		System.out.println("Introduzca un operando (a)");
		a = entradaTeclado.nextDouble();
		System.out.println("Introduzca otro operando (b)");
		b = entradaTeclado.nextDouble();
		entradaTeclado.nextLine();
		System.out.println("Introduzca un operador (+ - * / %)");
		entrada = entradaTeclado.nextLine();
		
		//Cálculo carácter operación
		operador = entrada.charAt(0);
		
		//Resultado
		resultado = operacion(a, b, operador);
		System.out.println("El resultado es " + resultado + ".");
	}
	
	//Método que recoje los operandos y el operador para calcular el resultado
	public static double operacion(double a, double b, char operador)
	{
		double resultado = 0;
		switch(operador)
		{
		case '+':
			resultado = a + b;
			break;
		case '-':
			resultado = a - b;
			break;
		case '*':
			resultado = a * b;
			break;
		case '/':
			if(b == 0)
			{
				System.out.println("La divisón entre 0 no es posible.");
			}
			else
			{
				resultado = a / b;
			}
			break;
		case '%':
			resultado = a % b;
			break;
		default:
			System.out.println("El operador introducido no es válido.");
			break;
		}
		return resultado;
	}
}
