package common;

import java.util.Comparator;
/*
 * Clase Comparator que compara objetos Nota 
 * por su nota de matemáticas y por su nombre
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 27/03/2025
 */
public class ComparatorNotaNombre implements Comparator<Notas>
{
	@Override
	public int compare(Notas o1, Notas o2) 
	{
		int resultado = 0;
		if(o1.getMat() > o2.getMat())
		{
			resultado = -1;
		}else if(o1.getMat() < o2.getMat())
		{
			resultado = 1;
		}else if(o1.getMat() == o2.getMat())
		{
			resultado = o1.getNombre().compareTo(o2.getNombre());
		}
		return resultado;
	}
}
