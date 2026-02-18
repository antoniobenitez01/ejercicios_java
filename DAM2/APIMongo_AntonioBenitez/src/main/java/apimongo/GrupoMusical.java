package apimongo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "grupos")
public class GrupoMusical {
	@Id
	private String id;
	private String nombre;
	private String pais;
	private List<String> estilos;
	private List<Album> albumes;
	
	public GrupoMusical() {
		
	}
	
	public GrupoMusical(String id, String nombre, String pais, List<String> estilos, List<Album> albumes) {
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.estilos = estilos;
		this.albumes = albumes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<String> getEstilos() {
		return estilos;
	}

	public void setEstilos(List<String> estilos) {
		this.estilos = estilos;
	}

	public List<Album> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(List<Album> albumes) {
		this.albumes = albumes;
	}
	
	
}
