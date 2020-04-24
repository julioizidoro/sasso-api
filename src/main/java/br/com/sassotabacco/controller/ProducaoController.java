package br.com.sassotabacco.controller;

import java.util.ArrayList;
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

import br.com.sassotabacco.model.Estoque;
import br.com.sassotabacco.model.Producao;
import br.com.sassotabacco.model.Producaoproduto;
import br.com.sassotabacco.repository.EstoqueRepository;
import br.com.sassotabacco.repository.ProducaoProdutoRepository;
import br.com.sassotabacco.repository.ProducaoRepository;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("producoes")
public class ProducaoController {
	
	@Autowired
	private ProducaoRepository producaoRepository;
	
	@Autowired
	private ProducaoProdutoRepository producaoProdutoRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@PostMapping("/salvar/producao")
	@ResponseStatus(HttpStatus.CREATED)
	public Producao salvarReceita(@Valid @RequestBody Producao producao) {
		return producaoRepository.save(producao);
	}
	
	@PostMapping("/salvar/produto")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Producaoproduto> salvarProduto(@Valid @RequestBody List<Producaoproduto> listaProducaoProduto)  {
		List<Producaoproduto> listaSalva = new ArrayList<Producaoproduto>();
		for (Producaoproduto pp : listaProducaoProduto) {
			pp = producaoProdutoRepository.save(pp);
		    Estoque estoque = pp.getEstoque();
		    estoque.setQuantidadeestoque(estoque.getQuantidadeestoque() - pp.getQuantidade());;
		    estoqueRepository.save(estoque);
		    pp.setEstoque(estoque);
			listaSalva.add(pp);
		}
		return listaSalva;
	}
	
	@GetMapping("/producao/{id}")
	public ResponseEntity<Producao> buscarProducao(@PathVariable Integer id) {
		Optional<Producao> producao = producaoRepository.findById(id);
		
		if (producao==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(producao.get());
	}
	
	@GetMapping("/producao/listar/{descricao}/{idempresa}")
	public ResponseEntity<List<Producao>> listarProducao(@PathVariable String descricao, @PathVariable int idempresa) {
		Conversor c = new Conversor();
		Date data = c.SomarDiasData(new Date(), -90);
		if (descricao.equalsIgnoreCase("@")) {
			descricao = " ";
		}
		List<Producao> lista = producaoRepository.findByDescricao(descricao, data, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/produto/listar/{id}")
	public ResponseEntity<List<Producaoproduto>> listarProducaoProduto(@PathVariable int id) {
		List<Producaoproduto> lista = producaoRepository.findByProducaoProduto(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	

}
