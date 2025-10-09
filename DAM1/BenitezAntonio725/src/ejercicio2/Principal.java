/*
 * Programa que hace uso de las clases creadas
 * Mascota,Perro,Gato,Loro,Canario e Inventario
 * para hacer uso de sus métodos y constructores
 * Excepciones: IllegalArgumentException
 */
package ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal 
{
	public static void main(String[] args) 
	{
		
		// DECLARACIÓN DE VARIABLES ===========================================================
		
		Scanner entradaTeclado = new Scanner(System.in);
		Inventario tiendaAnimales = new Inventario(new Mascota[10]);
		
		// INSERTAR MASCOTAS EN INVENTARIO ====================================================
		
		tiendaAnimales.insertarAnimal(new Perro("Rex", 15, true, LocalDate.of(2005, 12, 31),"Caniche", false));
		tiendaAnimales.insertarAnimal(new Perro("Maximilian", 50, false, LocalDate.of(1978, 05, 15),"Bulldog", false));
		tiendaAnimales.insertarAnimal(new Gato("Priscilla", 10, true, LocalDate.of(2010, 12, 31), "Blanco", true));
		tiendaAnimales.insertarAnimal(new Gato("Edgar", 25, false, LocalDate.of(1999, 12, 31), "Negro", true));
		tiendaAnimales.insertarAnimal(new Loro("Maxie", 30, false,LocalDate.of(1987, 06, 12),"Fino", true, "Himalaya", false));
		tiendaAnimales.insertarAnimal(new Loro("Roberto", 5, true,LocalDate.of(2015, 06, 12),"Largo", false, "Tibet", true));
		tiendaAnimales.insertarAnimal(new Canario("Papagayo", 15, true, LocalDate.of(2005, 12, 31), "Gordo", true, "Amazonas", false));
		tiendaAnimales.insertarAnimal(new Canario("Bebe", 0, true, LocalDate.now(), "Pequeño", false, "Europa", true));
		
		//		No comprobamos ninguna expeción porque están insertados de forma correcta y controlada
		
		// PROGRAMA ============================================================================
		
		int opcion;
		do
		{
			opcion = menuPrincipal(entradaTeclado); // MENÚ PRINCIPAL --------------------------
			switch(opcion)
			{
			case 1: // MOSTRAR LISTA -----------------------------------------------------------
				try
				{
					tiendaAnimales.mostrarLista();
				}catch(NullPointerException ex)
				{
					System.out.printf("%s\n", ex.getMessage());
				}
				break;
			case 2: // BUSCAR ANIMAL -----------------------------------------------------------
				System.out.println("Introduzca el nombre del animal.");
				String nombre = entradaTeclado.nextLine();
				try
				{
					tiendaAnimales.mostrarDatosAnimal(nombre);
				}catch(NullPointerException ex)
				{
					System.out.printf("%s\n", ex.getMessage());
				}
				break;
			case 3: // MOSTRAR DATOS ------------------------------------------------------------
				try
				{
					tiendaAnimales.mostrarTodosDatos();
				}catch(NullPointerException ex)
				{
					System.out.printf("%s\n", ex.getMessage());
				}
				break;
			case 4: // INSERTAR ANIMAL ----------------------------------------------------------
				int opcionAnimal = menuAnimal(entradaTeclado);
				Mascota mascotaCreada = null;
				switch(opcionAnimal)
				{
				case 1:
					mascotaCreada = crearPerro(entradaTeclado);
					break;
				case 2:
					mascotaCreada = crearGato(entradaTeclado);
					break;
				case 3:
					mascotaCreada = crearLoro(entradaTeclado);
					break;
				case 4:
					mascotaCreada = crearCanario(entradaTeclado);
					break;
				case 5:
					System.out.println("Cancelando operación ...");
					break;
				}
				if(mascotaCreada == null)
				{
					System.out.println("Ha ocurrido un error y no se ha insertado la mascota.");
				}
				else
				{
					tiendaAnimales.insertarAnimal(mascotaCreada);
				}
				break;
			case 5: // ELIMINAR ANIMAL ----------------------------------------------------------
				int opcionEliminar = inputInt("Seleccione el número del animal a eliminar.", entradaTeclado);
				try
				{
					tiendaAnimales.eliminarAnimal(opcionEliminar);
					System.out.println("Eliminado con éxito.");
				}catch(NullPointerException ex)
				{
					System.out.printf("%s\n", ex.getMessage());
				}
				break;
			case 6: // VACIAR INVENTARIO --------------------------------------------------------
				System.out.println("Vaciando el inventario ...");
				tiendaAnimales.vaciarInventario();
				break;
			case 7: // APAGAR PROGRAMA ----------------------------------------------------------
				System.out.println("Apagando programa ...");
				break;
			}
		}while(opcion != 7);
		
		//FIN PROGRAMA ==========================================================================
	}
	
// MÉTODOS CREACIÓN MASCOTA ============================================================================
	
	//CREAR PERRO - Método que devuelve un objeto Perro creado a partir de parámetros introducidos por teclado
	private static Perro crearPerro(Scanner entradaTeclado)
	{
		Perro perroCreado = null;
		
		System.out.println("Introduzca el nombre del Perro.");
		String nombreTeclado = entradaTeclado.nextLine();
		
		int edadTeclado = inputInt("Introduzca la edad del Perro.", entradaTeclado);
		
		boolean estadoTeclado = booleanCheck("¿El perro está vivo?", entradaTeclado);
		
		LocalDate fechaTeclado = crearFecha("Introduzca la fecha de nacimiento del Perro", entradaTeclado);
		
		System.out.println("Introduzca la raza del Perro.");
		String razaTeclado = entradaTeclado.nextLine();
		
		boolean pulgasTeclado = booleanCheck("El perro tiene pulgas? Introduzca sí o no.", entradaTeclado);
		
		try
		{
			perroCreado = new Perro(nombreTeclado, edadTeclado, estadoTeclado, fechaTeclado, razaTeclado, pulgasTeclado);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		return perroCreado;
	}
	
	//CREAR GATO - Método que devuelve un objeto Gato creado a partir de parámetros introducidos por teclado
	private static Gato crearGato(Scanner entradaTeclado)
	{
		Gato gatoCreado = null;
		
		System.out.println("Introduzca el nombre del Gato.");
		String nombreTeclado = entradaTeclado.nextLine();
		
		int edadTeclado = inputInt("Introduzca la edad del Gato.", entradaTeclado);
		
		boolean estadoTeclado = booleanCheck("¿El Gato está vivo? Introduzca SÍ o NO", entradaTeclado);
		
		LocalDate fechaTeclado = crearFecha("Introduzca la fecha de nacimiento del Gato", entradaTeclado);
		
		System.out.println("Introduzca el color del Gato.");
		String colorTeclado = entradaTeclado.nextLine();
		
		boolean peloTeclado = booleanCheck("El Gato tiene el pelo largo? Introduzca SÍ o NO.", entradaTeclado);
		
		try
		{
			gatoCreado = new Gato(nombreTeclado, edadTeclado, estadoTeclado, fechaTeclado, colorTeclado, peloTeclado);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		return gatoCreado;
	}
	
	//CREAR LORO - Método que devuelve un Loro creado a partir de parámetros introducidos por teclado
	private static Loro crearLoro(Scanner entradaTeclado)
	{
		Loro loroCreado = null;
		
		System.out.println("Introduzca el nombre del Loro.");
		String nombreTeclado = entradaTeclado.nextLine();
		
		int edadTeclado = inputInt("Introduzca la edad del Loro.", entradaTeclado);
		
		boolean estadoTeclado = booleanCheck("¿El Loro está vivo? Introduzca SÍ o NO", entradaTeclado);
		
		LocalDate fechaTeclado = crearFecha("Introduzca la fecha de nacimiento del Loro", entradaTeclado);
		
		System.out.println("Introduzca el tipo de pico del Loro.");
		String picoTeclado = entradaTeclado.nextLine();
		
		boolean volarTeclado = booleanCheck("El Loro puede volar? Introduzca SÍ o NO.", entradaTeclado);
		
		System.out.println("Introduzca el origen del Loro.");
		String origenTeclado = entradaTeclado.nextLine();
		
		boolean hablarTeclado = booleanCheck("El Loro puede hablar? Introduzca SÍ o NO.", entradaTeclado);
		
		try
		{
			loroCreado = new Loro(nombreTeclado, edadTeclado, estadoTeclado, fechaTeclado,
					picoTeclado, volarTeclado, origenTeclado,hablarTeclado);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		return loroCreado;
	}
	
	//CREAR CANARIO - Método que devuelve un Canario creado a partir de parámetros introducidos por teclado
	private static Canario crearCanario(Scanner entradaTeclado)
	{
		Canario canarioCreado = null;
		
		System.out.println("Introduzca el nombre del Canario.");
		String nombreTeclado = entradaTeclado.nextLine();
		
		int edadTeclado = inputInt("Introduzca la edad del Canario.", entradaTeclado);
		
		boolean estadoTeclado = booleanCheck("¿El Canario está vivo? Introduzca SÍ o NO", entradaTeclado);
		
		LocalDate fechaTeclado = crearFecha("Introduzca la fecha de nacimiento del Canario", entradaTeclado);
		
		System.out.println("Introduzca el tipo de pico del Canario.");
		String picoTeclado = entradaTeclado.nextLine();
		
		boolean volarTeclado = booleanCheck("El Canario puede volar? Introduzca SÍ o NO.", entradaTeclado);
		
		System.out.println("Introduzca el color del Loro.");
		String colorTeclado = entradaTeclado.nextLine();
		
		boolean cantarTeclado = booleanCheck("El Loro puede cantar? Introduzca SÍ o NO.", entradaTeclado);
		
		try
		{
			canarioCreado = new Canario(nombreTeclado, edadTeclado, estadoTeclado, fechaTeclado,
					picoTeclado, volarTeclado, colorTeclado, cantarTeclado);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		return canarioCreado;
	}
	
// MÉTODOS ====================================================================================================
	
	//BOOLEAN CHECK - Devuelve un boolean en base a la respuesta SI o NO introducida por teclado
	private static boolean booleanCheck(String mensaje, Scanner entradaTeclado)
	{
		boolean resultado = false, flag = false;
		
		do
		{
			System.out.println(mensaje);
			String respuesta = entradaTeclado.nextLine();
			
			if(respuesta.toLowerCase().equals("si") || respuesta.toLowerCase().equals("sí"))
			{
				resultado = true;
				flag = true;
			}
			else if(respuesta.toLowerCase().equals("no"))
			{
				resultado = false;
				flag = true;
			}
			else
			{
				System.out.println("Respuesta no válida. Inténtelo de nuevo.");
				flag = false;
			}
		}while(flag == false);
		
		return resultado;
	}
	
	//CREAR FECHA - Crea un objeto LocalDate mediante una fecha introducida por teclado
	private static LocalDate crearFecha(String mensaje, Scanner entradaTeclado)
	{
		LocalDate fechaIntroducida = null;
		boolean fechaCorrecta = false;
		do
		{
			try
			{
				System.out.println(mensaje);
				String fechaString = entradaTeclado.nextLine();
				fechaIntroducida = LocalDate.parse(fechaString);
				fechaCorrecta = true;
			}
			catch(DateTimeParseException ex)
			{
				System.out.println("La fecha introducida no es válida."+
									"\nAsegúrese de que está siguiendo el formato correctamente.");
			}
		}while(fechaCorrecta == false);
		return fechaIntroducida;
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n=== || MENÚ PRINCIPAL || ==="+
					"\n\n 1. Mostrar lista de animales"+
					"\n 2. Mostrar datos de animal"+
					"\n 3. Mostrar todos los datos" +
					"\n 4. Insertar animal"+
					"\n 5. Eliminar animal"+
					"\n 6. Vaciar el inventario"+
					"\n 7. Apagar el programa\n");
			opcion = inputInt("Elija una opción", entradaTeclado);
			if(opcion < 1 || opcion > 7) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 7);
		return opcion;
	}
	
	//MENÚ ANIMAL - Muestra el Menú de raza de animal y devuelve la opción elegida por teclaod
	private static int menuAnimal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n-- | INSERTAR ANIMAL | --"+
					"\n\n 1. Perro"+
					"\n 2. Gato"+
					"\n 3. Loro" +
					"\n 4. Canario"+
					"\n 5. Cancelar operación\n");
			opcion = inputInt("Elija el tipo de animal a insertar", entradaTeclado);
			if(opcion < 1 || opcion > 5) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 5);
		return opcion;
	}
	
	//INPUT INT - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	private static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			try //TRY CATCH - Trata las excepciones dadas al introducir datos por teclado
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				entrada.nextLine(); //Depuración Scanner
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine(); //Depuración Scanner
			}
		}while(inputTrue == false);
		return num;
	}
}
