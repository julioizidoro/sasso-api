package br.com.sassotabacco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.sassotabacco.model.Planoconta;
import br.com.sassotabacco.repository.PlanoContaRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/planoconta")
public class PlanoContaController {
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Planoconta salvar(@Valid @RequestBody Planoconta planoConta) {
		return planoContaRepository.save(planoConta);
	}
	
	@GetMapping
	public ResponseEntity<List<Planoconta>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "descricao");
		List<Planoconta> lista = planoContaRepository.findAll(sort);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/{descricao}")
	public ResponseEntity<Optional<List<Planoconta>>> listarDescricao(@PathVariable("descricao") String descricao) {
		Optional<List<Planoconta>> lista = planoContaRepository.findByDescricaoContainingOrderByDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("categoria/{idcategoria}")
	public ResponseEntity<Optional<List<Planoconta>>> getCategoria(@PathVariable("idcategoria") int idCategoria) {
		Optional<List<Planoconta>> lista = planoContaRepository.findCategoria(idCategoria);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Planoconta>> pesquisar(@PathVariable("id") int id) {
		Optional<Planoconta> lista = planoContaRepository.findById(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}

}
