package ejercicioCoche;

public class Vehiculo {
	// Constantes
	public final static double MINIMO_CONSUMO_MEDIO = 2.0 / 100;
	public final static double MAXIMO_CONSUMO_MEDIO = 20.0 / 100;

	public final static double MINIMA_CAPACIDAD_DEPOSITO = 10.0;
	public final static double MAXIMA_CAPACIDAD_DEPOSITO = 100.0;

	public final static double CONSUMO_ARRANCAR_VEHICULO = 0.02;

	public final static double CONSUMO_MEDIO_PREDETERMINADO = 5.0 / 100;
	public final static double CAPACIDAD_VEHICULO_OMISION = 50.0;

	// Atributos estáticos

	private static double kmTotalesVehiculos;
	private static double combustibleTotalConsumido;
	private static short vehiculosMotorEncendido;

	// Atributos constantes
	private final double capacidadDeposito;
	private final double consumoMedioVehiculo;

	// Atributos que si iran cambiando
	private boolean estadoMotor;
	private double nivelActualDeposito;
	private double cantidadKmRecorridos;
	private double kmRecorridoRec;
	private double consumoRealizado;
	private double kilometrosTotalesRec;

	// Métodos Constructores

	public Vehiculo(double capacidadDeposito, double consumoMedioVehiculo) {
		
		if (capacidadDeposito>MAXIMA_CAPACIDAD_DEPOSITO || capacidadDeposito<MINIMA_CAPACIDAD_DEPOSITO ) {
			throw new IllegalArgumentException("No cumplen las condiciones que se piden");
		}
		if (consumoMedioVehiculo>MAXIMO_CONSUMO_MEDIO  || consumoMedioVehiculo<MINIMO_CONSUMO_MEDIO ) {
			throw new IllegalArgumentException("No cumplen las condiciones que se piden");
		}
		
		this.capacidadDeposito=;
		this.consumoMedioVehiculo=;
	}

	public Vehiculo() {
		this.capacidadDeposito = 50.0;
		this.consumoMedioVehiculo = 5.0 / 100;
		
		
	}
	
	//Métodos consultores
	
	
	
	
}
