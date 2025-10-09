package mobiliario;

/**
 * Clase que representa un <strong>Armario</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>puertas:</strong> Número de puertas del Armario</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public final class Armario extends Almacenaje
{
	/**
	 * Número mínimo de puertas permitido :
	 * {@value MIN_PUERTAS} puerta.
	 */
	public static final int MIN_PUERTAS = 1;
	/**
	 * Número máximo de puertas permitido :
	 * {@value MAX_PUERTAS} puertas.
	 */
	public static final int MAX_PUERTAS = 6;
	
	private int puertas;
	
	/**
	 * Constructor maestro (6 parámetros)
	 *
	 * @param precio Precio del Mueble como valor decimal double
	 * @param desc Descripción del Mueble en formato String
	 * @param anchura Anchura del Mueble de Almacenaje como valor decimal double
	 * @param altura Altura del Mueble de Almacenaje como valor decimal double
	 * @param numModulos Número máximo de objetos Módulo como valor entero int
	 * @param puertas Número de puertas del Armario como valor entero int
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Armario(double precio, String desc, double anchura, double altura, int numModulos, int puertas)
	{
		super(precio, desc, anchura, altura, numModulos);
		
		if(puertas < MIN_PUERTAS || puertas > MAX_PUERTAS)
		{
			throw new IllegalArgumentException(String.format("No se puede crear el Armario."
					+ " El número de puertas no está en el rango permitido: %d", puertas));
		}
		this.puertas = puertas;
	}
	
	/**
	 * Devuelve el número de puertas del Armario
	 * @return int puertas
	 */
	public int getNumPuertas()
	{
		return this.puertas;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada del Armario
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción} 
	 * Anchura: {Anchura} Altura: {Altura} Número de módulos máximo: {numModulos}<br>
	 * Módulos: {Modulo}, {Modulo}, {Modulo} Puertas: {Puertas}
	 * @return Cadena que representa la información del Armario.
	 */
	@Override
	public String toString()
	{
		return String.format("%s Número de puertas: %d", super.toString(), this.puertas);
	}
}
