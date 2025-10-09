package ejemploIterator;

import java.util.Comparator;

public class ComparadorEspeciePlantaPorLongitud implements Comparator<String>
{
	@Override
	public int compare(String o1, String o2) 
	{
		int resultado;
		if(o1.length() > o2.length())
		{
			resultado = 1;
		}else if(o1.length() < o2.length())
		{
			resultado = -1;
		}else
		{
			resultado = 0;
		}
		return resultado;
	}
}
