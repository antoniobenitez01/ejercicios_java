package ejercicioD1;

public class Punto 
{
	private int x;
	private int y;
	
// CONSTRUCTORES ===
	public Punto(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
// GETTERS =========
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
// SETTERS ==========
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
// MÉTODOS ===========
	
	//MÉTODO - Imprime por pantalla las coordenadas del objeto
	public void imprime()
	{
		System.out.println("(" + this.x + "," + this.y + ")");
	}
	
	//MÉTODO - Establece los valores de X e Y a la vez
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//MÉTODO - Desplaza las coordenadas de X e Y
	public void desplaza(int dx, int dy)
	{
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
	
	//MÉTODO - Recoge un objeto Punto y devuelve la distancia entre los dos puntos
	public int distancia (Punto p)
	{
		int distancia = 0;
		distancia = (int) Math.sqrt(Math.pow((p.x - this.x),2) + Math.pow((p.y - this.y),2));
		return distancia;
	}
}
