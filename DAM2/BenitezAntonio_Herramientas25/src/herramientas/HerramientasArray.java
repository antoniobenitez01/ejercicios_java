package herramientas;

public abstract class HerramientasArray 
{
	
	//SORT ARRAY (double) - Organiza un array de números decimales de mayor a menor
	public static void sortArray(double[] array)
	{
	    for(int i=0; i < array.length; i++)
	    {
	        for(int j = i + 1; j < array.length; j++)
	        {
	            if(array[i] < array[j])
	            {
	            	double temp = array[i];
	            	array[i] = array[j];
	            	array[j] = temp;
	            }
	        }
	    }
    }
	
	//SORT ARRAY (int) - Organiza un array de números enteros de mayor a menor
	public static void sortArray(int[] array)
	{
	    for(int i=0; i < array.length; i++)
	    {
	        for(int j = i + 1; j < array.length; j++)
	        {
	            if(array[i] < array[j])
	            {
	            	int temp = array[i];
	            	array[i] = array[j];
	            	array[j] = temp;
	            }
	        }
	    }
    }
	
	//SUM ARRAY (double) - Recoge un array de números decimales y devuelve la suma de todos los valores
	public static double sumArray(double[] numeros)
	{
		double suma = 0;
		for(int i=0;i<numeros.length;i++)
		{
			suma += numeros[i];
		}
		return suma;
	}
	
	//SUM ARRAY (int) - Recoge un array de números enteros y devuelve la suma de todos los valores
	public static double sumArray(int[] numeros)
	{
		double suma = 0;
		for(int i=0;i<numeros.length;i++)
		{
			suma += numeros[i];
		}
		return suma;
	}
	
	//AVG ARRAY (double) - Recoge un array de números decimales y devuelve la media de todos los valores
	public static double avgArray(double[] numeros)
	{
		double suma = 0, media = 0;
		for(int i=0;i<numeros.length;i++)
		{
			suma += numeros[i];
		}
		media = suma * numeros.length;
		return media;
	}
	
	//AVG ARRAY (int) - Recoge un array de números enteros y devuelve la media de todos los valores
	public static double avgArray(int[] numeros)
	{
		double suma = 0, media = 0;
		for(int i=0;i<numeros.length;i++)
		{
			suma += numeros[i];
		}
		media = suma * numeros.length;
		return media;
	}
	
	//NUM MAX (double) - Recoge un array de números decimales y devuelve el valor máximo
	public static double numMax(double[] numeros)
	{
		double mayor = numeros[0];
		for(int i=1; i<numeros.length; i++)
		{
			if(numeros[i] > mayor)
			{
				mayor = numeros[i];
			}
		}
		return mayor;
	}
	
	//NUM MAX (int) - Recoge un array de números enteros y devuelve el valor máximo
	public static int numMax(int[] numeros)
	{
		int mayor = numeros[0];
		for(int i=1; i<numeros.length; i++)
		{
			if(numeros[i] > mayor)
			{
				mayor = numeros[i];
			}
		}
		return mayor;
	}
	
	//NUM MIN (double) - Recoge un array de números decimales y devuelve el valor mínimo
	public static double numMin(double[] numeros)
	{
		double menor = numeros[0];
		for(int i=1; i<numeros.length; i++)
		{
			if(numeros[i] < menor)
			{
				menor = numeros[i];
			}
		}
		return menor;
	}

	//NUM MIN (int) - Recoge un array de números enteros y devuelve el valor mínimo
	public static int numMin(int[] numeros)
	{
		int menor = numeros[0];
		for(int i=1; i<numeros.length; i++)
		{
			if(numeros[i] < menor)
			{
				menor = numeros[i];
			}
		}
		return menor;
	}
	
	//NUM EVEN (double) - Recoge un array de números enteros y devuelve la cantidad de números pares
	public static int numerosPares(double[] numeros)
	{
		int numerosPares = 0;
		for(int i=0; i<numeros.length; i++)
		{
			if(numeros[i]%2==0)
			{
				numerosPares++;
			}
		}
		return numerosPares;
	}
	
	//NUM EVEN (int) - Recoge un array de números enteros y devuelve la cantidad de números pares
	public static int numerosPares(int[] numeros)
	{
		int numerosPares = 0;
		for(int i=0; i<numeros.length; i++)
		{
			if(numeros[i]%2==0)
			{
				numerosPares++;
			}
		}
		return numerosPares;
	}
	
	//IS IN ARRAY (double) - Recoge un array de decimal y un número decimal, devuelve true si el número introducido está dentro del array
	public static boolean inArray(double[] numeros, double numIntroducido)
	{
		boolean estaEnArray = false;
		for(int i=0; i<numeros.length; i++)
		{
			if(numeros[i] == numIntroducido)
			{
				estaEnArray = true;
			}
		}
		return estaEnArray;
	}
	
	//IS IN ARRAY (int) - Recoge un array de enteros y un número entero, devuelve true si el número introducido está dentro del array
	public static boolean inArray(int[] numeros, int numIntroducido)
	{
		boolean estaEnArray = false;
		for(int i=0; i<numeros.length; i++)
		{
			if(numeros[i] == numIntroducido)
			{
				estaEnArray = true;
			}
		}
		return estaEnArray;
	}
}
