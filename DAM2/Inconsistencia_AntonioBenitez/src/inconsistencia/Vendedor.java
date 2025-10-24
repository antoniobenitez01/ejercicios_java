package inconsistencia;

public class Vendedor extends Thread
{
	public static int numero;
	public static int vendido;
	
	private String nombre;
	
	static {
		numero = 10;
		vendido = 0;
	}
	
	public Vendedor(String nombre) {
		this.nombre = nombre;
	}
	
	public void vender() {
		try {
			System.out.printf("%s - Vendiendo Ticket Nº%d\n", this.nombre,numero);
			numero--;
			vendido++;
			Thread.sleep(1000 * 5);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		while(numero > 0) {
			vender();
		}
	}
}
