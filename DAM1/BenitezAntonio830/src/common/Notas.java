package common;

import java.util.Objects;
/*
 * Clase que guarda las siguientes Notas de un Alumno
 * (identificado por grupo y nombre)
 * - Matemáticas
 * - Lengua
 * - Física
 * - Química
 * - Inglés
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 31/03/2025
 */
public class Notas
{
	
// ATRIBUTOS ==========================================================
	
	private String grupo;
	private String nombre;
	private int mat;
	private int lng;
	private int fsc;
	private int qmc;
	private int ing;
	
// CONSTRUCTORES ======================================================
	
	public Notas(String grupo, String nombre, int mat, int lng, int fsc, int qmc, int ing)
	{
		this.grupo = grupo;
		this.nombre = nombre;
		this.mat = mat;
		this.lng = lng;
		this.fsc = fsc;
		this.qmc = qmc;
		this.ing = ing;
	}
	
// GETTERS =============================================================
	
	public String getGrupo()
	{
		return this.grupo;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getMat()
	{
		return this.mat;
	}
	
// MÉTODOS ================================================================
	
	//NOTA MEDIA - Calcula la nota media del conjunto del Alumno
	public double notaMedia()
	{
		return (this.mat + this.lng + this.fsc + this.qmc + this.ing) / 5;
	}
	
	//HASH CODE - Método genérico que crea un HashCode del objeto basado en los parámetros de Grupo y Nombre
	@Override
	public int hashCode() 
	{
		return Objects.hash(grupo, nombre);
	}

	//EQUALS - Método genérico que determina cuando dos objetos de la clase son iguales
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notas other = (Notas) obj;
		return Objects.equals(grupo, other.grupo) && Objects.equals(nombre, other.nombre);
	}
	
	//TO STRING - Devuelve un objeto String con la información detallada del Alumno y sus Notas
	public String toString()
	{
		return String.format("Grupo: %s; Nombre: %s; "
				+ "Matemáticas: %d; Lengua: %d; Física: %d; Química: %d; Inglés: %d",
				this.grupo, this.nombre, this.mat, this.lng, this.fsc, this.qmc, this.ing);
	}
}
