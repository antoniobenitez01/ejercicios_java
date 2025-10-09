package operLinkedList;

import java.util.LinkedList;

import common.ComparatorNotas;
import common.Notas;
import common.UtilidadesList;

public class Main 
{
	public static void main(String[] args) 
	{
		/*1. Importa los registros contenidos en el documento notas1.txt, donde la información tiene el
		siguiente formato: grupo;nombre,matemáticas;lengua;física;química;inglés*/
		
		System.out.println("1. Añadiendo registros de notas1.txt a la lista ...\n");
		LinkedList<Notas> registros = UtilidadesList.importarDatosLinkedList("notas1.txt");
		
		//2. Muestra el número de registros que contiene.
		
		System.out.printf("2. Números de registros añadidos a la lista: %d\n", registros.size());
		
		//3. Ordena los registros por grupo y nombre.
		
		System.out.println("\n3. Ordenamos la lista por grupo y nombre ..."
				+ "\nGuardamos la lista ordenada en: LinkedList3.txt\n");
		registros.sort(new ComparatorNotas());
		UtilidadesList.exportarLista(registros, "LinkedList3.txt");
		
		/*4. Añade el registro abajo indicado en la mitad de la lista.
		1º ESO A;Plaza Gallego, Juan;1;1;3;1;1*/
		
		System.out.println("4. Añadimos un registro en mitad de la lista ...\n");
		Notas insertado = new Notas("1º ESO A","Plaza Gallego, Juan",1,1,3,1,1);
		registros.add((int) (registros.size() / 2), insertado);
		System.out.printf("Número de registros: %d"
				+ "\nPosición del nuevo registro: %d\n\n",
				registros.size(),registros.indexOf(insertado));
		
		//5. Añade el mismo registro al principio de la lista.
		
		System.out.println("5. Añadimos el registro ...\n");
		registros.addFirst(insertado);
		
		System.out.printf("Número de registros: %d"
				+ "\nPosición del nuevo registro: %d\n\n",
				registros.size(),registros.indexOf(insertado));
		
		//6. Importa los registros contenidos en el documento notas2.txt en una lista auxiliar.
		
		System.out.println("6. Añadiendo registros de notas2.txt a la lista mediante una lista auxiliar ...");
		LinkedList<Notas> auxiliar = UtilidadesList.importarDatosLinkedList("notas2.txt");
		
		System.out.printf("Total registros antes de añadir: %d"
				+ "\nTotal registros de la lista auxiliar: %d\n\n",
				registros.size(), auxiliar.size());
		
		//7. Añade la lista auxiliar al principio de la lista original.
		
		System.out.println("7. Añade la lista auxiliar al principio de la lista original ...");
		registros.addAll(0, auxiliar);
		
		System.out.printf("Total registros después de añadir: %d"
				+ "\nGuardamos la lista completa en: LinkedList7.txt\n\n", registros.size());
		UtilidadesList.exportarLista(registros,"LinkedList7.txt");
		
		//8. Muestra el registro que está en la primera posición de la lista.
		
		System.out.println("8. Muestra el registro que está en la primera posición de la lista ...");
		System.out.printf("%s\n\n", registros.getFirst().toString());
		
		//9. Muestra el registro que está en la última posición posición de la lista.
		
		System.out.println("9. Muestra el registro que está en la última posición de la lista ...");
		System.out.printf("%s\n\n", registros.getLast().toString());
		
		//10. Muestra el registro que está en la mitad de la lista.
		
		System.out.println("10. Muestra el registro que está en mitad de la lista ...");
		System.out.printf("%s\n\n", registros.get((int) (registros.size() / 2)).toString());
		
		//11. ¿Qué posición ocupa la primera ocurrencia del registro insertado?
		
		System.out.printf("11. ¿Qué posición ocupa la primera ocurrencia del registro insertado?"
				+ "\n%d\n\n", registros.indexOf(insertado));
				
		//12. Qué posición ocupa la última ocurrencia del registro insertado?
		
		System.out.printf("12. ¿Qué posición ocupa la última ocurrencia del registro insertado?"
				+ "\n%d\n\n", registros.lastIndexOf(insertado));
				
		//13. ¿El siguiente registro está en la lista? 1º ESO E;Postigo Vázquez, Salvador;3;6;5;3;4
		
		System.out.println("13. ¿El siguiente registro está en la lista? 1º ESO E;Postigo Vázquez, Salvador;3;6;5;3;4 ...");
		Notas salvador = new Notas("1º ESO E","Postigo Vázquez, Salvador",3,6,5,3,4);
		if(registros.contains(salvador))
		{
			System.out.printf("%s\n", registros.get(registros.indexOf(salvador)).toString());
		}else
		{
			System.out.println("Registro no encontrado.");
		}
		
		//14. ¿Y éste? 1º ESO A;García Fernández, María;6;5;6;5;5
		
		System.out.println("\n14. ¿El siguiente registro está en la lista? 1º ESO A;García Fernández, María;6;5;6;5;5 ...");
		Notas maria = new Notas("1º ESO A","García Fernández, María",6,5,6,5,5);
		if(registros.contains(maria))
		{
			System.out.printf("%s\n", registros.get(registros.indexOf(maria)).toString());
		}else
		{
			System.out.println("Registro no encontrado.");
		}
		
		//15. Elimina la primera ocurrencia del registro insertado y muestra su posición y contenido.
		
		System.out.println("\n15. Elimina la primera ocurrencia del registro insertado y muestra su posición y contenido ...");
		
		System.out.printf("Primera ocurrencia: Posición: %d Registro: %s\n",
				registros.indexOf(insertado),registros.get(registros.indexOf(insertado)));
		
		System.out.println("Borramos el registro ...");
		registros.remove(registros.indexOf(insertado));
		
		System.out.printf("Primera ocurrencia: Posición: %d Registro: %s\n",
				registros.indexOf(insertado),registros.get(registros.indexOf(insertado)));
		
		//16. Elimina el registro que ocupa la posición media de la lista mostrando su contenido.
		
		System.out.println("\n16. Elimina el registro que ocupa la posición media de la lista mostrando su contenido ...");
		int posicionMitad = (int) (registros.size() / 2);
		System.out.printf("Registro en la mitad %s\n", registros.get(posicionMitad));
		
		System.out.println("Borramos el registro ...");
		registros.remove(posicionMitad);
		
		System.out.printf("Nuevo registro en la posicion %s\n", registros.get(posicionMitad));
		
		//17. Elimina el registro cuyo nombre es: Carrillo Segura, Félix, indicando su posición y contenido.
		
		System.out.println("\n17. Elimina el registro de Carrillo Segura, Félix ...");
		Notas encontrado;
		try
		{
			encontrado = UtilidadesList.buscarNombre(registros, "Carrillo Segura, Félix");
			System.out.printf("Posición: %d Registro: %s\n", 
					registros.indexOf(encontrado), registros.get(registros.indexOf(encontrado)));
			registros.remove(encontrado);
		}catch(NullPointerException e)
		{
			System.out.printf("%s\n", e.getMessage());
		}
		
		//18. Elimina el registro cuyo nombre es: Robles Ortiz, Rafael, indicando su posición y contenido.
		
		System.out.println("\n18. Elimina el registro de Roblex Ortiz, Rafael ...");
		try
		{
			encontrado = UtilidadesList.buscarNombre(registros, "Carillo Segura, Félix");
		}catch(NullPointerException e)
		{
			System.out.printf("%s\n", e.getMessage());
		}
		
		//19. Intenta simular una pila con la lista original. Realiza dos inserciones y extracciones detallando su funcionamiento.
		
		System.out.println("\n19. Simular FIFO");
		
		Notas fifo;
		
		System.out.println("Insercción 1:");
		fifo = new Notas("1º ESO A","López Rivero, José",6,5,6,5,5);
		registros.push(fifo);
		System.out.printf("Registro añadido. Posición: %d. %s\n",
				registros.indexOf(fifo), registros.get(0).toString());
		
		System.out.println("Insercción 2:");
		fifo = new Notas("1º ESO A","Pérez García, Elena",4,8,6,3,5);
		registros.push(fifo);
		System.out.printf("Registro añadido. Posición: %d. %s\n",
				registros.indexOf(fifo), registros.get(0).toString());
		
		System.out.println("Extracción 1:");
		System.out.printf("Registro extraído: %s\n", registros.pop().toString());
		
		System.out.println("Extracción 2:");
		System.out.printf("Registro extraído: %s\n", registros.pop().toString());
		
		//20. Intenta simular una cola con la lista original. Realiza dos inserciones y extracciones detallando su funcionamiento.
		
		System.out.println("\n20. Simular LIFO ...");
		
		System.out.println("Insercción 1:");
		fifo = new Notas("1º ESO A","López Rivero, José",6,5,6,5,5);
		registros.offer(fifo);
		System.out.printf("Registro añadido. Posición: %d. %s\n",
				registros.indexOf(fifo), registros.get(0).toString());
		
		System.out.println("Insercción 2:");
		fifo = new Notas("1º ESO A","Pérez García, Elena",4,8,6,3,5);
		registros.offer(fifo);
		System.out.printf("Registro añadido. Posición: %d. %s\n",
				registros.indexOf(fifo), registros.get(0).toString());
		
		System.out.println("Extracción 1:");
		System.out.printf("Registro extraído: %s\n", registros.poll().toString());
		
		System.out.println("Extracción 2:");
		System.out.printf("Registro extraído: %s\n", registros.poll().toString());
	}
}
