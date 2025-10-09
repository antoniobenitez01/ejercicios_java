package ejercicio2;

import java.time.LocalDate;

public class Gato extends Mascota
{
	
// ATRIBUTOS ===========================================================================
	
	public static final String COLOR_DEFAULT = "Ninguno";
	
	private String color;
	private boolean peloLargo;
	
// CONSTRUCTORES ========================================================================
	
	//Constructor maestro (6 parámetros)
	public Gato(String nombre, int edad, boolean estado, LocalDate fechaNacimiento,
			String color, boolean peloLargo)
	{
		super(nombre, edad, estado, fechaNacimiento);
		
		stringException(color, "color");
		
		this.color = color;
		this.peloLargo = peloLargo;
	}
	
	//Constructor por omisión
	public Gato()
	{
		this(Mascota.NOMBRE_DEFAULT, Mascota.EDAD_DEFAULT, false, Mascota.FECHA_DEFAULT, COLOR_DEFAULT, false);
	}
	
// MÉTODOS ===============================================================================
	
	//TO STRING - Devuelve un String con la información detallada del Gato
	@Override
	public String toString()
	{
		return String.format("%s\nColor: %s\nPelo largo: %s",
				super.toString(), this.color, this.peloLargo ? "Sí" : "No");
	}
	
	//HABLAR - Devuelve un String del Gato hablando
	@Override
	protected String hablar() throws IllegalStateException
	{
		if(!this.estado)
		{
			throw new IllegalStateException("La mascota está muerta");
		}
		return "Meow!";
	}
}
