package biblioteca;

import java.util.Comparator;
/*
 * Clase Comparator de objetos Libro
 * que compara los objetos por su identificador
 * de forma descendente
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 01/04/2025
 */
public class Comparator_LibroID implements Comparator<Libro>
{
	//COMPARE - Compara dos objetos Libro por su identificador de forma descendiente
	@Override
	public int compare(Libro o1, Libro o2) 
	{
		return (o1.getID().compareTo(o2.getID())) * -1;
	}
}
