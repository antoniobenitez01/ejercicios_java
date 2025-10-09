package biblioteca;
/*
 * Clase que representa un Libro Digital
 * Extends: Libro
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 01/04/2025
 */
public class LibroDigital extends Libro
{

// ATRIBUTOS ==================================================================
	
	public enum Formatos {PDF, EPUB, MOBI};
	
	public static final double TAMANYO_DEFAULT = 0;
	public static final Formatos FORMATO_DEFAULT = Formatos.EPUB;
	
	private double tamanyo;
	private Formatos formato;
	
// CONSTRUCTORES ==============================================================
	
	// Constructor maestro (3 parámetros)
	public LibroDigital(Generos genero, double tamanyo, Formatos formato)
	{
		super(String.format("D-%s-%04d", genero.toString().substring(0, 3), contador[genero.ordinal()]),
				Libro.TITULO_DEFAULT, Libro.AUTOR_DEFAULT, Libro.FECHAPUB_DEFAULT, Libro.GENERO_DEFAULT, true);
		this.tamanyo = tamanyo;
		this.formato = formato;
		
		numLibrosDigitales++;
	}
	
	//Constructor por omisión
	public LibroDigital()
	{
		this(Libro.GENERO_DEFAULT, TAMANYO_DEFAULT, FORMATO_DEFAULT);
	}
	
// MÉTODOS =====================================================================
	
	//CALCULAR PRECIO - Método abstracto que calcula el precio del Libro Digital
	@Override
	protected double calcularPrecio() throws IllegalStateException
	{
		if(!this.disponibilidad)
		{
			throw new IllegalStateException("El libro no está disponible.");
		}
		double resultado = 0;
		resultado = this.tamanyo * 0.45;
		if(this.formato != Formatos.EPUB)
		{
			resultado += 1.5;
		}
		return resultado;
	}
	
	//TO STRING - Devuelve un objeto String con la información detallada del Libro Digital
	@Override
	public String toString()
	{
		return String.format("%s - Tamaño: %.2f Mb - Formato: %s", super.toString(), this.tamanyo, this.formato.toString());
	}
}
