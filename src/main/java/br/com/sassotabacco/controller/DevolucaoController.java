package br.com.sassotabacco.controller;

import java.util.Date;
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

import br.com.sassotabacco.model.Devolucao;
import br.com.sassotabacco.model.Devolucaoproduto;
import br.com.sassotabacco.repository.DevolucaoProdutoRepository;
import br.com.sassotabacco.repository.DevolucaoRepository;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("devolucoes")
public class DevolucaoController {
	
	@Autowired
	private DevolucaoRepository devolucaoRepository;
	@Autowired
	private DevolucaoProdutoRepository devolucaoProdutoRepository;
	
	@PostMapping("/salvar/devolucao")
	@ResponseStatus(HttpStatus.CREATED)
	public Devolucao salvar(@Valid @RequestBody Devolucao devolucao) {
		return devolucaoRepository.save(devolucao);
	}
	
	@PostMapping("/salvar/produto")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@Valid @RequestBody List<Devolucaoproduto> lista) {
		for(int i=0;i<lista.size();i++) {
			devolucaoProdutoRepository.save(lista.get(i));
		}
	}
	
	@GetMapping("/devolucao/{id}")
	public ResponseEntity<Devolucao> buscarDevolucao(@PathVariable Integer id) {
		Optional<Devolucao> devolucao = devolucaoRepository.findById(id);
		
		if (devolucao==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(devolucao.get());
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Devolucaoproduto> buscarProduto(@PathVariable Integer id) {
		Optional<Devolucaoproduto> devolucaoProduto = devolucaoProdutoRepository.findById(id);
		
		if (devolucaoProduto==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(devolucaoProduto.get());
	}
	
	@GetMapping("listar/devolucao/{idempresa}")
	public ResponseEntity<List<Devolucao>> listarDevolucao(@PathVariable int idempresa) {
		Conversor c =new Conversor();
		Date data = c.SomarDiasData(new Date(), -90);
		List<Devolucao> lista = devolucaoRepository.findByData(data, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/produto/{id}")
	public ResponseEntity<List<Devolucaoproduto>> listarProduto(@PathVariable Integer id) {
		List<Devolucaoproduto> lista = devolucaoProdutoRepository.findByDevolucao(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
}

