/*
 * Objetivo: Hacer uso de la clase creada Bombilla y
 * utilizar sus constructores y métodos.
 * Excepciones: IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 20/01/2025
 */
package claseBombilla;

public class MainBombilla 
{

	public static void main(String[] args) 
	{
		//1.Muestre la cantidad de bombillas creadas hasta el momento mediante el uso de método getBombillasCreadas;
		System.out.printf("1. Bombilla creadas hasta el momento: %d \n", Bombilla.getBombillasCreadas());
		
		//2.Muestre la cantidad de bombillas encendidas en este momento mediante el uso de método getBombillasEncendidas;
		System.out.printf("\n2. Bombillas encendidas en este momento: %d \n", Bombilla.getBombillasEncendidas());
		
		//3.Declare dos variables b1, b2 y b3 de tipo referencia a la clase Bombilla;
		System.out.println("\n3. Creando variables de referencia Bombilla b1, b2 y b3...");
		Bombilla b1,b2,b3;
		
		/*4.Instancie una primera bombilla, se asigne su referencia a la variable b1 usando el 
		 * constructor sin parámetros y se muestre su estado usando el método getEstado;*/
		System.out.println("\n4. Instanciando bombilla1...");
		b1 = new Bombilla();
		System.out.println("Bombilla1 instanciada con éxito.");
		System.out.printf("Estado de la primera bombilla: %s \n", b1.getEncendida() ? "encendida" : "apagada");
		
		/*5.Instancie una segunda bombilla encendida, se asigne su referencia a la variable b2 usando 
		 * el constructor con párametros y se muestre su estado usando el método toString;*/
		System.out.println("\n5. Instanciando bombilla2...");
		b2 = new Bombilla(true);
		System.out.println("Bombilla2 instanciada con éxito.");
		System.out.println(b2.toString());
		
		/*6.Para esta segunda bombilla , realice las siguientes acciones 
		 * (tras cada acción se mostrará su estado mediante el método toString):
		 * - se conmuta su estado tres veces seguidas mediante un bucle for
		 * - se enciende dos veces seguidas
		 * - se apaga una vez
		 * - se vuelve a encender*/
		System.out.println("\n6. Bucle FOR, conmutando bombilla2 3 veces...");
		for(int i=0; i<3; i++)
		{
			b2.conmutar();
		}
		System.out.println("Bombilla2 conmutada 3 veces con éxito.");
		System.out.println(b2.toString());
		
		try //EXCEPCIÓN - IllegalStateException - Tratamos las excepciones del estado de la bombilla
		{
			System.out.println("\nEncendiendo bombilla 2...");
			b2.encender();
			System.out.println("Bombilla2 encendida con éxito.");
			System.out.println("Encendiendo bombilla 2...");
			b2.encender();
			System.out.println("Bombilla2 encendida con éxito.");
		}catch(IllegalStateException ex)
		{
			System.out.println(ex);
		}
		System.out.println(b2.toString());
		
		try //EXCEPCIÓN - IllegalStateException - Tratamos las excepciones del estado de la bombilla
		{
			System.out.println("\nApagando bombilla2...");
			b2.apagar();
			System.out.println("Bombilla2 apagada con éxito.");
			System.out.println(b2.toString());
			
			System.out.println("\nEncendiendo bombilla2...");
			b2.encender();
			System.out.println("Bombilla2 encendida con éxito.");
			System.out.println(b2.toString());
		}catch(IllegalStateException ex)
		{
			System.out.println(ex);
		}
		
		/*7.Instancie una tercera bombilla encendida, se asigne su referencia a 
		 * la variable b3 usando el constructor con párametros y se muestre su estado usando el método toString*/
		System.out.println("\n7. Instanciando bombilla3...");
		b3 = new Bombilla(false);
		System.out.println("Bombilla3 instanciada con éxito.");
		System.out.println(b3.toString());
		
		//8.Muestre la cantidad de bombillas creadas hasta este momento mediante el uso de método getBombillasCreadas;
		System.out.printf("\n8. Bombilla creadas hasta el momento: %d \n", Bombilla.getBombillasCreadas());
		
		//9.Muestre la cantidad de bombillas encendidas en este momento mediante el uso de método getBombillasEncendidas;
		System.out.printf("\n9. Bombillas encendidas en este momento: %d \n", Bombilla.getBombillasEncendidas());
	}

}
