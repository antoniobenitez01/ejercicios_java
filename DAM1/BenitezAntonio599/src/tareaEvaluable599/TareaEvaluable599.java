/*
 * Objetivo: Hacer uso de la clase Teatro para
 * crear objetos Teatro y realizar diferentes
 * operaciones sobre ellos.
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/01/2025
 */
package tareaEvaluable599;

import libtarea3.Teatro;

public class TareaEvaluable599 {

	public static void main(String[] args) 
	{
		
		System.out.println("------------------------------"+
						"\n|        CLASE TEATRO         |"+
						"\n------------------------------");
		//2.- Declarar tres variables referencia a objetos instancia de la clase Teatro.
		Teatro teatro1 = null, teatro2 = null, teatro3 = null;
		
		//3.- Instanciar cada una de las tres variables con un valor proporcionado por aforoAleatorio.
		try
		{
			System.out.println("\n=== APARTADO 3 ===\n");
			System.out.println("Creando Teatro 1...");
			teatro1 = new Teatro("Merlín", aforoAleatorio());
			System.out.println("Creado con éxito.\n");
			
			System.out.println("Creando Teatro 2...");
			teatro2 = new Teatro("Rubí", aforoAleatorio());
			System.out.println("Creado con éxito.\n");
			
			System.out.println("Creando Teatro 3...");
			teatro3 = new Teatro("Estrella", aforoAleatorio());
			System.out.println("Creado con éxito.\n");
			
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		/*4.- Mostrar el nombre y el aforo de los teatros creados o el mensaje correspondiente
		en caso de que no se hayan creado.*/
		System.out.println("\n=== APARTADO 4 ===\n"+
						"\nMostrando objetos Teatro...\n");
		System.out.println(teatro1.toString()+"\n"+teatro2.toString()+"\n"+teatro3.toString());
		
		/*5.- Obtener el número de entradas vendidas en todos los teatros y para todas las
		obras que se han representado hasta el momento utilizando la herramienta de E/S
		System.out.printf.*/
		System.out.println("\n=== APARTADO 5 ===\n");
		System.out.printf("Número de entradas vendidas en total: %d entradas\n", Teatro.getEntradasVendidasTotales());
		
		/*6.- Declarar e instanciar un teatro por defecto. El identi�cador de la variable
		referencia a ese teatro será tu primer apellido.*/
		Teatro benitez = new Teatro();
		
		//7.- Terminar de representar una obra en el teatro del apartado anterior.
		try
		{
			benitez.terminarObra();
		}catch(IllegalStateException excepcion1)
		{
			System.out.println(excepcion1);
		}
		
		/*8.- Asignar la obra "El Rey León" al teatro declarado en el apartado 6. Una vez
		asignada la obra, deberás llenar el teatro, mostrando a continuación el número de
		entradas vendidas*/
		System.out.println("\n=== APARTADO 8 ===\n");
		System.out.println("Asignando Obra 'El Rey León' al Teatro por defecto...");
		benitez.asignarObra("El Rey León");
		System.out.println("Llenando Teatro por defecto...");
		benitez.llenarTeatro();
		System.out.printf("Número de entradas vendidas: %d entradas\n", benitez.getEntradasVendidas());
		
		/*9.- Devolver 50 entradas del teatro declarado en el apartado 6. Mostrar las entradas
		vendidas de la obra que se representa en el teatro del apartado 6.*/
		System.out.println("\n=== APARTADO 9 ===\n");
		System.out.println("Devolviendo 50 entradas del Teatro por defecto...");
		benitez.devolverEntradas(50);
		System.out.printf("Número de entradas vendidas: %d entradas\n", benitez.getEntradasVendidas());
		
		/*10.- Mostrar la siguiente información:
				10.1.- número de teatros creados hasta el momento.
				10.2.- número de obras que se están representando en este momento en todos los teatros.*/
		
		System.out.println("\n=== APARTADO 10 ===\n");
		System.out.printf("Número de Teatros creados: %d"+
						"\nNúmero de obras activas: %d",
						Teatro.getTeatrosTotales(), Teatro.getObrasActivas());
	}
	
	//1.- Implementar el método aforoAleatorio que devuelva valores entre 750 y 850.
	//MÉTODO - Devuelve un número entero aleatorio entre 750 y 850
	public static int aforoAleatorio()
	{
		int aforo = (int) ((Math.random()*100)+750);
		return aforo;
	}
}
