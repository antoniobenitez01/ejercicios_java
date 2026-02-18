package loginUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public AnuncioDTO createAnuncio(AnuncioDTO anuncioDTO, String token) {
		
		if(!jwtTokenUtil.validateToken(token)) {
			throw new InvalidCredentialsException("TOKEN Inválido o Expirado");
		}
		
		Usuario usuario = usuarioRepository.findById(jwtTokenUtil.getUserIdFromToken(token))
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
		Anuncio anuncio = new Anuncio(anuncioDTO.getTitulo(), anuncioDTO.getDescripcion(), usuario.getNombre_completo());
		anuncio = anuncioRepository.save(anuncio);
		return new AnuncioDTO(anuncio.getId(), anuncio.getTitulo(), anuncio.getDescripcion(), anuncio.getAutor());
	}
	
	public List<AnuncioDTO> buscarAnunciosPorTitulo(String texto){
		List<Anuncio> anuncios = anuncioRepository.findTop5ByTituloContainingIgnoreCaseOrderByIdDesc(texto);
		return anuncios.stream()
				.map( anuncio -> new AnuncioDTO(anuncio.getId(), anuncio.getTitulo(), anuncio.getDescripcion(), anuncio.getAutor()))
				.toList();
	}
}
