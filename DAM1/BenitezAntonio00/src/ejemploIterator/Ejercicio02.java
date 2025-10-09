package ejemploIterator;

import java.util.HashSet;
import java.util.LinkedList;

/** Ejercicio 2. Búsqueda de especies de plantas populares
 * @author Antonio Benítez Rodríguez
 * @date 24/03/2025
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
    	
    	final int CANTIDAD_ESPECIES_PLANTAS = 10;
        
        // Variables de entrada
        
        // Variables auxiliares
       
        // Variables de salida

        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        System.out.println("BÚSQUEDA DE ESPECIES DE PLANTAS POPULARES");
        System.out.println("-----------------------------------------");
        
        
        // No hay, pues se usa un número fijo de elementos aleatorios

        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_ESPECIES_PLANTAS
        
        LinkedList<String> lista1 = new LinkedList<String>();
        LinkedList<String> lista2 = new LinkedList<String>();
        
        for(int i = 0;i<CANTIDAD_ESPECIES_PLANTAS; i++)
        {
        	lista1.add(Utilidades.especiePlantaAleatoria());
        	lista2.add(Utilidades.especiePlantaAleatoria());
        }
        
        System.out.printf("1. Contenido inicial de la lista 1: %s\n2. Contenido inicial de la lista 2: %s\n",
        		lista1.toString(), lista2.toString());
        
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------


        // Recorremos a la vez las dos listas
        
        LinkedList<String> populares = new LinkedList<String>();
        LinkedList<Integer> posicionesPop = new LinkedList<Integer>();
        HashSet<String> especiesPop = new HashSet<String>();
   
        for(int i=0; i<CANTIDAD_ESPECIES_PLANTAS; i++)
        {
        	if(lista1.get(i).equals(lista2.get(i)))
        	{
        		populares.add(lista1.get(i));
        		posicionesPop.add(i + 1);
        		especiesPop.add(lista1.get(i));
        		
        		lista1.set(i, String.format("*%s*", lista1.get(i)));
        		lista2.set(i, String.format("*%s*", lista2.get(i)));
        	}
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.printf("\n1. Contenido final de la lista 1: %s"
        		+ "\n2. Contenido final de la lista 2: %s"
        		+ "\n3. Contenido final de la lista de especies de plantas populares: %s"
        		+ "\n4. Contenido final de la lista de posiciones populares: %s"
        		+ "\n5. Contenido final del conjunto de especies de plantas populares: %s",
        		lista1.toString(), lista2.toString(), populares.toString(), posicionesPop.toString(), especiesPop.toString());
    }
}