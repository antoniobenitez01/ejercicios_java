package ejemploColecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Colecciones 
{
	public static void main(String[] args) 
	{
		Scanner entradaTeclado = new Scanner(System.in);
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		int size = numAleatorio(20);
		for(int i=0; i < size; i++)
		{
			lista.add(numAleatorio(100));
		}
		
		int num = inputInt("Introduzca un número por teclado.", entradaTeclado);
		int index = lista.indexOf(num);
		if(index == -1)
		{
			System.out.println("El elemento no se ha encontrado en la lista.");
		}
		else
		{
			System.out.printf("El elemento se ha encontrado en la posición Nº%d\n", index + 1);
		}
		
		System.out.printf("%s\n", lista.toString());
		
		int numBorrar = inputInt("Introduzca la posición del número que quiere borrar.", entradaTeclado);
		try
		{
			System.out.printf("Borrando el número en la posición Nº%d (%d)\n", numBorrar, lista.get(numBorrar - 1));
			lista.remove(numBorrar - 1);
			System.out.println("Número borrado con éxito.");
			System.out.printf("%s\n", lista.toString());
		}catch(IndexOutOfBoundsException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		int numBorrar2 = inputInt("Introduzca el número que quiere borrar.", entradaTeclado);
		boolean borrado = lista.remove(new Integer(numBorrar2));
		if(borrado)
		{
			System.out.printf("Número %d borrado con éxito de la lista.\n", numBorrar2);
			System.out.printf("%s\n", lista.toString());
		}else
		{
			System.out.println("No se ha encontrado el número en la lista.");
		}
		
		
		// -------------------------------------------------------------------------
		
		/*System.out.println("\n---------------------------- \nCREACIÓN DE UN HASH SET \n----------------------------");
		HashSet<Integer> hash = new HashSet<Integer>();
		int size2 = numAleatorio(50);
		int numAleatorio;
		for(int i = 0; i<size2; i++)
		{
			numAleatorio = numAleatorio(100);
			if(!hash.add(numAleatorio))
			{
				System.out.printf("No se ha introducido el valor %d porque ya está en la lista.\n", numAleatorio);
			}
		}
		System.out.printf("\n%s\n", hash.toString());
		
		int numTeclado = inputInt("\nIntroduzca un número que quiera buscar en la colección", entradaTeclado);
		if(hash.contains(numTeclado))
		{
			System.out.printf("El número %d sí está en la lista.\n", numTeclado);
		}else
		{
			System.out.printf("El número %d no está en la lista.\n", numTeclado);
		}
		
		numTeclado = inputInt("\nIntroduzca un número que quiera eliminar de la colección", entradaTeclado);
		if(hash.remove(numTeclado))
		{
			System.out.printf("Se ha eliminado el número %d con éxito.\n", numTeclado);
			System.out.printf("\n%s\n", hash.toString());
		}else
		{
			System.out.printf("No se ha eliminado el número %d porque no está en la colección\n", numTeclado);
		}
		
		System.out.println("\n---------------------------- \nCREACIÓN DE UN LINKED HASH SET \n----------------------------");
		
		LinkedHashSet<Integer> linked = new LinkedHashSet<Integer>();
		int numAleatorio = numAleatorio(50);
		System.out.printf("\nCreando LinkedHashSet con tamaño %d ...\n", numAleatorio);
		for(int i=0; i<numAleatorio; i++)
		{
			numAleatorio = numAleatorio(100);
			if(!linked.add(numAleatorio))
			{
				System.out.printf("ERROR: No se ha introducido el valor %d porque ya está en la lista.\n", numAleatorio);
			}
			
		}
		System.out.printf("\n%s\n", linked.toString());
		
		int numTeclado = inputInt("\nIntroduzca un número que quiera buscar en la colección", entradaTeclado);
		if(linked.contains(numTeclado))
		{
			System.out.printf("El número %d sí está en la lista.\n", numTeclado);
		}else
		{
			System.out.printf("El número %d no está en la lista.\n", numTeclado);
		}
		
		numTeclado = inputInt("\nIntroduzca un número que quiera eliminar de la colección", entradaTeclado);
		if(linked.remove(numTeclado))
		{
			System.out.printf("Se ha eliminado el número %d con éxito.\n", numTeclado);
			System.out.printf("\n%s\n", linked.toString());
		}else
		{
			System.out.printf("No se ha eliminado el número %d porque no está en la colección\n", numTeclado);
		}*/
		
		/*HashSet<Integer> hash1 = new HashSet<Integer>();
		HashSet<Integer> hash2 = new HashSet<Integer>();
		
		int size = numAleatorio(20);
		for(int i=0;i<size;i++)
		{
			if(!hash1.add(numAleatorio(50)))
			{
				System.out.println("ERROR1");
			}
			if(!hash2.add(numAleatorio(50)))
			{
				System.out.println("ERROR2");
			}
		}
		
		System.out.printf("\n%s\n%s\n", hash1.toString(), hash2.toString());
		hash1.retainAll(hash2);
		System.out.printf("\n%s\n", hash1.toString());*/
	}
	
	private static int numAleatorio(int limite)
	{
		return (int) (Math.random() * limite + 1);
	}
	
	//INPUT INT - Recoge un mensaje String y un objeto Scanner, comprueba si se introduce un valor Integer correctamente
	public static int inputInt(String mensaje, Scanner entrada)
	{
		int num = 0;
		boolean inputTrue = false;
		do
		{
			//EXCEPCIÓN - InputMismatchException - Bucle que asegura que el valor introducido es un valor decimal
			try 
			{
				System.out.println(mensaje);
				num = entrada.nextInt();
				entrada.nextLine(); // Depuración Scanner
				inputTrue = true;
			} catch(InputMismatchException excepcion1)
			{
				System.out.println("Valor introducido incorrecto.");
				entrada.nextLine(); // Depuración Scanner
			}
		}while(inputTrue == false);
		return num;
	}
}
