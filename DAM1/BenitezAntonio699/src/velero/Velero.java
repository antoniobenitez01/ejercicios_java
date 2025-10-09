/*
 * Clase que representa un Velero
 * Excepciones: IllegalArgumentException, IllegalStateException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 12/02/2025 
 */
package velero;

public class Velero 
{
	
// ATRIBUTOS ================================================
	
	public static final int MIN_MASTILES = 1; // Número mínimo de mástiles
	public static final int MAX_MASTILES = 4; // Número máximo de mástiles
	public static final int MIN_VELOCIDAD = 2; // Número mínimo de nudos de velocidad
	public static final int MAX_VELOCIDAD = 30; // Número máximo de nudos de velocidad
	public static final String PATRON_POR_DEFECTO = "Sin patrón"; // Nombre del Patrón por defecto
	public static final String RUMBO_POR_DEFECTO = "Sin rumbo"; // Rumbo por defecto
	public static final int MIN_TRIPULANTES = 0; // Número mínimo de tripulantes
	
	private static int numBarcos; // Número de barcos en la flota
	private static int numBarcosNavegando; // Número de barcos navegando en la flota
	private static float totalNavegacionFlota; // Tiempo total de navegación de la flota en horas
	
	private final String nombre; // Nombre del Velero
	private final int numMastiles; // Número de mástiles del Velero
	private final int numMaxTripulantes; // Número máximo de tripulantes del Velero
	
	private boolean navegando; // True si el Velero está navegando
	private float tiempoTotalNavegacion; // Tiempo total de navegación del Velero en horas
	private int velocidad; // Velocidad del Velero en nudos
	private String nombrePatron; // Nombre del Patrón del Velero
	private String rumbo; // Rumbo del Velero
	private int numTripulantes; // Número de tripulantes del Velero
	
	static
	{
		numBarcos = 0;
		numBarcosNavegando = 0;
		totalNavegacionFlota = 0;
	}
	
// CONSTRUCTORES ============================================
	
	//Constructor maestro (3 parámetros)
	public Velero(String nombre, int numMastiles, int numMaxTripulantes) throws IllegalArgumentException
	{
		if(nombre.isEmpty() || nombre == null)
		{
			throw new IllegalArgumentException("El nombre del velero no puede estar vacío o ser nulo.\n");
		}
		if(numMastiles > MAX_MASTILES || numMastiles < MIN_MASTILES)
		{
			throw new IllegalArgumentException(String.format("El número de mástiles debe estar entre %d y %d.\n",MIN_MASTILES, MAX_MASTILES));
		}
		if(numMaxTripulantes < MIN_TRIPULANTES)
		{
			throw new IllegalArgumentException(String.format("El número de tripulantes debe ser, como mínimo, %d.\n",MIN_TRIPULANTES));
		}
		
		this.nombre = nombre;
		this.numMastiles = numMastiles;
		this.numMaxTripulantes = numMaxTripulantes;
		
		this.navegando = false;
		this.tiempoTotalNavegacion = 0;
		this.velocidad = 0;
		this.nombrePatron = PATRON_POR_DEFECTO;
		this.rumbo = RUMBO_POR_DEFECTO;
		this.numTripulantes = 0;
		
		numBarcos++;
	}
	
	//Constructor por omisión
	public Velero()
	{
		this(String.format("Velero %d", numBarcos), MIN_MASTILES, MIN_TRIPULANTES);
	}
	
	//Pseudo-constructor - Crea un array de veleros por omisión
	public static Velero[] crearArrayVelero(int cantidadBarcos) throws IllegalArgumentException
	{
		if(cantidadBarcos < 1 || cantidadBarcos > 10)
		{
			throw new IllegalArgumentException(String.format("Número de barcos incorrecto (%d), debe estar entre 1 y 10.\n",
															cantidadBarcos));
		}
		
		Velero[] flota = new Velero[cantidadBarcos];
		for(int i=0;i<flota.length; i++)
		{
			flota[i] = new Velero();
		}
		return flota;
	}

// GETTERS ========================================================
	
	//Devuelve el nombre del Velero
	public String getNombreBarco() 
	{
		return this.nombre;
	}
	
	//Devuelve el número de mástiles
	public int getNumMastiles()
	{
		return this.numMastiles;
	}
	
	//Devuelve el máximo de tripulantes
	public int getMaxTripulantes()
	{
		return this.numMaxTripulantes;
	}
	
	//Devuelve true si el Velero está navegando
	public boolean isNavegando()
	{
		return this.navegando;
	}
	
	//Devuelve el tiempo total de navegación del Velero en minutos
	public int getTiempoTotalNavegacionBarco()
	{
		return (int) (this.tiempoTotalNavegacion * 60);
	}
	
	//Devuelve la velocidad del Velero en nudos
	public int getVelocidad()
	{
		return this.velocidad;
	}
	
	//Devuelve el rumbo
	public String getRumbo()
	{
		return this.rumbo;
	}
	
	//Devuelve el nombre del patrón del Velero
	public String getPatron()
	{
		return this.nombrePatron;
	}
	
	//Devuelve el número de tripulantes
	public int getTripulacion()
	{
		return this.numTripulantes;
	}
	
	//Devuelve el número de barcos en la flota
	public static int getNumBarcos()
	{
		return numBarcos;
	}
	
	//Devuelve el número de barcos navegando en la flota
	public static int getNumBarcosNavegando()
	{
		return numBarcosNavegando;
	}
	
	//Devuelve el tiempo total de navegación de la flota
	public static float getTiempoTotalNavegacion()
	{
		return totalNavegacionFlota;
	}
	
// SETTERS ====================================================
	
