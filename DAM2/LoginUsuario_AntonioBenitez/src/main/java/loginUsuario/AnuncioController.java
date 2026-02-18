package loginUsuario;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
	
@RestController
@RequestMapping(path="/api/anuncios")
public class AnuncioController {
		
	@Autowired
	private AnuncioService anuncioService;
		
	@PostMapping
	public ResponseEntity<AnuncioDTO> createAnuncio(
			@RequestBody AnuncioDTO anuncioDTO,
			@RequestHeader("Authorization") String authHeader){
		try {
			
			if(authHeader == null || !authHeader.startsWith("Bearer ")) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
			String token = authHeader.substring(7);
			AnuncioDTO createdAnuncio = anuncioService.createAnuncio(anuncioDTO, token);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdAnuncio);
			
		}catch(InvalidCredentialsException | ResourceNotFoundException e) {
	           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    } catch(IllegalArgumentException e) {
	           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    } catch(Exception e) {
	           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	@GetMapping
	public ResponseEntity<List<AnuncioDTO>> buscarAnunciosPorTitulo(
			@RequestParam String titulo){
		List<AnuncioDTO> anuncios = anuncioService.buscarAnunciosPorTitulo(titulo);
		return ResponseEntity.ok(anuncios);
	}
}
