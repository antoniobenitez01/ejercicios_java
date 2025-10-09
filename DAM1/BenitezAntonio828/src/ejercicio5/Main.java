/*
 * Programa que hace uso de las clase creada
 * Alumno para simular un instituto de FP
 * Excepciones: InputMismatchException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 21/30/2025
 */
package ejercicio5;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		//INICIALIZACIÓN ---------------------------------------------------------------------------------------------------------------
		
		Scanner entradaTeclado = new Scanner(System.in);
		
		//CREACIÓN DE COLECCIÓN --------------------------------------------------------------------------------------------------------
		
		LinkedList<Alumno> fp = new LinkedList<Alumno>();
		
		fp.add(new Alumno("García Lorca", "Felipe", "C/Lorca", "600600600", LocalDate.of(2001, 12, 28)));
		fp.add(new Alumno("Del Norte Durán", "María", "C/Lorca", "600600600", LocalDate.of(1998, 1, 28)));
		fp.add(new Alumno("Benítez García", "Juan", "C/Lorca", "600600600", LocalDate.of(2010, 2, 28)));
		fp.add(new Alumno("Cabello Cano", "Claudia", "C/Lorca", "600600600", LocalDate.of(2005, 3, 28)));
		fp.add(new Alumno("Delirio Martinez", "Pepe", "C/Lorca", "600600600", LocalDate.of(1999, 5, 28)));
		fp.add(new Alumno("García Jimenez", "Carlos", "C/Lorca", "600600600", LocalDate.of(1987, 7, 28)));
		fp.add(new Alumno("Jimenez Perez", "María", "C/Lorca", "600600600", LocalDate.of(2005, 2, 28)));
		fp.add(new Alumno("Perez Martinez", "Francisca", "C/Lorca", "600600600", LocalDate.of(2006, 10, 28)));
		fp.add(new Alumno("Lorca Perez", "Antonio", "C/Lorca", "600600600", LocalDate.of(2004, 6, 28)));
		fp.add(new Alumno("Del Olmo Grund", "Mario", "C/Lorca", "600600600", LocalDate.of(2002, 5, 28)));
		
		//PROGRAMA ----------------------------------------------------------------------------------------------------------------------
		
		System.out.println("\n=== COLECCIONES EJERCICIO 5: ALUMNOS DE FP ===\n");
		
		System.out.println("--- LISTA DE ALUMNOS ---\n");
		int contador = 1;
		for(Alumno i: fp)
		{
			System.out.printf("%d. %s\n", contador, i.toString());
			contador++;
		}
		
		int opcion;
		Alumno encontrado;
		do
		{
			encontrado = null;
			opcion = menuPrincipal(entradaTeclado);
			switch(opcion)
			{
			case 1: // INCORPORAR UN NUEVO ALUMNO -------------------------------------------------------------------
				Alumno alumnoCreado = crearAlumno(entradaTeclado);
				if(alumnoCreado != null)
				{
					fp.add(alumnoCreado);
				}else
				{
					System.out.println("Se ha producido un error. Volviendo al menú principal.");
				}
				break;
			case 2: // MOSTRAR INFORMACION ----------------------------------------------------------------------
				encontrado = buscarAlumno(entradaTeclado, fp);
				if(encontrado != null)
				{
					System.out.printf("%s\n", encontrado.toString());
				}else
				{
					System.out.println("No se ha encontrado ningún Alumno con ese código.");
				}
				break;
			case 3: // DAR DE BAJA A ALUMNO ---------------------------------------------------------------------
				System.out.println("Introduzca el nombre del Alumno");
				String nombreTeclado = entradaTeclado.nextLine();
				
				System.out.println("Introduzca los apellidos del Alumno");
				String apellidosTeclado = entradaTeclado.nextLine();
				
				encontrado = null;
				for(Alumno i: fp)
				{
					if(i.getNombre().equals(nombreTeclado) && i.getApellidos().equals(apellidosTeclado))
					{
						encontrado = i;
					}
				}
				if(encontrado != null)
				{
					fp.remove(encontrado);
					System.out.printf("Alumno %s %s ha sido eliminado con éxito. Mostrando lista de Alumnos ...\n",
							encontrado.getNombre(),encontrado.getApellidos());
					contador = 1;
					for(Alumno i: fp)
					{
						System.out.printf("%d. %s\n", contador, i.toString());
						contador++;
					}
				}else
				{
					System.out.println("No se ha encontrado a un Alumno con ese nombre y apellidos");
				}
				break;
			case 4: // MODIFICAR DIRECCION Y TELEFONO --------------------------------------------------------------
				encontrado = buscarAlumno(entradaTeclado, fp);
				if(encontrado != null)
				{
					System.out.println("Introduzca la nueva direccion del Alumno");
					String direccionTeclado = entradaTeclado.nextLine();
					
					System.out.println("Introduzca el nuevo telefono del Alumno");
					String telefonoTeclado = entradaTeclado.nextLine();
					
					encontrado.setDireccion(direccionTeclado);
					encontrado.setTelefono(telefonoTeclado);
					System.out.printf("%s\n", encontrado.toString());
				}else
				{
					System.out.println("No se ha encontrado a un Alumno con ese código.");
				}
				break;
			case 5: // SOLICITAR CAMBIO DE CARRERA  -----------------------------------------------------------------
				encontrado = buscarAlumno(entradaTeclado, fp);
				if(encontrado != null)
				{
					System.out.println("Introduzca el código de carrera del Alumno");
					String codCicloTeclado = entradaTeclado.nextLine();
					
					int cantAprobadoTeclado = inputInt("Introduzca la cantidad de cursos aprobados del Alumno", entradaTeclado);
					
					encontrado.setCodigoCiclo(codCicloTeclado);
					encontrado.setCantAprobado(cantAprobadoTeclado);
					System.out.printf("%s\n", encontrado.toString());
				}else
				{
					System.out.println("No se ha encontrado a un Alumno con ese código.");
				}
				break;
			case 6: // APAGAR PROGRAMA -------------------------------------------------------------------------------
				System.out.println("Saliendo del programa ...");
				break;
			}
		}while(opcion != 6);
		
		//FIN PROGAMA ---------------------------------------------------------------------------------------------------------------
	}
	
	//BUSCAR ALUMNO - Devuelve el Alumno encontrado a partir de su código
	private static Alumno buscarAlumno(Scanner entradaTeclado, LinkedList<Alumno> fp)
	{
		System.out.println("Introduzca el código de Alumno");
		String codigoTeclado = entradaTeclado.nextLine();
		Alumno encontrado = null;
		for(Alumno i:fp)
		{
			if(i.getCodigo().equals(codigoTeclado))
			{
				encontrado = i;
			}
		}
		return encontrado;
	}
	
	//CREAR ALUMNO - Crea  y devuelve un objeto Alumno a partir de datos introducidos por teclado
	private static Alumno crearAlumno(Scanner entradaTeclado)
	{
		System.out.println("Introduzca el nombre del Alumno");
		String nombreTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca los apellidos del Alumno");
		String apellidosTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca la direccion del Alumno");
		String direccionTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca el telefono del Alumno");
		String telefonoTeclado = entradaTeclado.nextLine();
		
		System.out.println("Introduzca la fecha de ingreso del Alumno");
		LocalDate fechaTeclado = inputDate(entradaTeclado);
		
		Alumno alumnoCreado = new Alumno(apellidosTeclado, nombreTeclado, direccionTeclado, telefonoTeclado, fechaTeclado);
		return alumnoCreado;
	}
	
	//MENÚ PRINCIPAL - Muestra el menú principal y devuelve la opción escogida por teclado
	private static int menuPrincipal(Scanner entradaTeclado)
	{
		int opcion;
		do // BUCLE - Do while que termina cuando se escoge una opción correctamente
		{
			System.out.println("\n=== || MENÚ PRINCIPAL || ==="+
					"\n\n 1. Incorporar un nuevo Alumno"+
					"\n 2. Mostrar información por código"+
					"\n 3. Dar de baja a Alumno" +
					"\n 4. Modificar dirección y teléfono de Alumno" +
					"\n 5. Solicitar cambio de carrera" +
					"\n 6. Salir del programa\n");
			opcion = inputInt("Elija una opción:", entradaTeclado);
			if(opcion < 1 || opcion > 6) // Opcion introducida no válida
			{
				System.out.println("Opción introducida no válida, inténtelo de nuevo.");
			}
		}while(opcion < 1 || opcion > 6);
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
	
	//INPUT DATE - Devuelve un objeto LocalDate a través de una fecha introducida por teclado
	private static LocalDate inputDate(Scanner entradaTeclado)
	{
		String fechaString;
		LocalDate fechaIntroducida = null;
		boolean fechaCorrecta = false;
		
		//BUCLE - Do While para asegurarse de que se introduce la fecha correctamente por teclado
		do
		{
			//EXCEPCIÓN - DateTimeParseException - Devuelve un error cuando se introduce un fecha fuera del formato ISO
			try
			{
				System.out.println("Introduzca una fecha por teclado (formato: YYYY-MM-DD)");
				fechaString = entradaTeclado.nextLine();
				fechaIntroducida = LocalDate.parse(fechaString);
				fechaCorrecta = true;
			}
			catch(DateTimeParseException excepcion1)
			{
				System.out.println("La fecha introducida no es válida."+
									"\nAsegúrese de que está siguiendo el formato correctamente.");
			}
		}while(fechaCorrecta == false);
		
		return fechaIntroducida;
	}
}