	//Establece un nuevo rumbo
	public void setRumbo(String rumbo) throws IllegalStateException, IllegalArgumentException
	{
		if(!this.isNavegando())
		{
			throw new IllegalStateException(String.format("El velero %s no está navegando, no se puede cambiar el rumbo.\n",
					this.nombre));
		}
		if(rumbo.isEmpty() || rumbo == null)
		{
			throw new IllegalArgumentException("El rumbo no es correcto, debes indicar el rumbo (ceñida o empopada) para poder modificarlo.\n");
		}
		if(rumbo.equals(this.rumbo))
		{
			throw new IllegalStateException(String.format("El velero %s ya está navegando con ese rumbo (%s), "
					+ "debes indicar un rumbo distinto para poder modificarlo.\n",
					this.nombre, this.rumbo));
		}
		
		this.rumbo = rumbo;
	}
	
// MÉTODOS ====================================================
	
	/*INICIAR NAVEGACIÓN - Recoge parámetros de velocidad, rumbo, nombrePatron, numTripulantes y los 
	establece correspondientemente, simulando la navegación del velero.*/
	public void iniciarNavegacion(int velocidad, String rumbo, String nombrePatron, int numTripulantes) 
			throws IllegalArgumentException, IllegalStateException
	{
		if(velocidad < MIN_VELOCIDAD || velocidad > MAX_VELOCIDAD)
		{
			throw new IllegalArgumentException(String.format("La velocidad de navegación de %d nudos es incorrecta.\n", velocidad));
		}
		if(this.isNavegando())
		{
			throw new IllegalStateException(String.format("El velero %s ya está navegando y se encuentra fuera de puerto.\n",this.nombre));
		}
		if(rumbo.isEmpty() || rumbo == null)
		{
			throw new IllegalArgumentException("El patrón del barco no puede estar vacío o ser nulo,"
					+ " se necesita un patrón para iniciar la navegación.\n");
		}
		if(numTripulantes < MIN_TRIPULANTES)
		{
			throw new IllegalArgumentException(String.format("El número de tripulantes debe estar entre %d y %d.\n",
					MIN_TRIPULANTES, this.numMaxTripulantes));
		}
		
		this.velocidad = velocidad;
		this.rumbo = rumbo;
		this.nombrePatron = nombrePatron;
		this.numTripulantes = numTripulantes;
		this.navegando = true;
		
		numBarcosNavegando++;
	}
	
	/*PARAR NAVEGACION - Recoge el tiempoNavegacion y lo añade al total del Velero,
	 modificando el resto de atributos para simular el Velero parando su navegación*/
	public void pararNavegacion(float tiempoNavegacion) throws IllegalArgumentException, IllegalStateException
	{
		if(!this.isNavegando())
		{
			throw new IllegalStateException(String.format("El velero %s no está navegando.\n", this.nombre));
		}
		if(tiempoNavegacion < 0)
		{
			throw new IllegalArgumentException("Tiempo navegando incorrecto, debe ser mayor que cero.\n");
		}
		
		this.tiempoTotalNavegacion += tiempoNavegacion;
		this.velocidad = 0;
		this.rumbo = "";
		this.nombrePatron = "";
		this.numTripulantes = MIN_TRIPULANTES;
		this.navegando = false;
		
		numBarcosNavegando--;
		totalNavegacionFlota += tiempoNavegacion;
	}
	
	//INICIAR REGATA - Recoge un objeto Velero para iniciar una carrera contra este
	public String iniciarRegata(Velero velero) throws NullPointerException, IllegalStateException
	{
		if(velero == null)
		{
			throw new NullPointerException("El barco con el que se intenta regatear no existe.\n");
		}
		if(!this.isNavegando())
		{
			throw new IllegalStateException(String.format("No se puede iniciar la regata, el barco %s no está navegando.\n", this.nombre));
		}
		if(!this.rumbo.equals(velero.rumbo))
		{
			throw new IllegalStateException(String.format("No se puede iniciar la regata,"
					+ " los barcos %s y %s deben navegar con el mismo rumbo.\n",
					this.nombre, velero.nombre));
		}
		if(this.numMastiles != velero.numMastiles)
		{
			throw new IllegalStateException(String.format("No se puede iniciar la regata,"
					+ " los barcos %s y %s no tienen el mismo número de mástiles.\n",
					this.nombre, velero.nombre));
		}
		
		String resultado = "";
		if(this.velocidad == velero.velocidad)
		{
			resultado = String.format("Los barcos %s y %s han llegado a la vez a la línea de llegada.\n", this.nombre, velero.nombre);
		}
		else if(this.velocidad > velero.velocidad)
		{
			resultado = String.format("El barco %s ha llegado antes a la línea de llegada.\n", this.nombre);
		}
		else
		{
			resultado = String.format("El barco %s ha llegado antes a la línea de llegada.\n", velero.nombre);
		}
		return resultado;
	}
	
	//TO STRING - Devuelve un String con la información detalla del Velero
	public String toString()
	{
		String toString = "";
		if(this.isNavegando())
		{
			toString = String.format("{Nombre del barco: %s, Número de mástiles: %d, Tripulación: %d, Navegando: %s,"
					+ " con el patrón %s en %s a %d nudos, Tiempo total de navegación del barco: %.2f horas}",
					this.nombre, this.numMastiles, this.numTripulantes, this.navegando ? "Sí" : "No", this.nombrePatron,
							this.rumbo, this.velocidad, this.tiempoTotalNavegacion);
		}
		else
		{
			toString = String.format("{Nombre del barco: %s, Número de mástiles: %d, Tripulación: %d, Navegando: %s,"
					+ " Tiempo total de navegación del barco: %.2f horas}",
					this.nombre, this.numMastiles, this.numTripulantes, this.navegando ? "Sí" : "No", this.tiempoTotalNavegacion);
		}
		return toString;
	}
}
