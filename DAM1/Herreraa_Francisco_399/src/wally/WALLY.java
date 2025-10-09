package wally;
import java.util.Scanner;
import java.util.Random;
public class WALLY {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Random random = new Random();
        int posicionx = random.nextInt(999);
        int posiciony = random.nextInt(999);
        int intentos = 0;
        boolean acertado = false;
		double x, y;
		

	        System.out.println("¡Bienvenido al juego de encontrar a Wally!");
	        System.out.println("Él está en una coordenada aleatoria intenta averiguar donde esta.");
	        System.out.println();
	        
	        while (!acertado) {
	            System.out.print("Introduce la coordenada x: ");
	            try {
	                int numero = scanner.nextInt();
	                intentos++;

	                if (numero < posicionx) {
	                    System.out.println("El número es mayor.");
	                } else if (numero > posiciony) {
	                    System.out.println("El número es menor.");
	                } else {
	                    System.out.printf("¡Felicidades! Has adivinado el número %d en %d intentos.%n", posicionx, intentos);
	                    acertado = true;
	                }
	            } catch (Exception e) {
	                System.out.println("Por favor, introduce una coordenada válida.");
	                scanner.next();     
	
	            
	            
	            
	            }
	        }
	        
	               
	        
	        
	        
	}
	
}


