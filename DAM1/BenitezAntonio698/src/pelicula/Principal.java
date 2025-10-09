package pelicula;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import pelicula.Pelicula.Genero;

public class Principal 
{

	public static void main(String[] args) 
	{
		//1. Una película (pelicula1) con los valores por defecto que consideres oportunos.
		System.out.println("1. Creando película con valores por defecto ...");
		Pelicula pelicula1 = new Pelicula();
		System.out.printf("%s\n", pelicula1.toString());
		
		//2. Calcular el número de años desde que se realizó la película
		System.out.println("\n2. Calculando número de años desde que se realizó la película ...");
		System.out.printf("Años desde que se creó la película: %d años\n", pelicula1.getAntiguedad());
		
		//3. Modificar la calificación de la película con un valor aleatorio entre 5 y 15
		System.out.println("\n3. Modificando calificación de la película con un valor aleatorio entre 5 y 15 ...");
		int valorAleatorio = (int) ((Math.random() * 10) + 5);
		try
		{
			pelicula1.setCalificacion(valorAleatorio);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		//4. Indicar si la película es recomendable (si tiene una calificación superior a 5) y menos de 5 años de antigüedad.
		System.out.println("\n4. Indicando si la película es recomendable ...");
		if(pelicula1.isRecomendable())
		{
			System.out.printf("La película %s es recomendable.\n",pelicula1.getNombre());
		}
		else
		{
			System.out.printf("La película %s es recomendable.\n",pelicula1.getNombre());
		}
		
		//5. Crear otra película (pelicula2) solicitando al usuario todas las características.
		System.out.println("\n5. Creando película con datos solicitados ...");
		Scanner entradaTeclado = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre.");
		String nombreTeclado = entradaTeclado.nextLine();
		
		LocalDate fechaIntroducida = null;
		boolean fechaCorrecta = false;
		do
		{
			
			try
			{
				System.out.println("Introduzca la fecha de realización (formato: YYYY-MM-DD)");
				String fechaString = entradaTeclado.nextLine();
				fechaIntroducida = LocalDate.parse(fechaString);
				fechaCorrecta = true;
			}
			catch(DateTimeParseException excepcion1)
			{
				System.out.println("La fecha introducida no es válida."+
									"\nAsegúrese de que está siguiendo el formato correctamente.");
			}
		}while(fechaCorrecta == false);
		
		int opcionGenero = menuEnum(entradaTeclado);
		Genero generoTeclado = null;
		switch(opcionGenero)
		{
		case 1:
			generoTeclado = Genero.ACCION;
			break;
		case 2:
			generoTeclado = Genero.COMEDIA;
			break;
		case 3:
			generoTeclado = Genero.DRAMA;
			break;
		case 4:
			generoTeclado = Genero.SUSPENSE;
			break;
		}
		
		int duracionTeclado = inputInt("Introduzca la duración en minutos (entero)", entradaTeclado);
		
		int calificacionTeclado = inputInt("Introduzca la calificación", entradaTeclado);
		
		try
		{
			Pelicula pelicula2 = new Pelicula(nombreTeclado, fechaIntroducida, generoTeclado, duracionTeclado, calificacionTeclado);
			System.out.println("Película creada con éxito.");
			System.out.printf("%s\n", pelicula2.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalStateException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		//6. Intentar crear 100 películas de SUSPENSE con calificaciones aleatorias entre 5 y 15.
		System.out.println("\n6. Creando 100 películas de SUSPENSE con calificaciones entre 5 y 15 ...");
		for(int i=0; i<100; i++)
		{
			int numeroRandom = (int) ((Math.random() * 10) + 5);
			try
			{
				Pelicula peliculaSuspense = new Pelicula("Suspense", LocalDate.now(), Genero.SUSPENSE, 100, numeroRandom);
				System.out.println("Película creada con éxito.");
				System.out.printf("%s\n\n", peliculaSuspense.toString());
			}catch(IllegalArgumentException ex)
			{
				System.out.printf("%s\n\n", ex.getMessage());
			}catch(IllegalStateException ex2)
			{
				System.out.printf("%s\n\n", ex2.getMessage());
			}
		}
		
		//7. Mostrar la duración total de las películas existentes y la duración total de las películas de SUSPENSE
		System.out.println("\n7. Mostrando duración total de películas y películas suspense ...");
		System.out.printf("Duración total películas: %d minutos\nDuración total películas suspense: %d minutos\n",
				Pelicula.getDuracionPeliculasTotal(), Pelicula.getDuracionPeliculasSuspense());
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuEnum(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n- GÉNEROS -"+
					"\n 1. ACCIÓN"+
					"\n 2. COMEDIA"+
					"\n 3. DRAMA"+
					"\n 4. SUSPENSE");
			opcion = inputInt("Elija una opción", entradaTeclado);
			if(opcion < 1 || opcion > 4) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 4);
		return opcion;
	}
	
	//INPUT INT - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				entrada.nextLine(); // Depuración Scanner
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine(); // Depuración Scanner
			}
		}while(inputTrue == false);
		return num;
	}
}
