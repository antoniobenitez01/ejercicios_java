/*
 * Clase Comparator que comparar dos objetos Trabajador
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025
 */
package ejercicio3;

import java.util.Comparator;

public class ComparatorTrabajador implements Comparator<Trabajador>
{
	//COMPARE - Devuelve el resultado de comparar dos objetos Trabajador en base a su sexo y estado civil
	@Override
	public int compare(Trabajador t1, Trabajador t2) 
	{
		int resultado = 0;
		if(t1.esHombre() && !t2.esHombre())
		{
			resultado = -1;
		}else if(!t1.esHombre() && t2.esHombre())
		{
			resultado = 1;
		}else if(t1.esHombre() && t2.esHombre() || !t1.esHombre() && !t2.esHombre())
		{
			if(t1.getEstadoCivil().ordinal() > t2.getEstadoCivil().ordinal())
			{
				resultado = 1;
			}else if(t1.getEstadoCivil().ordinal() < t2.getEstadoCivil().ordinal())
			{
				resultado = -1;
			}
		}
		return resultado;
	}
}
