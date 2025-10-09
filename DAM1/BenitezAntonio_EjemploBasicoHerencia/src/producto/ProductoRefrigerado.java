/*
 * Clase que representa un Producto Refrigerado
 * Esta clase contiene los siguientes atributos:
 * 		- codigo: Código del Producto en formato 0000
 * 		- nombre: Nombre del Producto
 * 		- fechaCaducidad: Fecha de caducidad del Producto en formato LocalDate
 * 		- numeroLote: Número de Lote del Producto
 * 		- codigoOrganismo: Código del organismo que comprueba el Producto
 * 		- tempMinima: Temperatura mínima de refrigeración del Producto
 * 		- fechaConsumoPreferente: Fecha de consumo preferente del Producto en formato LocalDate
 * 
 * Además contiene atributos de clase como:
 * 		- numUltimoProducot: Último número usado del código de la clase Producto
 * 		- NUM_MAXIMO_PRODUCTO: Número máximo de código de la clase Producto
 * 
 * Herencia: Producto
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 11/02/2025 
 */
package producto;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto
{
	
// ATRIBUTOS ---------------------------------------------
	
	private String codigoOrganismo;
	private double tempMinima;
	private LocalDate fechaConsumoPreferente;
	
// CONSTRUCTORES ---------------------------------------------
	
	//Constructor maestro (seis parámetros)
	public ProductoRefrigerado(String nombre, LocalDate fechaCaducidad, int numeroLote, 
			String codigoOrganismo, double tempMinima, LocalDate fechaConsumoPreferente) throws IllegalArgumentException
	{
		super(nombre, fechaCaducidad, numeroLote);
		
		stringException(codigoOrganismo, "Código de organismo");
		localDateException(fechaConsumoPreferente, "Fecha de consumo preferente");
		
		this.codigoOrganismo = codigoOrganismo;
		this.tempMinima = tempMinima;
		this.fechaConsumoPreferente = fechaConsumoPreferente;
	}
	
	//Constructor por omisión
	public ProductoRefrigerado()
	{
		this("Defecto", LocalDate.of(2999, 12, 28), 999999, "XXXXXX", -999, LocalDate.of(2999, 12, 28));
	}
	
// GETTERS ---------------------------------------------
	
	//Devuelve el codigoOrganismo del ProductoRefrigerado en formato String
	public String getCodigoOrganismo()
	{
		return this.codigoOrganismo;
	}
	
	//Devuelve la tempMinima del ProductoRefrigerado como valor decimal double
	public double getTemperaturaMinima()
	{
		return this.tempMinima;
	}
	
	//Devuelve la fechaConsumoPreferente del ProductoRefrigerado en formato LocalDate
	public LocalDate getFechaConsumoPreferente()
	{
		return this.fechaConsumoPreferente;
	}
	
// SETTERS ---------------------------------------------
	
	//Establece el codigoOrganismo del ProductoRefrigerado pasado por parámetro
	public void setCodigoOrganismo(String codigoOrganismo)
	{
		stringException(codigoOrganismo, "Código de organismo");
		this.codigoOrganismo = codigoOrganismo;
	}
	
	//Establece la tempMinima del ProductoRefrigerado pasada por parámetro
	public void setTemperaturaMinima(double tempMinima)
	{
		this.tempMinima = tempMinima;
	}
	
	//Establece la fechaConsumoPreferente del ProductoRefrigerado pasada por parámetro
	public void setFechaConsumoPreferente(LocalDate fechaConsumoPreferente)
	{
		localDateException(fechaConsumoPreferente, "Fecha de consumo preferente");
		this.fechaConsumoPreferente = fechaConsumoPreferente;
	}
	
// MÉTODOS ---------------------------------------------
	
	//TO STRING - Devuelve un String que representa la información del ProductoRefrigerado
	@Override
	public String toString()
	{
		return String.format("%s \nCódigo organismo: %s \nTemperatura mínima: %.2fºC \nFecha de consumo preferente: %s",
				super.toString(), this.codigoOrganismo, this.tempMinima, fechaFormato(this.fechaConsumoPreferente));
	}
}
