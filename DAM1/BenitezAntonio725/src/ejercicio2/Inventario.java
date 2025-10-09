package ejercicio2;

public class Inventario 
{
	private Mascota[] listaMascotas;
	private int ultimaPosicion;
	
	public Inventario(Mascota[] listaMascotas)
	{
		this.listaMascotas = listaMascotas;
		this.ultimaPosicion = 0;
	}
	
	public void mostrarLista()
	{
		isVacioException();
		for(int i=0; i<this.ultimaPosicion; i++)
		{
			System.out.printf("%d. Nombre: %s || Tipo: %s\n",i+1,listaMascotas[i].getNombre(), tipoMascota(listaMascotas[i]));
		}
	}
	
	public void mostrarDatosAnimal(String nombre)
	{
		isVacioException();
		Mascota mascota = encontrarAnimal(nombre);
		if(mascota == null)
		{
			System.out.println("No se ha encontrado la mascota con ese nombre.");
		}
		else
		{
			System.out.printf("%s\n\n", mascota.toString());
		}
	}
	
	public void mostrarTodosDatos()
	{
		isVacioException();
		for(int i=0; i<ultimaPosicion; i++)
		{
			System.out.printf("%d. %s\n\n",i+1, listaMascotas[i].toString());
		}
	}
	
	public void insertarAnimal(Mascota mascota) throws IllegalStateException
	{
		if(this.ultimaPosicion > this.listaMascotas.length)
		{
			throw new IllegalStateException("El inventario está lleno.");
		}
		this.listaMascotas[this.ultimaPosicion] = mascota;
		this.ultimaPosicion++;
	}
	
	public void eliminarAnimal(int posicion) throws NullPointerException
	{
		int posicionReal = posicion - 1;
		if(this.listaMascotas[posicionReal] == null || posicionReal < 0 || posicionReal > this.listaMascotas.length)
		{
			throw new NullPointerException ("No hay ninguna Mascota en esa posición.");
		}
		
		this.listaMascotas[posicionReal] = null;
		reorganizarListaMascotas(posicionReal);
		this.ultimaPosicion--;
	}
	
	public void vaciarInventario()
	{
		isVacioException();
		for(int i=0; i<this.listaMascotas.length;i++)
		{
			this.listaMascotas[i] = null;
		}
		this.ultimaPosicion = 0;
	}
	
	private void reorganizarListaMascotas(int posicionReal)
	{
		for(int i=posicionReal;i<this.listaMascotas.length;i++)
		{
			if(this.listaMascotas[i] == null && i != (this.listaMascotas.length - 1))
			{
				this.listaMascotas[i] = this.listaMascotas[i+1];
				this.listaMascotas[i+1] = null;
			}
		}
	}
	
	private Mascota encontrarAnimal(String nombre)
	{
		Mascota mascota = null;
		int contador = 0;
		do
		{
			if(this.listaMascotas[contador].getNombre().equals(nombre))
			{
				mascota = this.listaMascotas[contador];
			}
			else
			{
				contador++;
			}
		}while(mascota == null && contador < this.ultimaPosicion);
		return mascota;
	}
	
	private void isVacioException() throws NullPointerException
	{
		if(this.ultimaPosicion == 0)
		{
			throw new NullPointerException("ERROR: Inventario vacío.");
		}
	}
	
	private String tipoMascota(Mascota mascota) throws IllegalArgumentException
	{
		String tipo = "";
		if(mascota instanceof Perro)
		{
			tipo = "Perro";
		}else if(mascota instanceof Gato)
		{
			tipo = "Gato";
		}else if(mascota instanceof Loro)
		{
			tipo = "Loro";
		}else if(mascota instanceof Canario)
		{
			tipo = "Canario";
		}else
		{
			throw new IllegalArgumentException("No se ha reconocido la mascota introducida.");
		}
		return tipo;
	}
}
