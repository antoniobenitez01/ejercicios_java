package common;

import java.util.Comparator;
/*
 * Clase Comparator que compara objetos Nota 
 * por su nombre de forma descendente
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/03/2025
 */
public class ComparatorNotasDescendente implements Comparator<Notas>
{
	@Override
	public int compare(Notas o1, Notas o2) 
	{
		return (o1.getNombre().compareTo(o2.getNombre())) * -1;
	}
}
