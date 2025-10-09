package ejemploIterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class EjemploIterator 
{
	public static void main(String[] args) 
	{
        final int CANTIDAD_ESPECIES_PLANTAS = 10;
        
        LinkedList<String> lista1 = new LinkedList<String>();
        LinkedList<String> lista2 = new LinkedList<String>();
        
        for(int i = 0;i<CANTIDAD_ESPECIES_PLANTAS; i++)
        {
        	lista1.add(Utilidades.especiePlantaAleatoria());
        	lista2.add(Utilidades.especiePlantaAleatoria());
        }
        
        Iterator<String> it1 = lista1.iterator();
        Iterator<String> it2 = lista2.iterator();
        
        LinkedList<String> populares = new LinkedList<String>();
        LinkedList<Integer> posicionesPop = new LinkedList<Integer>();
        HashSet<String> especiesPop = new HashSet<String>();
        
        int contador = 0;
        
        while(it1.hasNext() && it2.hasNext())
        {
        	String obj1 = it1.next();
        	String obj2 = it2.next();
        	
        	if(obj1.equals(obj2))
        	{
        		populares.add(obj1);
        		posicionesPop.add(contador + 1);
        		especiesPop.add(obj1);
        		
        		lista1.set(contador, String.format("*%s*", obj1));
        		lista2.set(contador, String.format("*%s*", obj2));
        	}
        	contador++;
        }
        
        System.out.printf("\n1. Contenido final de la lista 1: %s"
        		+ "\n2. Contenido final de la lista 2: %s"
        		+ "\n3. Contenido final de la lista de especies de plantas populares: %s"
        		+ "\n4. Contenido final de la lista de posiciones populares: %s"
        		+ "\n5. Contenido final del conjunto de especies de plantas populares: %s",
        		lista1.toString(), lista2.toString(), populares.toString(), posicionesPop.toString(), especiesPop.toString());
	}
}
