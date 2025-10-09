/*
 * Objetivo: Programa que tira una dado de 6 caras
 * 100 veces y luego muestra el nº y % de veces
 * que ha salido ese número
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 28/10/2024
 */
package ejercicio13;

public class Ejercicio13 
{

	public static void main(String[] args)
	{
		int num=0, uno=0, dos=0, tres=0, cuatro=0, cinco=0, seis=0;
		double porcentaje;
		
		for(int i=0; i<100; i++)
		{
			num = (int) (Math.random()*6)+1;
			switch(num)
			{
			case 1:
				uno++;
				break;
			case 2:
				dos++;
				break;
			case 3:
				tres++;
				break;
			case 4:
				cuatro++;
				break;
			case 5:
				cinco++;
				break;
			case 6:
				seis++;
				break;
			}
		}
		System.out.println("El número final es: " + num);
		switch(num)
		{
		case 1:
			System.out.println("El porcentaje de veces que ha salido " + num + " es " + uno + "%.");
			break;
		case 2:
			System.out.println("El porcentaje de veces que ha salido " + num + " es " + dos + "%.");
			break;
		case 3:
			System.out.println("El porcentaje de veces que ha salido " + num + " es " + tres + "%.");
			break;
		case 4:
			System.out.println("El porcentaje de veces que ha salido " + num + " es " + cuatro + "%.");
			break;
		case 5:
			System.out.println("El porcentaje de veces que ha salido " + num + " es " + cinco + "%.");
			break;
		case 6:
			System.out.println("El porcentaje de veces que ha salido " + num + " es " + seis + "%.");
			break;
		}
	}
}
