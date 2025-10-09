package claseVehiculo;

/**
 * Clase que representa un <strong>Vehículo</strong>.
 * <p>Los objetos de esta clase contienen atributos que permiten almacenar información sobre:</p>
 * <ul>
 * <li><strong>capacidadDeposito:</strong> Capacidad del depósito de combustible (en litros)</li>
 * <li><strong>consumoMedio:</strong> Consumo medio del vehículo (en litros/100 km)</li>
 * <li><strong>encendido:</strong> Si el vehículo tiene el motor encendido o apagado</li>
 * <li><strong>nivelCombustible:</strong> El nivel actual del depósito de combustible (en litros)</li>
 * <li><strong>distanciaRecorrido:</strong> La cantidad de kilómetros recorridos desde que se ha arrancado por última vez (en kilómetros)</li>
 * <li><strong>consumoRecorrido:</strong> El consumo realizado desde que se ha arrancado por última vez (en litros)</li>
 * <li><strong>distanciaTotal:</strong> La cantidad total de kilómetros recorridos desde que se fabricó el vehículo (en kilómetros)</li>
 * <li><strong>consumoTotal:</strong> El consumo total realizado desde que se fabricó el vehículo (en litros)</li>
 * </ul>
 * <p>La clase también dispone de información general independiente de los objetos concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>distanciaTotalVehiculos:</strong> Distancia recorrida total por todos los vehículos que se hayan ido creando hasta el momento (kilómetros)</li>
 * <li><strong>combustibleTotalConsumido:</strong> Combustible total consumido por todos los vehículos que se hayan ido creando hasta el momento (litros)</li>
 * <li><strong>vehiculosEncendidos:</strong> Número de vehículos con el motor encendido en el momento actual</li>
 * </ul>
 * 
 * @author Antonio Benítez Rodríguez
 */
public class Vehiculo 
{
	
//ATRIBUTOS ===========================================================================
	
	/**
	* Mínimo consumo medio permitido a la hora de crear un nuevo vehículo :
	* {@value MINIMO_CONSUMO_MEDIO} litros/100km.
	*/
	public static final double MINIMO_CONSUMO_MEDIO = 2.0;
	/**
	* Máximo consumo medio permitido a la hora de crear un nuevo vehículo :
	* {@value MAXIMO_CONSUMO_MEDIO} litros/100km.
	*/
	public static final double MAXIMO_CONSUMO_MEDIO = 20.0;
	/**
	* Mínima capacidad del depósito permitida a la hora de crear nuevo vehículo :
	* {@value MINIMO_CAPACIDAD_DEPOSITO} litros.
	*/
	public static final double MINIMO_CAPACIDAD_DEPOSITO = 10;
	/**
	* Máxima capacidad del depósito permitida a la hora de crear nuevo vehículo :
	* {@value MAXIMO_CAPACIDAD_DEPOSITO} litros.
	*/
	public static final double MAXIMO_CAPACIDAD_DEPOSITO = 100;
	/**
	* Consumo que se produce al arrancar un vehículo :
	* {@value CONSUMO_ARRANQUE} litros.
	*/
	public static final double CONSUMO_ARRANQUE = 0.02;
	/**
	* Valor por omisión para el consumo medio de un vehículo :
	* {@value CONSUMO_MEDIO_DEFAULT} litros/100km.
	*/
	public static final double CONSUMO_MEDIO_DEFAULT = 5;
	/**
	* Valor por omisión para la capacidad del depósito de un vehículo :
	* {@value CAPACIDAD_DEPOSITO_DEFAULT} litros/100km.
	*/
	public static final double CAPACIDAD_DEPOSITO_DEFAULT = 50;
	
	private static double distanciaTotalVehiculos;
	private static double combustibleTotalConsumido;
	private static int vehiculosEncendidos;
	
	private double capacidadDeposito;
	private double consumoMedio;
	
	private boolean encendido;
	private double nivelCombustible;
	private double distanciaRecorrido;
	private double consumoRecorrido;
	private double distanciaTotal;
	private double consumoTotal;
	
//CONSTRUCTORES ===========================================================================
	
