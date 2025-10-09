package salidaentrada;

import java.io.*;

public class Main 
{
	public static void main(String[] args) 
	{
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
		try 
		{
			Process p = pb.start();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str;
			while((str=br.readLine())!= null)
			{
				System.out.println(str);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
