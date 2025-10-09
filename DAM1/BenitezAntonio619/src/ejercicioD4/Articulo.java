package ejercicioD4;

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
	
// MÉTODOS ===============
	
	//MÉTODO - Imprime los atributos del objeto por pantalla
	public void imprimir()
	{
		System.out.printf("Nombre: %s" +
						"\nPrecio: %.2f" +
						"\nIVA: %.2f" +
						"\nCuantos quedan: %d", 
						this.nombre, this.precio, this.iva, this.cuantosQuedan);
	}
	
	//MÉTODO - Devuelve el PVP del Objeto
	public double getPVP()
	{
		double pvp = 0;
		pvp = this.precio * (this.iva / 100);
		return pvp;
	}
	
	//MÉTODO - Recoge un descuento para devolver el PVP del Objeto calculado con el descuento
	public double getPVPDescuento(double descuento)
	{
		double pvpDescuento = 0, pvp = 0;
		pvp = this.precio * (this.iva / 100);
		pvpDescuento = pvp - (pvp * (descuento / 100));
		return pvpDescuento;
	}
	
	//MÉTODO - Recoge una cantidad y devuelve true si se puede vender
	public boolean vender(int cantidad)
	{
		boolean vendido = false;
		if(this.cuantosQuedan - cantidad >= 0)
		{
			this.cuantosQuedan = this.cuantosQuedan - cantidad;
			vendido = true;
		}
		else
		{
			vendido = false;
		}
		return vendido;
	}
	
	//MÉTODO - Recoge una cantidad y devuelve true si se puede almacenar
	public boolean almacenar(int cantidad)
	{
		boolean almacenado = false;
		if(cantidad < 1)
		{
			almacenado = false;
		}
		else
		{
			almacenado = true;
			this.cuantosQuedan = this.cuantosQuedan + cantidad;
		}
		return almacenado;
	}
}
