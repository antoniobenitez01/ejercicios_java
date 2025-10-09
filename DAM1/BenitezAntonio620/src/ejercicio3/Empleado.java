/*
 * Clase que representa un Empleado con su
 * información personal detalla y su información ecónomica.
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/01/2025
 */
package ejercicio3;

public class Empleado 
{
	//ATRIBUTOS ================================
	
	public static final  double PAGO_HORAS_EXTRAS= 5.25; //Valor constante del pago de horas extras
	private static int cantidadEmpleados = 0; //Cantidad de empleados en la empresa
	
	private String dni;			//DNI
	private String nombre;		//Nombre
	private String apellidos;	//Apellidos 
	private double sueldoBase;	//Sueldo base
	private int horasExtrasMes;	//Horas extras en el mes
	private double tipoIrpf;	//Tipo de IRPF (porcentaje)
	private boolean casado;		//Casado o no casado
	private int numeroHijos;	//Número de hijos
	
	// CONSTRUCTORES ===========================

	//	Constructor maestro (todos los atributos)
	public Empleado(String dni, String nombre, String apellidos, double sueldoBase, int horasExtrasMes, 
					double tipoIrpf, boolean casado, int numeroHijos) throws IllegalArgumentException
	{
		//		Excepciones
		if(dni == null || dni.isEmpty())
		{
			throw new IllegalArgumentException("El DNI no puede estar vacío o ser nulo.");
		}
		if(nombre == null || nombre.isEmpty())
		{
			throw new IllegalArgumentException("El nombre no puede estar vacío o ser nulo.");
		}
		if(apellidos == null || apellidos.isEmpty())
		{
			throw new IllegalArgumentException("Los apellidos no pueden estar vacíos o ser nulos.");
		}
		if(sueldoBase < 0)
		{
			throw new IllegalArgumentException ("El sueldo base no puede ser negativo.");
		}
		if(horasExtrasMes < 0)
		{
			throw new IllegalArgumentException ("Las horas extras no pueden ser negativas.");
		}
		if(tipoIrpf < 0)
		{
			throw new IllegalArgumentException ("El tipo IRPF no puede ser negativo.");
		}
		if(numeroHijos < 0)
		{
			throw new IllegalArgumentException ("El número de hijos no puede ser negativo.");
		}
		
		//		Construccion de objeto
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldoBase = sueldoBase;
		this.horasExtrasMes = horasExtrasMes;
		this.tipoIrpf = tipoIrpf;
		this.casado = casado;
		this.numeroHijos = numeroHijos;
		
		//		Tratamiento atributos de clase
		cantidadEmpleados++;
	}
	
	//	Constructor 3 parámetros
	public Empleado(String dni, String nombre, String apellidos)
	{
		this(dni,nombre,apellidos,1000.00,0,9.75,false,0);
	}
	
	// Constructor de copia
	public Empleado(Empleado e)
	{
		this(e.dni,e.nombre,e.apellidos,e.sueldoBase,e.horasExtrasMes,e.tipoIrpf,e.casado,e.numeroHijos);
	}
	
	// GETTERS Y SETTERS =======================
	
	//GET - Devuelve el valor entero estático cantidadEmpleados
	public static int getCantidadEmpleados()
	{
		return cantidadEmpleados;
	}
	
	//GET - Devuelve el objeto String dni
	public String getDni()
	{
		return this.dni;
	}
	
	//SET - Recoge un objeto de String para establecerlo como el atributo dni
	public void setDni(String dni) throws IllegalArgumentException
	{
		if(dni == null || dni.isEmpty())
		{
			throw new IllegalArgumentException("El DNI no puede estar vacío o ser nulo.");
		}
		this.dni = dni;
	}
	
	//GET - Devuelve el objeto String nombre
	public String getNombre()
	{
		return this.nombre;
	}
	
	//SET - Recoge un objeto de String para establecerlo como el atributo nombre
	public void setNombre(String nombre) throws IllegalArgumentException
	{
		if(nombre == null || nombre.isEmpty())
		{
			throw new IllegalArgumentException("El nombre no puede estar vacío o ser nulo.");
		}
		this.nombre = nombre;
	}
	
	//GET - Devuelve el objeto String apellidos
	public String getApellidos()
	{
		return this.apellidos;
	}
	
