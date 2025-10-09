package graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Draw extends Canvas
{

	public static void main(String[] args) 
	{
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Draw();
        canvas.setSize(1280, 720);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
	}
	
    public void paint(Graphics g) 
    {
        g.fillOval(100, 100, 200, 200);
    }

}
