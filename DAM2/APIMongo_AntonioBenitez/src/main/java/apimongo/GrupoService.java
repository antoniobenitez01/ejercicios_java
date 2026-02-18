package apimongo;

import java.util.List;

public interface GrupoService {
	List<GrupoMusicalDTO> getGrupoMusicalByNombre(String nombre);
	List<GrupoMusicalDTO> getGrupoMusicalByFecha(String fecha);
	List<AlbumBusquedaDTO> getAlbumBySubstring(String substring);
}
