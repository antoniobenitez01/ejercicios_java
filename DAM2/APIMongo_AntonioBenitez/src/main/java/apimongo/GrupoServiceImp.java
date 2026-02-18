package apimongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoServiceImp implements GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;

	@Override
	public List<GrupoMusicalDTO> getGrupoMusicalByNombre(String nombre) {
		List<GrupoMusical> grupos = grupoRepository.findByNombre(nombre);
		return grupos.stream().map( grupo -> {
			List<AlbumDTO> albumesDTO = grupo.getAlbumes().stream().map( album -> new AlbumDTO(album.getNombre(), album.getFecha())).toList();
			return new GrupoMusicalDTO(
                    grupo.getId(),
                    grupo.getNombre(),
                    grupo.getPais(),
                    grupo.getEstilos(),
                    albumesDTO
            );
		}).toList();
	}

	@Override
	public List<GrupoMusicalDTO> getGrupoMusicalByFecha(String fecha) {
		List<GrupoMusical> grupos = grupoRepository.findByAlbumesFecha(fecha);
		return grupos.stream().map( grupo -> {
			List<AlbumDTO> albumesDTO = grupo.getAlbumes().stream().map( album -> new AlbumDTO(album.getNombre(), album.getFecha())).toList();
			return new GrupoMusicalDTO(
                    grupo.getId(),
                    grupo.getNombre(),
                    grupo.getPais(),
                    grupo.getEstilos(),
                    albumesDTO
            );
		}).toList();
	}

	@Override
	public List<AlbumBusquedaDTO> getAlbumBySubstring(String substring) {
		return grupoRepository.buscarAlbumesPorSubcadena(substring);
	}
}
