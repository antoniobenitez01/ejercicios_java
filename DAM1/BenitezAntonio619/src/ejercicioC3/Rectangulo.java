package ejercicioC3;

public class Rectangulo 
{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
//CONSTRUCTORES
	
	public Rectangulo(int x1, int y1, int x2, int y2) throws IllegalArgumentException
	{
		//COMPROBACIÓN DE EXCEPCIONES
		if(x1 > x2 && y1 > y2) // EXCEPCIÓN: Lanza error si las coordenadas x1 e y1 no son la esquina inferior izquierda
		{
			throw new IllegalArgumentException ("Coordenadas X1 e Y1 deben ser la esquina inferior izquierda.");
		}
		
		//CONSTRUCCIÓN DE OBJETO
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
// GETTERS
	
	public int getX1()
	{
		return this.x1;
	}
	
	public int getX2()
	{
		return this.x2;
	}
	
	public int getY1()
	{
		return this.y1;
	}
	
	public int getY2()
	{
		return this.y2;
	}
	
// SETTERS
	
	public void setX1(int x1) throws IllegalArgumentException
	{
		if(x1 > this.x2 && this.y1 > this.y2) // EXCEPCIÓN: Lanza error si las coordenadas x1 e y1 no son la esquina inferior izquierda
		{
			throw new IllegalArgumentException ("Coordenadas X1 e Y1 deben ser la esquina inferior izquierda.");
		}
		this.x1 = x1;
	}
	
	public void setX2(int x2) throws IllegalArgumentException
	{
		if(this.x1 > x2 && this.y1 > this.y2) // EXCEPCIÓN: Lanza error si las coordenadas x1 e y1 no son la esquina inferior izquierda
		{
			throw new IllegalArgumentException ("Coordenadas X1 e Y1 deben ser la esquina inferior izquierda.");
		}
		this.x2 = x2;
	}
	
	public void setY1(int y1) throws IllegalArgumentException
	{
		if(this.x1 > this.x2 && y1 > this.y2) // EXCEPCIÓN: Lanza error si las coordenadas x1 e y1 no son la esquina inferior izquierda
		{
			throw new IllegalArgumentException ("Coordenadas X1 e Y1 deben ser la esquina inferior izquierda.");
		}
		this.y1 = y1;
	}
	
	public void setY2(int y2) throws IllegalArgumentException
	{
		if(this.x1 > this.x2 && this.y1 > y2) // EXCEPCIÓN: Lanza error si las coordenadas x1 e y1 no son la esquina inferior izquierda
		{
			throw new IllegalArgumentException ("Coordenadas X1 e Y1 deben ser la esquina inferior izquierda.");
		}
		this.y2 = y2;
	}
}