	/**
	 * Constructor maestro (dos parámetros)
	 *
	 * @param capacidadDeposito Capacidad del depósito de combustible (en litros)
	 * @param consumoMedio Consumo medio del vehículo (en litros/100 km)
	 * @throws IllegalArgumentException Si alguno de los parámetros no es válido
	 */
	public Vehiculo(double capacidadDeposito, double consumoMedio) throws IllegalArgumentException
	{
		if(capacidadDeposito < MINIMO_CAPACIDAD_DEPOSITO || capacidadDeposito > MAXIMO_CAPACIDAD_DEPOSITO)
		{
			throw new IllegalArgumentException ("Capacidad de depósito no válida.\nDebe tener entre 10 y 120 litros de capacidad.");
		}
		if(consumoMedio < MINIMO_CONSUMO_MEDIO || consumoMedio > MAXIMO_CONSUMO_MEDIO)
		{
			throw new IllegalArgumentException ("Consumo medio no válido. \nDebe tener entre 2 l/km y 20 l/km.");
		}
		
		this.capacidadDeposito = capacidadDeposito;
		this.consumoMedio = consumoMedio;
		
		this.encendido = false;
		this.nivelCombustible = capacidadDeposito; //Llenamos el depósito al máximo
		this.distanciaRecorrido = 0;
		this.consumoRecorrido = 0;
		this.distanciaTotal = 0;
		this.consumoTotal = 0;
	}
	
	/**
	 * Constructor por omisión
	 */
	public Vehiculo()
	{
		this(CAPACIDAD_DEPOSITO_DEFAULT, CONSUMO_MEDIO_DEFAULT);
	}
	
//GETTERS ===========================================================================
	
	/**
	 * Devuelve true si el Vehículo está arrancado
	 * @return boolean encendido
	 */
	public boolean isArrancado()
	{
		return this.encendido;
	}
	
	/**
	 * Devuelve el consumo medio del Vehículo en litros/100km
	 * @return double consumoMedio
	 */
	public double getConsumoMedio()
	{
		return this.consumoMedio;
	}
	
	/**
	 * Devuelve la capacidad del depósito en litros
	 * @return double capacidadDeposito
	 */
	public double getCapacidadDeposito()
	{
		return this.capacidadDeposito;
	}
	
	/**
	 * Devuelve el nivel del combustible en litros
	 * @return double nivelCombustible
	 */
	public double getNivelCombustible()
	{
		return this.nivelCombustible;
	}
	
	/**
	 * Devuelve la cantidad de kilómetros recorridos desde que se ha arrancado por última vez
	 * @return double distanciaRecorrido
	 */
	public double getDistanciaRecorrida()
	{
		return this.distanciaRecorrido;
	}
	
	/**
	 * Devuelve la cantidad total de kilómetros recorridos desde que se fabricó el vehículo
	 * @return double distanciaTotal
	 */
	public double getDistanciaRecorridaTotal()
	{
		return this.distanciaTotal;
	}
	
	/**
	 * Devuelve el consumo realizado desde que se ha arrancado por última vez
	 * @return double consumoRecorrido
	 */
	public double getCombustibleConsumido()
	{
		return this.consumoRecorrido;
	}
	
	/**
	 * Devuelve el consumo total realizado desde que se fabricó el vehículo 
	 * @return double consumoTotal
	 */
	public double getCombustibleConsumidoTotal()
	{
		return this.consumoTotal;
	}
	
	/**
	 * Devuelve la distancia recorrida total por todos los vehículos que se hayan ido creando hasta el momento en kilómetros
	 * @return double distanciaTotalVehiculos
	 */
	public static double getDistanciaRecorridaFlota()
	{
		return distanciaTotalVehiculos;
	}
	
	/**
	 * Devuelve el combustible total consumido por todos los vehículos que se hayan ido creando hasta el momento en litros
	 * @return double combustibleTotalConsumido
	 */
	public static double getCombustibleConsumidoFlota()
	{
		return combustibleTotalConsumido;
	}
	
	/**
	 * Devuelve el número de vehículos con el motor encendido en el momento actual
	 * @return int vehiculosEncendidos
	 */
	public static int getNumVehiculosArrancadosFlota()
	{
		return vehiculosEncendidos;
	}
	
//MÉTODOS ===========================================================================

	/**
	* Repuesta una cantidad de litros de combustible
	* @param cantidad Cantidad en litros a repostar
	* @throws IllegalStateException Si el vehículo está arrancado
	* @throws IllegalArgumentException Si alguno de los parámetros no es válido
	*/
	public void repostar(double cantidad) throws IllegalStateException, IllegalArgumentException
	{
		if(isArrancado())
		{
			throw new IllegalStateException ("Se intentó repostar con el motor encendido. No se ha repostado.");
		}
		if((this.nivelCombustible + cantidad) > this.capacidadDeposito)
		{
			double sobra = (this.nivelCombustible + cantidad) - this.capacidadDeposito;
			throw new IllegalArgumentException (String.format("Depósito lleno. Se ha sobrepasado la capaciad del depósito de combustible en %.2f litros.", sobra));
		}
		
		this.nivelCombustible += cantidad;
	}
	
