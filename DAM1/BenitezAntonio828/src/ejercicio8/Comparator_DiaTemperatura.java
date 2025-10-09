/*
 * Clase Comparator que compara dos objetos DiaTemperatura
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 24/03/2025
 */
package ejercicio8;

import java.util.Comparator;

public class Comparator_DiaTemperatura implements Comparator<DiaTemperatura>
{
	@Override
	public int compare(DiaTemperatura o1, DiaTemperatura o2) 
	{
		int resultado = 0;
		if(o1.getTempMedia() > o2.getTempMedia())
		{
			resultado = -1;
		}else if(o1.getTempMedia() < o2.getTempMedia())
		{
			resultado = 1;
		}else
		{
			resultado = 0;
		}
		return resultado;
	}
}
