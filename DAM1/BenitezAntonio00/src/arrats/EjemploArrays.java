package arrats;

public class EjemploArrays 
{

	public static void main(String[] args) 
	{
		int numeroAleatorio;
		int[] consecutivos = new int [10];
		
		for(int i=0; i < consecutivos.length; i++)
		{
			do
			{
				numeroAleatorio = (int) (Math.random()* 26);	
			}while(numeroAleatorio%2 != 0);
			
			consecutivos[i] =  numeroAleatorio;
			System.out.println("El número en la posición " + i + " es " + consecutivos[i]);
		}
	}
}
