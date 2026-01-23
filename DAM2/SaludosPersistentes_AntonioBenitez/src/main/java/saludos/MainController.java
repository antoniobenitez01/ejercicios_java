package saludos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class MainController {
	
	@Autowired
	private SaludosRepository saludosRepository;
	
	@PostMapping(path="/saludos")
	public ResponseEntity<String> addSaludo(@RequestParam(defaultValue = "World") String nombre) {
		Saludo saludo = new Saludo(nombre,LocalDateTime.now());
		saludosRepository.save(saludo);
		return ResponseEntity.ok(String.format("Buenos días, %s!",nombre));
	}
	
	@GetMapping(path="/todos10")
	public @ResponseBody Iterable<Saludo> getUltimosSaludos(){
		return saludosRepository.findTop10ByOrderByIdDesc();	
	}
	
	@GetMapping(path="/versaludo")
	public @ResponseBody Saludo getSaludo(@RequestParam(defaultValue = "World") String nombre){
		return saludosRepository.findByNombreIgnoreCase(nombre.trim())
				.orElseThrow(() ->
						new ResponseStatusException(HttpStatus.NOT_FOUND,"Nombre no registrado."));
	}
}
