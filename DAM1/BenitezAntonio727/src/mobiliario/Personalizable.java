package mobiliario;

/**
 * Interfaz aplicable a objetos <strong>Personalizables</strong>.
 * @author Antonio Benítez Rodríguez
 */
public interface Personalizable 
{
	/**
	 * Devuelve una cadena String que representa los Módulos de un objeto Personalizable
	 * @return String cadena
	 */	
	public String obtenerModulos();
	/**
	 * Añade un Módulo al array de Módulos de un objeto Personalizable
	 * @param modulo Objeto enumerado Módulo que se va a añadir
	 * @throws IllegalStateException Si no se puede añadir más Módulos
	 * @throws NullPointerException Si el Módulo parámetro es nulo
	 */
	public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException;
	/**
	 * Extrae un Módulo del array de Módulos de un objeto Personalizable
	 * @return Modulo modulo
	 * @throws IllegalStateException Si no se pueden extraer más Módulos
	 */
	public Modulo extraerModulo() throws IllegalStateException;
}
