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
		System.out.println("Salvou");
		return receitaRepository.save(receita);
	}
	
	@PostMapping("/salvar/produto")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarProduto(@Valid @RequestBody List<Receitaproduto> listaReceitaProduto)  {
		for (int i=0;i<listaReceitaProduto.size();i++) {
			receitaProdutoRepository.save(listaReceitaProduto.get(i));
		}
	}
	
	@GetMapping("/receita/{id}")
	public ResponseEntity<Receita> buscarReceita(@PathVariable Integer id) {
		Optional<Receita> receita = receitaRepository.findById(id);
		
		if (receita==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(receita.get());
	}
	
	@GetMapping("/produto/delete/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> removerProduto(@PathVariable int id) {
		Receitaproduto receitaProduto = receitaProdutoRepository.findById(id).get();
		receitaProdutoRepository.delete(receitaProduto);
		return ResponseEntity.ok("OK");
	}
	
	@GetMapping("/receita/listar/{descricao}")
	public ResponseEntity<List<Receita>> listarReceita(@PathVariable String descricao) {
		if (descricao.equalsIgnoreCase("@")) {
			descricao = " ";
		}
		List<Receita> lista = receitaRepository.findByDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/produto/listar/{id}")
	public ResponseEntity<List<Receitaproduto>> listarReceitaProduto(@PathVariable int id) {
		List<Receitaproduto> lista = receitaRepository.findByReceitaProduto(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	

}
