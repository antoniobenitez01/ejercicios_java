package producto;

import java.time.LocalDate;

public class PrincipalProducto {

	public static void main(String[] args) 
	{
		System.out.println("\n=== PRODUCTOS ===\n");
		
		ProductoFresco producto1 = null, producto4 = null;
		ProductoRefrigerado producto2 = null;
		ProductoCongelado producto3 = null;
		
		System.out.println(" -- Producto fresco --\n");
		
		try
		{
			System.out.println("Creando producto fresco...");
			producto1 = new ProductoFresco("Queso de cabra", LocalDate.of(2025, 12, 28), 25, 
					LocalDate.of(2001, 12, 28), "España");
			System.out.println("Producto fresco creado con éxito.\n");
			System.out.printf("%s\n", producto1.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			if(Producto.getNumUltimoProducto() < Producto.NUM_MAXIMO_PRODUCTO)
			{
				System.out.println("Se ha detectado un error, creando producto fresco por defecto...");
				producto1 = new ProductoFresco();
			}
			else
			{
				System.out.println("Se ha detectado un error. No se pueden crear más objetos Producto.");
			}
		}
		
		System.out.println("\n -- Producto refrigerado --\n");
		
		try
		{
			System.out.println("Creando producto refrigerado...");
			producto2 = new ProductoRefrigerado("Carne de buey", LocalDate.of(2028, 12, 28), 21566,
					"XORC", -25, LocalDate.of(2025, 12, 28));
			System.out.println("Producto congelado creado con éxito.\n");
			System.out.printf("%s\n", producto2.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			if(Producto.getNumUltimoProducto() < Producto.NUM_MAXIMO_PRODUCTO)
			{
				System.out.println("Se ha detectado un error, creando producto refrigerado por defecto...");
				producto2 = new ProductoRefrigerado();
			}
			else
			{
				System.out.println("Se ha detectado un error. No se pueden crear más objetos Producto.");
			}
		}
		
		System.out.println("\n -- Producto congelado --\n");
		
		try
		{
			System.out.println("Creando producto congelado...");
			producto3 = new ProductoCongelado("Palitos de merluza", LocalDate.of(2026, 12, 28), 245, -10, 6);
			System.out.println("Producto congelado creado con éxito.\n");
			System.out.printf("%s\n", producto3.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			if(Producto.getNumUltimoProducto() < Producto.NUM_MAXIMO_PRODUCTO)
			{
				System.out.println("Se ha detectado un error, creando producto congelado por defecto...");
				producto3 = new ProductoCongelado();
			}
			else
			{
				System.out.println("Se ha detectado un error. No se pueden crear más objetos Producto.");
			}
		}
		
		System.out.println("\n -- Producto fresco erróneo --\n");
		
		try
		{
			System.out.println("Creando producto fresco erróneo...");
			producto4 = new ProductoFresco("Queso de cabra", LocalDate.of(1999, 12, 28), 25, 
					LocalDate.of(2001, 12, 28), "España");
			System.out.println("No se ha creado un producto fresco erróneo.\n");
			System.out.printf("%s\n", producto4.toString());
		}catch(IllegalArgumentException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
			System.out.printf("ERROR: %s\n", ex.getMessage());
			if(Producto.getNumUltimoProducto() < Producto.NUM_MAXIMO_PRODUCTO)
			{
				System.out.println("Se ha detectado un error, creando producto fresco por defecto...");
				producto4 = new ProductoFresco();
			}
			else
			{
				System.out.println("Se ha detectado un error. No se pueden crear más objetos Producto.");
			}
		}
		
		System.out.println("\n -- Caducidad --\n");
		
		try
		{
			System.out.println("Comprobando si producto1 está caducado...");
			if(producto1.estaCaducado())
			{
				System.out.println("Producto 1 está caducado.");
			}
			else
			{
				System.out.println("Producto 1 no está caducado.");
			}
			
			System.out.println("\nCalculando días hasta caducarse ...\n");
			System.out.printf("PRODUCTO 1 - Días hasta caducarse: %d días" +
							"\nPRODUCTO 2 - Días hasta caducarse: %d días" +
							"\nPRODCUTO 3 - Días hasta caducarse: %d días" +
							"\nPRODUCTO 4 - Días hasta caducarse: %d días \n",
							producto1.diasHastaCaducar(), producto2.diasHastaCaducar(), producto3.diasHastaCaducar(),
							producto4.diasHastaCaducar());
		}catch(IllegalStateException ex)
		{
			System.out.printf("ERROR: %s\n", ex.getMessage());
		}
	}
}
