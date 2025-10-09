package claseBombilla;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
/**
 * Clase que representa una <strong>Bombilla</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>encendida:</strong> Valor booleano donde true significa que la Bombilla está encendida</li>
 * <li><strong>numeroVecesEncendida:</strong> Número de veces que se ha encendido la Bombilla</li>
 * <li><strong>potencia:</strong> Potencia de la Bombilla en W</li>
 * <li><strong>tiempoEncendida:</strong> Tiempo que lleva encendida la Bombilla en horas</li>
 * <li><strong>ultimaVezEncendida:</strong> Hora LocalTime en la que la Bombilla fue encendida por última vez</li>
 * </ul>
 * <p>La clase también dispone de información general independiente de los objetos concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>POTENCIA_MAX:</strong> Potencia máxima posible para la Bombilla</li>
 * <li><strong>POTENCIA_MIN:</strong> Potencia mínima posible para la Bombilla</li>
 * <li><strong>POTENCIA_DEFAULT:</strong> Potencia por defecto de la Bombilla</li>
 * <li><strong>bombillasCreadas:</strong> Número de Bombillas creadas en total</li>
 * <li><strong>bombillasEncendidas:</strong> Número de Bombillas encendidas en el momento</li>
 * </ul>
 * @author Antonio Benítez Rodríguez
 */
public class Bombilla 
{
	//ATRIBUTOS ====================================================
	
	/**
	 * Potencia máxima posible para la Bombilla :
	 * {@value POTENCIA_MAX} W
	 */
	public static final double POTENCIA_MAX = 1000.00; //FINAL - Potencia máxima
	/**
	 * Potencia mínima posible para la Bombilla :
	 * {@value POTENCIA_MIN} W
	 */
	public static final double POTENCIA_MIN = 10.00; //FINAL - Potencia mínima
	/**
	 * Potencia por defecto de la Bombilla :
	 * {@value POTENCIA_DEFAULT} W
	 */
	public static final double POTENCIA_DEFAULT = 100.00; //FINAL - Potencia por defecto
	private static int bombillasCreadas; // Número de Bombillas creadas en total
	private static int bombillasEncedidas; // Número de Bombillas encendidas en el momento
	
	private boolean encendida; // Booleano que es true cuando la Bombilla está encendida
	private int numeroVecesEncendida; // Número de veces que la Bombilla ha sido encendida
	private double potencia; // Potencia de la Bombilla
	private double tiempoEncendida; // Tiempo que lleva encendida la Bombilla
	private LocalTime ultimaVezEncendida; // Objeto LocalTime de la última vez en la que se encendió la Bombilla
	
	//CONSTRUCTORES =================================================
	
	/**
	 * Constructor maestro (dos parámetros)
	 *
	 * @param encendida Valor booleano donde true significa que la Bombilla está encendida.
	 * @param potencia Valor decimal double que representa la potencia de la Bombilla en W.
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido.
	 */
	public Bombilla(boolean encendida, double potencia) throws IllegalArgumentException
	{
		//----- excepciones
		if(potencia > POTENCIA_MAX) //EXCEPCIÓN - IllegalArgumentException - La potencia no puede ser mayor que el máximo
		{
			throw new IllegalArgumentException ("Potencia mayor que la potencia máxima permitida (" + POTENCIA_MAX + "W).");
		}
		if(potencia < POTENCIA_MIN) //EXCEPCIÓN - IllegalArgumentException - La potencia no puede ser menor que el mínimo
		{
			throw new IllegalArgumentException ("Potencia menor que la potencia mínima permitida (" + POTENCIA_MIN + "W).");
		}
		
		//----- construcción objeto
		this.encendida = encendida;
		if(encendida)
		{
			this.numeroVecesEncendida = 1;
			Bombilla.bombillasEncedidas++;
			this.ultimaVezEncendida = LocalTime.now();
		}
		else
		{
			this.numeroVecesEncendida = 0;
		}
		this.potencia = potencia;
		this.tiempoEncendida = 0;
		
		//----- variables static
		Bombilla.bombillasCreadas++;
	}
	
	/**
	 * Constructor de un parámetro
	 *
	 * @param encendida Valor booleano donde true significa que la Bombilla está encendida.
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido.
	 */
	public Bombilla(boolean encendida)
	{
		this(encendida, POTENCIA_DEFAULT);
	}
	
	/**
	 * Constructor por omisión
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido.
	 */
	public Bombilla()
	{
		this(false, POTENCIA_DEFAULT);
	}
	
	// GETTERS Y SETTERS ================================================
	
	/**
	 * Devuelve el número entero de Bombillas creadas en total.
	 * @return int bombillasCreadas
	 */
	public static int getBombillasCreadas()
	{
		return Bombilla.bombillasCreadas;
	}
	
