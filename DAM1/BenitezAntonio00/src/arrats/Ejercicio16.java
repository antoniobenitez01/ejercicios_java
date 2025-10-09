/*
 * Crea un programa que cree un array de enteros e introduzca la siguiente secuencia de
 * valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10 diez veces, y luego la
 * muestre por pantalla usando el método Arrays.fill().
 */
package arrats;
import java.util.Arrays;

public class Ejercicio16
{
	public static void main (String args[]) {
		int vectorNumeros[]=new int [55];
		
		int longitud=vectorNumeros.length;
		
		int inicio=0, fin=0;
		
		for( int i=1;i<11;i++) {
			
			fin=inicio+i;//Calculamos la primera posición que indicaremos en la funcion Arrays.fill
			
			Arrays.fill(vectorNumeros,inicio,fin,i);//Utilizamos la funcion Arrays.fill para ir dando valores  a las posiciones
			
			inicio=fin; //Le damos ese valor a inicio para que los valores vayan aumentando y se pueda realizar la secuencia
		}
		
		for( int i=0;i<longitud;i++) { //Imprimimos por pantalla los valores del array
			System.out.println(vectorNumeros[i]);
		}
	}

}
