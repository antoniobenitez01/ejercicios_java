package claseDado;

public class Dado 
{
	private static final String[] NOMBRES_CARAS = {"UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE", 
			"DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISÉIS", "DICECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE"};
	public static final int NUMERO_CARAS_DEFAULT = 6;
	
	private int[] registroLanzamientos;
	
	public Dado(int numeroCaras)
	{
		if(numeroCaras != 4 && numeroCaras != 6 && numeroCaras != 8 && numeroCaras != 12 && numeroCaras != 20)
		{
			throw new IllegalArgumentException (String.format("Número de caras no válido: %d caras", numeroCaras));
		}
		this.registroLanzamientos = new int[numeroCaras];
	}
	
	public Dado()
	{
		this(NUMERO_CARAS_DEFAULT);
	}
	
	public int getNumeroCaras()
	{
		return this.registroLanzamientos.length;
	}
	
	public int getCantidadLanzamientos()
	{
		int suma = 0;
		for(int i=0;i<getNumeroCaras();i++)
		{
			suma += registroLanzamientos[i];
		}
		return suma;
	}
	
	public int getNumeroVecesCara(int cara) throws IllegalArgumentException
	{
		if(cara < 1 || cara > getNumeroCaras())
		{
			throw new IllegalArgumentException ("Cara no válida.");
		}
		return this.registroLanzamientos[cara-1];
	}
	
	public String lanzar()
	{
		int numeroAleatorio = (int) (Math.random()*getNumeroCaras());
		this.registroLanzamientos[numeroAleatorio]++;
		return NOMBRES_CARAS[numeroAleatorio];
	}
	
	public String toString()
	{
		return String.format("Número de caras: %d. Número de lanzamientos: %d",getNumeroCaras(), getCantidadLanzamientos());
	}
}
