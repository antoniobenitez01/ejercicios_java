/*
 * Objetivo: Programa que hace uso de la Clase CuentaBancaria, realizando
 * una serie de operaciones con métodos de CuentaBancaria y LocalDate.
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha:  02/12/2024
 */
package ejercicio01;

import java.time.LocalDate;
import libtarea3.CuentaBancaria;

public class Ejercicio01 
{

	public static void main(String[] args) 
	{
		CuentaBancaria cuentaPrivada = null, cuentaConjunta= null, cuentaFamiliar = null, cuentaTest = null;
		LocalDate localDate = LocalDate.now();
		LocalDate cuentaPrivadaDate = LocalDate.of(2021, 7, 1),
				  cuentaConjuntaDate = LocalDate.of(2021, 7, 1);
		
		System.out.println("USANDO CUENTAS BANCARIAS"+"\n-------------------------" +
							"\nFecha actual: " + localDate + "\n" + "\nCreación de cuentas (constructores)"+
							"\n-----------------------------------");
		
		try
		{
			System.out.println("Intentando crear cuenta privada con una fecha no válida.");
			cuentaTest = new CuentaBancaria(1000, LocalDate.of(2027, 9, 1));
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf(excepcion1.getMessage()+"\n"+"\n");
		}
		
		try
		{
			System.out.println("Intentando crear cuenta privada con un saldo no válida.");
			cuentaTest = new CuentaBancaria(-200.00);
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf(excepcion1.getMessage()+"\n"+"\n");
		}
		
		try
		{
			System.out.println("Creando cuenta privada válida con un constructor con tres parámetros...");
			cuentaPrivada = new CuentaBancaria(1000.00, cuentaPrivadaDate, -200.00);
			System.out.printf("Cuenta privada creada: " + cuentaPrivada + "\n" + "\n");
			
			System.out.println("Creando cuenta conjunta válida con un constructor con dos parámetros...");
			cuentaConjunta = new CuentaBancaria(200.00, cuentaConjuntaDate);
			System.out.printf("Cuenta privada creada: " + cuentaPrivada + "\n" + "\n");
			
			System.out.println("Creando cuenta familiar válida con un constructor sin parámetros...");
			cuentaFamiliar = new CuentaBancaria();
			System.out.printf("Cuenta privada creada: " + cuentaPrivada + "\n" + "\n");
		}
		catch(IllegalArgumentException excepcion1)
		{
			System.out.printf(excepcion1.getMessage()+"\n"+"\n");
		}
		
		System.out.printf("Prueba de los getters de la cuenta privada:" + "\n-----------------------------" +
						  "\nId: " + cuentaPrivada.getId() +
						  "\nFecha de creación: " + cuentaPrivada.getFechaCreacion() +
						  "\nLímite de descubierto: %.2f" +
						  "\nEstá embargada: " + cuentaPrivada.isEmbargada() +
						  "\nEstá en  descubierto: " + cuentaPrivada.isDescubierta() +
						  "\nNúmero de días que lleva la cuenta abierta: " + cuentaPrivada.getDiasCuenta(), 
						  cuentaPrivada.getLimiteDescubierto());
		
		System.out.println("\n" + "\nRealización de operaciones sobre las cuentas"+"\n----------------------------------");
		
		try
		{
			System.out.println("Ingresamos 100 euros en la cuenta familiar...");
			cuentaFamiliar.ingresar(100.00);
			
			System.out.println("Extraemos 100 euros de la cuenta conjunta...");
			cuentaConjunta.extraer(100.00);
			
			System.out.println("Transferimos 1100 euros de la cuenta privada a la familiar...");
			cuentaPrivada.transferir(1100.00, cuentaFamiliar);
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.printf("\n" + excepcion1.getMessage());
		}catch(IllegalStateException excepcion2)
		{
			System.out.printf("\n" + excepcion2.getMessage());
		}
	
		System.out.printf("\nEstado final de las cuentas:" + "\n--------------------------:" +
						  "\nEstado final de la cuenta privada: " + cuentaPrivada +
						  "\nEstado final de la cuenta conjunta: " + cuentaConjunta +
						  "\nEstado final de la cuenta familiar: " + cuentaFamiliar);
	}
}
