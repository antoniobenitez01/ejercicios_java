package ejercicioD2;

public class Persona 
{
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	
// CONSTRUCTORES ===
	
	public Persona(String dni, String nombre, String apellidos, int edad)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
// GETTERS =========
	
	public String getDni()
	{
		return this.dni;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getApellidos()
	{
		return this.apellidos;
	}
	
	public int getEdad() 
	{
		return this.edad;
	}
	
// SETTERS =========
	
	public void setDni(String dni)
	{
		this.dni = dni;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}
	
	public void setEdad(int edad)
	{
		this.edad = edad;
	}
	
// MÉTODOS ==========
	
	//MÉTODO - Imprime por pantalla los atributos del objeto Persona
	public void imprime()
	{
		System.out.println("DNI: " + this.dni +
						"\nNombre: " + this.nombre +
						"\nApellidos: " + this.apellidos +
						"\nEdad: " + this.edad); 
	}
	
	//MÉTODO - Devuelve true si la edad de Persona es 18 o mayor
	public boolean esMayorEdad()
	{
		boolean esMayorEdad = false;
		if(this.edad >= 18)
		{
			esMayorEdad = true;
		}
		else
		{
			esMayorEdad = false;
		}
		return esMayorEdad;
	}
	
	//MÉTODO - Devuelve true si la edad de Persona es 65 o mayor
	public boolean esJubilado()
	{
		boolean esJubilado = false;
		if(this.edad >= 65)
		{
			esJubilado = true;
		}
		else
		{
			esJubilado = false;
		}
		return esJubilado;
	}
	
	//MÉTODO - Recoge un objeto Persona y devuelve la diferencia de edad entre dos objetos Persona
	public int diferenciaEdad(Persona p)
	{
		int diferenciaEdad = 0;
		if(p.edad > this.edad)
		{
			diferenciaEdad = p.edad - this.edad;
		}
		else
		{
			diferenciaEdad = this.edad - p.edad;
		}
		return diferenciaEdad;
	}
}
