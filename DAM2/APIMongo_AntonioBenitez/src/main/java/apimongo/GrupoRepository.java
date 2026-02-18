package apimongo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GrupoRepository extends MongoRepository<GrupoMusical, String>{
	
	List<GrupoMusical> findByNombre(String nombre);
	List<GrupoMusical> findByAlbumesFecha(String anyo);
	@Aggregation(pipeline = {
	        "{ $unwind: '$albumes' }",
	        "{ $match: { 'albumes.nombre': { $regex: ?0, $options: 'i' } } }",
	        "{ $project: { _id: 0, grupo: '$nombre', nombre: '$albumes.nombre', fecha: '$albumes.fecha' } }"
	    })
	 List<AlbumBusquedaDTO> buscarAlbumesPorSubcadena(String subcadena);
}
