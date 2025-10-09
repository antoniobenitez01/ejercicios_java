package clasePersona;

import java.time.LocalDate;

public class Persona 
{
	private String dni;
	private String nombre;
	private int edad;
	private LocalDate fechaNacimiento;
	
	void setDNI(String dniSet)
	{
		dni = dniSet;
	}
	
	void setName(String nombreSet)
	{
		nombre = nombreSet;
	}
	
	void setEdad(int edadSet)
	{
		edad = edadSet;
	}
	
	void setFechaNac(LocalDate fechaNacSet)
	{
		fechaNacimiento = fechaNacSet;
	}
	
	String getDNI()
	{
		String dniGet = dni;
		return dniGet;
	}
	
	String getName()
	{
		String nombreGet = nombre;
		return nombreGet;
	}
	
	int getEdad()
	{
		int edadGet = edad;
		return edadGet;
	}
	
	LocalDate getFechaNac()
	{
		LocalDate fechaNacGet = fechaNacimiento;
		return fechaNacGet;
	}
}

class Alumno extends Persona 
{
	private String curso;
	private LocalDate fechaMatriculacion;
	
	void setCurso(String cursoSet)
	{
		curso = cursoSet;
	}
	
	String getCurso()
	{
		String cursoGet = curso;
		return cursoGet;
	}
	
	void setFechaMat(LocalDate fechaMatSet)
	{
		fechaMatriculacion = fechaMatSet;
	}
	
	LocalDate getFechaMat()
	{
		LocalDate fechaMatGet = fechaMatriculacion;
		return fechaMatGet;
	}
}

class Profesor extends Persona 
{
	private LocalDate fechaContrato;
	private String departamento;
	
	void setDepartamento(String departamentoSet)
	{
		departamento = departamentoSet;
	}
	
	String getDepartamento()
	{
		String dptoGet = departamento;
		return dptoGet;
	}
}