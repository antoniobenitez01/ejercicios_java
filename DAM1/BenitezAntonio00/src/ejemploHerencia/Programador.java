package ejemploHerencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Programador extends Trabajador
{
	private String lenguajesProg;
	private int anyosExp;
	private boolean esJefeEquip;
	
	public Programador(String dni, String nombre, String apellidos, LocalDate fechaInicio, int numHijos, 
			String lenguajesProg, int anyosExp, boolean esJefeEquip)
	{
		super (dni, nombre, apellidos, fechaInicio, numHijos);
		this.lenguajesProg = lenguajesProg;
		this.anyosExp = anyosExp;
		this.esJefeEquip = esJefeEquip;
	}
	
	public Programador()
	{
		this(DNI_DEFAULT, NOMBRE_DEFAULT, APELLIDOS_DEFAULT, FECHA_DEFAULT, NUMHIJOS_DEFAULT, "Ninguno", 5, true);
	}
	
	public double calcularNomina(double salarioBase)
	{
		double nomina = salarioBase;
		nomina += (salarioBase * 0.05) * this.anyosExp;
		if(this.esJefeEquip)
		{
			nomina += salarioBase * 0.25;
		}
		return nomina;
	}
	
	public int calcularVacaciones()
	{
		int diasVacaciones = DIAS_VACACIONES_DEFAULT;
		long anyosAntiguedad = ChronoUnit.YEARS.between(this.fechaInicio, LocalDate.now());
		diasVacaciones += 2 * anyosAntiguedad;
		return diasVacaciones;
	}
	
	@Override
	public String toString()
	{
		return String.format(super.toString() + "\nLenguajes de Programación: %s \nAños de Experiencia: %d"
				+ "\nEs jefe de equipo: %s", this.lenguajesProg, this.anyosExp, this.esJefeEquip ? "Sí." : "No");
	}
}
