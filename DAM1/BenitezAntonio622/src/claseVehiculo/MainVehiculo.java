package claseVehiculo;

public class MainVehiculo 
{

	public static void main(String[] args) 
	{
		
		System.out.println("=== CLASE VEHÍCULO ===\n");
		//1. Crear el objeto v1 con la capacidad del depósito de 150l y 10l/100km de consumo medio;
		try
		{
			System.out.println("1. Creando vehículo v1 con capacidad de depósito 150l...");
			Vehiculo v1 = new Vehiculo(150, 10);
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		//2. Crear el objeto v2 con la capacidad del depósito de 60l y 25l/100km de consumo medio;
		try
		{
			System.out.println("\n2. Creando vehículo v2 con 25l/100km de consumo medio...");
			Vehiculo v2 = new Vehiculo(60, 25);
			System.out.println("Creado con éxito.");
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		//3. Crear el objeto vehículo v3 con el constructor sin parámetros;
		System.out.println("\n3. Creando vehículo v3 con constructor por omisión...");
		Vehiculo v3 = new Vehiculo();
		System.out.println("Creado con éxito.");
		
		//4. Repostar 20 litros de combustible en el vehículo v3;
		try
		{
			System.out.println("\n4. Repostando 20 litros en el vehículo v3...");
			v3.repostar(20);
			System.out.println("Repostado con éxito.");
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		//5. Arrancar el vehículo v3;
		try
		{
			System.out.println("\n5. Arrancando vehículo v3...");
			v3.arrancar();
			System.out.println("Arrancado con éxito.");
			System.out.printf("%s\n", v3.toString());
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
		
		//6. Recorrer un trayecto de 100 km con el vehículo v3;
		try
		{
			System.out.println("\n6. Recorriendo trayecto de 100km con vehículo v3...");
			v3.realizarTrayecto(900);
			System.out.println("Recorrido con éxito.");
			System.out.printf("%s\n", v3.toString());
		}catch(IllegalStateException ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("%s\n", ex2.getMessage());
		}
		
		//7. Dejar el motor del vehículo v3 encendido, es decir, no apagarlo.
		System.out.println("\n7. Dejando motor de vehículo v3 encendido...");
		System.out.printf("%s\n", v3.toString());
	}
}
