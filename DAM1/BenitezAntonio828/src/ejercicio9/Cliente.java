/*
 * Clase que representa un Cliente con sus telefonos y compras
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 20/03/2025
 */
package ejercicio9;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente 
{
	
// ATRIBUTOS ------------------------------------------------------------------------------------
	
	private String nombre;
	private String email;
	private ArrayList<String> telefonos;
	private HashMap<String, Integer> compras;
	
// CONSTRUCTORES --------------------------------------------------------------------------------
	
	//Constructor maestro (2 parámetros)
	public Cliente(String nombre, String email)
	{
		this.nombre = nombre;
		this.email = email;
		this.telefonos = new ArrayList<String>();
		this.compras = new HashMap<String,Integer>();
	}
	
// MÉTODOS --------------------------------------------------------------------------------------
	
	//ADD TELEFONO - Añade el telefono introducido por parámetro a la lista de teléfonos si no está registrado ya
	public void addTelefono(String telefono) throws IllegalArgumentException
	{
		if(this.telefonos.contains(telefono))
		{
			throw new IllegalArgumentException("El Cliente ya tiene registrado ese número.");
		}
		this.telefonos.add(telefono);
	}
	
	//GET TELEFONO - Recoge un índice y devuelve el teléfono que se encuentre en ese índice
	public String getTelefono(int index)
	{
		String resultado;
		try
		{
			resultado = this.telefonos.get(index);
		}catch(IndexOutOfBoundsException ex)
		{
			resultado = "";
		}
		return resultado;
	}
	
	//BUSCAR TELEFONO - Recoge una cadena y devuelve una lista de teléfonos que contengan esa cadena
	public ArrayList<String> buscarTelefono(String cadena)
	{
		ArrayList<String> resultado = new ArrayList<String>();
		for(String i:this.telefonos)
		{
			if(i.contains(cadena))
			{
				resultado.add(i);
			}
		}
		return resultado;
	}
	
	//ADD COMPRA - Recoge un nombre y cantidad de producto para añadirlo a la lista de compras del Cliente si no está registrado ya
	public void addCompra(String producto, int cantidad) throws IllegalArgumentException
	{
		if(this.compras.containsKey(producto))
		{
			throw new IllegalArgumentException("El Cliente ya tiene registrado ese producto");
		}
		this.compras.put(producto, cantidad);
	}
	
	//ELIMINAR PRODUCTO - Recoge un nombre de producto y lo elimina de la lista de compras del Cliente
	public void eliminarProducto(String producto) throws IllegalArgumentException
	{
		if(!this.compras.containsKey(producto))
		{
			throw new IllegalArgumentException("El Cliente no tiene ese producto registrado en sus compras");
		}
		this.compras.remove(producto);
	}
	
	//VER PRODUCTOS - Devuelve una lista de String con los nombres de los productos en la lista de compras del Cliente
	public ArrayList<String> verProductos() throws IllegalStateException
	{
		if(this.compras.isEmpty())
		{
			throw new IllegalStateException("El Cliente no tiene ninguna compra registrada.");
		}
		ArrayList<String> stringProductos = new ArrayList<String>();
		for(String i: this.compras.keySet())
		{
			stringProductos.add(i);
		}
		stringProductos.sort(null);
		return stringProductos;
	}
	
	//TOTAL UNIDADES - Devuelve el total de las unidades de la lista de compras del Cliente
	public int totalUnidades()
	{
		int total = 0;
		for(Integer i: this.compras.values())
		{
			total += i;
		}
		return total;
	}
	
	//TO STRING - Devuelve un objeto String con la información detallada del Cliente
	public String toString()
	{
		return String.format("Nombre: %s\nEmail: %s\nTeléfonos: %s\nCompras: %s",
				this.nombre, this.email, this.telefonos.toString(), this.compras.toString());
	}
}
