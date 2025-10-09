package botanico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/** Ejercicio 3. Calendario de especies de plantas
 * @author Antonio Benítez Rodríguez
 * @date 24/03/2025
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
    	
        final int DIAS_SEMANA = 7;
        
        // Variables de entrada
        
        // Variables auxiliares
        
        // Variables de salida
        

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        
        System.out.println("CALENDARIO DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");
        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        HashMap<LocalDate, String> calendario = new HashMap<LocalDate, String>();
        
        for(int i=0; i<DIAS_SEMANA; i++)
        {
        	String random = Utilidades.especiePlantaAleatoria();
        	boolean done = false;
        	do
        	{
        		if(calendario.containsValue(random))
        		{
        			random = Utilidades.especiePlantaAleatoria();
        		}else
        		{
        			calendario.put(LocalDate.now().plusDays(i), random);
        			done = true;
        		}
        	}while(done == false);
        }
   
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        
        for(LocalDate i : calendario.keySet())
        {
        	System.out.printf("Fecha %s: %s\n", dateFormat(i), calendario.get(i));
        }
    }
    
	//DATE FORMAT - Introduce un objeto LocalDate por parámetro y lo devuelve formateado como un String
	protected static String dateFormat(LocalDate date)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formato);
	}
}