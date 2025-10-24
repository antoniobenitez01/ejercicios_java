package inconsistencia;

import java.util.ArrayList;
import java.util.List;

public class Main 
{
	public static void main(String[] args) 
	{
		// CREANDO OBJETOS RATON --------------------------
		Vendedor ven1 = new Vendedor("Juan");
		Vendedor ven2 = new Vendedor("María");
		Vendedor ven3 = new Vendedor("Antonio");
		Vendedor ven4 = new Vendedor("Erin");
		// CORRIENDO OBJETOS RATON ------------------------
		long start = System.currentTimeMillis();
		System.out.println("SYSTEM START - CURRENT TIME MILLIS = " + start);
		System.out.printf("Número inicial de tickets = %d\n\n",Vendedor.numero);
		List<Thread> threads = new ArrayList<>(); // Lista de Threads
		ven1.start();
		threads.add(ven1);
		ven2.start();
		threads.add(ven2);
		ven3.start();
		threads.add(ven3);
		ven4.start();
		threads.add(ven4);
		// Bucle for que espera a que todos los objetos Thread terminen
		for (Thread t : threads) { 
		    try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.printf("\nTickets vendidos en total = %d\n",Vendedor.vendido);
		// CÁLCULO TIEMPO DE EJECUCIÓN --------------------
		long stop = System.currentTimeMillis();
		System.out.println("SYSTEM STOP - CURRENT TIME MILLIS = " + stop);
		System.out.println("CÁLCULO DE TIEMPO TOTAL EN SEGUNDOS = " + ((stop - start) / 1000) + " segundos");
	}
}
