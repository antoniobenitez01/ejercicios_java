package ejercicioC2;

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
}
