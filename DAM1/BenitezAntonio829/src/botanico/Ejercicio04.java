package botanico;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/** Ejercicio 4. Clasificación de especies de plantas coincidentes 
 * (con el mismo nombre y en la misma posición)
 * @author Antonio Benítez Rodríguez
 * @date 24/03/2025
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        // Constantes
        
        final int CANTIDAD_ESPECIES_PLANTAS = 20;
    	
        // Variables de entrada
        
        // Variables auxiliares
        
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");

        
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        
        LinkedList<String> lista1 = new LinkedList<String>();
        LinkedList<String> lista2 = new LinkedList<String>();
        
        for(int i=0; i<CANTIDAD_ESPECIES_PLANTAS; i++)
        {
        	lista1.add(Utilidades.especiePlantaAleatoria());
        	lista2.add(Utilidades.especiePlantaAleatoria());
        }
        
        HashMap<String, LinkedList<Integer>> mapa = new HashMap<String, LinkedList<Integer>>();
        
        for(int i=0; i<CANTIDAD_ESPECIES_PLANTAS; i++)
        {
        	if(lista1.get(i).equals(lista2.get(i)))
        	{
        		if(!mapa.containsKey(lista1.get(i)))
        		{
        			mapa.put(lista1.get(i), new LinkedList<Integer>());
        			mapa.get(lista1.get(i)).add(i);
        		}else
        		{
        			mapa.get(lista1.get(i)).add(i);
        		}
        	}
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        
        System.out.printf("Contenido inicial de la lista de especies de plantas 1:"
        		+ "\n%s"
        		+ "\nContenido inicial de la lista de especies de plantas 2:"
        		+ "\n%s"
        		+ "\n"
        		+ "\nClasificación de coincidencias:"
        		+ "\n%s\n",lista1.toString(), lista2.toString(), mapa.toString());

    }
}