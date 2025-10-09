package mobiliario;

import java.util.ArrayList;

public class TestColecciones {

	public static void main(String[] args) 
	{
		ArrayList<Mueble> listaMuebles = new ArrayList<Mueble>();
		int randNum = (int) (Math.random() * 20 + 1);
		int randOpt = 0;
		System.out.printf("\n== NÚMERO DE REPETICIONES: %d ==\n\n", randNum);
		for(int i=0; i<randNum; i++)
		{
			try
			{
				randOpt = (int) (Math.random() * 5 + 1);
				switch(randOpt)
				{
				case 1:
					listaMuebles.add(new Mesa(Math.random() * 3000, "Mesa", "Cuadrada", (int) (Math.random() * 16 + 1)));
					System.out.println("Mesa creada con éxito.");
					break;
				case 2:
					listaMuebles.add(new Armario(Math.random() * 3000, "Armario",
							Math.random() * 200,Math.random() * 200, (int) (Math.random() * 50 + 1), (int) (Math.random() * 3 + 1)));
					System.out.println("Armario creado con éxito.");
					break;
				case 3:
					listaMuebles.add(new Sofa(Math.random() * 3000, "Sofa", (int) (Math.random() * 20 + 1),
							"Tapiceria", "Color", "Composición"));
					System.out.println("Sofa creado con éxito.");
					break;
				case 4:
					listaMuebles.add(new Silla(Math.random() * 3000, "Silla","Tapicería", "Color"));
					System.out.println("Silla creado con éxito.");
					break;
				case 5:
					listaMuebles.add(new Estanteria(Math.random() * 3000, "Estantería",
							Math.random() * 200, Math.random() * 200, (int) (Math.random() * 50 + 1), "Tipo"));
					System.out.println("Estantería creado con éxito.");
					break;
				}
			}catch(IllegalArgumentException ex)
			{
				System.out.printf("ERROR: %s\n", ex.getMessage());
			}
		}
		
		int contador = 0;
		System.out.println("\n=== MOSTRANDO COLECCION ===\n");
		System.out.printf("HashCode: %d\nSize: %d\n\n", listaMuebles.hashCode(), listaMuebles.size());
		for(Mueble i : listaMuebles)
		{
			contador++;
			System.out.printf("Mueble Nº%d	|| %s\n", contador, i.toString());
		}
		
		System.out.println("\n=== ORDENANDO COLECCION (POR PRECIO DESCENDENTE) ===\n");
		listaMuebles.sort(new ComparatorMueble());
		contador = 0;
		for(Mueble i : listaMuebles)
		{
			contador++;
			System.out.printf("Mueble Nº%d	|| %s\n", contador, i.toString());
		}
	}
}
