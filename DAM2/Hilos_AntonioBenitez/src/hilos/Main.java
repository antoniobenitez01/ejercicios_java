package hilos;

public class Main 
{
	public static void main(String[] args) 
	{
		TareaHilo tarea1 = new TareaHilo("Hilo-1");
		TareaHilo tarea2 = new TareaHilo("Hilo-2");
		TareaHilo tarea3 = new TareaHilo("Hilo-3");
		
		//2. Crear los objetos Thread pasando la tarea (Runnable) y el nombre
		Thread t1 = new Thread(tarea1);
		Thread t2 = new Thread(tarea2);
		Thread t3 = new Thread(tarea3);
		
		//3. Iniciar la ejecución de los hilos
		// LLAMAR a start() ES FUNDAMNETAL, NO a run()
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("HIlos iniciados. EL hilo principal (main) continúa su ejecución.");
	}
}
