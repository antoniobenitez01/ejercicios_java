package apimongo;

public class AlbumBusquedaDTO {
	
	private String grupo;
	private String nombre;
	private String fecha;
	
	public AlbumBusquedaDTO() {
		
	}
	
	public AlbumBusquedaDTO(String grupo, String nombre, String fecha) {
		this.grupo = grupo;
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
