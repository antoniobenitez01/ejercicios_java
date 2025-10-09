package operArrayList;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.ComparatorNotaNombre;
import common.ComparatorNotas;
import common.ComparatorNotasDescendente;
import common.Notas;
import common.UtilidadesList;

public class Main {

	public static void main(String[] args) 
	{
		/*1. Importa la información contenida en el documento notas1.txt, donde la información tiene el
		siguiente formato:
		grupo;nombre,matemáticas;lengua;física;química;inglés*/
		
		System.out.println("1. Añadiendo registros de notas1.txt a la lista ...\n");
		ArrayList<Notas> registros = UtilidadesList.importarDatosArrayList("notas1.txt");
		
		// 2. Muestra el número de registros que contiene.
		
		System.out.printf("2. Número de registros añadidos a la lista: %d\n", registros.size());
		
		// 3. Ordena los registros por grupo y nombre.
		
		System.out.println("\n3. Ordenamos la lista por grupo y nombre ...");
		registros.sort(new ComparatorNotas());
		System.out.println("Guardamos la lista ordenada en: notasPorGrupoYNombre.txt");
		UtilidadesList.exportarLista(registros, "notasPorGrupoYNombre.txt");
		
		/*4. Inserta siguiente registro:
		1º ESO D;López Muro, Rosario;3;3;4;4;3*/
		
		System.out.println("\n4. Añadimos el registro ...");
		registros.add(new Notas("1º ESO D","López Muro, Rosario",3,3,4,4,3));
		System.out.printf("Número de registros: %d\n", registros.size());
		
		/*5. Insertar el siguiente registro en mitad de la lista:
		1º ESO B;Duarte Durán, Alba;2;3;4;1;3*/
		
		System.out.println("\n5. Añadimos un registro en mitad de la lista ...");
		Notas alba = new Notas("1º ESO B", "Duarte Durán, Alba",2,3,4,1,3);
		registros.add((int) (registros.size() / 2), alba);
		
		// 6. Mostrar la posición que ocupa el último registro anterior insertado.
		
		int posicion = registros.indexOf(alba);
		System.out.printf("\n6. Posición del nuevo registro: %d\n", posicion);
		
		/*7. Importa los registros del documento notas2.txt a un ArraList auxiliar e incluye los elementos
		de este ArrayList auxiliar al primer ArrayList.*/
		
		System.out.println("\n7. Añadiendo registros de notas2.txt a la lista mediante una lista auxiliar ...");
		
		ArrayList<Notas> auxiliar = UtilidadesList.importarDatosArrayList("notas2.txt");
		
		System.out.printf("Total de registros antes de añadir: %d"
				+ "\nTotal de registros de la lista auxiliar: %d\n", registros.size(), auxiliar.size());
		
		registros.addAll(auxiliar);
		
		System.out.printf("Total de registros después de añadir: %d\n", registros.size());
		System.out.println("Guardamos la lista completa y ordenada en: registroCompletoDeNotas.txt ...");
		registros.sort(new ComparatorNotas());
		UtilidadesList.exportarLista(registros, "registroCompletoDeNotas.txt");
		
		//8. Busca el registro con el nombre “Cordero Benítez, Alejandro” y muestra toda su información.
		
		System.out.println("\n8. Busca a Cordero Benítez, Alejandro e imprime toda su información ...");
		try
		{
			Notas alejandro = UtilidadesList.buscarNombre(registros, "Cordero Benítez, Alejandro");
			System.out.printf("%s\n", alejandro);
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		//9. Busca el registro con el nombre “Fernández Villalón, Carlos” y muestra toda su información.
		
		System.out.println("\n9. Busca a Fernández Villalón, Carlos e imprime toda su información ...");
		try
		{
			Notas alejandro = UtilidadesList.buscarNombre(registros, "Fernández Villalón, Carlos");
			System.out.printf("%s\n", alejandro);
		}catch(NullPointerException e)
		{
			System.out.printf("%s\n", e.getMessage());
		}
		
		//10. Borra el registro que está en la posición mitad más 1, indicando la información del registro que borras.
		
		System.out.println("\n10. Borra el  registro que está en la posición mitad más 1 e imprime toda su información ...");
		
		posicion = (registros.size() / 2) + 1;
		System.out.printf("Posición mitad + 1: %1$d"
				+ "\nRegistro en la posición %1$d:"
				+ "\n%2$s\n", posicion, registros.get(posicion).toString());
		
		System.out.println("Borramos el registro ...");
		registros.remove(posicion);
		
		System.out.printf("Nuevo registro en la posición %d:\n%s\n",posicion,registros.get(posicion).toString());
		
		//11. Borra los primeros 10 registros.
		
		System.out.println("\n11. Borra los primeros 10 registros ...");
		System.out.printf("Total de registros: %d", registros.size());
		ArrayList<Notas> borrados = new ArrayList<Notas>();
		for(int i=0;i<10;i++)
		{
			borrados.add(registros.removeFirst());
		}
		System.out.printf("Total de registros después de borrar: %d\n", registros.size());
		System.out.println("Se recogen los registros borrados en: registrosBorrados.txt");
		UtilidadesList.exportarLista(borrados, "registrosBorrados.txt");
		
		//12. Borra todos los registros que tengan en matemáticas un 2. Indica cuántos registros borras.
		
		System.out.println("\n12. Borra todos los registros que tengan en matemáticas un 2 ...");
		Iterator<Notas> it = registros.iterator();
		borrados.clear();
		while(it.hasNext())
		{
			Notas nota = it.next();
			if(nota.getMat() == 2)
			{
				borrados.add(nota);
				it.remove();
			}
		}
		System.out.printf("Se han borrado %d registros\n", borrados.size());
		System.out.println("\nSe recogen los registros borrados en: registrosEliminadosMatematicas.txt");
		UtilidadesList.exportarLista(borrados, "registrosEliminadosMatematicas.txt");
		
		//13. Calcula la nota media para cada alumno.
		
		System.out.println("\n13. Calcula la nota media para cada registro ...");
		
		exportarMedias(registros, "nombre_y_notas_media.txt");
		
		System.out.println("Se ha guardado el nombre y la nota media de cada registro en nombre_y_nota_media.txt");

		
		//14. Crea una sublista por cada grupo y ordénala por nombre descendente.
		
		System.out.println("\n14. Crea una sublista por cada grupo y ordénala por nombre descendente");
		
		// ------------------------ RECOGEMOS LAS ULTIMAS POSICIONES DE CADA GRUPO DE FORMA AUXILIAR EN UN ARRAY
		int[] posiciones = new int[5]; 
		for(Notas i: registros)
		{
			if(i.getGrupo().equals("1º ESO A"))
			{
				posiciones[0] = registros.indexOf(i);
			}
			else if(i.getGrupo().equals("1º ESO B"))
			{
				posiciones[1] = registros.indexOf(i);
			}
			else if(i.getGrupo().equals("1º ESO C"))
			{
				posiciones[2] = registros.indexOf(i);
			}
			else if(i.getGrupo().equals("1º ESO D"))
			{
				posiciones[3] = registros.indexOf(i);
			}
			else if(i.getGrupo().equals("1º ESO E"))
			{
				posiciones[4] = registros.indexOf(i);
			}
		} // ----------------------------------------------------------------------------
		
		List<Notas> sublista1 = registros.subList(0, posiciones[0]);
		sublista1.sort(new ComparatorNotasDescendente());
		UtilidadesList.exportarLista(sublista1, "1º ESO A_ordenado_por_nombre_descendente.txt");
		System.out.println("Sublista para el grupo '1º ESO A' ordenada por nombre descendente"
				+ "\nguardada en: 1º ESO A_ordenado_por_nombre_descendente.txt");
		
		List<Notas> sublista2 = registros.subList(posiciones[0] + 1, posiciones[1]);
		sublista2.sort(new ComparatorNotasDescendente());
		UtilidadesList.exportarLista(sublista2, "1º ESO B_ordenado_por_nombre_descendente.txt");
		System.out.println("Sublista para el grupo '1º ESO B' ordenada por nombre descendente"
				+ "\nguardada en: 1º ESO B_ordenado_por_nombre_descendente.txt");
		
		List<Notas> sublista3 = registros.subList(posiciones[1] + 1, posiciones[2]);
		sublista3.sort(new ComparatorNotasDescendente());
		UtilidadesList.exportarLista(sublista3, "1º ESO C_ordenado_por_nombre_descendente.txt");
		System.out.println("Sublista para el grupo '1º ESO C' ordenada por nombre descendente"
				+ "\nguardada en: 1º ESO C_ordenado_por_nombre_descendente.txt");
		
		List<Notas> sublista4 = registros.subList(posiciones[2] + 1, posiciones[3]);
		sublista4.sort(new ComparatorNotasDescendente());
		UtilidadesList.exportarLista(sublista4, "1º ESO D_ordenado_por_nombre_descendente.txt");
		System.out.println("Sublista para el grupo '1º ESO D' ordenada por nombre descendente"
				+ "\nguardada en: 1º ESO D_ordenado_por_nombre_descendente.txt");
		
		List<Notas> sublista5 = registros.subList(posiciones[3] + 1, posiciones[4]);
		sublista5.sort(new ComparatorNotasDescendente());
		UtilidadesList.exportarLista(sublista5, "1º ESO E_ordenado_por_nombre_descendente.txt");
		System.out.println("Sublista para el grupo '1º ESO E' ordenada por nombre descendente"
				+ "\nguardada en: 1º ESO e_ordenado_por_nombre_descendente.txt");

		//15. Calcula para cada grupo la nota media de cada materia.
		
		System.out.println("\n15. Calcula para cada grupo la nota media de cada materia ...");
		
		exportarMedias(sublista1, "1º ESO A_notas_medias.txt");
		System.out.println("Los resultados se han guardado en el archivo 1º ESO A_notas_medias.txt");
		
		exportarMedias(sublista2, "1º ESO B_notas_medias.txt");
		System.out.println("Los resultados se han guardado en el archivo 1º ESO B_notas_medias.txt");
		
		exportarMedias(sublista3, "1º ESO C_notas_medias.txt");
		System.out.println("Los resultados se han guardado en el archivo 1º ESO C_notas_medias.txt");
		
		exportarMedias(sublista4, "1º ESO D_notas_medias.txt");
		System.out.println("Los resultados se han guardado en el archivo 1º ESO D_notas_medias.txt");
		
		exportarMedias(sublista5, "1º ESO E_notas_medias.txt");
		System.out.println("Los resultados se han guardado en el archivo 1º ESO E_notas_medias.txt");
		
		//16. Para cada grupo muestra las diez mejores notas en matemáticas ordenadas por nota y nombre.
		
		System.out.println("\n16. Muestra las diez mejores notas en matemáticas por cada grupo ordenadas por nota y nombre.");
		
		mostrarMejoresMat(sublista1, "\n- GRUPO 1º ESO A -\n");
		mostrarMejoresMat(sublista2, "\n- GRUPO 1º ESO B -\n");		
		mostrarMejoresMat(sublista3, "\n- GRUPO 1º ESO C -\n");		
		mostrarMejoresMat(sublista4, "\n- GRUPO 1º ESO D -\n");		
		mostrarMejoresMat(sublista5, "\n- GRUPO 1º ESO E -\n");		
	}
	
	//MOSTRAR MEJORES MATEMÁTICAS - Muestra los 10 mejores registros basados en la nota de Matemáticas de una lista de Notas
	private static void mostrarMejoresMat(List<Notas> lista, String mensaje)
	{
		System.out.println(mensaje);
		lista.sort(new ComparatorNotaNombre());
		for(int i=0; i<10; i++)
		{
			System.out.printf("%s\n", lista.get(i));
		}
	}
	
	//EXPORTAR MEDIAS - Exporta las medias de cada alumno de una lista de Notas
	private static void exportarMedias(List<Notas> lista, String ruta)
	{
		String stringMedia = "";
		for(Notas i: lista)
		{
			stringMedia += String.format("Nombre: %s; Nota media: %.2f\n", i.getNombre(), i.notaMedia());
		}
		File notasmedia = new File(ruta);
		FileWriter escritorMedia; 
		try
		{
			escritorMedia = new FileWriter(notasmedia);
			escritorMedia.write(stringMedia);
			escritorMedia.close();
		}catch(Exception e)
		{
			System.out.printf("%s\n", e.getMessage());
		}
	}
}
