/*
 * Clase que representa una Cuenta Bancaria
 * Esta clase contiene los siguientes atributos:
 * 		- Movimientos: Movimientos de la cuenta almacenados en un array de String
 * 		- IBAN: IBAN de la cuenta representando por un String
 * 		- Titular: Titular de la cuenta representado por un String
 * 		- Saldo: Saldo de la cuenta representado por un valor decimal double
 * 		- UltimoMovimiento: Valor entero que representa la última posición disponible en el array de movimientos
 * 
 * Además contiene atributos de clase como:
 * 		- Saldo mínimo: Saldo mínimo constante de la cuenta bancaria
 * 		- Movimiento Hacienda: Cantidad constante de dinero desde la cual se debe comunicar con Hacienda
 * 
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/02/2025 
 */
package ejercicio4;

public class CuentaBancaria 
{

// ATRIBUTOS ====================================================
	
	public static final double MINIMO_SALDO = -50;
	public static final double MOVIMIENTO_HACIENDA = 3000;
	
	private String[] movimientos;
	private String iban;
	private String titular;
	private double saldo;
	private int ultimoMovimiento;
	
// CONSTRUCTORES ================================================

	//Constructor maestro (dos parámetros) 
	public CuentaBancaria(String iban, String titular) throws IllegalArgumentException, CuentaException
	{
		if(iban.isEmpty() || iban == null)
		{
			throw new CuentaException(iban, "IBAN");
		}
		if(titular.isEmpty() || titular == null)
		{
			throw new CuentaException(titular, "Titular");
		}
		
		this.iban = iban;
		this.titular = titular;
		this.saldo = 0;
		this.movimientos = new String[100];
		this.ultimoMovimiento = 0;
	}
	
	//Constructor por omisión
	public CuentaBancaria() throws IllegalArgumentException, CuentaException
	{
		this("AA0000000000000000000000", "Default");
	}
	
// MÉTODOS ====================================================
	
	// GET - Devuelve el IBAN de la cuenta en String
	public String getIban()
	{
		return this.iban;
	}
	
	// GET - Devuelve el Titular de la cuenta en String
	public String getTitular()
	{
		return this.titular;
	}
	
	// GET - Devuelve el Saldo de la cuenta en valor decimal double
	public double getSaldo()
	{
		return this.saldo;
	}
	
	// INGRESO - Ingresa una cantidad decimal introducida por parámetro en la cuenta bancaria
	public void ingreso(double cantidad) throws IllegalArgumentException, AvisarHaciendaException
	{
		checkSaldo(this.saldo + cantidad);
		checkCantidad(cantidad, "ingresar");
		
		if(cantidad > MOVIMIENTO_HACIENDA)
		{
			this.saldo += cantidad;
			this.movimientos[ultimoMovimiento] = String.format("Se han ingresado %.2f €", cantidad);
			ultimoMovimiento++;
			throw new AvisarHaciendaException(this.titular, this.iban, "ingresar", cantidad);
		}
		
		this.saldo += cantidad;
		this.movimientos[ultimoMovimiento] = String.format("Se han ingresado %.2f €", cantidad);
		ultimoMovimiento++;
	}
	
	// RETIRAR - Retira una cantidad decimal introducida por parámetro de la cuenta bancaria
	public void retirar(double cantidad) throws IllegalArgumentException, AvisarHaciendaException
	{
		checkSaldo(this.saldo - cantidad);
		checkCantidad(cantidad, "retirar");
		
		if(cantidad > MOVIMIENTO_HACIENDA)
		{
			this.saldo -= cantidad;
			this.movimientos[ultimoMovimiento] = String.format("Se han retirado %.2f €", cantidad);
			ultimoMovimiento++;
			throw new AvisarHaciendaException(this.titular, this.iban, "retirar", cantidad);
		}
		
		this.saldo -= cantidad;
		this.movimientos[ultimoMovimiento] = String.format("Se han retirado %.2f €", cantidad);
		ultimoMovimiento++;
	}
	
	// CHECK - Revisa la cantidad introducida por parámetro, tratando la excepción IllegalArgumentException
	private void checkCantidad(double cantidad, String accion) throws IllegalArgumentException, AvisarHaciendaException
	{
		if(cantidad <= 0)
		{
			throw new IllegalArgumentException ("La cantidad a " + accion + " debe ser mayor que 0.");
		}
	}
	
	// CHECK - Revisa el saldo de la cuenta, tratando la excepción IllegalArgumentException
	private void checkSaldo(double saldo) throws IllegalStateException
	{
		if(saldo < -50)
		{
			throw new IllegalStateException ("El saldo no puede ser menor que -50€.");
		}
		
		if(saldo < 0 && saldo > -50)
		{
			System.out.println("AVISO: Saldo negativo.");
		}
	}
	
	//TO STRING - Devuelve un String que representa los datos de la cuenta
	public String toString()
	{
		return String.format("IBAN: %s \nTitular: %s \nSaldo: %.2f",
				this.iban, this.titular, this.saldo);
	}
	
	//TO STRING - Devuelve un String que representa los movimientos de la cuenta
	public String movimientosToString()
	{
		String movimientosString = "";
		for(int i=0; i<this.movimientos.length; i++)
		{
			if(movimientos[i] != null)
			{
				movimientosString += "- " + movimientos[i] + "\n";
			}
		}
		return movimientosString;
	}
}
