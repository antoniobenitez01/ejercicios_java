package biblioteca;
/*
 * Clase que representa un Libro Físico
 * Extends: Libro
 * Excepciones: IllegalArgumentException, IllegalStateException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 01/04/2025
 */
public class LibroFisico extends Libro
{
	
// ATRIBUTOS =====================================================
	
	public static final int PAGINAS_DEFAULT = 10;
	
	private int paginas;
	private boolean tapa; //TRUE = DURA || FALSE = BLANDA
	
// CONSTRUCTORES ==================================================
	
	// Constructor maestro (3 parámetros)	
	public LibroFisico(Generos genero, int paginas, boolean tapa) throws IllegalArgumentException
	{
		super(String.format("F-%s-%04d", genero.toString().substring(0, 3), contador[genero.ordinal()]),
				Libro.TITULO_DEFAULT, Libro.AUTOR_DEFAULT, Libro.FECHAPUB_DEFAULT, Libro.GENERO_DEFAULT, true);
		if(paginas < 0)
		{
			throw new IllegalArgumentException("El número de páginas no puede ser negativo.");
		}
		this.paginas = paginas;
		this.tapa = tapa;
		
		numLibrosFisicos++;
	}
	
	// Constructor por omisión
	public LibroFisico()
	{
		this(Libro.GENERO_DEFAULT, PAGINAS_DEFAULT, false);
	}
	
// MÉTODOS ================================================================
	
	//CALCULAR PRECIO - Método abstracto que calcula el precio del Libro Físico
	@Override
	protected double calcularPrecio() throws IllegalStateException
	{
		if(!this.disponibilidad)
		{
			throw new IllegalStateException("El libro no está disponible.");
		}
		double resultado = 0;
		resultado = this.paginas * 0.75;
		if(!this.tapa)
		{
			resultado += 3;
		}
		return resultado;
	}
	
	//TO STRING - Devuelve un objeto String con la información detallada del Libro Físico
	@Override
	public String toString()
	{
		return String.format("%s - Páginas: %d - Tapa: %s", super.toString(), this.paginas, this.tapa ? "Dura" : "Blanda");
	}
}
