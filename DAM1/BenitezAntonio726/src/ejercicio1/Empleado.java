/*
 * Clase que representa un Empleado
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 19/02/2025 
 */
package ejercicio1;

public class Empleado 
{

// ATRIBUTOS ======================================================================
	
	public static final String DNI_DEFAULT = "00000000A";
	public static final String NOMBRE_DEFAULT = "Sin nombre";
	public static final double SUELDO_DEFAULT = 1000;
	public static final short EDAD_DEFAULT = 20;
	public static final String TELEFONO_DEFAULT = "000000000";
	public static final String DIRECCION_DEFAULT = "Sin dirección";
	
	private final String dni;
	private final String nombre;
	
	private double sueldoBruto;
	private short edad;
	private String telefono;
	private String direccion;
	
// CONSTRUCTORES ==================================================================
	
	//Constructor maestro (3 parámetros)
	public Empleado(String dni, String nombre, double sueldoBruto) throws IllegalArgumentException
	{
		if(dni.isEmpty() || dni == null)
		{
			throw new IllegalArgumentException("El dni no puede ser nulo o vacío.");
		}
		if(nombre.isEmpty() || nombre == null)
		{
			throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
		}
		if(sueldoBruto < 0)
		{
			throw new IllegalArgumentException("El sueldo bruto no puede ser menor que 0.");
		}
		
		this.dni = dni;
		this.nombre = nombre;
		this.sueldoBruto = sueldoBruto;
		this.edad = EDAD_DEFAULT;
		this.telefono = TELEFONO_DEFAULT;
		this.direccion = DIRECCION_DEFAULT;
	}
	
	//Constructor por omisión
	public Empleado()
	{
		this(DNI_DEFAULT, NOMBRE_DEFAULT, SUELDO_DEFAULT);
	}
	
// GETTERS ========================================================================
	
	//Devuelve el DNI del Empleado en formato String
	public String getDni()
	{
		return this.dni;
	}
	
	//Devuelve el sueldo bruto del Empleado como valor decimal double
	public double getSueldoBruto()
	{
		return this.sueldoBruto;
	}
	
// MÉTODOS ========================================================================
	
	//CALCULAR SUELDO NETO - Devuelve el sueldo neto calculado a partir del sueldo bruto anual
	public double calcularSueldoNeto()
	{
		double sueldoNeto = 0;
		double sueldoBrutoAnual = this.sueldoBruto * 12;
		double irpf;
		
		if(sueldoBrutoAnual < 12000)
		{
			irpf = 20;
		}else if(sueldoBrutoAnual > 12000 && sueldoBrutoAnual < 25000)
		{
			irpf = 30;
		}else
		{
			irpf = 40;
		}
		sueldoNeto = this.sueldoBruto - (this.sueldoBruto * (irpf/100));
		return sueldoNeto;
	}
	
	//TO STRING - Devuelve un String con la información detallada del Empleado
	public String toString()
	{
		return String.format("DNI: %s\nNombre: %s\nSueldo bruto: %.2f€\nEdad: %d\nTeléfono: %s\nDirección: %s",
				this.dni, this.nombre, this.sueldoBruto, this.edad, this.telefono, this.direccion);
	}
}
