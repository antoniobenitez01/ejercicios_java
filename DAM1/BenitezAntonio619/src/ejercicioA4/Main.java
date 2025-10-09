/*
 * Objetivo: Hacer uso de la clase Articulo que hemos creado
 * para crear objetos, modificar sus atributos y mostrarlos por pantalla
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 07/01/2025
 */
package ejercicioA4;

public class Main {

	public static void main(String[] args) 
	{
		Articulo articulo = new Articulo();
		double pvp;
		
		//Declaración valores iniciales de atributos
		articulo.nombre = "Balón";
		articulo.precio = 50.64;
		articulo.cuantosQuedan = 5;
		pvp = articulo.precio * (Articulo.IVA / 100); //Cálculo PVP, multiplicamos el precio por el IVA dividido entre 100
		//Muestra valores iniciales de atributos
		System.out.println("= PRECIO INICIAL =");
		System.out.printf(articulo.nombre + " - Precio: %.01f€ - IVA: %1.0f%% - PVP: %.01f€", articulo.precio, Articulo.IVA, pvp);
		//Modificación de valores de atributos
		articulo.precio = 80.45;
		pvp = articulo.precio * (Articulo.IVA / 100); //Cálculo PVP, multiplicamos el precio por el IVA dividido entre 100
		//Muestra de valores de atributos modificados
		System.out.println("\n\n= PRECIO MODIFICADO =");
		System.out.printf(articulo.nombre + " - Precio: %.01f€ - IVA: %1.0f%% - PVP: %.01f€", articulo.precio, Articulo.IVA, pvp);
	}
}
