package ejemploHerencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Analista extends Trabajador
{
	private String herramienta;
	private int anyosExp;
	private boolean haSidoProgramador;
	
	public Analista(String dni, String nombre, String apellidos, LocalDate fechaInicio, int numHijos, 
			String herramienta, int anyosExp, boolean haSidoProgramador)
	{
		super(dni, nombre, apellidos, fechaInicio, numHijos);
		this.herramienta = herramienta;
		this.anyosExp = anyosExp;
		this.haSidoProgramador = haSidoProgramador;
	}
	
	public Analista()
	{
		this(DNI_DEFAULT, NOMBRE_DEFAULT, APELLIDOS_DEFAULT, FECHA_DEFAULT, NUMHIJOS_DEFAULT,
				"Ninguna", 5, true);
	}
	
	public double calcularNomina(double salarioBase)
	{
		double nomina = salarioBase;
		nomina += (salarioBase * 0.01) * this.anyosExp;
		if(this.haSidoProgramador)
		{
			nomina += 200;
		}
		return nomina;
	}
	
	public int calcularVacaciones()
	{
		int diasVacaciones = DIAS_VACACIONES_DEFAULT;
		long anyosAntiguedad = ChronoUnit.YEARS.between(this.fechaInicio, LocalDate.now());
		diasVacaciones += 3*(anyosAntiguedad/3);
		return diasVacaciones;
	}
	
	@Override
	public String toString()
	{
		return String.format(super.toString() + "\nHerramienta: %s \nAños de Experiencia: %d \nHa sido programador: %s",
				this.herramienta,this.anyosExp,this.haSidoProgramador ? "Sí" : "No");
	}
}
