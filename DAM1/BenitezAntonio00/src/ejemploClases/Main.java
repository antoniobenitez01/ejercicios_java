package ejemploClases;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) 
	{
		Alumno alumno1, alumno2, alumno1copia;
		Alumno[] alumnoArray;
		try
		{
			System.out.println("Creando Alumno 1 con datos correctos");
			alumno1 = new Alumno("26267841R", "Antonio", "Benítez Rodríguez", LocalDate.of(2001, 12, 28), 81.45, 1.87, 1, true, LocalTime.of(21, 30));
			System.out.println("Creado correctamente!");
			
			System.out.println("Creando Alumno 2 con constructor de menos parámetros");
			alumno2 = new Alumno("26267841R", "fasfgsa", "saffdsa", LocalDate.of(2001, 12, 28));
			System.out.println("Creado correctamente!");
			
			System.out.println("Creando array de Alumnos de ejemplo...");
			alumnoArray = Alumno.crearArrayAlumnosEjemplo();
			
			System.out.println("Creando copia de alumno 1...");
			alumno1copia = new Alumno(alumno1);
			
			System.out.println("Mostrando toString de Alumno...");
			System.out.println(alumno1.toString());
			
			System.out.println("Mostrando Array de Alumnos de Alumno...");
			for(int i=0; i<alumnoArray.length; i++)
			{
				System.out.println("\n=== ALUMNO " + (i+1) + " ===");
				System.out.println(alumnoArray[i].toString());
			}
		}catch(IllegalArgumentException excepcion1)
		{
			System.out.println(excepcion1);
		}
	}

}
