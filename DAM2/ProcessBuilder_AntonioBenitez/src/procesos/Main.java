/*
 * Programa que crea tres procesos al ejecutarse:
 * - Calculadora
 * - Bloc de notas
 * - Aplicación entrada por teclado
 * Autor: Antonio Benítez Rodríguez
 * Fecha: 19-09-2025
 */
package procesos;

public class Main 
{
	public static void main(String[] args) 
	{
		try
		{
			ProcessBuilder notepad = new ProcessBuilder("Notepad.exe");
			System.out.println("Ejecutando 'Notepad.exe' ...");
			Process notepadp = notepad.start();
			System.out.println(String.format("'Notepad.exe' - Exit value: %d", notepadp.waitFor()));
			
			ProcessBuilder calc = new ProcessBuilder("Calc.exe");
			System.out.println("Ejecutando 'Calc.exe' ...");
			Process calcp = calc.start();
			System.out.println(String.format("'Calc.exe' - Exit value: %d", calcp.waitFor()));
			
			ProcessBuilder pb = new ProcessBuilder(args);
			Process pbp = pb.start();
			System.out.println(String.format("'%s' - Exit value: %d",args.toString(), pbp.waitFor()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
