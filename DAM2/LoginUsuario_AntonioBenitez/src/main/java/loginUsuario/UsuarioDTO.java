package loginUsuario;

public class UsuarioDTO {
	
	private Long id;
    private String nombre;
    private String contrasena;
    private String nombre_completo;
    private String email;
    private String token;
    
    public UsuarioDTO() {
    	
    }
    
    public UsuarioDTO(Long id, String nombre, String contrasena, String nombre_completo, String email) {
    	this.id = id;
    	this.nombre = nombre;
    	this.contrasena = contrasena;
    	this.nombre_completo = nombre_completo;
    	this.email = email;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
