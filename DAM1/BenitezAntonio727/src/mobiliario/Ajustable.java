package mobiliario;

/**
 * Interfaz aplicable a objetos <strong>Ajustables</strong>.
 * @author Antonio Benítez Rodríguez
 */
public interface Ajustable 
{
	/**
	 * Devuelve la posición en la que se encuentra el objeto Ajustable
	 * @return int posicion
	 */	
	public int obtenerPosicion();
	/**
	 * Sube y devuelve la posición en la que se encuentra el objeto Ajustable por 1
	 * @return int posicion
	 * @throws IllegalStateException Cuando no se puede subir más la posición del objeto Ajustable
	 */	
	public int subirPosicion() throws IllegalStateException;
	/**
	 * Baja y devuelve la posición en la que se encuentra el objeto Ajustable por 1
	 * @return int posicion
	 * @throws IllegalStateException Cuando no se puede bajar más la posición del objeto Ajustable
	 */	
	public int bajarPosicion() throws IllegalStateException;
}
