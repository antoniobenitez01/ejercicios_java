package ejercicio1;

public class PrincipalCancion {

	public static void main(String[] args) 
	{
		
		Cancion cancion1 = null, cancion2 = null; //Inicializamos variables Cancion para evitar errores
		//1. Crear una canción sin título y sin autor.
		try
		{
			System.out.println("1. Creando canción sin título y sin autor...");
			cancion1 = new Cancion("","");
			System.out.println("Canción 1 creada con éxito.");
		}catch(IllegalArgumentException ex)
		{
			//EXCEPCIÓN - Lanza error cuando los parámetros están vacíos o nulos
			System.out.println(ex);
		}
		
		//2. Crear una canción con los valores por defecto.
		System.out.println("\n2. Creando canción con valores por defecto...");
		cancion1 = new Cancion();
		System.out.println("Canción 1 creada con éxito.");
		
		//3. Modificar el título de la canción anterior con y sin contenido.
		try
		{
			System.out.println("\n3. Modificando título de Canción 1 con contenido...");
			cancion1.ponTitulo("Contenido");
			System.out.println("Título de Canción 1 modificado con éxito." + 
							"\nModificando título de Canción 1 sin contenido...");
			cancion1.ponTitulo("");
			System.out.println("Título de Canción 1 modificado con éxito.");
		}catch(IllegalArgumentException ex)
		{
			//EXCEPCIÓN - Lanza error cuando los parámetros están vacíos o nulos
			System.out.println(ex);
		}
		
		//4. Clonar la canción anterior.
		System.out.println("\n4. Clonando Canción 1 en Canción 2...");
		cancion2 = new Cancion(cancion1);
		
		//5. Crear una variable de referencia a la canción clonada.
		System.out.println("\n5. Creando variable de referencia a Canción 2...");
		Cancion cancionClon = cancion2;
		
		//6. Modificar el autor de la canción clonada usando la variable de referencia creada en el apartado anterior.
		System.out.println("\n6. Modificando autor de Canción 2 mediante variable de referencia...");
		cancionClon.ponAutor("Autor nuevo");
		
		//7. Mostrar La información de todas las canciones.
		System.out.println("\n7. Mostrando información de todas las canciones...");
		System.out.printf("Canción 1: %s \nCanción2: %s \nCanción clonada: %s",
				cancion1.toString(), cancion2.toString(), cancionClon.toString());
	}

}
