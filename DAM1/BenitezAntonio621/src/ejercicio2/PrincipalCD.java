package ejercicio2;

import ejercicio1.Cancion;

public class PrincipalCD {

	public static void main(String[] args) 
	{
		//Instanciamos las canciones para añadirlas a continuación
		Cancion cancion1 = new Cancion("SORRY NOT SORRY","Tyler the Creator"), 
				cancion2 = new Cancion("Monitoring", "DECO*27"), 
				cancion3 = new Cancion("tv off.","Kendrick Lamar");
		
		//1. Crea un CD llamado unCd.
		System.out.println("1.Creando CD unCd...");
		CD unCd = new CD();
		System.out.println("Creado con éxito.");
		
		//2. Incluye tres canciones y muestra el número de canciones que incluye.
		System.out.println("\n2. Incluyendo 3 canciones en unCd...");
		try
		{
			System.out.println("\nIncluyendo canción 1...");
			unCd.agrega(cancion1);
			System.out.println("Incluida con éxito.\n");
			System.out.println("Incluyendo canción 2...");
			unCd.agrega(cancion2);
			System.out.println("Incluida con éxito.\n");
			System.out.println("Incluyendo canción 3...");
			unCd.agrega(cancion3);
			System.out.println("Incluida con éxito.\n");
		}catch(IllegalStateException ex)
		{
			//EXCEPCIÓN - Lanza error cuando el CD esté lleno
			System.out.println(ex);
		}
		System.out.printf("Número de canciones: %d \n", unCd.numeroCanciones());
		
		//3. Elimina la segunda canción.
		System.out.println("\n3. Eliminando segunda canción en unCd...");
		try
		{
			unCd.elimina(2);
			System.out.println("Eliminada con éxito.");
		}catch(ArrayIndexOutOfBoundsException ex)
		{
			/*EXCEPCIÓN - Lanza error cuando la posición introducida
			 está fuera del rango del array de canciones*/
			System.out.println(ex);
		}catch(NullPointerException ex2)
		{
			/*EXCEPCIÓN - Lanza error cuando la posición introducida
			 apunta a un valor nulo o espacio vacío en el CD*/
			System.out.println(ex2);
		}
		
		//4. Crea un CD llamado otroCd y copia el contenido de unCd a él.
		System.out.println("\n4. Creando CD otroCD...");
		CD otroCd = new CD();
		System.out.println("CD otroCD creado con éxito.");
		System.out.println("Copiando unCd a otroCd...");
		otroCd.copiarCD(unCd);
		System.out.println("unCd copiado con éxito en otroCd.");
		
		//5. Agrega una canción a otroCd.
		System.out.println("\n5. Agregando canción 2 a otroCd...");
		try
		{
			otroCd.agrega(cancion2);
			System.out.println("Agregado con éxito.");
		}catch(IllegalStateException ex)
		{
			System.out.println(ex);
		}
		
		//6. Muestra el contenido de unCd.
		System.out.println("\n6. Mostrando contenido de unCd...");
		System.out.println("\n" + unCd.toString());
		
		//7. Muestra el contenido de otroCd.
		System.out.println("\n7. Mostrando contenido de otroCd...");
		System.out.println("\n" + otroCd.toString());
	}
}
