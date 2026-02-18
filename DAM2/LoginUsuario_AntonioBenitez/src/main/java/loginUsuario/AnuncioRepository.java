package loginUsuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
	List<Anuncio> findTop5ByTituloContainingIgnoreCaseOrderByIdDesc(String texto);
}

