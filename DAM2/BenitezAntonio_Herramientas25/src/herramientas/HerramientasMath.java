package herramientas;

public abstract class HerramientasMath 
{
	//DIVISION (int) - Devuelve la división de dos valores enteros, comprobando que la operación es válida
	public static double division(int a, int b)
	{
		double resultado = 0;
		//EXCEPCIÓN - ArithmeticException - Nos aseguramos de que la división es posible
		try
		{
			resultado = (a/b);
		}
		catch(ArithmeticException excepcion2)
		{
			System.out.println("La operación es inválida.");
		}
		return resultado;
	}
	
	//DIVISION (double) - Devuelve la división de dos valores decimales, comprobando que la operación es válida
	public static double division(double a, double b)
	{
		double resultado = 0;
		//EXCEPCIÓN - ArithmeticException - Nos aseguramos de que la división es posible
		try
		{
			resultado = (a/b);
		}
		catch(ArithmeticException excepcion2)
		{
			System.out.println("La operación es inválida.");
		}
		return resultado;
	}
	
	
	//NUM LESS - Devuelve el menor número decimal entre dos números decimales
	public static double numLess(double num1, double num2)
	{
		double numMenor = num1;
		if(numMenor > num2)
		{
			numMenor = num2;
		}
		return numMenor;
	}
	
	//NUM MORE - Devuelve el mayor número decimal entre dos números decimales
	public static double numMore(double num1, double num2)
	{
		double numMayor = num1;
		if(numMayor < num2)
		{
			numMayor = num2;
		}
		return numMayor;
	}
	
	//RECTANGLE AREA - Recoge dos valores reales de ancho y alto para calcular el área del rectángulo
	public static double rectangleArea(double ancho, double alto)
	{
		double resultado;
		resultado = ancho * alto;
		return resultado;
	}
	
	//RECTANGLE PERIMETER - Recoge dos valores reales de ancho y alto para calcular el perímetro del rectángulo
	public static double rectanglePerimeter(double ancho, double alto)
	{
		double resultado;
		resultado = (2*ancho) + (2*alto);
		return resultado;
	}
	
	//CIRCLE CIRCUMFERENCE - Recoge el radio del círculo y devuelve la circumferencia
	public static double circleCircumference(double r)
	{
		double resultado;
		resultado = (2 * Math.PI) * r;
		return resultado;
	}
	
	//CIRCLE AREA - Recoge el radio del círculo y devuelve el área
	public static double circleArea(double r)
	{
		double resultado;
		resultado = Math.PI * (Math.pow(r, 2));
		return resultado;
	}
	
	//CIRCLE VOLUME - Recoge el radio del círculo y devuelve el volumen
	public static double circleVolume(double r)
	{
		double resultado;
		resultado = (Math.pow(r, 3) * 4/3) * Math.PI;
		return resultado;
	}
	
	//MULTIPLICATION TABLE - Muestra por consola la tabla de mulitplicación del número decimal introducido por parámetro
	public static void multiplicationTable(double num)
	{
		for(int i=1; i <= 10; i++)
		{
			System.out.println(num + " x " + i + " = " + (num*i));
		}
	}
	
	//IS PRIME - Devuelve true si el número entero introducido es primo
	public static boolean isPrime(int num)
	{
		boolean esPrimo = true;
		int contador=2;
		
		if(num == 0 || num == 1)
		{
			esPrimo = false;
		}
		else
		{
			do
			{
				if(num%contador==0)
				{
					esPrimo = false;
				}
				contador++;
			}while(contador < num && esPrimo == false);
		}
		return esPrimo;
	}
}
