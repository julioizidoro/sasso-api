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

import br.com.sassotabacco.model.Estoque;
import br.com.sassotabacco.repository.EstoqueRepository;
import br.com.sassotabacco.repository.ProdutoRepository;

@CrossOrigin
@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Estoque salvar(@Valid @RequestBody Estoque estoque) {
		estoque.setProduto(produtoRepository.save(estoque.getProduto()));
		return estoqueRepository.save(estoque);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Estoque> findEstoqueById(@PathVariable Integer id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		if (estoque==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estoque.get());
	}
	
	@GetMapping("/produto/id/{id}/{idempresa}")
	public ResponseEntity<Estoque> findProdutoById(@PathVariable Integer id, @PathVariable int idempresa) {
		Optional<Estoque> estoque = estoqueRepository.findProdutoId(id, idempresa);
		if (estoque==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estoque.get());
	}
	
	@GetMapping("listar/produto/descricao/{descricao}/{idempresa}")
	public ResponseEntity<Optional<List<Estoque>>> listarProdutoDescricao(@PathVariable("descricao") String descricao, @PathVariable int idempresa) {
		if (descricao.equalsIgnoreCase("@")) {
			descricao = "";
		}
		Optional<List<Estoque>> lista = estoqueRepository.findProdutoDescricao(descricao, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/produto/cb/{cb}/{idempresa}")
	public ResponseEntity<Optional<List<Estoque>>> listarProdutoCodigoBarras(@PathVariable("cb") String cb, @PathVariable int idempresa) {
		Optional<List<Estoque>> lista = estoqueRepository.findProdutoCodigoBarras(cb, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

}
