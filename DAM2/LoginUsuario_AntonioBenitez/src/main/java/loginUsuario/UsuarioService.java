package loginUsuario;

public interface UsuarioService {
	UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);
	UsuarioDTO loginUsuario(String email, String password);
}
