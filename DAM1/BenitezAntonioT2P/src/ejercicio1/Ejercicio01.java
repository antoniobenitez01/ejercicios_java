/*
 * Objetivo: Hacer uso de la clase CuentaBancaria para
 * crear objetos con ella y utilizar sus métodos.
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/01/2025
 */
package ejercicio1;

import java.time.LocalDate;

import libtarea3.CuentaBancaria;

public class Ejercicio01 {

	public static void main(String[] args) 
	{
		//2. Declara diez variables referencia a objetos instancia de la clase CuentaBancaria
		System.out.println("2. Declarando diez variables referencia a objetos instancia de la clase CuentaBancaria...");
		CuentaBancaria[] cuentas = new CuentaBancaria[10]; //He creado un array para facilitar cálculos a continuación
		System.out.println("Declarados con éxito.");
		
		/*3.Instancia las diez variables de referencia con los siguientes valores:
		- FechaCreación: valor generado por anyoAleatorio
		- Saldo: saldo por defecto;
		- Límite descubierto: 50€*/
		System.out.println("\n3. Instanciando diez variables de referencia...");
		for(int i=0; i<cuentas.length;i++)
		{
			cuentas[i] = cuentaAnyoAleatorio();
		}
		System.out.println("Instanciadas con éxito.");
		System.out.println("Mostrando información de cuentas...\n");
		//Muestra la información de cada cuenta
		for(int i=0; i<cuentas.length; i++)
		{
			if(cuentas[i] != null)
			{
				System.out.printf(cuentas[i].toString() + "\n");
			}
		}
		
		//4.Indica qué cuenta tiene la fecha más reciente
		System.out.printf("\n4. Cuenta con fecha más reciente: %s \n", cuentaFechaMasReciente(cuentas).toString());
		
		/*5. Declara e instancia una variable de referencia con el identificador
		[TuPrimerApellido] y con los siguientes valores:
		 	- Saldo inicial = 50€*/
		System.out.println("\n5. Declarando e instanciando variable de referencia con identificador benitez...");
		CuentaBancaria benitez = null;
		try
		{
			benitez = new CuentaBancaria(50);
			System.out.println("Declarada e instanciada con éxito.");
			System.out.println("Mostrando información de cuenta...");
			//Muestra la información de la cuenta
			System.out.printf(benitez.toString() + "\n");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s \n", ex.getMessage());
		}
		
		/*6.Declara e instancia otra variable de referencia con los valores por defecto con el
		 	identificador [TuNombre]*/
		System.out.println("\n6. Declarando e instanciando variable de referencia con identificador antonio...");
		System.out.println("Declarada e instanciada con éxito.");
		System.out.println("Mostrando información de cuenta...");
		CuentaBancaria antonio = new CuentaBancaria();
		//Muestra la información de la cuenta
		System.out.printf(antonio.toString() + "\n");
		
		//7.Ingresa 1000€ en la cuenta con el identificador [TuPrimerApellido]
		System.out.println("\n7. Ingresando 1000€ en la cuenta benitez...");
		try
		{
			benitez.ingresar(1000);
			System.out.println("Ingresado con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s \n", ex.getMessage());
		}catch(IllegalStateException ex2)
		{
			System.out.printf("%s \n", ex2.getMessage());
		}
		//Muestra la información de la cuenta
		System.out.println("Mostrando información de cuenta...");
		System.out.printf("%s \n", benitez.toString());
		
		//8.Extrae 500€ de la cuenta con el identificador [TuNombre]
		System.out.println("\n8. Extrayendo 500€ de la cuenta antonio...");
		try
		{
			antonio.extraer(500);
			System.out.println("Dinero extraído con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s \n", ex.getMessage());
		}catch(IllegalStateException ex2)
		{
			System.out.printf("%s \n", ex2.getMessage());
		}
		//Muestra la información de la cuenta
		System.out.println("Mostrando información de cuenta...");
		System.out.printf("%s \n", antonio.toString());
		
		/*9.Transfiere 250€ de la cuenta con identificador [TuNombre] a la cuenta con el
		identificador [TuPrimerApellido]*/
		System.out.println("\n9. Transferiendo 250€ de la cuenta antonio a la cuenta benitez...");
		try
		{
			antonio.transferir(250, benitez);
			System.out.println("Dinero transferido con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s \n", ex.getMessage());
		}catch(IllegalStateException ex2)
		{
			System.out.printf("%s \n", ex2.getMessage());
		}
		//Muestra la información de ambas cuentas
		System.out.println("Mostrando información de ambas cuentas...");
		System.out.printf("%s \n %s \n", benitez.toString(), antonio.toString());
		
		//10.Embarga el 50% de la cuenta identificador [TuPrimerApellido]
		System.out.println("\n10. Embargando el 50% de la cuenta benitez...");
		try
		{
			benitez.embargar(50);
			System.out.println("Cuenta embargada con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s \n", ex.getMessage());
		}catch(IllegalStateException ex2)
		{
			System.out.printf("%s \n", ex2.getMessage());
		}
		//Muestra la información de la cuenta
		System.out.println("Mostrando información de cuenta...");
		System.out.printf("%s \n", benitez.toString());
		
		//11.Muestra el saldo de todas las cuentas y el número de cuentas embargadas
		System.out.println("\n11. Mostrando información de todas las cuentas...");
		for(int i=0;i<cuentas.length;i++)
		{
			if(cuentas[i] != null)
			{
				System.out.printf("Saldo cuenta %d: %.2f \n", i+1,cuentas[i].getSaldo());	
			}
		}
		System.out.printf("Saldo cuenta benítez: %.2f \nSaldo cuenta antonio: %.2f",
				benitez.getSaldo(), antonio.getSaldo());
		System.out.printf("\nNúmero de cuentas embargadas: %d", CuentaBancaria.getNumCuentasEmbargadas());
	}
	
	//1. Crea un método anyoAleatorio que genere un valor aleatorio entre 1850 y 1950
	//MÉTODO - Devuelve un valor aleatorio entre 1850 y 1950
	private static int anyoAleatorio()
	{
		return (int) (Math.random() * 100 + 1850);
	}
	
	//MÉTODO - Recoge una array de CuentaBancaria para devolver la cuenta con la fecha más reciente
	private static CuentaBancaria cuentaFechaMasReciente(CuentaBancaria[] cuentas)
	{
		CuentaBancaria cuentaFechaReciente = cuentas[0];
		for(int i=0; i<cuentas.length;i++)
		{
			if(cuentas[i] != null)
			{
				if(cuentas[i].getFechaCreacion() == CuentaBancaria.getFechaMasModerna())
				{
					cuentaFechaReciente = cuentas[i];
				}
			}
		}
		return cuentaFechaReciente;
	}
	
	//MÉTODO - Devuelve un objeto CuentaBancaria creado a partir de un año aleatorio
	private static CuentaBancaria cuentaAnyoAleatorio()
	{
		boolean cuentaCreada = false;
		CuentaBancaria cuenta = null;
		try
		{
			cuenta = new CuentaBancaria(CuentaBancaria.DEFAULT_SALDO, LocalDate.of(anyoAleatorio(), 1, 1), -50);
			cuentaCreada = true;
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s \n", ex.getMessage());
		}
		return cuenta;
	}
}
