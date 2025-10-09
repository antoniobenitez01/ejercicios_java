package mobiliario;

/**
 * Clase que representa una <strong>Estantería</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>tipo:</strong> Tipo de estantería</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public final class Estanteria extends Almacenaje
{
	private String tipo;
	
	/**
	 * Constructor maestro (6 parámetros)
	 *
	 * @param precio Precio del Mueble como valor decimal double
	 * @param desc Descripción del Mueble en formato String
	 * @param anchura Anchura del Mueble de Almacenaje como valor decimal double
	 * @param altura Altura del Mueble de Almacenaje como valor decimal double
	 * @param numModulos Número máximo de objetos Módulo como valor entero int
	 * @param tipo Tipo de Estantería en formato String
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Estanteria(double precio, String desc, double anchura, double altura, int numModulos, String tipo)
	{
		super(precio, desc, anchura, altura, numModulos);
		this.tipo = tipo;
	}
	
	/**
	 * Devuelve el tipo de Estantería
	 * @return String tipo
	 */
	public String getTipo()
	{
		return this.tipo;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada de la Estantería
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción} 
	 * Anchura: {Anchura} Altura: {Altura} Número de módulos máximo: {numModulos}<br>
	 * Módulos: {Modulo}, {Modulo}, {Modulo} Tipo: {Tipo}
	 * @return Cadena que representa la información de la Estantería.
	 */
	@Override
	public String toString()
	{
		return String.format("%s Tipo: %s", super.toString(), this.tipo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException, IllegalArgumentException
	{
		if(modulo == null)
		{
			throw new NullPointerException("Error: el módulo a añadir no puede ser nulo");
		}
		if(modulo != Modulo.BALDA)
		{
			throw new IllegalArgumentException("Solo pueden añadirse módulos de tipo BALDA en objetos Estantería.");
		}
		super.anyadirModulo(modulo);
	}
}
