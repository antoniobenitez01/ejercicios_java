package crudtabla;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO){
		ClienteDTO clienteCreado = clienteService.createCliente(clienteDTO);
		return ResponseEntity.status(201).body(clienteCreado);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id ){
		ClienteDTO cliente = clienteService.getClienteById(id);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/buscar/email")
	public ResponseEntity<ClienteDTO> getClienteByEmail(@RequestParam String email){
		ClienteDTO cliente = clienteService.getClienteByEmail(email);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/buscar/dni")
	public ResponseEntity<ClienteDTO> getClienteByDni(@RequestParam String dni){
		ClienteDTO cliente = clienteService.getClienteByDni(dni);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/buscar/apellidos")
	public ResponseEntity<List<ClienteDTO>> getClientesByApellidos(@RequestParam String apellidos){
		List<ClienteDTO> clientes = clienteService.getClientesByApellidos(apellidos);
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/buscar/nombre")
	public ResponseEntity<List<ClienteDTO>> getClientesByNombreContainingIgnoreCase(@RequestParam String nombre){
		List<ClienteDTO> clientes = clienteService.getClientesByNombreContainingIgnoreCase(nombre);
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/buscar/nombrecompleto")
	public ResponseEntity<List<ClienteDTO>> getClientesByNombreAndApellidos(
			@RequestParam String nombre,
			@RequestParam String apellidos){
		List<ClienteDTO> clientes = clienteService.getClientesByNombreAndApellidos(nombre, apellidos);
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/activos")
	public ResponseEntity<List<ClienteDTO>> getClientesByActivoTrue(){
		List<ClienteDTO> clientes = clienteService.getClientesByActivoTrue();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/buscar/ciudad")
	public ResponseEntity<List<ClienteDTO>> getClientesByCiudad(@RequestParam String ciudad){
		List<ClienteDTO> clientes = clienteService.getClientesByCiudad(ciudad);
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/buscar/alta")
	public ResponseEntity<List<ClienteDTO>> getClientesByFechaAltaAfter(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
		List<ClienteDTO> clientes = clienteService.getClientesByFechaAltaAfter(fecha);
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/activos/{ciudad}")
	public ResponseEntity<List<ClienteDTO>> getClientesByActivoTrueAndCiudad(@PathVariable String ciudad){
		List<ClienteDTO> clientes = clienteService.getClientesByActivoTrueAndCiudad(ciudad);
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/count/{ciudad}")
	public ResponseEntity<Long> getCountByCiudad(@PathVariable String ciudad){
		Long count = clienteService.getCountByCiudad(ciudad);
		return ResponseEntity.ok(count);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO)
	{
		ClienteDTO clienteUpdate = clienteService.updateCliente(id, clienteDTO);
		return ResponseEntity.ok(clienteUpdate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> deleteCliente(@PathVariable Long id){
		clienteService.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
}

