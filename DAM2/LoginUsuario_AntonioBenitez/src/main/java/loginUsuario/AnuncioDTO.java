package loginUsuario;

public class AnuncioDTO {
	
    private Long id;
	private String titulo;
	private String descripcion;
	private String autor;
	
	public AnuncioDTO() {
		
	}
	
	public AnuncioDTO(Long id, String titulo, String descripcion, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.autor = autor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}
