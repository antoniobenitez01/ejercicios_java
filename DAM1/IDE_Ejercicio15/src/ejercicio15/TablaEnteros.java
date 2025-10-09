package ejercicio15;

public class TablaEnteros 
{ 
	/** 
	* Variable de instancia 
	*/ 
	private int [] tabla; 
	/** 
	* Constructor 
	* @param tabla 
	*/ 
	public TablaEnteros(int [] tabla) 
	{ 
		if ((tabla==null) || (tabla.length == 0)) 
			throw new IllegalArgumentException("No hay elementos"); 
		this.tabla = tabla; 
	} 
	/** 
	* Devuelve la suma de los elementos de la tabla 
	*/ 
	public int sumaTabla() 
	{ 
	int suma = 0; 
	for (int i=0; i<tabla.length; i++) 
		suma += tabla[i]; 
	return suma; 
	}
	/** 
	* Devuelve el mayor elemento de la tabla 
	*/ 
	public int mayorTabla() 
	{ 
	int max = tabla[0]; 
	for (int i=1; i<tabla.length; i++) 
		if (tabla[i] > max) 
			max = tabla[i];
	return max; 
	} 
	/** 
	* Devuelve la posición de un elemento cuyo valor se pasa 
	* @param n 
	* @return 
	*/ 
	public int posicionTabla(int n) 
	{ 
		int pos = -1; 
		for (int i = 0; i<tabla.length; i++) 
			if (tabla[i]==n) 
				pos = i; 
		if (pos!=-1) 
			return pos; 
		throw new java.util.NoSuchElementException("No existe: "+n); 
	} 
} 

