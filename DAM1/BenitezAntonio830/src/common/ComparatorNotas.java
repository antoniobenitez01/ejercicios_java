package common;

import java.util.Comparator;
/*
 * Clase Comparator que compara objetos Nota 
 * por su grupo y por su nombre
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 27/03/2025
 */
public class ComparatorNotas implements Comparator<Notas>
{
	@Override
	public int compare(Notas o1, Notas o2) 
	{
		int resultado = 0;
		if(o1.getGrupo().equals(o2.getGrupo()))
		{
			resultado = o1.getNombre().compareTo(o2.getNombre());
		}else
		{
			resultado = o1.getGrupo().compareTo(o2.getGrupo());
		}
		return resultado;
	}
}
