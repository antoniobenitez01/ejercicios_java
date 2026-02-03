package crudtabla;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public ClienteDTO createCliente(ClienteDTO clienteDTO) {
		if(clienteRepository.existsByEmail(clienteDTO.getDni())) {
			throw new IllegalArgumentException("DNI ya existe.");
		}
		if(clienteRepository.existsByEmail(clienteDTO.getEmail())) {
			throw new IllegalArgumentException("E-Mail ya existe.");
		}
		Cliente cliente = new Cliente(
				clienteDTO.getDni(),
				clienteDTO.getNombre(),
				clienteDTO.getApellidos(),
				clienteDTO.getEmail(),
				clienteDTO.getCiudad(),
				clienteDTO.isActivo());
		cliente = clienteRepository.save(cliente);
		return new ClienteDTO(cliente.getId(),
				cliente.getDni(),
				cliente.getNombre(),
				cliente.getApellidos(),
				cliente.getEmail(),
				cliente.getCiudad(),
				cliente.isActivo());
	}
	
	@Override
	public ClienteDTO getClienteById(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente con id " + id + " no encontrado."));
		return new ClienteDTO(cliente.getId(),
				cliente.getDni(),
				cliente.getNombre(),
				cliente.getApellidos(),
				cliente.getEmail(),
				cliente.getCiudad(),
				cliente.isActivo());
	}
	
	@Override
	public ClienteDTO getClienteByEmail(String email) {
		Cliente cliente = clienteRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente con email " + email + " no encontrado."));
		return new ClienteDTO(cliente.getId(),
				cliente.getDni(),
				cliente.getNombre(),
				cliente.getApellidos(),
				cliente.getEmail(),
				cliente.getCiudad(),
				cliente.isActivo());
	}
	
	@Override
	public ClienteDTO getClienteByDni(String dni) {
		Cliente cliente = clienteRepository.findByDni(dni)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente con DNI " + dni + " no encontrado."));
		return new ClienteDTO(cliente.getId(),
				cliente.getDni(),
				cliente.getNombre(),
				cliente.getApellidos(),
				cliente.getEmail(),
				cliente.getCiudad(),
				cliente.isActivo());
	}
	
	@Override
	public List<ClienteDTO> getClientesByApellidos(String apellidos){
		return clienteRepository.findByApellidos(apellidos).stream()
				.map(cliente -> new ClienteDTO(cliente.getId(),
						cliente.getDni(),
						cliente.getNombre(),
						cliente.getApellidos(),
						cliente.getEmail(),
						cliente.getCiudad(),
						cliente.isActivo())).toList();
	}
	
	@Override
	public List<ClienteDTO> getClientesByNombreContainingIgnoreCase(String nombre){
		return clienteRepository.findByNombreContainingIgnoreCase(nombre).stream()
				.map(cliente -> new ClienteDTO(cliente.getId(),
						cliente.getDni(),
						cliente.getNombre(),
						cliente.getApellidos(),
						cliente.getEmail(),
						cliente.getCiudad(),
						cliente.isActivo())).toList();
	}
	
	@Override
	public List<ClienteDTO> getClientesByNombreAndApellidos(String nombre, String apellidos){
		return clienteRepository.findByNombreAndApellidos(nombre, apellidos).stream()
				.map(cliente -> new ClienteDTO(cliente.getId(),
						cliente.getDni(),
						cliente.getNombre(),
						cliente.getApellidos(),
						cliente.getEmail(),
						cliente.getCiudad(),
						cliente.isActivo())).toList();
	}
	
	@Override
	public List<ClienteDTO> getClientesByActivoTrue(){
		return clienteRepository.findByActivoTrue().stream()
				.map(cliente -> new ClienteDTO(cliente.getId(),
						cliente.getDni(),
						cliente.getNombre(),
						cliente.getApellidos(),
						cliente.getEmail(),
						cliente.getCiudad(),
						cliente.isActivo())).toList();
	}
	
	@Override
	public List<ClienteDTO> getClientesByCiudad(String ciudad){
		return clienteRepository.findByCiudad(ciudad).stream()
				.map(cliente -> new ClienteDTO(cliente.getId(),
						cliente.getDni(),
						cliente.getNombre(),
						cliente.getApellidos(),
						cliente.getEmail(),
						cliente.getCiudad(),
						cliente.isActivo())).toList();
	}
	
	@Override
	public List<ClienteDTO> getClientesByFechaAltaAfter(LocalDate fecha){
		return clienteRepository.findByFechaAltaAfter(fecha).stream()
				.map(cliente -> new ClienteDTO(cliente.getId(),
						cliente.getDni(),
						cliente.getNombre(),
						cliente.getApellidos(),
						cliente.getEmail(),
						cliente.getCiudad(),
						cliente.isActivo())).toList();
	}
	
	@Override
	public List<ClienteDTO> getClientesByActivoTrueAndCiudad(String ciudad){
		return clienteRepository.findByActivoTrueAndCiudad(ciudad).stream()
				.map(cliente -> new ClienteDTO(cliente.getId(),
						cliente.getDni(),
						cliente.getNombre(),
						cliente.getApellidos(),
						cliente.getEmail(),
						cliente.getCiudad(),
						cliente.isActivo())).toList();
	}
	
	public long getCountByCiudad(String ciudad) {
	    return clienteRepository.countByCiudad(ciudad);
	}
	
	@Override
	public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente con id " + id + " no encontrado."));
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setEmail(clienteDTO.getEmail());
		Cliente clienteActualizado = clienteRepository.save(cliente);
		return new ClienteDTO(clienteActualizado.getId(),
				clienteActualizado.getDni(),
				clienteActualizado.getNombre(),
				clienteActualizado.getApellidos(),
				clienteActualizado.getEmail(),
				clienteActualizado.getCiudad(),
				clienteActualizado.isActivo());
	}
	
	@Override
	public void deleteCliente(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente con id " + id + " no encontrado."));
		clienteRepository.delete(cliente);
	}
}
