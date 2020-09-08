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
import br.com.sassotabacco.model.Contas;
import br.com.sassotabacco.model.Estoque;
import br.com.sassotabacco.model.Venda;
import br.com.sassotabacco.model.Vendaproduto;
import br.com.sassotabacco.repository.EstoqueRepository;
import br.com.sassotabacco.repository.VendaProdutoRepository;
import br.com.sassotabacco.repository.VendaRepository;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("vendas")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private VendaProdutoRepository vendaProdutoRepository;
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	
	@PostMapping("/salvar/venda")
	@ResponseStatus(HttpStatus.CREATED)
	public Venda salvar(@Valid @RequestBody Venda venda) {
		venda.setDatatipo(new Date());
		Conversor c = new Conversor();
		venda.setHora(c.foramtarHoraString());
		return vendaRepository.save(venda);
	}
	
	@PostMapping("/salvar/produto")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@Valid @RequestBody List<Vendaproduto> lista) {
		for(int i=0;i<lista.size();i++) {
			Optional<Estoque> e = estoqueRepository.findById(lista.get(i).getEstoque().getIdestoque());
			Estoque estoque = e.get();
			estoque.setQuantidadeestoque(estoque.getQuantidadeestoque() - lista.get(i).getQuantidade());
			
			estoqueRepository.save(estoque);
			Vendaproduto vendaProduto = lista.get(i);
			vendaProduto.setCustototal(vendaProduto.getQuantidade() * estoque.getCustomedio());
			vendaProduto.setLucrobruto(vendaProduto.getSubtotal() - vendaProduto.getCustototal());
			vendaProdutoRepository.save(vendaProduto);
		}
	}
	
	@GetMapping("/venda/{id}")
	public ResponseEntity<Venda> buscarVenda(@PathVariable Integer id) {
		Optional<Venda> venda = vendaRepository.findById(id);
		
		if (venda==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(venda.get());
	}
	
	// Consulta Vendas Data
	@GetMapping("venda/{datainicial}/{datafinal}/{idempresa}")
	public ResponseEntity<List<Venda>> findByData(
			@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal,
			@PathVariable int idempresa) {
		List<Venda> lista = vendaRepository.findByVendas(datainicial, datafinal, idempresa);
		if (lista == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	// Consulta Vendas Data
		@GetMapping("venda/listar/{idempresa}")
		public ResponseEntity<List<Venda>> findByVenda(@PathVariable int idempresa) {
			Conversor c = new Conversor();
			Date datainicial = c.SomarDiasData(new Date(), -7);
			Date datafinal = new Date();
			List<Venda> lista = vendaRepository.findByVendas(datainicial, datafinal, idempresa);
			if (lista == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(lista);
		}
		
	// Consulta Vendas Data
	@GetMapping("venda/produto/listar/{idvenda}")
	public ResponseEntity<List<Vendaproduto>> findByVendaProduto(@PathVariable int idvenda) {
		List<Vendaproduto> lista = vendaProdutoRepository.findByVenda(idvenda);
		if (lista == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

}
