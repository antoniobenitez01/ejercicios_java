/*
 * Clase que representa un Satelite
 * Extends: Astro
 * Excepciones: IllegalArgumentException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 17/02/2025 
 */
package ejercicio1;

public class Satelite extends Astro
{

// ATRIBUTOS ============================================================================================
	
	public static final double DISTANCIAPLANETA_DEFAULT = 99999;
	public static final int DIASORBITAPLANETA_DEFAULT = 365;
	public static final String NOMBREPLANETA_DEFAULT = "Vacío";
	
	private double distanciaPlaneta;
	private int diasOrbitaPlaneta;
	private String nombrePlaneta;
	
// CONSTRUCTORES ========================================================================================
	
	//Constructor maestro (7 parámetros)
	public Satelite(String nombre, double masa, double diametro, double horasRotacion,
			double distanciaPlaneta, int diasOrbitaPlaneta, String nombrePlaneta)
	{
		super(nombre, masa, diametro, horasRotacion);
		
		minusValueException(distanciaPlaneta, "distancia al Planeta");
		minusValueException(diasOrbitaPlaneta, "días de órbita al Planeta");
		stringException(nombrePlaneta, "nombre del Planeta");
		
		this.distanciaPlaneta = distanciaPlaneta;
		this.diasOrbitaPlaneta = diasOrbitaPlaneta;
		this.nombrePlaneta = nombrePlaneta;
	}
	
	//Constructor por omisión
	public Satelite()
	{
		this(Astro.NOMBRE_DEFAULT, Astro.MASA_DEFAULT, Astro.DIAMETRO_DEFAULT, Astro.HORASROT_DEFAULT,
				DISTANCIAPLANETA_DEFAULT, DIASORBITAPLANETA_DEFAULT, NOMBREPLANETA_DEFAULT);
	}
	
// GETTERS =============================================================================
	
	//Devuelve la distancia al Planeta en valor decimal double
	public double getDistanciaPlaneta()
	{
		return this.distanciaPlaneta;
	}
	
	//Devuelve los días de órbita al Planeta en valor entero int
	public int getDiasOrbitaPlaneta()
	{
		return this.diasOrbitaPlaneta;
	}
	
	//Devuelve el nombre del Planeta como objeto String
	public String getNombrePlaneta()
	{
		return this.nombrePlaneta;
	}
	
// SETTERS ==============================================================================
	
	//Establece la distancia al Planeta
	public void setDistanciaPlaneta(double distanciaPlaneta)
	{
		minusValueException(distanciaPlaneta, "distancia al Planeta");
		this.distanciaPlaneta = distanciaPlaneta;
	}
	
	//Establece los días de órbita al Planeta
	public void setDiasOrbitaPlaneta(int diasOrbitaPlaneta)
	{
		minusValueException(diasOrbitaPlaneta, "días de órbita al Planeta");
		this.diasOrbitaPlaneta = diasOrbitaPlaneta;
	}
	
	//Establece el nombre del Planeta
	public void setNombrePlaneta(String nombrePlaneta)
	{
		stringException(nombrePlaneta, "nombre del Planeta");
		this.nombrePlaneta = nombrePlaneta;
	}
	
// MÉTODOS ==============================================================================
	
	//TO STRING - Devuelve un String con la información detallada del Satelite
	@Override
	public String toString()
	{
		return String.format("%s\nNombre del planeta órbita: %s\nDistancia al planeta: %.2f metros"
				+ "\nDías órbita planeta: %d días",
				super.toString(),this.nombrePlaneta,this.distanciaPlaneta,this.diasOrbitaPlaneta);
	}
}
