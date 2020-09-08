package br.com.sassotabacco.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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

import br.com.sassotabacco.model.Compras;
import br.com.sassotabacco.model.Comprasconta;
import br.com.sassotabacco.model.Comprasproduto;
import br.com.sassotabacco.model.Conta;
import br.com.sassotabacco.model.Contas;
import br.com.sassotabacco.model.Estoque;
import br.com.sassotabacco.model.Fluxocaixa;
import br.com.sassotabacco.model.Fluxocontas;
import br.com.sassotabacco.repository.ComprasContaRepository;
import br.com.sassotabacco.repository.ComprasProdutoRepository;
import br.com.sassotabacco.repository.ComprasRepository;
import br.com.sassotabacco.repository.ContaRepository;
import br.com.sassotabacco.repository.ContaSaldoRepository;
import br.com.sassotabacco.repository.ContasRepository;
import br.com.sassotabacco.repository.EstoqueRepository;
import br.com.sassotabacco.repository.FluxoCaixaRepository;
import br.com.sassotabacco.repository.FluxoContasRepository;
import br.com.sassotabacco.service.S3Service;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("compras")
public class ComprasController {
	
	@Autowired
	private ContasRepository contasRepository;
	@Autowired
	private FluxoCaixaRepository fluxoCaixaRepository;
	@Autowired
	private FluxoContasRepository fluxoContasRepository;
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ComprasRepository comprasRepository;
	
	@Autowired
	private ComprasContaRepository comprasContaRepository; 
	
	@Autowired
	private ComprasProdutoRepository comprasProdutoRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Compras salvar(@Valid @RequestBody Compras compra) {
		return comprasRepository.save(compra);
	}
	
	@PostMapping("/salvar/conta")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarConta(@Valid @RequestBody List<Comprasconta> lista) {
		for(int i=0;i<lista.size();i++) {
			salvarParcelaConta(lista.get(i).getContas());
			comprasContaRepository.save(lista.get(i));		}
	}
	
	@PostMapping("/salvar/produto")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarProduto(@Valid @RequestBody List<Comprasproduto> lista) {
		for(int i=0;i<lista.size();i++) {
			comprasProdutoRepository.save(lista.get(i));
			Optional<Estoque> e = estoqueRepository.findById(lista.get(i).getEstoque().getIdestoque());
			Estoque estoque = e.get();
			estoque.setQuantidadeestoque(estoque.getQuantidadeestoque() + lista.get(i).getQuantidade());
			estoque.setCustomedio(lista.get(i).getCusto());
			estoqueRepository.save(estoque);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Compras> buscar(@PathVariable Integer id) {
		Optional<Compras> compras = comprasRepository.findById(id);
		
		if (compras==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(compras.get());
	}
	
	
	@GetMapping("listar/{nome}/{idempresa}")
	public ResponseEntity<List<Compras>> listar(@PathVariable("nome") String nome, @PathVariable Integer idempresa) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		Conversor c = new Conversor();
		Date data90 = c.SomarDiasData(new Date(), -90);
		List<Compras> lista = comprasRepository.findAll(nome, data90, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/doc/{documento}/{idempresa}")
	public ResponseEntity<List<Compras>> listarDocumento(@PathVariable("documento") String documento, @PathVariable Integer idempresa) {
		List<Compras> lista = comprasRepository.findDocumento(documento, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/nome/{nome}/{idempresa}")
	public ResponseEntity<List<Compras>> listarNome(@PathVariable("nome") String nome, @PathVariable Integer idempresa) {
		List<Compras> lista = comprasRepository.findNome(nome, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/produto/{id}")
	public ResponseEntity<List<Comprasproduto>> listarProduto(@PathVariable("id") int id) {
			List<Comprasproduto> lista = comprasProdutoRepository.findByComprasConta(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/conta/{id}")
	public ResponseEntity<List<Comprasconta>> listarConta(@PathVariable("id") int id) {
			List<Comprasconta> lista = comprasContaRepository.findByComprasConta(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	public Contas salvarParcelaConta(Contas conta) {
		if (conta.getConta()== null) {
			Conta contaBanco = contaRepository.findById(7);
			conta.setConta(contaBanco);
		}
		conta = contasRepository.save(conta);
		Fluxocaixa fluxoCaixa = fluxoCaixaRepository.findFluxoCaixa(conta.getDatavencimento(), conta.getConta().getIdconta());
		if (fluxoCaixa == null) {
			fluxoCaixa = new Fluxocaixa();
			fluxoCaixa.setData(conta.getDatavencimento());
			fluxoCaixa.setEntradas(0.0f);
			fluxoCaixa.setEntradasprevistas(0.0f);
			fluxoCaixa.setSaidas(0.0f);
			fluxoCaixa.setSaidasprevistas(0.0f);
			fluxoCaixa.setConta(conta.getConta());
		}
		fluxoCaixa.setSaidasprevistas(fluxoCaixa.getSaidasprevistas() + conta.getValorparcela());
		fluxoCaixa = fluxoCaixaRepository.save(fluxoCaixa);
		Fluxocontas fluxoContas = new Fluxocontas();
		fluxoContas.setContas(conta);
		fluxoContas.setFluxocaixa(fluxoCaixa);
		fluxoContasRepository.save(fluxoContas);
		return contasRepository.save(conta);
	}

}
