package loginUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired(required = false)
	private JwtTokenUtil jwtTokenUtil;
	
	@Transactional
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
		
		UsuarioDTO created = new UsuarioDTO(usuario.getId(),
				usuario.getNombre(),
				null,
				usuario.getNombre_completo(),
				usuario.getEmail());
		try {
			String token = jwtTokenUtil.generateToken(created);
			created.setToken(token);
		} catch (Exception e) {
			System.err.println("Error generating token: " + e.getMessage());
		}
		return created;
	}
	
	public UsuarioDTO loginUsuario(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente con email " + email + " no encontrado."));
		if(!passwordEncoder.matches(password, usuario.getContrasena())){
			throw new InvalidCredentialsException("Credenciales inválidas.");
		}
		UsuarioDTO created = new UsuarioDTO(usuario.getId(),
				usuario.getNombre(),
				null,
				usuario.getNombre_completo(),
				usuario.getEmail());
		String token = jwtTokenUtil.generateToken(created);
		created.setToken(token);
		return created;
	}
}
