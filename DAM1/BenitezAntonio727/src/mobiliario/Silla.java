package mobiliario;

/**
 * Clase que representa una <strong>Silla</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>posicion:</strong> Posición del respaldo de la silla</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public final class Silla extends Asiento implements Ajustable
{
	/**
	 * Número mínimo de posición permitido :
	 * {@value MIN_POSICION}.
	 */
	public static final int MIN_POSICION = 1;
	/**
	 * Número máximo de posición permitido :
	 * {@value MAX_POSICION}.
	 */
	public static final int MAX_POSICION = 4;
	
	private int posicion;
	
	/**
	 * Constructor maestro (4 parámetros)
	 *
	 * @param precio Precio del Mueble como valor decimal double
	 * @param desc Descripción del Mueble en formato String
	 * @param tapiceria Tapicería del Mueble de Asiento en formato String
	 * @param color Color del Mueble de Asiento en formato String
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 * El atributo numPlazas se inicializa el valor mínimo posible.
	 * El atributo de posición se inicializa al valor mínimo posible.
	 */
	public Silla(double precio, String desc, String tapiceria, String color)
	{
		super(precio, desc, Asiento.MIN_PLAZAS, tapiceria, color);
		this.posicion = MIN_POSICION;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada de la Silla
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción} 
	 * Tapicería: {Tapicería} Color: {Color} Número de plazas: {numPlazas} Posición: {Posicion}<br>
	 * @return Cadena que representa la información de la Silla.
	 */
	@Override
	public String toString()
	{
		return String.format("%s Posición: %d", super.toString(), this.posicion);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int obtenerPosicion() 
	{
		return this.posicion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int subirPosicion() throws IllegalStateException 
	{
		if(this.posicion++ > MAX_POSICION)
		{
			throw new IllegalStateException(String.format("Error: No se puede subir a la posición %d, "
					+ "ya que la posición máxima es %d", this.posicion++, MAX_POSICION));
		}
		this.posicion++;
		return this.posicion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int bajarPosicion() throws IllegalStateException 
	{
		if(this.posicion-- < MIN_POSICION)
		{
			throw new IllegalStateException(String.format("Error: No se puede bajar a la posición %d, "
					+ "ya que la posición mínima es %d", this.posicion--, MIN_POSICION));
		}
		this.posicion--;
		return this.posicion;
	}
}
