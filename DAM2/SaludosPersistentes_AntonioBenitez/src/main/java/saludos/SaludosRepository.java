package saludos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaludosRepository extends JpaRepository<Saludo, Integer> {
	Optional<Saludo> findByNombreIgnoreCase(String nombre);
	List<Saludo> findTop10ByOrderByIdDesc();
}
