package claseBombo;

public class Bombo 
{
	public static final int MINIMO_BOLAS = 9;
	public static final int MAXIMO_BOLAS = 90;
	public static final int BOLAS_DEFAULT = 10;
	
	private int[] bolasBombo;
	private int cantidadBolasExtraidas;
	
	public Bombo(int capacidadBombo) throws IllegalArgumentException
	{
		if(capacidadBombo < MINIMO_BOLAS)
		{
			throw new IllegalArgumentException (String.format("La capacidad debe ser mayor que %d bolas.", MINIMO_BOLAS));
		}
		if(capacidadBombo > MAXIMO_BOLAS)
		{
			throw new IllegalArgumentException (String.format("La capacidad debe de ser menor que %d bolas.", MAXIMO_BOLAS));
		}
		
		this.bolasBombo = new int[capacidadBombo];
		rellenar();
	}
	
	public Bombo()
	{
		this(MAXIMO_BOLAS);
	}
	
	public int getCapacidadBombo()
	{
		return this.bolasBombo.length;
	}
	
	public int getCantidadBolasExtraidas()
	{
		return this.cantidadBolasExtraidas;
	}
	
	public int getCantidadBolasRestantes()
	{
		return getCapacidadBombo() - getCantidadBolasExtraidas();
	}
	
	public boolean isCompleto()
	{
		return this.cantidadBolasExtraidas == 0;
	}
	
	public boolean isVacio()
	{
		return this.cantidadBolasExtraidas == getCapacidadBombo();
	}
	
	public void rellenar()
	{
		for(int i=0; i<getCapacidadBombo(); i++)
		{
			this.bolasBombo[i] = i + 1;
		}
	}
	
	public int extraerBola() throws IllegalStateException
	{
		if(this.isVacio())
		{
			throw new IllegalStateException ("El bombo está vacío.");
		}
		
		int aleatoria, bola;
		do
		{
			aleatoria = (int) (Math.random() * this.getCapacidadBombo());
			bola = this.bolasBombo[aleatoria];
			this.bolasBombo[aleatoria] = 0;
		}while(bola == 0);
		
		this.cantidadBolasExtraidas++;
		return bola;
	}
	
	public int reset()
	{
		int bolasRestantes = this.getCantidadBolasRestantes();
		this.cantidadBolasExtraidas = 0;
		this.rellenar();
		return bolasRestantes;
	}
	
	public String toString()
	{
		return String.format("Capacidad: %d bolas. Cantidad de bolas extraídas: %d", getCapacidadBombo(), this.cantidadBolasExtraidas);
	}	
}
