package br.com.sassotabacco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sassotabacco.model.Receita;
import br.com.sassotabacco.model.Receitaproduto;
import br.com.sassotabacco.repository.ReceitaProdutoRepository;
import br.com.sassotabacco.repository.ReceitaRepository;

@CrossOrigin
@RestController
@RequestMapping("receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ReceitaProdutoRepository receitaProdutoRepository;
	
	@PostMapping("/salvar/receita")
	@ResponseStatus(HttpStatus.CREATED)
	public Receita salvarReceita(@Valid @RequestBody Receita receita) {
		return receitaRepository.save(receita);
	}
	
	@PostMapping("/salvar/produto")
	@ResponseStatus(HttpStatus.CREATED)
	public Receitaproduto salvarProduto(@Valid @RequestBody Receitaproduto receitaProduto)  {
		return receitaProdutoRepository.save(receitaProduto);
	}
	
	@GetMapping("/receita/{id}")
	public ResponseEntity<Receita> buscarReceita(@PathVariable Integer id) {
		Optional<Receita> receita = receitaRepository.findById(id);
		
		if (receita==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(receita.get());
	}
	
	@DeleteMapping("/produto/delete/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> removerProduto(@Valid @RequestBody Receitaproduto receitaProduto) {
		receitaProdutoRepository.delete(receitaProduto);
		return ResponseEntity.ok("OK");
	}
	
	@GetMapping("/receita/listar")
	public ResponseEntity<List<Receita>> listarReceita() {
		List<Receita> lista = receitaRepository.findAll();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	

}
