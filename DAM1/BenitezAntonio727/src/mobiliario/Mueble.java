package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>id:</strong> ID del Mueble como valor entero int</li>
 * <li><strong>desc:</strong> Descripción del Mueble en formato String</li>
 * <li><strong>precio:</strong> Precio del Mueble como valor decimal double</li>
 * </ul>
 * <p>La clase también dispone de información general independiente de los objetos concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>ultimoNum:</strong> Último número para su uso en la creación de la ID del Mueble</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public abstract class Mueble implements Comparable<Mueble>
{
	/**
	 * Precio mínimo permitido :
	 * {@value MIN_PRECIO} €.
	 */
	public static final double MIN_PRECIO = 0.01;
	/**
	 * Precio máximo permitido :
	 * {@value MAX_PRECIO} €.
	 */
	public static final double MAX_PRECIO = 100000;
	
	private static int ultimoNum;
	
	private final int id;
	private final String desc;
	
	protected double precio;
	
	static
	{
		ultimoNum = 1;
	}
	
	/**
	 * Constructor maestro (2 parámetros)
	 *
	 * @param precio Precio del Mueble como valor decimal double
	 * @param desc Descripción del Mueble en formato String
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Mueble(double precio, String desc)
	{
		if(precio < MIN_PRECIO || precio > MAX_PRECIO)
		{
			throw new IllegalArgumentException(String.format("El precio no está en el rango permitido: %.2f", precio));
		}
		this.desc = desc;
		this.precio = precio;
		this.id = ultimoNum;
		
		ultimoNum++;
	}
	
	/**
	 * Devuelve la ID del Mueble como valor entero int
	 * @return int id
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Devuelve el Precio del Mueble como valor decimal double
	 * @return double precio
	 */
	public double getPrecio()
	{
		return this.precio;
	}
	
	/**
	 * Devuelve la Descripción del Mueble como cadena String
	 * @return String desc
	 */
	public String getDescripcion()
	{
		return this.desc;
	}
	
	@Override
	public int compareTo(Mueble m)
	{
		int result = 0;
		if(this.getPrecio() > m.getPrecio())
		{
			result = -1;
		}
		else if(this.getPrecio() < m.getPrecio())
		{
			result = 1;
		}
		else
		{
			result = 0;
		}
		return result;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada del Mueble
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción}<br>
	 * @return Cadena que representa la información del Mueble.
	 */
	public String toString()
	{
		return String.format("Tipo: %s ID: %3d Precio: %.2f Descripción: %s", this.getClass().getSimpleName(), this.id, this.precio, this.desc);
	}
}
