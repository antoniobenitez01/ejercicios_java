package mobiliario;

/**
 * Clase que representa un Mueble de <strong>Almacenaje</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>numModulos:</strong> Número máximo para el array de objetos Módulo</li>
 * <li><strong>anchura:</strong> Anchura del Mueble de Almacenaje</li>
 * <li><strong>altura:</strong> Altura del Mueble de Almacenaje</li>
 * <li><strong>modulos:</strong> Array de objetos Modulo</li>
 * <li><strong>numModulosAnadidos:</strong> Número de objetos Módulo añadidos al array de objetos Módulo</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public abstract class Almacenaje extends Mueble implements Personalizable
{
	/**
	 * Número mínimo de objetos Módulo permitido :
	 * {@value MIN_MODULOS} módulos.
	 */
	public static final int MIN_MODULOS = 1;
	/**
	 * Número máximo de objetos Módulo permitido :
	 * {@value MAX_MODULOS} módulos.
	 */
	public static final int MAX_MODULOS = 20;
	
	private final int numModulos;
	
	private double anchura;
	private double altura;
	private Modulo[] modulos;
	protected int numModulosAnadidos;
	
	/**
	 * Constructor maestro (5 parámetros)
	 *
	 * @param precio Precio del Mueble como valor decimal double
	 * @param desc Descripción del Mueble en formato String
	 * @param anchura Anchura del Mueble de Almacenaje como valor decimal double
	 * @param altura Altura del Mueble de Almacenaje como valor decimal double
	 * @param numModulos Número máximo de objetos Módulo como valor entero int
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Almacenaje(double precio, String desc, double anchura, double altura, int numModulos)
	{
		super(precio, desc);
		
		if(numModulos < MIN_MODULOS || numModulos > MAX_MODULOS)
		{
			throw new IllegalArgumentException(String.format("ERROR: No se puede crear el mueble de Almacenaje."
					+ " El número de módulos no está en el rango permitido: %d", numModulos));
		}
		this.anchura = anchura;
		this.altura = altura;
		this.numModulos = numModulos;
		this.modulos = new Modulo[numModulos];
		this.numModulosAnadidos = MIN_MODULOS;
		
		this.modulos[0] = Modulo.BALDA;
	}
	
	/**
	 * Devuelve la anchura del Mueble de Almacenaje
	 * @return double anchura
	 */
	public double getAnchura()
	{
		return this.anchura;
	}
	
	/**
	 * Devuelve la altura del Mueble de Almacenaje
	 * @return double altura
	 */
	public double getAltura()
	{
		return this.altura;
	}
	
	/**
	 * Devuelve el número máximo de objetos Módulo
	 * @return int numModulos
	 */
	public int getNumModulos()
	{
		return this.numModulos;
	}
	
	/**
	 * Devuelve el número de objetos Módulo añadidos
	 * @return int numModulosAnadidos
	 */
	public int getModulosAnyadidos()
	{
		return this.numModulosAnadidos;
	}
	
	/**
	 * Devuelve una cadena String que representa la información detallada del Mueble de Almacenaje
	 * <p><strong>El formato de salida</strong> será del siguiente tipo: </p>
	 * <p>Tipo: {Tipo} Precio: {Precio} Descripción: {Descripción} 
	 * Anchura: {Anchura} Altura: {Altura} Número de módulos máximo: {numModulos}<br>
	 * Módulos: {Modulo}, {Modulo}, {Modulo}
	 * @return Cadena que representa la información del Mueble de Almacenaje.
	 */
	@Override
	public String toString()
	{
		return String.format("%s Anchura: %.2f Altura: %.2f Número modulos máximo: %d Módulos: %s", 
				super.toString(), this.anchura, this.altura, this.numModulos, this.modulosToString());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerModulos()
	{
		return this.modulosToString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException
	{
		if(modulo == null)
		{
			throw new NullPointerException("Error: el módulo a añadir no puede ser nulo");
		}
		if(this.numModulosAnadidos >= this.numModulos)
		{
			throw new IllegalStateException(String.format("Error: no se puede añadir el módulo %s."
					+ "El número de módulos no puede superar el máximo permitido: %d", modulo.toString(), this.numModulos));
		}
		this.modulos[this.numModulosAnadidos] = modulo;
		this.numModulosAnadidos++;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Modulo extraerModulo() throws IllegalStateException
	{
		if(this.numModulosAnadidos <= MIN_MODULOS)
		{
			throw new IllegalStateException(String.format("Error: no se puede quitar el módulo."
					+ "El número de módulos no puede ser inferior a %d", MIN_MODULOS));
		}
		
		Modulo moduloExtraido = this.modulos[this.numModulosAnadidos - 1];
		this.modulos[this.numModulosAnadidos - 1] = null;
		this.numModulosAnadidos--;
		return moduloExtraido;
	}
	
	private String modulosToString()
	{
		String string = "";
		for(int i=0; i<this.numModulosAnadidos; i++)
		{
			string += this.modulos[i].toString();
			if(i+1 < this.numModulosAnadidos)
			{
				string += ", ";
			}
		}
		return string;
	}
}
