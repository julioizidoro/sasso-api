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

import br.com.sassotabacco.model.Categoriaconta;
import br.com.sassotabacco.repository.CategoriaContaRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/categoriaconta")
public class CategoriaContaController {
	
	@Autowired
	CategoriaContaRepository categoriaContaRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoriaconta salvar(@Valid @RequestBody Categoriaconta categoriaConta) {
		return categoriaContaRepository.save(categoriaConta);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoriaconta>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "descricao");
		List<Categoriaconta> lista = categoriaContaRepository.findAll(sort);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/{descricao}")
	public ResponseEntity<Optional<List<Categoriaconta>>> listarNome(@PathVariable("descricao") String descricao) {
		Optional<List<Categoriaconta>> lista = categoriaContaRepository.findByDescricaoContainingOrderByDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Categoriaconta>> pesquisar(@PathVariable("id") int id) {
		Optional<Categoriaconta> lista = categoriaContaRepository.findById(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}

}
