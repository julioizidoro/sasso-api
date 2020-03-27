package br.com.sassotabacco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
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

import br.com.sassotabacco.model.Grupoplanoconta;
import br.com.sassotabacco.repository.GrupoPlanoContaRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/grupoplanocontas")
public class GrupoPlanoContaController {
	
	@Autowired
	private GrupoPlanoContaRepository grupoPlanoContaRepository;
	
	@GetMapping("descricao/{descricao}")
	public ResponseEntity<Optional<List<Grupoplanoconta>>> pesquisarDescricao(@PathVariable("descricao") String descricao) {
		Optional<List<Grupoplanoconta>> lista = grupoPlanoContaRepository.findByDescricaoContainingOrderByDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("conta/{conta}")
	public ResponseEntity<Optional<List<Grupoplanoconta>>> pesquisarConta(@PathVariable("conta") String conta) {
		Optional<List<Grupoplanoconta>> lista = grupoPlanoContaRepository.findByContaContainingOrderByDescricao(conta);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Grupoplanoconta>> pesquisar(@PathVariable("id") int id) {
		Optional<Grupoplanoconta> lista = grupoPlanoContaRepository.findById(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);  
	}
	
	@GetMapping
	@Cacheable("consultaGrupoContas")
	public ResponseEntity<List<Grupoplanoconta>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "descricao");
		List<Grupoplanoconta> lista = grupoPlanoContaRepository.findAll(sort);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/salvar")
	@CachePut("consultaGrupoContas")
	@ResponseStatus(HttpStatus.CREATED)
	public Grupoplanoconta salvar(@Valid @RequestBody Grupoplanoconta Grupoplanoconta) {
		return grupoPlanoContaRepository.save(Grupoplanoconta);
	}

}
