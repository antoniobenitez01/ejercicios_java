package crudtabla;

import java.time.LocalDate;
import java.util.List;

public interface ClienteService {
	ClienteDTO createCliente(ClienteDTO clienteDTO);
	ClienteDTO getClienteById(Long id);
	ClienteDTO getClienteByEmail(String email);
	ClienteDTO getClienteByDni(String dni);
	List<ClienteDTO> getClientesByApellidos(String apellidos);
	List<ClienteDTO> getClientesByNombreContainingIgnoreCase(String nombre);
    List<ClienteDTO> getClientesByNombreAndApellidos(String nombre, String apellidos);
    List<ClienteDTO> getClientesByActivoTrue();
    List<ClienteDTO> getClientesByCiudad(String ciudad);
    List<ClienteDTO> getClientesByFechaAltaAfter(LocalDate fecha);
    List<ClienteDTO> getClientesByActivoTrueAndCiudad(String ciudad);
    long getCountByCiudad(String ciudad);
	ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);
	void deleteCliente(Long id);
}
