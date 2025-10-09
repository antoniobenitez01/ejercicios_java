/*
 * Clase que representa una Empresa
 * Excepciones: IllegalArgumentException, IllegalStateException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 19/02/2025 
 */
package ejercicio1;

public class Empresa 
{
	
// ATRIBUTOS ===========================================================================
	
	public static final String NOMBRE_DEFAULT = "Sin nombre";
	public static final String CIF_DEFAULT = "A999999";
	public static final String TELEFONO_DEFAULT = "999999999";
	public static final String DIRECCION_DEFAULT = "Sin dirección";
	public static final int TAMANYO_DEFAULT = 50;
	
	private final String nombre;
	private final String cif;
	
	private int tamanyoEmpresa;
	private String telefono;
	private String direccion;
	private Empleado[] empleados;
	private short ultimaPos;
	
// CONSTRUCTORES ========================================================================
	
	//Constructor maestro (4 parámetros)
	public Empresa(String nombre, String cif, String telefono, String direccion, int tamanyoEmpresa) throws IllegalArgumentException
	{
		if(nombre.isEmpty() || nombre == null)
		{
			throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
		}
		if(cif.isEmpty() || cif == null)
		{
			throw new IllegalArgumentException("El CIF no puede ser nulo o vacío.");
		}
		if(telefono.isEmpty() || telefono == null)
		{
			throw new IllegalArgumentException("El teléfono no puede ser nulo o vacío.");
		}
		if(direccion.isEmpty() || direccion == null)
		{
			throw new IllegalArgumentException("La dirección no puede ser nula o vacía.");
		}
		if(tamanyoEmpresa < 1)
		{
			throw new IllegalArgumentException("El tamaño de la Empresa no puede ser menor que 1.");
		}
		
		this.nombre = nombre;
		this.cif = cif;
		
		this.telefono = telefono;
		this.direccion = direccion;
		this.tamanyoEmpresa = tamanyoEmpresa;
		
		this.empleados = new Empleado[this.tamanyoEmpresa];
		this.ultimaPos = 0;
	}
	
	//Constructor por omisión
	public Empresa()
	{
		this(NOMBRE_DEFAULT, CIF_DEFAULT, TELEFONO_DEFAULT, DIRECCION_DEFAULT, TAMANYO_DEFAULT);
	}
	
// GETTERS ================================================================================
	
	/*Originalmente, configuré un Get que te devolvía el array de objetos Empleado,
	  pero consideré que era demasiada información privada siendo compartida.
	  Necesitaba el array para saber la longitud de la empresa, pero acabé separando
	  los valores para proporcionar más customización de la empresa y para no compartir
	  tanta información privada mediante un Get.*/
	
	//Devuelve el tamaño de la Empresa
	public int getTamanyoEmpresa()
	{
		return this.tamanyoEmpresa;
	}
	
// MÉTODOS ================================================================================
	
	//AÑADIR EMPLEADO - Añade un empleado a la lista de empleados de la Empresa
	public void anadirEmpleado(Empleado empleado) throws NullPointerException, IllegalStateException
	{
		if(empleado == null)
		{
			throw new NullPointerException("El empleado introducido no puede ser nulo.");
		}
		if(ultimaPos >= empleados.length)
		{
			throw new IllegalStateException("No se puede añadir el Empleado porque la Empresa está llena.");
		}
		this.empleados[ultimaPos] = empleado;
		ultimaPos++;
	}
	
	//ELIMINAR EMPLEADO - Elimina el empleado que se encuentra en la posición introducida por parámetro
	public void eliminarEmpleado(int posicion) throws NullPointerException
	{
		int posicionReal = posicion - 1;
		
		if(this.empleados[posicionReal] == null || posicionReal < 0 || posicionReal > this.empleados.length)
		{
			throw new NullPointerException("No hay ningún empleado en esa posición");
		}
		
		this.empleados[posicionReal] = null;
		reorganizarEmpresa(posicionReal);
	}
	
	//MOSTRAR TODOS EMPLEADOS - Muestra todos los empleados de la lista de empleados
	public void mostrarTodosEmpleados()
	{
		for(int i=0; i<this.empleados.length && this.empleados[i] != null; i++)
		{
			System.out.printf("Empleado Nº%d\n%s\n\n", i+1,this.empleados[i].toString());
		}
	}
	
	//MOSTRAR SUELDOS EMPLEADOS - Muestra los sueldos de todos los empleados de la lista de empleados
	public void mostrarSueldosEmpleados()
	{
		for(int i=0; i<this.empleados.length && this.empleados[i] != null; i++)
		{
			System.out.printf("Empleado Nº%d\nDNI: %s\nSueldo bruto: %.2f€\nSueldo neto: %.2f€\n\n",
					i+1,this.empleados[i].getDni(),this.empleados[i].getSueldoBruto(),this.empleados[i].calcularSueldoNeto());
		}
	}
	
	//SUMA SUELDO BRUTO - Suma los sueldos brutos de todos los empleados
	public double sumaSueldoBruto()
	{
		double suma = 0;
		for(int i=0; i<this.empleados.length && this.empleados[i] != null; i++)
		{
			suma += this.empleados[i].getSueldoBruto();
		}
		return suma;
	}
	
	//SUMA SUELDO NETO - Suma los sueldos neto de todos los empleados
	public double sumaSueldoNeto()
	{
		double suma = 0;
		for(int i=0; i<this.empleados.length && this.empleados[i] != null; i++)
		{
			suma += this.empleados[i].calcularSueldoNeto();
		}
		return suma;
	}
	
	//REORGANIZAR EMPRESA - Reorganiza el array de lista de empleados de la Empresa
	private void reorganizarEmpresa(int posicionReal)
	{
		for(int i=posicionReal;i<this.empleados.length;i++)
		{
			if(this.empleados[i] == null && i != (this.empleados.length - 1))
			{
				this.empleados[i] = this.empleados[i+1];
				this.empleados[i+1] = null;
			}
		}
	}
}
