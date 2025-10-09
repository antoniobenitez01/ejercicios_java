package mobiliario;

/**
 * Clase que representa un <strong>Sillón</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>posicion:</strong> Posición de los pies del Sillón</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public final class Sillon extends Asiento implements Ajustable
{
	/**
	 * Número mínimo de posición permitido que representa el respaldo bajado :
	 * {@value POS_BAJADO}.
	 */
	public static final int POS_BAJADO = 0;
	/**
	 * Número máximo de posición permitido que representa el respaldo subido :
	 * {@value POS_SUBIDO}.
	 */
	public static final int POS_SUBIDO = 1;
	
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
	public Sillon(double precio, String desc, String tapiceria, String color)
	{
		super(precio, desc, Asiento.MIN_PLAZAS, tapiceria, color);
		this.posicion = POS_BAJADO;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada del Sillón
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción} 
	 * Tapicería: {Tapicería} Color: {Color} Número de plazas: {numPlazas} Posición: {Posicion}<br>
	 * @return Cadena que representa la información del Sillón.
	 */
	@Override 
	public String toString()
	{
		return String.format("%s PPP: %s", super.toString(), this.posicion == 1 ? "Subida" : "Bajada");
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
		if(this.posicion != 0)
		{
			throw new IllegalStateException("Error: no se pueden subir los pies del sillón. Ya están subidos");
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
		if(this.posicion != 1)
		{
			throw new IllegalStateException("Error: no se pueden bajar los pies del sillón. Ya están bajados");
		}
		this.posicion--;
		return this.posicion;
	}
}
