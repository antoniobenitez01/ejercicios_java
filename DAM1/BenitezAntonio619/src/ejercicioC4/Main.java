/*
 * Objetivo: Modificar el código del EjercicioB4 para hacer uso
 * de los nuevos métodos getters y setters.
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/01/2025
 */
package ejercicioC4;

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
	}
}
