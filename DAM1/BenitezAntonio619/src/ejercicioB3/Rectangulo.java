package ejercicioB3;

public class Rectangulo 
{
	int x1;
	int y1;
	int x2;
	int y2;
	
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
}
