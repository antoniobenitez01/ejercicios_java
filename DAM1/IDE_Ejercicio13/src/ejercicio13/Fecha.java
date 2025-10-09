package ejercicio13;

import java.text.SimpleDateFormat; 
import java.util.Date; 

public class Fecha 
{ 
/** 
* Variables de instancia 
*/ 
	private SimpleDateFormat formato; 
	private Date hoy; 
/** 
* Constructor 
*/ 
	public Fecha() 
	{ 
		hoy = new Date(); 
	} 
/** 
* Método que formatea la fecha según el valor de tipo 
* @param tipo 
* @return 
*/ 
	public String devuelveFecha(int tipo) 
	{
		String cad = ""; 
		switch (tipo) 
		{
		case 1: 
			formato = new SimpleDateFormat("dd/MM/yyyy"); 
			cad = formato.format(hoy); 
			break; 
		case 2: 
			formato = new SimpleDateFormat("MM/yyyy"); 
			cad = formato.format(hoy); 
			break; 
		case 3: 
			formato = new SimpleDateFormat("EEEE dd-MMM-yyyy, HH:mm:ss"); 
			cad = formato.format(hoy); 
			break; 
		default: 
			cad = "ERROR"; 
		} 
		return cad; 
	}
}
