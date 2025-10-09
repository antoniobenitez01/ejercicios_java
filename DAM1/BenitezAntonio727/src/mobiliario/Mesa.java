package mobiliario;

/**
 * Clase que representa una <strong>Mesa</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>forma:</strong> Forma de la Mesa en formato String</li>
 * <li><strong>comensales:</strong> Número de comensales de la Mesa como valor entero int</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public final class Mesa extends Mueble
{
	/**
	 * Número mínimo de comensales permitido :
	 * {@value MIN_COMENSALES} comensales.
	 */
	public static final int MIN_COMENSALES = 4;
	/**
	 * Numero máximo de comensales permitido :
	 * {@value MAX_COMENSALES} comensales.
	 */
	public static final int MAX_COMENSALES = 16;
	
	private String forma;
	private int comensales;
	
	/**
	 * Constructor maestro (4 parámetros)
	 *
	 * @param precio Precio del Mueble como valor decimal double
	 * @param desc Descripción del Mueble en formato String
	 * @param forma Forma de la Mesa en formato String
	 * @param comensales Número de comensales de la Mesa como valor entero int
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Mesa(double precio, String desc, String forma, int comensales)
	{
		super(precio, desc);
		
		if(comensales < MIN_COMENSALES || comensales > MAX_COMENSALES)
		{
			throw new IllegalArgumentException(String.format("El número de comensales no está en el rango permitido: %d", comensales));
		}
		this.forma = forma;
		this.comensales = comensales;
	}
	
	/**
	 * Devuelve la forma de la Mesa en formato String
	 * @return String forma
	 */
	public String getForma()
	{
		return this.forma;
	}
	
	/**
	 * Devuelve el número de comensales de la Mesa como valor entero int
	 * @return int comensales
	 */
	public int getComensales()
	{
		return this.comensales;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada de la Mesa
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción} Forma: {Forma} Número de comensales: {Comensales}<br>
	 * @return Cadena que representa la información de la Mesa.
	 */
	@Override
	public String toString()
	{
		return String.format("%s Forma: %s Número de comensales: %d", super.toString(), this.forma, this.comensales);
	}
}
