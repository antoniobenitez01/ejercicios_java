/*
 * Clase que representa un CD, con
 * un array de objetos Cancion y un contador
 * que representa el primer espacio vacío en el CD.
 * Excepciones: ArrayIndexOutOfBoundsException, IllegalStateException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 24/01/2025
 */
package ejercicio2;

import ejercicio1.Cancion;

public class CD 
{
	
//ATRIBUTOS ================================
	
	public static final int NUMERO_CANCIONES_DEFAULT = 5; //Número por defecto de tamaño del CD
	
	private Cancion[] canciones; //Array de objetos Cancion
	private int contador; //Contador que representa el primer espacio vacío en el CD

//CONSTRUCTORES ================================
	
	//Constructor por omisión
	public CD()
	{
		this.canciones = new Cancion[NUMERO_CANCIONES_DEFAULT];
		this.contador = 0;
	}
	
//MÉTODOS ================================
	
	//Devuelve el número entero de canciones 
	public int numeroCanciones()
	{
		return this.contador;
	}
	
	//Devuelve el objeto Canción en la posición introducida por parámetro
	public Cancion dameCancion(int posicion) throws NullPointerException
	{
		int posicionReal = posicion - 1;
		excepcionNullPosicion(posicionReal);
		return canciones[posicionReal];
	}
	
	//Introduce un objeto Cancion en una posición entera, ambos introducidos por parámetro
	public void grabaCancion(int posicion, Cancion c) throws ArrayIndexOutOfBoundsException
	{
		int posicionReal = posicion - 1;
		excepcionArrayPosicion(posicionReal);
		this.canciones[posicionReal] = c;
		reorganizarCD(0);
		contador++;
	}
	
	//Agrega un objeto Cancion al primer espacio vacío en el CD
	public void agrega(Cancion c) throws IllegalStateException
	{
		if(contador == this.canciones.length)
		{
			throw new IllegalStateException ("CD está lleno.");
		}
		this.canciones[contador] = c;
		contador++;
	}
	
	//Elimina el contenido que se encuentra en la posición introducida por parámetro
	public void elimina(int posicion) throws NullPointerException
	{
		int posicionReal = posicion - 1;
		excepcionArrayPosicion(posicionReal);
		excepcionNullPosicion(posicionReal);
		this.canciones[posicionReal] = null;
		reorganizarCD(posicionReal);
		contador--;
	}
	
	/*Reorganiza el array de canciones, reemplazando espacios vacíos 
	 desde una posición inicial introducida por parámetro.*/
	private void reorganizarCD(int posicionReal)
	{
		for(int i=posicionReal;i<this.canciones.length;i++)
		{
			if(this.canciones[i] == null && i != (this.canciones.length - 1))
			{
				this.canciones[i] = this.canciones[i+1];
				this.canciones[i+1] = null;
			}
		}
	}
	
	//Recoge una posición entera y comprueba excepciones ArrayIndexOutOfBoundsException
	private void excepcionArrayPosicion(int posicionReal) throws ArrayIndexOutOfBoundsException
	{
		if(posicionReal < 0)
		{
			throw new ArrayIndexOutOfBoundsException("La posición no puede ser menor que 0.");
		}
		if(posicionReal >= this.canciones.length)
		{
			throw new ArrayIndexOutOfBoundsException("La posición no puede ser mayor que " + this.canciones.length);
		}
	}
	
	//Recoge una posición entera y comprueba excepciones NullPointerException
	private void excepcionNullPosicion(int posicionReal) throws NullPointerException
	{
		if(this.canciones[posicionReal] == null)
		{
			throw new NullPointerException ("No hay canción en la posición introducida.");
		}
	}
	
	//Copia los contenidos de otro objeto CD
	public void copiarCD(CD cd) throws NullPointerException
	{
		if(cd == null)
		{
			throw new NullPointerException ("El CD introducido es nulo.");
		}
		for(int i=0; i<this.canciones.length; i++)
		{
			this.canciones[i] = cd.canciones[i];
		}
		this.contador = cd.contador;
	}
	
	//Devuelve el objeto CD representado en formato String
	public String toString()
	{
		String toString = "";
		for(int i=0;i<this.canciones.length; i++)
		{
			if(this.canciones[i] == null)
			{
				toString += (i+1) + ".- (---)\n";
			}
			else
			{
				toString += (i+1) + ".- " + this.canciones[i].toString() + "\n";	
			}
		}
		return toString;
	}
}
