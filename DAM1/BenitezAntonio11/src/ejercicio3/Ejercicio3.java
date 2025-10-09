/**El objetivo de este ejercicio es crear
 * dos variables de número entero ("num1"y "num2")
 * dos variables de número decimal ("val1" y "val2")
 * y dos variables de cadena de caracteres ("nombre" y "apellidos")
 * 
 * Tras declarar las variables, mostraremos por pantalla
 * los dos números, los dos valores y el nombre y apellidos.
 */
package ejercicio3;

public class Ejercicio3 
{

	public static void main(String[] args) 
	{
		//Creamos las variables y las inicializamos con sus valores correspondientes (a excepción de val1 y val2).
		
		int num1 = 0, num2 = 0;
		double val1, val2;
		String nombre = "Antonio", apellidos = "Benítez Rodríguez";
		
		//Asignamos un valor cualquiera a las variables val1 y val2.
		
		val1 = 5.50;
		val2 = 2.50;

		//Mostramos por pantalla los números, los valores y el nombre y apellidos.
		System.out.println("El primer número es " + num1 + " y el segundo número es " + num2
				+ "\n El primer valor es " + val1 + " y el segundo valor es " + val2
				+ "\n Mi nombre es " + nombre + " y mis apellidos son " + apellidos);
	}

}
