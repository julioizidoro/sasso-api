package br.com.sassotabacco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sassotabacco.model.Usuario;
import br.com.sassotabacco.repository.UsuarioRepository;
import br.com.sassotabacco.util.Criptografia;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	@GetMapping("buscar/{situacao}")
	public ResponseEntity<Optional<List<Usuario>>> buscarSituacao(@PathVariable("situacao") boolean situacao) {
		Optional<List<Usuario>> usuarios = usuarioRepository.findBySituacaoOrderByNome(situacao);
		if (usuarios==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping(path = "/logar", consumes = "application/json", produces = "application/json") 
	@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Usuario> logar(@Valid @RequestBody Usuario usuario) {
		Criptografia criptografia = new Criptografia();
		String password = (criptografia.encript(usuario.getPassword()));
		usuario = usuarioRepository.findByUserAndPasswordAndSituacao(usuario.getUser(), password,true);
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@Valid @RequestBody Usuario usuario) {
		Criptografia criptografia = new Criptografia();
		usuario.setPassword(criptografia.encript(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> buscar(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/{user}/{password}")
	public ResponseEntity<Usuario> buscar(@PathVariable("user") String user, @PathVariable("password") String password) {
		Criptografia criptografia = new Criptografia();
		password = (criptografia.encript(password));
		Usuario usuario = usuarioRepository.findByUserAndPasswordAndSituacao(user, password,true);
		
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("buscarnome/{nome}")
	public ResponseEntity<Optional<List<Usuario>>> buscarNome(@PathVariable("nome") String nome) {
		Optional<List<Usuario>> usuarios = usuarioRepository.findByNomeContainingOrderByNome(nome);
		
		if (usuarios==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuarios);
	}
}

