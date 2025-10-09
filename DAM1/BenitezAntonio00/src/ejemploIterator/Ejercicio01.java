package ejemploIterator;

import java.util.HashSet;

/**
 * Ejercicio 1. Creando jardín botánico
 * @author Antonio Benítez Rodríguez
 * @date 24/03/2025
 */
public class Ejercicio01 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
    	
        final int CANTIDAD_ESPECIES_PLANTAS = 5;
        
        // Variables de entrada

        // Variables auxiliares
        
        // Variables de salida
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        // No hay, pues se usa un número fijo de elementos aleatorios
        
        System.out.println("CONJUNTOS DE ESPECIES DE PLANTAS");
        System.out.println("--------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Rellenamos los conjuntos con especies de plantas aleatorias hasta que haya CANTIDAD_ESPECIES_PLANTAS
        
        HashSet<String> conjunto1 = new HashSet<String>();
        HashSet<String> conjunto2 = new HashSet<String>();
        
        for(int i = 0; i<CANTIDAD_ESPECIES_PLANTAS; i++)
        {
        	conjunto1.add(Utilidades.especiePlantaAleatoria());
        	conjunto2.add(Utilidades.especiePlantaAleatoria());
        }
        
        // Unión de los dos conjuntos
        
        HashSet<String> union = new HashSet<String>();
        
        union.addAll(conjunto1);
        union.addAll(conjunto2);
        
        // Intersección de los conjuntos
        
        HashSet<String> interseccion = new HashSet<String>();
        
        interseccion.addAll(conjunto1);
        interseccion.retainAll(conjunto2);  
        
        // Diferencia de los conjuntos
        
        HashSet<String> diferencia = new HashSet<String>();
        
        diferencia.addAll(conjunto1);
        diferencia.removeAll(conjunto2);
        
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        
        // Recorremos el conjunto y mostramos su contenido por pantalla
        System.out.printf("Conjunto C1: %s\nConjunto C2: %s\nUnión C1 y C2: %s\nIntersección C1 y C2: %s\nDiferencia C1 y C2: %s\n",
        		conjunto1.toString(),conjunto2.toString(), union.toString(), interseccion.toString(),diferencia.toString());
    }
}