package loginUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
		if(usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
			throw new IllegalArgumentException("E-Mail ya existe.");
		}
		Usuario usuario = new Usuario(
				usuarioDTO.getNombre(),
				passwordEncoder.encode(usuarioDTO.getContrasena()),
				usuarioDTO.getNombre_completo(),
				usuarioDTO.getEmail());
		usuario = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario.getId(),
				usuario.getNombre(),
				usuario.getContrasena(),
				usuario.getNombre_completo(),
				usuario.getEmail());
	}
	
	@Override
	public UsuarioDTO loginUsuario(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente con email " + email + " no encontrado."));
		if(!passwordEncoder.matches(password, usuario.getContrasena())){
			throw new InvalidCredentialsException("Credenciales inválidas.");
		}
		return new UsuarioDTO(usuario.getId(),
				usuario.getNombre(),
				null,
				usuario.getNombre_completo(),
				usuario.getEmail());
	}
}
