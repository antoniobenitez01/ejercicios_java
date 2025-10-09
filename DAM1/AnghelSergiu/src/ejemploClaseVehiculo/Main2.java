package ejemploClaseVehiculo;

public class Main2 {

	public static void main(String[] args) 
	{
		Vehiculo coche = null;	
		//COCHE 3
		try
		{
			coche = new Vehiculo();
			
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		try
		{
			coche.repostar(10);
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		try
		{
			coche.arrancar();
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		try
		{
			coche.realizarTrayecto(300);
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		try
		{
			coche.repostar(20);
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		try
		{
			coche.arrancar();
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		try
		{
			coche.realizarTrayecto(200);
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		System.out.printf("\nConsumo realizado: %.2f \nRecorrido parcial: %.2f \nRecorrido total: %.2f \nNivel de combustible: %.2f \n",
				coche.getCombustibleConsumido(), coche.getDistanciaRecorrida(),coche.getDistanciaRecorridaTotal(), coche.getNivelCombustible());
		
		System.out.printf("\n%s\n", coche.toString());
	}

}
