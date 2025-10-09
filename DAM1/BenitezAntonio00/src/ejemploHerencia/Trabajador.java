package ejemploHerencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Trabajador
{
	protected static final String DNI_DEFAULT = "XXXXXXXXA"; 
	protected static final String NOMBRE_DEFAULT = "Vacío"; 
	protected static final String APELLIDOS_DEFAULT = "Vacío"; 
	protected static final LocalDate FECHA_DEFAULT = LocalDate.of(1999, 1, 1); 
	protected static final int NUMHIJOS_DEFAULT = 0;
	protected static final double SALARIO_BASE_DEFAULT = 1024.50;
	protected static final int DIAS_VACACIONES_DEFAULT = 20;
	
	private static int numTrabajadores;
	
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected LocalDate fechaInicio;
	protected int numHijos;
	protected double salarioBase;
	
	public Trabajador(String dni, String nombre, String apellidos, LocalDate fechaInicio, int numHijos)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaInicio = fechaInicio;
		this.numHijos = numHijos;
		
		numTrabajadores++;
	}
	
	public Trabajador()
	{
		this(DNI_DEFAULT, NOMBRE_DEFAULT, APELLIDOS_DEFAULT, FECHA_DEFAULT, NUMHIJOS_DEFAULT);
	}
	
	public static int getNumeroTrabajadores()
	{
		return numTrabajadores;
	}
	
	public abstract double calcularNomina(double salarioBase);
	
	public abstract int calcularVacaciones();
	
	public String toString()
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("DNI: %s \nNombre: %s \nApellidos: %s \nFecha de inicio: %s \nNúmero de hijos: %d",
				this.dni, this.nombre, this.apellidos, this.fechaInicio.format(formato), this.numHijos);
	}
}