	//SET - Recoge un objeto de String para establecerlo como el atributo apellidos
	public void setApellidos(String apellidos) throws IllegalArgumentException
	{
		if(apellidos == null || apellidos.isEmpty())
		{
			throw new IllegalArgumentException("Los apellidos no pueden estar vacíos o ser nulos.");
		}
		this.apellidos = apellidos;
	}
	
	//GET - Devuelve el valor decimal sueldoBase
	public double getSueldoBase()
	{
		return this.sueldoBase;
	}
	
	//SET - Recoge un valor decimal para establecerlo como el atributo sueldoBase
	public void setSueldoBase(double sueldoBase) throws IllegalArgumentException
	{
		if(sueldoBase < 0)
		{
			throw new IllegalArgumentException ("El sueldo base no puede ser negativo.");
		}
		this.sueldoBase = sueldoBase;
	}
	
	//GET - Recoge el valor entero horasExtrasMes
	public int getHorasExtrasMes()
	{
		return this.horasExtrasMes;
	}
	
	//SET - Recoge un valor entero para establecerlo como el atributo horasExtrasMes
	public void setHorasExtrasMes(int horasExtrasMes) throws IllegalArgumentException
	{
		if(horasExtrasMes < 0)
		{
			throw new IllegalArgumentException ("Las horas extras no pueden ser negativas.");
		}
		this.horasExtrasMes = horasExtrasMes;
	}
	
	//GET - Devuelve el valor decimal tipoIrpf
	public double getTipoIrpf()
	{
		return this.tipoIrpf;
	}
	
	//SET - Recoge un valor decimal para establecerlo como el atributo tipoIrpf
	public void setTipoIrpf(double tipoIrpf) throws IllegalArgumentException
	{
		if(tipoIrpf < 0)
		{
			throw new IllegalArgumentException ("El tipo IRPF no puede ser negativo.");
		}
		this.tipoIrpf = tipoIrpf;
	}
	
	//GET - Devuelve el valor booleano casado
	public boolean getCasado()
	{
		return this.casado;
	}
	
	//SET - Recoge un valor booleano para establecerlo como el atributo casado
	public void setCasado(boolean casado)
	{
		this.casado = casado;
	}
	
	//GET - Devuelve el valor entero numeroHijos
	public int getNumeroHijos()
	{
		return this.numeroHijos;
	}
	
	//SET - Recoge un valor entero para establecerlo como el atributo numeroHijos
	public void setNumeroHijos(int numeroHijos) throws IllegalArgumentException
	{
		if(numeroHijos < 0)
		{
			throw new IllegalArgumentException ("El número de hijos no puede ser negativo.");
		}
		this.numeroHijos = numeroHijos;
	}
	
	// MÉTODOS ================================
	
	//Devuelve el complemento de las horas extras basado en las horas extras realizadas en el mes
	public double complementoHorasExtras()
	{
		return PAGO_HORAS_EXTRAS * this.horasExtrasMes;
	}
	
	//Calcula y devuelve el sueldo en bruto
	public double sueldoBruto()
	{
		return this.sueldoBase - (this.sueldoBase * (this.tipoIrpf / 100)) + this.complementoHorasExtras();
	}
	
	//Calcula y devuelve las retenciones de IRPF
	public double calculoIRPF()
	{
		double sueldoIRPF = 0;
		int puntos = 0;
		if(this.casado == true)
		{
			puntos = puntos + 2;
		}
		puntos = puntos + (puntos*this.numeroHijos);
		sueldoIRPF = this.sueldoBruto() * ((this.tipoIrpf - puntos)/100);
		return sueldoIRPF;
	}
	
	//Muestra el Empleado por pantalla con información básica
	public void verEmpleado()
	{
		System.out.printf("DNI: %s \nNombre: %s \nApellidos: %s \n\n",
							this.dni, this.nombre, this.apellidos);
	}
	
	//Muestra el Empleado por pantalla con información económica detallada
	public void verTodoEmpleado()
	{
		System.out.printf("DNI: %s \nNombre: %s \nApellidos: %s \nSueldo base: %.2f \nComplemento Horas extras: %.2f" + 
							"\nSueldo bruto: %.2f \nRetenciones IRPF: %.2f \nSueldo neto: %.2f \n\n",
							this.dni, this.nombre, this.apellidos, this.sueldoBase, this.complementoHorasExtras(),
							this.sueldoBruto(), this.calculoIRPF(), this.sueldoBruto() - this.calculoIRPF());
	}
	
	//Pseudo-constructor de copia de Empleado
	public static Empleado copia(Empleado e)
	{
		return new Empleado(e);
	}
}
