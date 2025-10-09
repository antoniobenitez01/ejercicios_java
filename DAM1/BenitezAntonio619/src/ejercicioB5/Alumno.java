package ejercicioB5;

import java.time.LocalDate;

public class Alumno 
{
	public static final int LIMITE_MAXIMO_ALUMNOS = 50;
	public static final int LIMITE_MODULOS_MATRICULA = 8;
	public static final LocalDate FECHA_NACIMIENTO_DEFAULT = LocalDate.of(1999, 1, 1);
	
	private static int numeroAlumnos;
	private static double mediaModulosAprobados;
	private static int numeroAlumnosTodoAprobado;
	
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private boolean tieneBeca;
	private int numeroModulosMatriculados;
	
	//CONSTRUCTORES
	//Constructor maestro (todos los parámetros)
	public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, boolean tieneBeca, int numeroModulosMatriculados)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.tieneBeca = tieneBeca;
		this.numeroModulosMatriculados = numeroModulosMatriculados;
	}
	
	//Constructor 3 parámetros (DNI, Nombre, Apellidos)
	public Alumno(String dni, String nombre, String apellidos)
	{
		this(dni, nombre, apellidos, FECHA_NACIMIENTO_DEFAULT, false, 0);
	}
	
	//Constructor por omisión de parámetros
	public Alumno()
	{
		this("000000000A", "---", "--- ---", FECHA_NACIMIENTO_DEFAULT, false, 0);
	}
}
