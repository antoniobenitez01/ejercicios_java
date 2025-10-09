package ejercicioA5;

import java.time.LocalDate;

public class Alumno 
{
	public static final int LIMITE_MAXIMO_ALUMNOS = 50;
	public static final int LIMITE_MODULOS_MATRICULA = 8;
	private static int numeroAlumnos;
	private static double mediaModulosAprobados;
	private static int numeroAlumnosTodoAprobado;
	
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private boolean tieneBeca;
	private int numeroModulosMatriculados;
}
