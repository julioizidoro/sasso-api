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

import br.com.sassotabacco.model.Acesso;
import br.com.sassotabacco.repository.AcessoRepository;


@CrossOrigin
@RestController
@RequestMapping("acessos")
public class AcessoController {
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Acesso salvar(@Valid @RequestBody Acesso acesso) {
		return acessoRepository.save(acesso);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Acesso> buscar(@PathVariable Integer id) {
		Optional<Acesso> acesso = acessoRepository.findById(id);
		
		if (acesso==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(acesso.get());
	}
	
	@GetMapping("listar/{nome}")
	public ResponseEntity<Optional<List<Acesso>>> listar(@PathVariable("nome") String nome) {
		Optional<List<Acesso>> lista = acessoRepository.findByNomeContainingOrderByNome(nome);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar")
	public ResponseEntity<List<Acesso>> listar() {
		List<Acesso> lista = acessoRepository.findAll();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}

}
