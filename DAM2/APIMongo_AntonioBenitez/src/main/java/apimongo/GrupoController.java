package apimongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/grupos")
public class GrupoController {
	
	@Autowired
	private GrupoService grupoService;
	
	@GetMapping("/nombre")
	public ResponseEntity<List<GrupoMusicalDTO>> getGrupoMusicalByNombre(@RequestParam String nombre){
		List<GrupoMusicalDTO> grupos = grupoService.getGrupoMusicalByNombre(nombre);
		return ResponseEntity.ok(grupos);
	}
	
	@GetMapping("/fecha")
	public ResponseEntity<List<GrupoMusicalDTO>> getGrupoMusicalByFecha(@RequestParam String fecha){
		List<GrupoMusicalDTO> grupos = grupoService.getGrupoMusicalByFecha(fecha);
		return ResponseEntity.ok(grupos);
	}
	
	@GetMapping("/albumes/{substring}")
	public ResponseEntity<List<AlbumBusquedaDTO>> getAlbumesBySubstring(@PathVariable String substring){
		List<AlbumBusquedaDTO> albumes = grupoService.getAlbumBySubstring(substring);
		return ResponseEntity.ok(albumes);
	}
}

