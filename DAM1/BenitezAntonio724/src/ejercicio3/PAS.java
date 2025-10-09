/*
 * Clase que representa un trabajador PAS (Personal, Administración y Servicios)
 * Extends: Personal
 * Excepciones: IllegalArgumentException, NullPointerException
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 14/02/2025 
 */
package ejercicio3;

import java.time.LocalDate;

public class PAS extends Personal
{
	
// ATRIBUTOS ==================================================
	
	private boolean aleman;
	private boolean chino;
	private boolean ingles;
	private String areaAtencion;
	
// CONSTRUCTORES ==================================================
	
	//Constructor maestro (12 paráme
	public PAS(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String genero, double salario,
			int telefono, String email, boolean aleman, boolean chino, boolean ingles, String areaAtencion)
	{
		super(dni, nombre, apellidos, fechaNacimiento, genero, salario, telefono, email);
		
		stringException(areaAtencion, "área de atención");
		
		this.aleman = aleman;
		this.chino = chino;
		this.ingles = ingles;
		this.areaAtencion = areaAtencion;
	}
	
	//Constructor por omisión
	public PAS()
	{
		this(Personal.DNI_DEFAULT, Personal.NOMBRE_DEFAULT, Personal.APELLIDOS_DEFAULT, Personal.FECHANAC_DEFAULT,
				Personal.GENERO_DEFAULT, Personal.SALARIO_DEFAULT, Personal.TELEFONO_DEFAULT, Personal.EMAIL_DEFAULT,
				false, false, false, "Ninguna");
	}
	
// MÉTODOS ==================================================
	
	//NÚMERO IDIOMAS - Calcula y devuelve el número de idiomas que conoce el trabajador PAS
	public int numIdiomas()
	{
		int numIdiomas = 0;
		if(this.aleman)
		{
			numIdiomas++;
		}
		if(this.chino)
		{
			numIdiomas++;
		}
		if(this.ingles)
		{
			numIdiomas++;
		}
		return numIdiomas;
	}
	
	//CAMBIO IDIOMA - Cambia el estado del idioma introducido
	public void cambioIdioma(String idioma) throws IllegalArgumentException
	{
		if(idioma.toLowerCase().equals("aleman") || idioma.toLowerCase().equals("alemán"))
		{
			this.aleman = !this.aleman;
		}else if(idioma.toLowerCase().equals("chino"))
		{
			this.chino = !this.chino;
		}else if(idioma.toLowerCase().equals("ingles") || idioma.toLowerCase().equals("inglés"))
		{
			this.ingles = !this.ingles;
		}
		else
		{
			throw new IllegalArgumentException("El idioma introducido no es válido."
					+ "\nIdiomas válidos: 'Alemán', 'Chino' e 'Inglés'");
		}
	}
	
	//TO STRING - Devuelve un String con la información detallada del trabajador PAS
	@Override
	public String toString()
	{
		return String.format("%s\nAlemán: %s\nChino: %s\nInglés: %s\nÁrea de atención: %s", 
				super.toString(), this.aleman ? "Sí" : "No", this.chino ? "Sí" : "No", this.ingles ? "Sí" : "No", this.areaAtencion);
	}
}
