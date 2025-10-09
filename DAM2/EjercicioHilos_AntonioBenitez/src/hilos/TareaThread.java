package hilos;

public class TareaThread implements Runnable 
{
	private String threadName;
	
	public TareaThread(String threadName)
	{
		this.threadName = threadName;
		System.out.println("Creando " + this.threadName);
	}
	
	@Override
	public void run()
	{
		System.out.println("Ejecutando " + this.threadName + "...");
		try
		{
			for(int i = 1; i<=5; i++)
			{
				System.out.println("Hilo: " + this.threadName + " - Contador: " + i);
				int randNum = (int) ((Math.random() * 20000) + 10000);
				Thread.sleep(randNum);
			}
		}catch(InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
