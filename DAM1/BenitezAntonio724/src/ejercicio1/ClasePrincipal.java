/*
 * Clase Main donde hacemos uso de las clases creadas
 * Humano y Ciudadano, utilizando sus constructores y métodos.
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025
 */
package ejercicio1;

public class ClasePrincipal 
{

	public static void main(String[] args) 
	{
		//Esta clase nos servirá para poder poner a prueba las clases anteriores.
		
		/*Crearemos tres objetos, un objeto de la clase Humano y otros dos de la clase
		Ciudadano. Al crearlos usaremos el constructor para darle valores en la propia creación.*/
		Humano humano = new Humano("Jorge", "Martínez");
		Ciudadano ciudadano1 = new Ciudadano("María", "Pérez", "Pasaporte"), 
				ciudadano2 = new Ciudadano("Álvaro", "Jiménez", "NIF");
		
		//Haremos uso del método nombreCompleto en cada uno de los objetos.
		System.out.println("\n=== USO DE MÉTODO NOMBRECOMPLETO ===\n");
		System.out.printf("· Humano: %s\n", humano.getNombreCompleto());
		System.out.printf("· Ciudadano 1: %s\n", ciudadano1.identificacion());
		System.out.printf("· Ciudadano 2: %s\n", ciudadano2.identificacion());
		
		/*Crearemos un objeto de la clase Humano con el constructor sin parámetros y
		solicitaremos los datos necesarios al usuario y modificaremos los valores de los atributos.
		
		Mostraremos un informe en el que se vea claramente la información del objeto
		después de la creación y después de la modificación de los atributos del objeto.*/
		Humano humano2 = new Humano();
		
		System.out.printf("\n=== HUMANO 2 ===\n"
				+ "\n - Nombre: %s"
				+ "\n - Apellidos: %s\n",
				humano2.nombre,humano2.apellidos);
		System.out.println("\nModificando valores de atributos...");
		humano2.nombre = "Pepito";
		humano2.apellidos = "Moreno";
		System.out.printf("\n=== HUMANO 2 ===\n"
				+ "\n - Nombre: %s"
				+ "\n - Apellidos: %s\n",
				humano2.nombre,humano2.apellidos);
	}
}
