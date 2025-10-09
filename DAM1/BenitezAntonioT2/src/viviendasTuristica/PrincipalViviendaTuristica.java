/*
 * Objetivo: mostrar el desarrollo de las clases creadas
 * Fecha: 11/03/2025
 * Autor: Antonio Benítez Rodríguez
 */
package viviendasTuristica;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalViviendaTuristica {

	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		
		// 1. Crea un apartamento con valores por defecto.
		// Evidencia. El valor de cada uno de los atributos
		System.out.println (" 1 ============");
		
		System.out.println("1. Creando apartamento con valores por defecto ...");
		Apartamento aptDefault = new Apartamento();
		System.out.printf("%s\n", aptDefault.toString());
		
		//2. Calcula el precio para una estancia de 3 días.
		// Evidencia: el precio de la estancia.
		System.out.println (" 2 ============");
		
		System.out.println("2. Calculando precio de estancia de 3 días ...");
		System.out.printf("Precio de estancia de 3 días: %.2f€\n", aptDefault.calcularPrecio(3));
		
		//3. Crea un apartamento con precio por noche (valor solicitado al usuario) y distancia al centro (solicitado al usuario). Resto de valores por defecto.
		// Evidencia. El valor de cada uno de los atributos
		System.out.println (" 3 ============");
		
		System.out.println("3. Creando Apartamento con valores solicitados ...");
		double precioTeclado = inputDouble("Introduzca el precio por noche del Apartamento:", entradaTeclado);
		double distanciaTeclado = inputDouble("Introduzca la distancia al centro del Apartamento:", entradaTeclado);
		
		Apartamento aptTeclado;
		try
		{
			aptTeclado = new Apartamento(Vivienda.DIRECCION_DEFAULT, precioTeclado, false, 
					Apartamento.HABITACIONES_DEFAULT, distanciaTeclado, Apartamento.FECHAREF_DEFAULT);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			aptTeclado = new Apartamento();
		}
		
		System.out.printf("%s\n", aptTeclado.toString());
		
		//4. Calcula el precio para una estancia de 5 días.
		// Evidencia: el precio de la estancia.
		System.out.println (" 4 ============");	
		
		System.out.println("4. Calculando precio de estancia de 5 días ...");
		System.out.printf("Precio de estancia de 5 días: %.2f€\n", aptTeclado.calcularPrecio(5));
		
		//5. Crea una casa rural con valores por defecto.
		// Evidencia. El valor de cada uno de los atributos.
		System.out.println (" 5 ============");	

		System.out.println("5. Creando Casa Rural con valores por defecto ...");
		CasaRural casaDefault = new CasaRural();
		System.out.printf("%s\n", casaDefault.toString());
		
		//6. Crea una casa rural con precio por noche (valor solicitado al usuario) y el resto por defecto.
		// Evidencia. El valor de cada uno de los atributos.
		System.out.println (" 6 ============");	

		System.out.println("6. Creando Casa Rural con valores por teclado ...");
		precioTeclado = inputDouble("Introduzca el precio por noche de la Casa Rural:", entradaTeclado);
		
		CasaRural casaTeclado;
		try
		{
			casaTeclado = new CasaRural(Vivienda.DIRECCION_DEFAULT, precioTeclado, false,
					CasaRural.METROS_DEFAULT, CasaRural.FECHACON_DEFAULT, false);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			casaTeclado = new CasaRural();
		}
		
		System.out.printf("%s\n", casaTeclado.toString());
		
		// 7. Calcula el precio de una estancia de 10 días.
		// Evidencia: el precio de la estancia.
		System.out.println (" 7 ============");	

		System.out.println("7. Calculando precio de estancia de 10 días ...");
		System.out.printf("Precio de estancia de 10 días: %.2f€\n", casaTeclado.calcularPrecio(10));
		
		// 8. Modifica la fecha de construcción a 1/1/2023.
		// Evidencia. El valor de cada uno de los atributos.
		System.out.println (" 8 ============");	
		
		System.out.println("8. Modificando fecha de construcción a 1/1/2023 ...");
		casaTeclado.setFechaConstruccion(LocalDate.of(2023, 01, 01));
		System.out.printf("%s\n", casaTeclado.toString());

		// 9. Indica si la casa es pet friendly.
		// Evidencia. Indica si es "pet friendly".
		System.out.println (" 9 ============");	

		System.out.println("9. Calculando si Casa Rural es pet friendly ...");
		if(casaTeclado.esPetFriendly())
		{
			System.out.println("La Casa Rural es pet friendly.");
		}else
		{
			System.out.println("La Casa Rural no es pet friendly.");
		}
		
		// 10. Crea un hotel con valores por defecto.
		// Evidencia. El valor de cada uno de los atributos.
		System.out.println (" 10 ============");

		System.out.println("10. Creando Hotel con valores por defecto ...");
		Hotel hotelDefault = new Hotel();
		System.out.printf("%s\n", hotelDefault.toString());
		
		// 11. Crea un hotel con todos los valores solicitados al usuario. (el objeto debe ser creado por un método)
		// Evidencia. El valor de cada uno de los atributos.
		System.out.println (" 11 ============");	

		System.out.println("11. Creando hotel con valores solicitados por teclado ...");
		Hotel hotelTeclado;
		hotelTeclado = crearHotel(entradaTeclado);
		System.out.printf("%s\n", hotelTeclado.toString());
		
		//12. Calcula el precio de una estancia de 1 día.
		// Evidencia: el precio de la estancia.
		System.out.println (" 12 ============");	

		System.out.println("12. Calculando precio de estancia de 1 día ...");
		System.out.printf("Precio de estancia de 1 día: %.2f€\n", hotelTeclado.calcularPrecio(1));
		
		// 13. Modifica el valor de Spa a sí.
		// Evidencia. El valor de cada uno de los atributos.
		System.out.println (" 13 ============");	

		System.out.println("13. Modificando valor de Spa a sí ...");
		hotelTeclado.setTieneSpa(true);
		System.out.printf("%s\n", hotelTeclado.toString());
		
		// 14. Calcula el precio de una estancia de 1 día.
		// Evidencia: el precio de la estancia.
		System.out.println (" 14 ============");	

		System.out.println("14. Calculando precio de estancia de 1 día ...");
		System.out.printf("Precio de estancia de 1 día: %.2f€\n", hotelTeclado.calcularPrecio(1));
	
		// 15. Calcula el número de viviendas creadas.
		// Evidencia. El número de viviendas creadas.
		System.out.println (" 15 ============");
		
		System.out.println("15. Calculando número de viviendas creadas en total ...");
		System.out.printf("Número de viviendas creadas en total: %d viviendas", Vivienda.getNumeroViviendas());
		
	}
	
	public static Hotel crearHotel(Scanner entradaTeclado)
	{
		System.out.println("Introduzca la dirección del Hotel");
		String direccionTeclado = entradaTeclado.nextLine();
		
		double precioTeclado = inputDouble("Introduzca el precio por noche del Hotel", entradaTeclado);
		
		boolean disponibleTeclado = booleanCheck("¿Está disponible el Hotel?", entradaTeclado);
		
		int estrellasTeclado = inputInt("Introduzca las estrellas que tiene el Hotel", entradaTeclado);
		
		int habitacionesTeclado = inputInt("Introduzca el número de habitaciones del Hotel", entradaTeclado);
		
		boolean spaTeclado = booleanCheck("¿El Hotel tiene spa?", entradaTeclado);
		
		Hotel hotelCreado;
		try
		{
			hotelCreado = new Hotel(direccionTeclado, precioTeclado, disponibleTeclado,
					estrellasTeclado, habitacionesTeclado, spaTeclado);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			System.out.println("Se ha producido un error a la hora de crear el Hotel, creando Hotel por defecto ...");
			hotelCreado = new Hotel();
		}
		
		return hotelCreado;
	}
	
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

	//INPUT DOUBLE - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Double correctamente
	public static double inputDouble(String mensaje, Scanner entrada)
	{
		double num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextDouble();
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
