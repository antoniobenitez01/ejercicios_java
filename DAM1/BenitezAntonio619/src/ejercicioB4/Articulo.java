package ejercicioB4;

public class Articulo 
{
	String nombre;
	double precio;
	double iva = 21; //Transformado a una variable de objeto de mutabilidad variable
	int cuantosQuedan;
	
	//CONSTRUCTORES
	public Articulo(String nombre, double precio, double iva, int cuantosQuedan) throws IllegalArgumentException
	{
		//COMPROBACIÓN DE EXCEPCIONES
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
}
