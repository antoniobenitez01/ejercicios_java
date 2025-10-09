/** El objetivo de este ejercicio es crear variables de tipo
 * byte, short, entero, carácter, número decimal, número flotante y de cadena de caracteres.
 * 
 * Tras haber creado las variables y asignarles sus correspondientes valores, vamos a
 * imprimir los resultados con frases que indiquen que tipo de variable son.
 */
package ejercicio4;

public class Ejercicio4 
{

	public static void main(String[] args) 
	{
		//Creamos las variables y las inicializamos con sus valores correspondientes.
		
		byte a = 25;
		short b = 32767;
		int c = 2024;
		char d = 'x';
		double e = 3.1415926537;
		float f = 12.12345f;
		String g = "Lorem ipsum.";
		
		//Escribimos el valor de cada una de las variables en diferentes líneas.
		System.out.println("El valor de la variable de tipo byte (a) es: " + a
				+ "\n El valor de la variable de tipo short (b) es: " + b
				+ "\n El valor de la variable de tipo entero (c) es: " + c
				+ "\n El carácter de la variable de tipo carácter (d) es: " + d
				+ "\n El valor de la variable de tipo número decimal (e) es: " + e
				+ "\n El valor de la variable de tipo número flotante (f) es: " + f
				+ "\n Los caracteres de la variable de tipo cadena de caracteres son: " + g);

	}

}
