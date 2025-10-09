package mobiliario;

/**
 * Clase que representa un Mueble de <strong>Asiento</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>numPlazas:</strong> Número de plazas del Mueble de Asiento</li>
 * <li><strong>tapiceria:</strong> Tapicería del Mueble de Asiento</li>
 * <li><strong>color:</strong> Color del Mueble de Asiento</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public abstract class Asiento extends Mueble
{
	/**
	 * Número mínimo de plazas permitido :
	 * {@value MIN_PLAZAS} plaza.
	 */
	public static final int MIN_PLAZAS = 1;
	/**
	 * Número máximo de plazas permitido :
	 * {@value MAX_PLAZAS} plazas.
	 */
	public static final int MAX_PLAZAS = 9;
	
	private final int numPlazas;
	private final String tapiceria;
	private final String color;
	
	/**
	 * Constructor maestro (5 parámetros)
	 *
	 * @param precio Precio del Mueble como valor decimal double
	 * @param desc Descripción del Mueble en formato String
	 * @param numPlazas Número de plazas del Mueble de Asiento como valor entero int
	 * @param tapiceria Tapicería del Mueble de Asiento en formato String
	 * @param color Color del Mueble de Asiento en formato String
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Asiento(double precio, String desc, int numPlazas, String tapiceria, String color)
	{
		super(precio, desc);
		
		if(numPlazas < MIN_PLAZAS || numPlazas > MAX_PLAZAS)
		{
			throw new IllegalArgumentException(String.format("El número de plazas no está en el rango permitido: %d", numPlazas));
		}
		this.numPlazas = numPlazas;
		this.tapiceria = tapiceria;
		this.color = color;
	}
	
	/**
	 * Devuelve el número de plazas del Mueble de Asiento como valor entero int
	 * @return int numPlazas
	 */
	public int getNumPlazas()
	{
		return this.numPlazas;
	}
	
	/**
	 * Devuelve la tapicería del Mueble de Asiento en formato String
	 * @return String tapiceria
	 */
	public String getTapiceria()
	{
		return this.tapiceria;
	}
	
	/**
	 * Devuelve el color del Mueble de Asiento en formato String
	 * @return String color
	 */
	public String getColor()
	{
		return this.color;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada del Mueble de Asiento
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción} 
	 * Tapicería: {Tapicería} Color: {Color} Número de plazas: {numPlazas}<br>
	 * @return Cadena que representa la información del Mueble de Asiento.
	 */
	@Override
	public String toString()
	{
		return String.format("%s Tapicería: %s Color: %s Número de plazas: %d", super.toString(), this.tapiceria, this.color, this.numPlazas);
	}
}
