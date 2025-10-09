/*
 * Objetivo: Modificar el código del EjercicioA4 para hacer uso
 * de los nuevos constructores de objetos Articulo.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 10/01/2025
 */
package ejercicioD4;

public class Main {

	public static void main(String[] args) 
	{
		//Declaración inicial de objetos Articulo
		Articulo articulo1 = null, articulo2 = null;
		
		//INSTANCIACION EN BLOQUES TRY-CATCH ===============================================
		try
		{
			System.out.println("Creando Artículo 1 ...");
			articulo1 = new Articulo("Balón", 25.65, 12.5, 3);
			System.out.println("Artículo 1 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			System.out.println("Creando Artículo 2 ...");
			articulo2 = new Articulo("", 15.00, 12.5, 3); //ERROR: Nombre vacío
			System.out.println("Artículo 2 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			System.out.println("Creando Artículo 2 ...");
			articulo2 = new Articulo("Balón", -15.00, 12.5, 3); //ERROR: Precio negativo
			System.out.println("Artículo 2 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			System.out.println("Creando Artículo 2 ...");
			articulo2 = new Articulo("Balón", 25.65, -5, 3); //ERROR: IVA negativo
			System.out.println("Artículo 3 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			System.out.println("Creando Artículo 2 ...");
			articulo2 = new Articulo("Balón", 25.65, 55.25, 3); //ERROR: IVA mayor que tipo general
			System.out.println("Artículo 4 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			System.out.println("Creando Artículo 2 ...");
			articulo2 = new Articulo("Balón", 25.65, 12.5, -5); //ERROR: cuantosQuedan negativo
			System.out.println("Artículo 5 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		//MODIFICACIÓN DE VALORES MEDIANTE MÉTODOS SET ===============================================
		
		try
		{
			articulo1.setNombre(""); //ERROR: Nombre vacío
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			articulo1.setPrecio(-5); //ERROR: Precio negativo
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			articulo1.setIva(-5); //ERROR: IVA negativo
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			articulo1.setIva(50); //ERROR: IVA mayor que tipo general
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			articulo1.setCuantosQuedan(-5); //ERROR: cuantosQuedan negativo
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		//USO DE MÉTODOS =============
		
		System.out.println("\n==== USO DE MÉTODOS ====");
		
		System.out.println("\nUtilizando método 'imprimir'...");
		articulo1.imprimir();
		
		System.out.println("\n\nUtilizando método 'getPVP'...");
		System.out.printf("PVP de %s: %.2f",articulo1.getNombre(), articulo1.getPVP());
		
		System.out.println("\n\nUtilizando método 'getPVPDescuento'...");
		System.out.printf("PVP de %s con un descuento de 25%%: %.2f \n", articulo1.getNombre(), articulo1.getPVPDescuento(25));
		
		System.out.println("\nUtilizando método 'vender'...");
		if(articulo1.vender(50))
		{
			System.out.println("El artículo " + articulo1.getNombre() + " se puede vender 50 veces.\n");
			articulo1.imprimir();
		}
		else
		{
			System.out.println("El artículo " + articulo1.getNombre() + " no se puede vender 50 veces. \n");
			articulo1.imprimir();
		}
		
		System.out.println("\n\nUtilizando método 'almacenar'...");
		if(articulo1.almacenar(50))
		{
			System.out.println("El artículo " + articulo1.getNombre() + " se puede almacenar 50 veces.\n");
			articulo1.imprimir();
		}
		else
		{
			System.out.println("El artículo " + articulo1.getNombre() + " no se puede almacenar 50 veces.\n");
			articulo1.imprimir();
		}
	}
}
