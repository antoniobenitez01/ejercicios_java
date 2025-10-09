/*
 * Objetivo: Modificar el código del EjercicioA4 para hacer uso
 * de los nuevos constructores de objetos Articulo.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 10/01/2025
 */
package ejercicioB4;

public class Main {

	public static void main(String[] args) 
	{
		//Declaración inicial de objetos Articulo
		Articulo articulo1, articulo2, articulo3, articulo4, articulo5;
		
		//Instanciación de objetos Articulo en bloques Try Catch para detectar errores
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
			articulo2 = new Articulo("Balón", -15.00, 12.5, 3); //ERROR: Precio negativo
			System.out.println("Artículo 2 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			System.out.println("Creando Artículo 3 ...");
			articulo3 = new Articulo("Balón", 25.65, -5, 3); //ERROR: IVA negativo
			System.out.println("Artículo 3 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			System.out.println("Creando Artículo 4 ...");
			articulo4 = new Articulo("Balón", 25.65, 55.25, 3); //ERROR: IVA mayor que tipo general
			System.out.println("Artículo 4 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		try
		{
			System.out.println("Creando Artículo 5 ...");
			articulo5 = new Articulo("Balón", 25.65, 12.5, -5); //ERROR: cuantosQuedan negativo
			System.out.println("Artículo 5 creado con éxito.");
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
	}
}
