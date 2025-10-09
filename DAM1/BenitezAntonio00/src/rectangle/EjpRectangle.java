package rectangle;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class EjpRectangle {

	public static void main(String[] args) 
	{
		Rectangle rectangulo1, rectangulo2, rectangulo3; //Declaro un objeto
		
		rectangulo1 = new Rectangle(); //Instanciación
		System.out.println(rectangulo1);
		
		rectangulo2 = new Rectangle(5,3);
		System.out.println(rectangulo2);
		
		rectangulo3 = rectangulo2;
		System.out.println(rectangulo3);
		
		rectangulo3.x = 5;
		System.out.println(rectangulo1);
		System.out.println(rectangulo2);
		System.out.println(rectangulo3);
		
		Rectangle rectangulo4 = new Rectangle(4, 5, 5, 4);
		System.out.println(rectangulo4);
		
		Rectangle rectangulo5 = new Rectangle();
		rectangulo5.x = 4; //Por lo general, no se deben tocar las propiedades directamente
		rectangulo5.y = 5;
		rectangulo5.width = 5;
		rectangulo5.height = 4;
		rectangulo5.setLocation(4,5); //Lo normal es utilizar métodos dentro de la clase que nos permitan modificar las propiedades
		rectangulo5.setSize(5,4);
		System.out.println(rectangulo5);
		
		Rectangle rectangulo6 = rectangulo4;
		// Comprobamos si un punto está dentro del rectangulo
		boolean estaDentro = rectangulo6.contains(7,5);
		System.out.println(estaDentro);
		
		Point point1 = new Point(4,5);
		Dimension dimension1 = new Dimension(5,4);
		Rectangle rectangulo7 = new Rectangle(point1, dimension1);	
		System.out.println(rectangulo7);
		System.out.println(rectangulo7.contains(point1));
	}
}
