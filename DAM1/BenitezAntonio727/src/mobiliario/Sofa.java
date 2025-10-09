package mobiliario;

/**
 * Clase que representa un <strong>Sofá</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>compisición:</strong> Composición del Sofá</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public class Sofa extends Asiento
{
	private String composicion;
	
	/**
	 * Constructor maestro (6 parámetros)
	 *
	 * @param precio Precio del Mueble como valor decimal double
	 * @param desc Descripción del Mueble en formato String
	 * @param numPlazas Número de Plazas del Mueble de Asiento como valor entero int
	 * @param tapiceria Tapicería del Mueble de Asiento en formato String
	 * @param color Color del Mueble de Asiento en formato String
	 * @param composicion Composición del Sofá en formato String
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Sofa(double precio, String desc, int numPlazas, String tapiceria, String color, String composicion)
	{
		super(precio, desc, numPlazas, tapiceria, color);
		this.composicion = composicion;
	}
	
	/**
	 * Devuelve la composición del Sofá
	 * @return String composicion
	 */
	public String getComposicion()
	{
		return this.composicion;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada del Sofa
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción} 
	 * Tapicería: {Tapicería} Color: {Color} Número de plazas: {numPlazas} Composición: {Composición}<br>
	 * @return Cadena que representa la información del Sofa.
	 */
	@Override
	public String toString()
	{
		return String.format("%s Composición: %s", super.toString(), this.composicion);
	}
}
