/*
 * Clase que representa un Planeta
 * Extends: Astro
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/02/2025 
 */
package ejercicio1;

public class Planeta extends Astro
{

// ATRIBUTOS =============================================================================================
	
	public static final double DISTANCIASOL_DEFAULT = 5000;
	public static final int DIASORBITA_DEFAULT = 365;
	
	private double distanciaSol;
	private int diasOrbita;
	private boolean tieneSatelites;
	
// CONSTRUCTORES ==========================================================================================
	
	//Constructor maestro (7 parámetros)
	public Planeta(String nombre, double masa, double diametro, double horasRotacion,
			double distanciaSol, int diasOrbita, boolean tieneSatelites)
	{
		super(nombre, masa, diametro, horasRotacion);
		
		minusValueException(distanciaSol, "distancia al Sol");
		minusValueException(diasOrbita, "días de órbita");
		
		this.distanciaSol = distanciaSol;
		this.diasOrbita = diasOrbita;
		this.tieneSatelites = tieneSatelites;
	}
	
	//Constructor por omisión
	public Planeta()
	{
		this(Astro.NOMBRE_DEFAULT, Astro.MASA_DEFAULT, Astro.DIAMETRO_DEFAULT, Astro.HORASROT_DEFAULT,
				DISTANCIASOL_DEFAULT, DIASORBITA_DEFAULT, false);
	}
	
// GETTERS =======================================================================
	
	//Devuelve la distancia al Sol en valor decimal double
	public double getDistanciaSol()
	{
		return this.distanciaSol;
	}
	
	//Devuelve los días de órbita en valor entero int
	public int getDiasOrbita()
	{
		return this.diasOrbita;
	}
	
	//Devuelve true si el Planeta tiene satélites
	public boolean tieneSatelites()
	{
		return this.tieneSatelites;
	}
	
// SETTERS ========================================================================
	
	//Establece la distancia al Sol
	public void setDistanciaSol(double distanciaSol)
	{
		minusValueException(distanciaSol, "distancia al Sol");
		this.distanciaSol = distanciaSol;
	}
	
	//Establece los días de órbita
	public void setDiasOrbita(int diasOrbita)
	{
		minusValueException(diasOrbita, "días de órbita");
		this.diasOrbita = diasOrbita;
	}
	
	//Establece el booleano de si tiene satélites o no
	public void setTieneSatelites(boolean tieneSatelites)
	{
		this.tieneSatelites = tieneSatelites;
	}
	
// MÉTODOS =========================================================================
	
	//TO STRING - Devuelve un String con la información detallada del Planeta
	@Override
	public String toString()
	{
		return String.format("%s\nDistancia al Sol: %.2f metros\nDías órbita: %d días\nTiene satélites: %s",
				super.toString(),this.distanciaSol,this.diasOrbita,this.tieneSatelites ? "Sí" : "No");
	}
}
