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

import br.com.sassotabacco.model.Acerto;
import br.com.sassotabacco.model.Acertoproduto;
import br.com.sassotabacco.model.Estoque;
import br.com.sassotabacco.repository.AcertoProdutoRepository;
import br.com.sassotabacco.repository.AcertoRepository;
import br.com.sassotabacco.repository.EstoqueRepository;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("acertos")
public class AcertoController {
	
	@Autowired
	private AcertoRepository acertoRepository;
	@Autowired
	private AcertoProdutoRepository acertoProdutoRepository;
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@PostMapping("/salvar/acerto")
	@ResponseStatus(HttpStatus.CREATED)
	public Acerto salvar(@Valid @RequestBody Acerto acerto) {
		return acertoRepository.save(acerto);
	}
	
	@PostMapping("/salvar/produto")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@Valid @RequestBody List<Acertoproduto> lista) {
		for(int i=0;i<lista.size();i++) {
			Estoque estoque = lista.get(i).getEstoque();
			estoque.setQuantidadeestoque(estoque.getQuantidadeestoque() - lista.get(i).getQuantidade());
			estoqueRepository.save(estoque);
			acertoProdutoRepository.save(lista.get(i));
		}
	}
	
	@GetMapping("/acerto/{id}")
	public ResponseEntity<Acerto> buscarAcerto(@PathVariable Integer id) {
		Optional<Acerto> acerto = acertoRepository.findById(id);
		
		if (acerto==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(acerto.get());
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Acertoproduto> buscarProduto(@PathVariable Integer id) {
		Optional<Acertoproduto> acertoProduto = acertoProdutoRepository.findById(id);
		
		if (acertoProduto==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(acertoProduto.get());
	}
	
	@GetMapping("listar/acerto/{idempresa}")
	public ResponseEntity<List<Acerto>> listarAcerto(@PathVariable Integer idempresa) {
		Conversor c =new Conversor();
		Date data = c.SomarDiasData(new Date(), -90);
		List<Acerto> lista = acertoRepository.findByData(data, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/produto/{id}")
	public ResponseEntity<List<Acertoproduto>> listarProduto(@PathVariable Integer id) {
		List<Acertoproduto> lista = acertoProdutoRepository.findByAcerto(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	

}
