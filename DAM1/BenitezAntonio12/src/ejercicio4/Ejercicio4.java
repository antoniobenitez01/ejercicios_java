/*
 * Objetivo: Programa que recoge un tipo enumerado
 * y crea cuatro variables para luego mostrarlas
 * por la consola con su texto correspondiente.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 02/10/2024
 */
package ejercicio4;

public class Ejercicio4 
{
	//Creación de tipo enumerado
	public enum Tamanyos {PEQUEÑA, MEDIANA, GRANDE, EXTRAGRANDE};

	public static void main(String[] args) 
	{
		
		//Inicialización variables Tamaños
		Tamanyos tamanyoPequenyo = Tamanyos.PEQUEÑA;
		Tamanyos tamanyoMediano = Tamanyos.MEDIANA;
		Tamanyos tamanyoGrande = Tamanyos.GRANDE;
		Tamanyos tamanyoExtraGrande = Tamanyos.EXTRAGRANDE;
		
		//Texto por consola
		System.out.println("La talla S es la talla " + tamanyoPequenyo
					   +"\n La talla M es la talla " + tamanyoMediano
					   +"\n La talla L es la talla " + tamanyoGrande
					   +"\n La talla XL es la talla " + tamanyoExtraGrande);
	}

}
