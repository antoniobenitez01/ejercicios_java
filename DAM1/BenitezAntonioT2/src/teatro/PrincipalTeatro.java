package teatro;

import libtarea3.Teatro;

public class PrincipalTeatro {

	public static void main(String[] args) {
		//1. Crea diez teatros por defecto.
		//Evidencia: mostrar el estado de los teatros creados 
		System.out.println("\n=== TEATRO ===\n\n1. Creando 10 objetos Teatro por defecto ...\n");
		Teatro[] teatros = new Teatro[10];
		for(int i=0; i<teatros.length; i++)
		{
			teatros[i] = new Teatro();
			System.out.printf("%s\n", teatros[i].toString());
		}
 		
		//2. Compra 25 entradas para cada uno de los teatros creados. 
		//Evidencia: mostrar el estado de los teatros creados 
		System.out.println("\n\n2. Comprando 25 entradas para cada uno de los teatros ...\n");
		for(int i=0; i<teatros.length; i++)
		{
			try
			{
				teatros[i].comprarEntradas(25);	
			}catch(IllegalStateException ex)
			{
				System.out.printf("ERROR: %s\n", ex.getMessage());
			}catch(IllegalArgumentException ex2)
			{
				System.out.printf("ERROR: %s\n", ex2.getMessage());
			}
			
			System.out.printf("%s\n\n", teatros[i].toString());
		}
		
		
		//3. Asigna la obra "La Celestina" a los cinco primeros teatros creados.
		//Evidencia: mostrar el estado de los cinco teatros.
		System.out.println("\n\n3. Asignando obra 'La Celestina' a cinco primeros teatros ...\n");
		for(int i=0; i<5; i++)
		{
			try
			{
				teatros[i].asignarObra("La Celestina");	
			}catch(IllegalStateException ex)
			{
				System.out.printf("ERROR: %s\n", ex.getMessage());
			}catch(IllegalArgumentException ex2)
			{
				System.out.printf("ERROR: %s\n", ex2.getMessage());
			}catch(NullPointerException ex3)
			{
				System.out.printf("ERROR: %s\n", ex3.getMessage());
			}
			System.out.printf("%s\n", teatros[i].toString());
		}
		
		
		//4. Crea un teatro con el nombre "Cervantes" y aforo 500. Asigna la obra "La vida es bella" a este teatro.
		//Evidencia: mostrar el estado del teatro creado.
		System.out.println("\n\n4. Creando teatro con el nombre Cervantes de aforo 500 ...\n");
		Teatro teatroCervantes;
		try
		{
			teatroCervantes = new Teatro("Cervantes", 500);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			System.out.println("Se ha detectado un error, creando Teatro por defecto...");
			teatroCervantes = new Teatro();
		}catch(NullPointerException ex2)
		{
			System.out.printf("ERROR: %s\n", ex2.getMessage());
			System.out.println("Se ha detectado un error, creando Teatro por defecto...");
			teatroCervantes = new Teatro();
		}
		System.out.printf("%s\n", teatroCervantes.toString());
		
		System.out.println("\nAsignando obra 'La vida es bella' ...\n");
		try
		{
			teatroCervantes.asignarObra("La vida es bella");	
		}catch(IllegalStateException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("ERROR: %s\n", ex2.getMessage());
		}catch(NullPointerException ex3)
		{
			System.out.printf("ERROR: %s\n", ex3.getMessage());
		}
		System.out.printf("%s\n", teatroCervantes.toString());
		
		//5. Compra un número de entradas aleatorio entre 100 y 1000. En el caso de que supere las entradas disponibles, se comprarán todas las posibles.
		//Evidencia: mostrar el número de entradas a comprar y el estado del teatro Cervantes.
		System.out.println("\n\n5. Comprando un número aleatorio entre 100 y 1000 de entradas ...");
		try
		{
			int numAleatorio = numAleatorio(900,100);
			System.out.printf("Comprando %d entradas ...\n", numAleatorio);
			teatroCervantes.comprarEntradas(numAleatorio);
		}catch(IllegalStateException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			System.out.println("Llenando Teatro Cervantes ...");
			teatroCervantes.llenarTeatro();
		}catch(IllegalArgumentException ex2)
		{
			System.out.printf("ERROR: %s\n", ex2.getMessage());
		}
		System.out.printf("\n%s\n", teatroCervantes.toString());
		
		//6. Crea un teatro con el nombre "Soho Málaga" y aforo 1000.
		//Evidencia: mostrar el estado del teatro Soho Málaga.
		System.out.println("\n\n6. Creando teatro con el nombre Soho Málaga de aforo 1000 ...\n");
		Teatro teatroSoho;
		try
		{
			teatroSoho = new Teatro("Soho Málaga", 1000);
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			System.out.println("Se ha detectado un error, creando Teatro por defecto...");
			teatroSoho = new Teatro();
		}catch(NullPointerException ex2)
		{
			System.out.printf("ERROR: %s\n", ex2.getMessage());
			System.out.println("Se ha detectado un error, creando Teatro por defecto...");
			teatroSoho = new Teatro();
		}
		System.out.printf("%s\n", teatroSoho.toString());
		
		
		//7. Traspasa la obra asignada del teatro "Cervantes" al teatro "Soho Málaga".
		//Evidencia: mostrar el estado de los teatros.
		System.out.println("\n\n7. Traspasando obra asignada de Teatro Cervante a Teatro Soho Málaga ...\n");
		try
		{
			teatroCervantes.traspasarObra(teatroSoho);
		}catch(IllegalStateException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
		}catch(NullPointerException ex2)
		{
			System.out.printf("ERROR: %s\n", ex2.getMessage());
		}
		System.out.printf("%s\n", teatroCervantes.toString());
		System.out.printf("%s\n", teatroSoho.toString());
		
		//8. Muestra el número de entradas vendidas y entradas por vender de los teatros "Cervantes" y "Soho Málaga".
		//Evidencia: mostrar el número de entradas vendidas y por vender para los teatros.
		System.out.println("\n\n8. Mostrando número de entradas vendidas y entradas por vender ...\n");		
		System.out.printf("--- Teatro Cervantes ---\n\nEntradas vendidas: %d \nEntradas por vender: %d\n\n",
				teatroCervantes.getEntradasVendidas(), teatroCervantes.getAforo() - teatroCervantes.getEntradasVendidas());
		System.out.printf("--- Teatro Soho Málaga ---\n\nEntradas vendidas: %d \nEntradas por vender: %d\n",
				teatroSoho.getEntradasVendidas(), teatroSoho.getAforo() - teatroSoho.getEntradasVendidas());
	}

	//NUM ALEATORIO - Devuelve un número entero aleatorio basado en parámetro de límite y desplazamiento
	public static int numAleatorio(int limite, int desplaza)
	{
		return (int) (Math.random() * limite + desplaza);
	}
}
