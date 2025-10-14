package comunicacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Padre 
{
	public static void main(String[] args) 
	{
		String pathHijo = new File("hijo.jar").getAbsolutePath();
		ProcessBuilder pbHijo = new ProcessBuilder("java","-jar",pathHijo);
		try 
		{
			System.out.println("Empezando proceso hijo ...");
			Process p = pbHijo.start();
			
			OutputStream os = p.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write("PREGUNTA");
			bw.close();
			
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str;
			while((str=br.readLine())!= null)
			{
				System.out.println(str);
			}
			System.out.println("HIJO EXIT CODE = " + p.exitValue());
		} catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
