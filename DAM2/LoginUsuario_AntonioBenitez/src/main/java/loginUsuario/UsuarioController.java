package loginUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;;

@RestController
@RequestMapping(path="/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
		try {
			UsuarioDTO usuarioCreado = usuarioService.createUsuario(usuarioDTO);
			usuarioCreado.setContrasena(null);
			return ResponseEntity.status(201).body(usuarioCreado);
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(409).body(null);
		}catch(Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}
	
	@GetMapping
	public ResponseEntity<UsuarioDTO> loginUsuario(
			@RequestParam String email,
			@RequestParam String contrasena){
		try {
			UsuarioDTO loggedUsuario = usuarioService.loginUsuario(email, contrasena);
			return ResponseEntity.status(201).body(loggedUsuario);
		}catch(ResourceNotFoundException | InvalidCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}catch(Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}
}

