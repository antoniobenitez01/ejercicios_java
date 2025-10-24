package ratones;

public class Raton extends Thread 
{
	private String nombre;
	private int tiempo;
	
	public Raton(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}
	
	public void comer() {
		try {
			System.out.printf("%s empieza la merienda.\n",this.nombre);
			Thread.sleep(1000 * this.tiempo);
			System.out.printf("%s terminó de comer.\n",this.nombre);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		this.comer();
	}
}
