/*
 * Clase que representa una Cuenta Bancaria
 * Esta clase contiene los siguientes atributos:
 * 		- NumeroCuenta: Número de cuenta en formato String
 * 		- PIN: PIN de la cuenta bancaria en valor entero
 * 		- SaldoReal: Saldo de la cuenta real representado por un valor decimal double
 * 		- Balance: Saldo temporal de la  cuenta representado por un valor decimal double
 * 		- Movimientos: Movimientos de la cuenta almacenados en un array de String
 * 		- UltimoMovimiento: Valor entero que representa la última posición disponible en el array de movimientos
 * 
 * Además contiene atributos de clase como:
 * 		- Saldo mínimo: Saldo mínimo constante de la cuenta bancaria
 * 
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 04/02/2025 
 */
package cajeroAutomatico;

public class CuentaBancaria
{
	
// ATRIBUTOS ====================================================
	
	private static final double SALDO_MINIMO = -50;
	
	private String numeroCuenta;
	private int pin;
	private double saldoReal;
	private double balance;
	private String[] movimientos;
	private int ultimoMovimiento;
	
// CONSTRUCTORES ====================================================
	
	//Constructor maestro (dos atributos)
	public CuentaBancaria(String numeroCuenta, int pin)
	{
		this.numeroCuenta = numeroCuenta;
		this.pin = pin;
		this.saldoReal = 0;
		this.balance = 0;
		this.movimientos = new String[100];
		this.ultimoMovimiento = 0;
	}
	
	//Constructor por omisión
	public CuentaBancaria()
	{
		this("AA0000000000000000000000", 1234);
	}
	
// MÉTODOS ====================================================
	
	//GET - Devuelve el número de cuenta en formato String
	public String getNumeroCuenta()
	{
		return this.numeroCuenta;
	}
	
	//GET - Devuelve el PIN de la cuenta como un valor entero
	public int getPin()
	{
		return this.pin;
	}
	
	//GET - Devuelve el saldo de la cuenta como un valor decimal double
	public double getSaldo()
	{
		return this.saldoReal;
	}
	
	//SACAR DINERO - Crea un balance temporal igual al saldoReal menos la cantidad introducida
	public void sacarDinero(double cantidad) throws IllegalArgumentException, IllegalStateException
	{
		if(cantidad < 0)
		{
			throw new IllegalArgumentException ("La cantidad a retirar no puede ser menor que 0.");
		}
		if(this.saldoReal - cantidad < SALDO_MINIMO)
		{
			throw new IllegalStateException (String.format("El saldo de la cuenta no puede ser menor que %.2f.",SALDO_MINIMO));
		}
		this.balance = this.saldoReal - cantidad;
	}
	
	//INGRESAR DINERO - Crea un balance temporal igual al saldoReal más la cantidad introducida
	public void ingresarDinero(double cantidad) throws IllegalArgumentException
	{
		if(cantidad < 0)
		{
			throw new IllegalArgumentException ("La cantidad a ingresar no puede ser menor que 0.");
		}
		this.balance = this.saldoReal + cantidad;
	}
	
	/*CONFIRMAR OPERACIÓN - Confirma la operación, haciendo que el saldoReal sea igual que el balance temporal
	 y registrando el movimiento dentro del array de movimientos*/
	public void confirmarOperacion(String operacion)
	{
		double cantidad;
		if(this.balance > this.saldoReal)
		{
			cantidad = this.balance - this.saldoReal;
		}
		else
		{
			cantidad = this.saldoReal - this.balance;
		}
		this.saldoReal = this.balance;
		this.movimientos[this.ultimoMovimiento] = String.format("%d - %s: %.2f€",this.ultimoMovimiento + 1, operacion, cantidad);
		this.ultimoMovimiento++;
	}
	
	//CANCELAR OPERACIÓN - Cancela la operación, haciendo que el balance sea igual que el saldoReal
	public void cancelarOperacion()
	{
		this.balance = this.saldoReal;
	}
	
	//TO STRING - Devuelve los movimientos de la cuenta en formato String
	public String movimientosToString()
	{
		String movimientosString = "";
		for(int i=0; i<this.ultimoMovimiento; i++)
		{
			if(movimientos[i] != null)
			{
				movimientosString += movimientos[i] + "\n";
			}
		}
		return movimientosString;
	}
}
