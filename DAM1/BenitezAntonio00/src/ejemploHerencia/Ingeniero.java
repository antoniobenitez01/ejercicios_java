package ejemploHerencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ingeniero extends Trabajador
{
	private boolean senior;
	private boolean directivo;
	
	public Ingeniero(String dni, String nombre, String apellidos, LocalDate fechaInicio, int numHijos,
			boolean senior, boolean directivo)
	{
		super(dni, nombre, apellidos, fechaInicio, numHijos);
		this.senior = senior;
		this.directivo = directivo;
	}
	
	public Ingeniero()
	{
		this(DNI_DEFAULT, NOMBRE_DEFAULT, APELLIDOS_DEFAULT, FECHA_DEFAULT, NUMHIJOS_DEFAULT, true, false);
	}
	
	public double calcularNomina(double salarioBase)
	{
		double nomina = salarioBase;
		if(this.senior)
		{
			nomina += salarioBase * 0.3;
		}
		if(this.directivo)
		{
			nomina += 1000;
		}
		return nomina;
	}
	
	public int calcularVacaciones()
	{
		int diasVacaciones = DIAS_VACACIONES_DEFAULT;
		if(this.directivo)
		{
			diasVacaciones += 5;
		}
		else
		{
			long anyosAntiguedad = ChronoUnit.YEARS.between(this.fechaInicio, LocalDate.now());
			diasVacaciones += 4*(anyosAntiguedad/3);
		}
		return diasVacaciones;
	}
	
	@Override
	public String toString()
	{
		return String.format(super.toString() + "\nSenior: %s \nDirectivo: %s",
				this.senior ? "Sí" : "No", this.directivo ? "Sí" : "No");
	}
}
