package ratones;

import java.util.ArrayList;
import java.util.List;

public class Main 
{
	public static void main(String[] args) 
	{
		// CREANDO OBJETOS RATON --------------------------
		Raton tinky = new Raton("Tinky",4);
		Raton winky = new Raton("Winky",2);
		Raton lala = new Raton("Lala",1);
		Raton po = new Raton("Po",5);
		// CORRIENDO OBJETOS RATON ------------------------
		long start = System.currentTimeMillis();
		System.out.println("SYSTEM START - CURRENT TIME MILLIS = " + start);
		List<Thread> threads = new ArrayList<>(); // Lista de Threads
		tinky.start();
		threads.add(tinky);
		winky.start();
		threads.add(winky);
		lala.start();
		threads.add(lala);
		po.start();
		threads.add(po);
		// Bucle for que espera a que todos los objetos Thread terminen
		for (Thread t : threads) { 
		    try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		// CÁLCULO TIEMPO DE EJECUCIÓN --------------------
		long stop = System.currentTimeMillis();
		System.out.println("SYSTEM STOP - CURRENT TIME MILLIS = " + stop);
		System.out.println("CÁLCULO DE TIEMPO TOTAL EN SEGUNDOS = " + ((stop - start) / 1000) + " segundos");
	}
}