	/**
	* Arranca el vehículo
	* @throws IllegalStateException Si el vehículo ya está arrancado o no tiene suficiente combustible
	*/
	public void arrancar()
	{
		if(isArrancado())
		{
			throw new IllegalStateException("Error: El motor ya se encuentra arrancado.");
		}
		if(this.nivelCombustible - CONSUMO_ARRANQUE < 0)
		{
			throw new IllegalStateException("Depósito vacío. Se intentó arrancar sin combustible suficiente.");
		}
		
		this.encendido = true;
		this.consumoRecorrido += CONSUMO_ARRANQUE;
		this.nivelCombustible -= CONSUMO_ARRANQUE;
		
		vehiculosEncendidos++;
	}
	
	/**
	* Realiza un trayecto de kilómetros
	* @param kilometros Kilómetros a recorrer
	* @throws IllegalStateException Si el vehículo no está arrancado
	* @throws IllegalArgumentException Si alguno de los parámetros no es válido o no tiene suficiente combustible
	*/
	public void realizarTrayecto(double kilometros) throws IllegalArgumentException, IllegalStateException
	{
		if(kilometros < 0)
		{
			throw new IllegalArgumentException ("Error: Se intentó realizar un trayecto negativo.");
		}
		if(!isArrancado())
		{
			throw new IllegalStateException("Error: Se intentó realizar un trayecto con el motor apagado. No se ha avanzado.");
		}
		if((this.nivelCombustible - (this.consumoMedio * (kilometros/100))) < 0)
		{
			double distanciaRestante = (this.nivelCombustible / this.consumoMedio) * 100;
			this.nivelCombustible = 0;
			this.apagar();
			
			distanciaTotalVehiculos += distanciaRestante;
			combustibleTotalConsumido += distanciaRestante * consumoMedio;
			
			throw new IllegalArgumentException(String.format("No se ha podido finalizar el trayecto completamente. "+
					"Depósito vacío. Han faltado por recorrer %.2f km.", distanciaRestante));
		}
		
		this.consumoRecorrido += this.consumoMedio * (kilometros/100);
		this.distanciaRecorrido += kilometros;
		
		this.nivelCombustible -= this.consumoRecorrido;
		
		this.consumoTotal += this.consumoRecorrido;
		this.distanciaTotal += this.consumoTotal;
		
		distanciaTotalVehiculos += this.distanciaTotal;
		combustibleTotalConsumido += this.consumoTotal;
	}
	
	/**
	* Apaga el vehículo
	* @throws IllegalStateException Si el vehículo ya está apagado
	*/
	public void apagar() throws IllegalStateException
	{
		if(!isArrancado())
		{
			throw new IllegalStateException("El motor ya se encuentra apagado.");
		}
		
		this.encendido = false;
		this.consumoRecorrido = 0;
		this.distanciaRecorrido = 0;
		
		vehiculosEncendidos--;
	}
	
	/**
	 * Devuelve un objeto String que representa la información
	 * detallada del Vehículo
	 * <p><strong>Ejemplo del formato de salida:</strong></p>
	 * <p>Motor: apagado   - Depósito:   0,00 - Dist:     0,00 - Consumo:     0,00 </p>
	 * <p>Motor: arrancado - Depósito:   4,98 - Dist:     0,00 - Consumo:     0,02 </p>
	 * <p>Motor: arrancado - Depósito:   4,23 - Dist:   15,00 - Consumo:     0,77  </p>
	 * <p>Motor: apagado   - Depósito:   4,23 - Dist:     0,00 - Consumo:     0,00 </p>
	 * <p>Motor: arrancado - Depósito:   4,68 - Dist:   10,00 - Consumo:     0,32  </p>
	 * @return Cadena que represeta la información del Vehículo.
	 */
	public String toString()
	{
		return String.format("Motor: %s - Depósito: %.2f - Dist: %.2f - Consumo: %.2f",
				this.encendido ? "encendido" : "apagado", this.nivelCombustible, this.distanciaRecorrido, this.consumoRecorrido);
	}
}
