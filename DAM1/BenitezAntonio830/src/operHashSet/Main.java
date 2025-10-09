package operHashSet;

import java.util.ArrayList;
import java.util.HashSet;

import common.ComparatorNotas;
import common.Notas;
import common.UtilidadesList;
import common.UtilidadesSet;

public class Main 
{
	public static void main(String[] args)
	{
		/*1. Importa los registros contenidos en el documento notas1hs.txt a un HashSet, donde la
		información tiene el siguiente formato:	grupo;nombre,matemáticas;lengua;física;química;inglés*/
		
		System.out.println("1. Añadiendo registros de notas1hs.txt al conjunto ...");
		HashSet<Notas> registros = UtilidadesSet.importarDatosHashSet("notas1hs.txt");
		
		//2. Muestra el número de registros que contiene.
		
		System.out.printf("\n2. Número de registros añadidos al conjunto: %d\n", registros.size());
		
		/*3. Ordena los registros por grupo y nombre.
		Pista: https://www.baeldung.com/java-sort-hashset*/
		
		System.out.println("\n3. Ordenamos los objetos del conjunto por grupo y nombre mediante un ArrayList ...");
		
		ArrayList<Notas> ordenados = new ArrayList<Notas>(registros);
		ordenados.sort(new ComparatorNotas());
		
		System.out.println("Guardamos los objetos ordenados en: HashSet3.txt");
		UtilidadesList.exportarLista(ordenados, "HashSet3.txt");
		
		/*4. Añade el registro abajo indicado.
		1º ESO A;Plaza Gallego, Juan;1;1;3;1;1*/
		
		System.out.println("\n4. Añadimos un registro: 1º ESO A;Plaza Gallego, Juan;1;1;3;1;1 ...");
		Notas juan = new Notas("1º ESO A","Plaza Gallego, Juan",1,1,3,1,1);
		if(registros.add(juan))
		{
			System.out.printf("Número de registros: %d\n",registros.size());
		}else
		{
			System.out.printf("El registro ya está en el conjunto. Número de registros: %d\n",registros.size());
		}

		/*5. Añade el registro abajo indicado.
		1º ESO A;Suárez Cano, Francisco José;2;3;4;1;2*/
		
		System.out.println("\n5. Añadimos un registro: 1º ESO A;Suárez Cano, Francisco José;2;3;4;1;2 ...");
		Notas jose = new Notas("1º ESO A","Suárez Cano, Francisco",2,3,4,1,2);
		if(registros.add(jose))
		{
			System.out.printf("Número de registros: %d\n",registros.size());
		}else
		{
			System.out.printf("El registro ya está en el conjunto. Número de registros: %d\n",registros.size());
		}
		
		//6. Importa los registros contenidos en el documento notas2hs.txt en un arralist.
		
		System.out.println("\n6. Añadiendo registros de notas2hs.txt a la lista mediante una lista auxiliar ...");
		ArrayList<Notas> auxiliar = UtilidadesList.importarDatosArrayList("notas2hs.txt");
		System.out.printf("Total registros de la lista auxiliar: %d\n", auxiliar.size());
		
		//7. Inserta los registros contenidos en el arralist anterior en el HashSet.
		
		System.out.println("\n7. Insertamos los registros contenidos en el ArrayList anterior en el HashSet ...");
		System.out.printf("Total registros en el HashSet antes de añadir: %d\n", registros.size());
		
		registros.addAll(auxiliar);
		System.out.printf("Total registros en el HashSet después de añadir: %d\n", registros.size());
		UtilidadesSet.exportarDatos(registros, "HashSet7.txt");
		System.out.println("Guardamos todos los objetos del HashSet en: HashSet7.txt");
		
		//8. Comprueba que el registro del punto 4 está en el conjunto.
		
		System.out.println("\n8. Comprueba que el registro del punto 4 está en el conjunto ...");
		System.out.printf("El registro de Juan está en la lista: %b\n", registros.contains(juan));
		
		//9. Comprueba que el registro del punto 5 está en el conjunto.
		
		System.out.println("\n9. Comprueba que el registro del punto 5 está en el conjunto ...");
		System.out.printf("El registro de Francisco está en la lista: %b\n", registros.contains(jose));
		
		//10. Crea un arraylist con los registros contenidos en notas3hs.txt.
		
		System.out.println("\n10. Creando ArrayList con notas3hs.txt ...");
		ArrayList<Notas> lista = UtilidadesList.importarDatosArrayList("notas3hs.txt");
		System.out.println("Guardamos todos los objetos del ArrayList en: HashSet10.txt");
		UtilidadesList.exportarLista(lista, "HashSet10.txt");
		
		//11. Aplica la intersección del HashSet y del arraylist del punto anterior. Muestra el resultado.
		
		System.out.println("\n11. Aplicando intersección de HashSet y ArrayList ...");
		lista.retainAll(registros);
		System.out.println("Guardamos la intersección en: HashSet11.txt");
		UtilidadesList.exportarLista(lista, "HashSet11.txt");		
		
		//12. Crea un HashSet e inserta el arraylist anterior. Inserta los objetos creados en el punto 4 y 5.
		
		System.out.println("\n12. Creando HashSet insertando el ArrayList anterior ...");
		HashSet<Notas> registros2 = new HashSet<Notas>();
		registros2.addAll(lista);
		System.out.printf("Número de registros: %d\n",registros2.size());
		
		System.out.println("Añadiendo los registros creados en el punto 4 y 5 ...");
		registros2.add(juan);
		registros2.add(jose);
		System.out.printf("Número de registros: %d\n",registros2.size());
		
		//13. Aplica la intersección de los dos HashSet. Muestra su contenido.
		
		System.out.println("\n13. Aplicando intersección de los dos HashSet ...");
		registros2.retainAll(registros);
		System.out.println("Guardamos la intersección en: HashSet13.txt");
		UtilidadesSet.exportarDatos(registros2, "HashSet13.txt");
		
		//14. Busca y muestra el registro con nombre “Romero Farfán, Estefanía”.
		
		System.out.println("\n14. Busca a Fernández Villalón, Carlos e imprime toda su información ...");
		try
		{
			Notas estefania = UtilidadesSet.buscarNombre(registros, "Romero Farfán, Estefanía");
			System.out.printf("%s\n", estefania);
		}catch(NullPointerException e)
		{
			System.out.printf("%s\n", e.getMessage());
		}
		
		//15. Busca y muestra el registro con nombre “Gutiérrez Martín, Marina”.
		
		System.out.println("\n15. Busca a Fernández Villalón, Carlos e imprime toda su información ...");
		try
		{
			Notas marina = UtilidadesSet.buscarNombre(registros, "Gutiérrez Martín, Marina");
			System.out.printf("%s\n", marina);
		}catch(NullPointerException e)
		{
			System.out.printf("%s\n", e.getMessage());
		}
		
		//16. Elimina el objeto insertado en el punto 4.
		
		System.out.println("\n16. Elimina el objeto insertado en el punto 4 ...");
		System.out.printf("Total de registros antes de eliminar: %d\n",registros.size());
		registros.remove(juan);
		System.out.printf("Total de registros después de eliminar: %d\n",registros.size());
		
		//17. Elimina el objeto insertado en el punto 5.
		
		System.out.println("\n17. Elimina el objeto insertado en el punto 5 ...");
		System.out.printf("Total de registros antes de eliminar: %d\n",registros.size());
		registros.remove(jose);
		System.out.printf("Total de registros después de eliminar: %d\n",registros.size());
		
		//18. Exporta el HashSet original a un documento de texto.
		
		System.out.println("\n18. Exporta el HashSet original a un documento de texto ...");
		System.out.println("Guardamos la lista completa en: HashSet18.txt");
		UtilidadesSet.exportarDatos(registros, "HashSet18.txt");		
	}
}
