/*
 * Clase principal que hace uso de las clases creadas
 * Vehiculo, VehiculoTerrestre, VehiculoAcuatico, VehiculoAereo,
 * Avion, Barco, Coche, Moto, Barco y Submarino para
 * hace uso de sus métodos y de sus constructores
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/03/2025
 */
package vehiculo;

import java.time.LocalDate;

public class PrincipalVehiculo {

	public static void main(String[] args) {

	    //1. Crea un coche con los siguientes datos: 1212ABC, Fiesta, 01/01/2010, 4, AA (sí).
	    //    Evidencia: mostrar todos los datos del objeto.
		System.out.println("--- 1 ---");
		System.out.println("\n1. Creando objeto Coche 'coche1' ...\n");
		Coche coche1 = new Coche("1212ABC", "Fiesta", LocalDate.of(2010, 01, 01), (short) 4, true);
		System.out.println("Objeto Coche 'coche1' creado con éxito.");
		System.out.printf("%s\n\n", coche1.toString());
		
	    //2. Calcula el precio de 5 días.
	    //    Evidencia: mostrar el precio.
		System.out.println("--- 2 ---");
		System.out.println("\n2. Calculando alquiler de 5 días en coche1 ...\n");
		System.out.printf("Precio de 5 días en Coche 1: %.2f€\n\n", coche1.calcularAlquiler(5));
		
	    //3. Crea una moto con los siguientes datos: 1234ABC, Vespa, 01/01/2015, 2, Blanco.
	    //    Evidencia: mostrar todos los datos del objeto.
		System.out.println("--- 3 ---");
		System.out.println("\n3. Creando objeto Moto 'moto1' ...\n");
		Moto moto1;
		try
		{
			moto1 = new Moto("1234ABC", "Vespa", LocalDate.of(2015, 01, 01), (short) 2, "Blanco");
			System.out.println("Objeto Moto 'moto1' creado con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
			System.out.println("Se ha producido un error, creando Moto por defecto ...");
			moto1 = new Moto();
		}
		System.out.printf("%s\n\n", moto1.toString());
		
	    //4. Crea un barco con los siguientes datos: AAQQ, Mistral, 01/01/2000, 20, Motor (sí).
	    //    Evidencia: mostrar todos los datos del objeto.
		System.out.println("--- 4 ---");
		System.out.println("\n4. Creando objeto Barco 'barco1' ...\n");
		Barco barco1 = new Barco("AAQQ", "Mistral", LocalDate.of(2000, 01, 01), (short) 20, true);
		System.out.println("Objeto Barco 'barco1' creado con éxito.");
		System.out.printf("%s\n\n", barco1.toString());
		
	    //5. Calcula el precio de 5 días.
	    //    Evidencia: mostrar el precio.
		System.out.println("--- 5 ---");
		System.out.println("\n5. Calculando alquiler de 5 días en barco1 ...\n");
		System.out.printf("Precio de 5 días en Barco 1: %.2f€\n\n", barco1.calcularAlquiler(5));
		
	    //6. Crea un submarino con los siguientes datos: WQASDEF, BV100, 10, 30.
	    //    Evidencia: mostrar todos los datos del objeto.
		System.out.println("--- 6 ---");
		System.out.println("\n6. Creando objeto Submarino 'sub1' ...\n");
		Submarino sub1;
		try
		{
			sub1 = new Submarino("WQASDEF", "BV100", Vehiculo.FECHAFAB_DEFAULT, 10, 30);
			System.out.println("Objeto Submarino 'sub1' creado con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
			System.out.println("Se ha producido un error, creando Submarino por defecto ...");
			sub1 = new Submarino();
		}
		System.out.printf("%s\n\n", sub1.toString());
		
	    //7. Crea un avión con valores por defecto.
	    //    Evidencia: mostrar todos los datos del objeto.
		System.out.println("--- 7 ---");
		System.out.println("\n7. Creando objeto Avion 'avion1' con valores por defecto ...\n");
		Avion avion1 = new Avion();
		System.out.println("Objeto Avion 'avion1' creado con éxito.");
		System.out.printf("%s\n\n", avion1.toString());
		
	    //8. Calcula el precio de 5 días.
	    //    Evidencia: mostrar el precio.
		System.out.println("--- 8 ---");
		System.out.println("\n8. Calculando alquiler de 5 días de avion1 ...\n");
		System.out.printf("Precio de 5 días en Avión 1: %.2f€\n\n", avion1.calcularAlquiler(5));
		
		//9. Crea un helicóptero con valores por defecto.
	    //    Evidencia: mostrar todos los datos del objeto.
		System.out.println("--- 9 ---");
		System.out.println("\n9. Creando objeto Helicoptero 'hel1' ...\n");
		Helicoptero hel1;
		try
		{
			hel1 = new Helicoptero();
			System.out.println("Objeto Helicoptero 'hel1' creado con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
			System.out.println("Se ha producido un error, creando Helicoptero por defecto ...");
			hel1 = new Helicoptero();
		}
		System.out.printf("%s\n\n", hel1.toString());
	}

}
