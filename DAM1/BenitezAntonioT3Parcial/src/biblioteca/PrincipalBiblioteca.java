package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import biblioteca.Libro.Generos;
import biblioteca.LibroDigital.Formatos;
/*
 * Clase principal que hace uso de la clases creadas
 * Libro, LibroDigital y LibroFisico
 * y de colecciones y listas para realizar una serie de operaciones
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 01/04/2025
 */
public class PrincipalBiblioteca {

	public static void main(String[] args) {
		
		// 1. Crea un libro digital con 3.5 Mb de tamaño y formato PDF
		System.out.println("==== 1 =====");
		LibroDigital digital1;
		try
		{
			System.out.println("\n1. Creando libro digital con 3.5 MB de tamaño y formato PDF ...");
			digital1 = new LibroDigital(Libro.GENERO_DEFAULT, 3.5, Formatos.PDF);
			System.out.printf("%s\n", digital1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n",ex.getMessage());
			System.out.println("Se ha producido un error, creando Libro Digital por defecto ...");
			digital1 = new LibroDigital();
		}
		// 2. Modifica la fecha de publicación a 20/12/2030.
		System.out.println("\n==== 2 =====");
		try
		{
			System.out.println("\n2. Cambiando fecha de publicación a 20/12/2030 ...");
			digital1.setFechaPub(LocalDate.of(2030, 12, 20));
			System.out.printf("%s\n", digital1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n",ex.getMessage());
		}	
		// 3. Crea un libro físico con 350 páginas y tapa dura. Los demás valores por defecto.
		System.out.println("\n==== 3 =====");
		LibroFisico fisico1;
		try
		{
			System.out.println("\n3. Creando libro físico con 350 páginas y tapa dura ...");
			fisico1 = new LibroFisico(Libro.GENERO_DEFAULT, 350, true);
			System.out.printf("%s\n", fisico1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n",ex.getMessage());
			System.out.println("Se ha producido un error, creando Libro Fisico por defecto ...");
			fisico1 = new LibroFisico();
		}
		// 4. Crea 20 libros físicos con número aleatorio de páginas entre -50 y 50 páginas y agrégalos a una colección que controle los duplicados a través del identificador.
		System.out.println("\n==== 4 =====");
		System.out.println("\n4. Creando 20 libros físicos con número aleatorio de páginas y agregándolo a colección ...\n");
		HashSet<Libro> coleccion = new HashSet<Libro>();
		LibroFisico fisicoAleatorio;
		do
		{
			int randPag = (int) ((Math.random() * 100) - 50);
			try
			{
				fisicoAleatorio = new LibroFisico(Libro.GENERO_DEFAULT, randPag, true);
				System.out.printf("%s\n", fisicoAleatorio.toString());
				coleccion.add(fisicoAleatorio);
			}catch(IllegalArgumentException ex)
			{
				System.out.printf("ERROR: %s\n",ex.getMessage());
			}
		}while(coleccion.size() < 20);
		System.out.printf("\nNúmero de registros añadidos a la colección: %d\n", coleccion.size());
		// 5. Crea 10 libros digitales con valores por defecto y agrégalos a la colección anterior.
		System.out.println("\n==== 5 =====");
		System.out.println("\n5. Creando 10 libros digitales con valores por defecto y agregándolos a la colección anterior ...\n");
		for(int i=0; i<10; i++)
		{
			LibroDigital defecto = new LibroDigital();
			coleccion.add(defecto);
		}
		int contador = 1;
		for(Libro i: coleccion)
		{
			System.out.printf("Libro Nº%d - %s\n",contador, i.toString());
			contador++;
		}
		// 6. Calcula el precio de cada uno de los libros de la colección.
		System.out.println("\n==== 6 =====");
		System.out.println("\n6. Calculando precio de cada libro de la colección ...\n");
		contador = 1;
		for(Libro i: coleccion)
		{
			try
			{
				System.out.printf("Libro Nº%d - Precio: %.2f€\n",contador, i.calcularPrecio());
			}catch(IllegalStateException ex)
			{
				System.out.printf("%s\n", ex.getMessage());
			}
			contador++;
		}
		
		// 7.  Indica la cantidad de libros que están en la colección y el importe total de todos los libros.
		System.out.println("\n==== 7 =====");
		System.out.println("\n7. Indicando cantidad de libros en colección y el importa total de todos ...\n");
		double importeTotal = 0;
		for(Libro i: coleccion)
		{
			try
			{
				importeTotal += i.calcularPrecio();
			}catch(IllegalStateException ex)
			{
				System.out.printf("%s\n", ex.getMessage());
			}
		}
		
		System.out.printf("Número de libros en la colección: %d\nImporte total de todos los libros: %.2f€\n",
				coleccion.size(), importeTotal);
		
		// 8. Ordena los libros por orden alfabético de identificador.
		System.out.println("\n==== 8 =====");
		
		System.out.println("\n8. Ordenando libros por orden alfabético de identificador ...\n");
		ArrayList<Libro> ordenados = new ArrayList<Libro>();
		ordenados.addAll(coleccion);
		ordenados.sort(new Comparator_LibroID());
		for(Libro i: ordenados)
		{
			System.out.printf("%s\n", i.toString());
		}
		// 9. Elimina los tres primeros libros con precio por debajo de 5€.
		System.out.println("\n==== 9 =====");
		System.out.println("\n9. Eliminando los tres primeros libros con precio por debajo de 5€ ...\n");
		contador = 0;
		ordenados.clear();
		ordenados.addAll(coleccion);
		Iterator<Libro> it = ordenados.iterator();
		while(it.hasNext() && contador < 3)
		{
			Libro libroBorrar = it.next();
			if(libroBorrar.calcularPrecio() < 5)
			{
				System.out.printf("Elemento eliminado: %s\n", libroBorrar.toString());
				coleccion.remove(libroBorrar);
				contador++;
			}
		}
		// 10. Crea un libro digital con los siguientes valores usando un pseudoconstructor.
		System.out.println("\n==== 10 =====");
		System.out.println("\n10. Creando un libro digital con valores usando pseudoconstructor ...\n");
		
		LibroDigital quijote = crearLibroDigital("El quijote", "Miguel de Cervantes", LocalDate.of(1605, 01, 01),
				Generos.NOVELA, true, 8.5, Formatos.EPUB);
		
		System.out.printf("%s\n", quijote.toString());
		
		// 11.Calcula el número de años transcurridos desde la fecha de publicación del libro "El quijote".
		System.out.println("\n==== 11 =====");
		System.out.println("\n11. Calculando anyos transcurridos desde la fecha de publicacion del Quijote ...\n");
		System.out.printf("Años transcurridos desde la publicación del Quijote: %d %s\n", 
				quijote.anyosTranscurridos(),quijote.anyosTranscurridos() == 1 ? "año" : "años");
	}
	
	//CREAR LIBRO DIGITAL - Crea un objeto LibroDigital a través de parámetros basados en los atributos de LibroDigital
	private static LibroDigital crearLibroDigital(String titulo, String autor, LocalDate fechaPub, Generos genero, boolean disponibilidad,
			double tamanyo, Formatos formato)
	{
		LibroDigital libro = new LibroDigital(genero, tamanyo, formato);
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		try
		{
			libro.setFechaPub(fechaPub);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n",ex.getMessage());
		}
		return libro;
	}
}
		