	/**
	 * Devuelve el número entero de Bombillas encendidas en el momento
	 * @return int bombillasEncendidas
	 */
	public static int getBombillasEncendidas()
	{
		return Bombilla.bombillasEncedidas;
	}
	
	/**
	 * Devuelve true si la Bombilla está encendida
	 * @return boolean encendida
	 */
	public boolean getEncendida()
	{
		return this.encendida;
	}
	
	/**
	 * Devuelve el número de veces que se ha encendido la Bombilla
	 * @return int numeroVecesEncendida
	 */
	public int getNumeroVecesEncendida()
	{
		return this.numeroVecesEncendida;
	}
	
	/**
	 * Devuelve la potencia en W de la Bombilla
	 * @return double potencia
	 */
	public double getPotencia()
	{
		return this.potencia;
	}
	
	/**
	 * Establece la potencia de la Bombilla en W mediante un parámetro double
	 *
	 * @param potencia Valor decimal double que representa la potencia de la Bombilla en W.
	 * @throws IllegalArgumentException Si la potencia introducida es inválida
	 */
	public void setPotencia(double potencia) throws IllegalArgumentException
	{
		if(potencia > POTENCIA_MAX) //EXCEPCIÓN - IllegalArgumentException - La potencia no puede ser mayor que el máximo
		{
			throw new IllegalArgumentException ("Potencia mayor que la potencia máxima permitida (" + POTENCIA_MAX + "W).");
		}
		if(potencia < POTENCIA_MIN) //EXCEPCIÓN - IllegalArgumentException - La potencia no puede ser menor que el mínimo
		{
			throw new IllegalArgumentException ("Potencia menor que la potencia mínima permitida (" + POTENCIA_MIN + "W).");
		}
		this.potencia = potencia; 
	}
	
	/**
	 * Devuelve las horas que lleva encendida la Bombilla
	 * @return double tiempoEncendida
	 */
	public double getTiempoEncendida()
	{
		return this.tiempoEncendida;
	}
	
	// MÉTODOS =============================================================
	
	/**
	 * Calcula y devuelve el consumo de la Bombilla
	 * @return double consumo
	 */
	public double calcularConsumo()
	{
		return this.potencia * this.tiempoEncendida;
	}
	
	/**
	 * Enciende la Bombilla
	 * @throws IllegalStateException Si la Bombilla ya está encendida
	 */
	public void encender() throws IllegalStateException
	{
		if(this.encendida == true) // EXCEPCIÓN - IllegalStateException - No se puede encender la Bombilla si ya está encendida.
		{
			throw new IllegalStateException ("La bombilla ya está encendida.");
		}
		else
		{
			this.encendida = true;
			this.ultimaVezEncendida = LocalTime.now();
			this.numeroVecesEncendida++;
			Bombilla.bombillasEncedidas++;
		}
	}
	
	/**
	 * Apaga la bombilla
	 * @throws IllegalStateException Si la bombilla ya está apagada
	 */
	public void apagar() throws IllegalStateException
	{
		if(this.encendida == false) // EXCEPCIÓN - IllegalStateException - No se puede apagar la bombilla si ya está apagada.
		{
			throw new IllegalStateException ("La bombilla ya está apagada.");
		}
		else
		{
			this.encendida = false;
			Bombilla.bombillasEncedidas--;
			//No lo convertimos a ChronoUnit.HOURS directamente para más precisión del tiempo.
			this.tiempoEncendida += (this.ultimaVezEncendida.until(LocalTime.now(), ChronoUnit.SECONDS)) / 3600;
			this.ultimaVezEncendida = null;  //No apunta a nada porque está apagada
		}
	}
	
	/**
	 * Conmmuta la bombilla en base a su estado actual
	 */
	public void conmutar()
	{
		if(this.encendida == true)
		{
			this.encendida = false;
			Bombilla.bombillasEncedidas--;
			this.tiempoEncendida += (this.ultimaVezEncendida.until(LocalTime.now(), ChronoUnit.SECONDS)) / 3600;
			this.ultimaVezEncendida = null;
		}
		else
		{
			this.encendida = true;
			this.ultimaVezEncendida = LocalTime.now();
			this.numeroVecesEncendida++;
			Bombilla.bombillasEncedidas++;
		}
	}
	
	/**
	 * <p>Devuelve un objeto String que representa la información
	 * detallada de la Bombilla</p>
	 * <p><strong>El formato de salida</strong> será del siguiente tipo:<br>
	 * Caso 1 <br>
	 * "Bombilla: encendida. Se ha encendido 1 vez."<br>
	 * Caso 2 <br>
	 * "Bombilla: apagada. Se ha encendido 5 veces".
	 * @return Cadena que represeta la información de la Bombilla.
	 */
	public String toString()
	{
		return String.format("Bombilla %s. Se ha encendido %d %s.", 
				this.encendida ? "encendida" : "apagada", 
				this.numeroVecesEncendida, 
				this.numeroVecesEncendida == 1 ? "vez" : "veces");
	}
}
