package crudtabla;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	boolean existsByNombre(String nombre);
    boolean existsByEmail(String email);
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByDni(String dni);
    List<Cliente> findByApellidos(String apellidos);
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    List<Cliente> findByNombreAndApellidos(String nombre, String apellidos);
    List<Cliente> findByActivoTrue();
    List<Cliente> findByCiudad(String ciudad);
    List<Cliente> findByFechaAltaAfter(LocalDate fecha);
    List<Cliente> findByActivoTrueAndCiudad(String ciudad);
    long countByCiudad(String ciudad);
}

