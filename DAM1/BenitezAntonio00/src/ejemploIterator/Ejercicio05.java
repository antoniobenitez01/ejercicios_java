package ejemploIterator;

import java.util.LinkedList;

/** Ejercicio 5. Ordenación de especies de plantas (por nombre y longitud)
 * @author Profesor
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        
    	final int CANTIDAD_ESPECIES_PLANTAS = 5;
    	
        // Variables de entrada
        
        // Variables auxiliares
        
        // Variables de salida

        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        
        System.out.println("ORDENACIÓN DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");
        
        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        
        LinkedList<String> lista = new LinkedList<String>();
        
        for(int i=0; i<CANTIDAD_ESPECIES_PLANTAS; i++)
        {
        	String plantRand;
        	do
        	{
        		plantRand = Utilidades.especiePlantaAleatoria();
        	}while(lista.contains(plantRand));
        	lista.add(plantRand);
        }
        System.out.println("Contenido inicial de la lista: \n");
        int contador = 1;
        for(String i: lista)
        {
        	System.out.printf("%d. %s\n", contador, i);
        	contador++;
        }
        
        System.out.println("\nOrdenación de la lista por nombre (alfabético): \n");
        lista.sort(new ComparadorEspeciePlantaPorNombre());
        contador = 1;
        for(String i: lista)
        {
        	System.out.printf("%d. %s\n", contador, i);
        	contador++;
        }
        
        System.out.println("\nOrdenación de la lista por longitud: \n");
        lista.sort(new ComparadorEspeciePlantaPorLongitud());
        contador = 1;
        for(String i: lista)
        {
        	System.out.printf("%d. %s\n", contador, i);
        	contador++;
        }
    }
}