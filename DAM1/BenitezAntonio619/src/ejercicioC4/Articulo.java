package ejercicioC4;

public class Articulo 
{
	private String nombre;
	private double precio;
	private double iva = 21; //Transformado a una variable de objeto de mutabilidad variable
	private int cuantosQuedan;
	
//CONSTRUCTORES ================
	
	public Articulo(String nombre, double precio, double iva, int cuantosQuedan) throws IllegalArgumentException
	{
		//COMPROBACIÓN DE EXCEPCIONES
		if(nombre == null || nombre.isEmpty())
		{
			throw new IllegalArgumentException ("El nombre no puede ser NULL o vacío.");
		}
		if(precio < 0) //EXCEPCIÓN: Lanza error si el precio es menor que 0
		{
			throw new IllegalArgumentException ("El precio no puede ser menor que 0.");
		}
		if(iva < 0) //EXCEPCIÓN: Lanza error si el IVA es negativo
		{
			throw new IllegalArgumentException ("El IVA no puede ser un valor negativo.");
		}
		if(iva > 21) //EXCEPCIÓN: Lanza error si el IVA sobrepasa el tipo general
		{
			throw new IllegalArgumentException ("El IVA no puede ser mayor que el tipo general.");
		}
		if(cuantosQuedan < 0) //EXCEPCIÓN: Lanza error si cuantosQuedan es un número negativo
		{
			throw new IllegalArgumentException ("No pueden haber un número negativo de artículos.");
		}
		
		//CONSTRUCCIÓN DE OBJETO
		this.nombre = nombre;
		this.precio = precio;
		this.cuantosQuedan = cuantosQuedan;
	}
	
//GETTERS ================
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public double getPrecio()
	{
		return this.precio;
	}
	
	public double getIva()
	{
		return this.iva;
	}
	
	public int getCuantosQuedan()
	{
		return this.cuantosQuedan;
	}
	
//SETTERS ================
	
	public void setNombre(String nombre)
	{
		if(nombre == null || nombre.isEmpty())
		{
			throw new IllegalArgumentException ("El nombre no puede ser NULL o vacío.");
		}
		this.nombre = nombre;
	}
	
	public void setPrecio(double precio)
	{
		if(precio < 0) //EXCEPCIÓN: Lanza error si el precio es menor que 0
		{
			throw new IllegalArgumentException ("El precio no puede ser menor que 0.");
		}
		this.precio = precio;
	}
	
	public void setIva(double iva)
	{
		if(iva < 0) //EXCEPCIÓN: Lanza error si el IVA es negativo
		{
			throw new IllegalArgumentException ("El IVA no puede ser un valor negativo.");
		}
		if(iva > 21) //EXCEPCIÓN: Lanza error si el IVA sobrepasa el tipo general
		{
			throw new IllegalArgumentException ("El IVA no puede ser mayor que el tipo general.");
		}
		this.iva = iva;
	}
	
	public void setCuantosQuedan(int cuantosQuedan)
	{
		if(cuantosQuedan < 0) //EXCEPCIÓN: Lanza error si cuantosQuedan es un número negativo
		{
			throw new IllegalArgumentException ("No pueden haber un número negativo de artículos.");
		}
		this.cuantosQuedan = cuantosQuedan;
	}
}
