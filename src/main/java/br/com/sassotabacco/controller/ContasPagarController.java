package br.com.sassotabacco.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.sassotabacco.model.Conta;
import br.com.sassotabacco.model.Contas;
import br.com.sassotabacco.model.Contasaldo;
import br.com.sassotabacco.model.Fluxocaixa;
import br.com.sassotabacco.model.Fluxocontas;
import br.com.sassotabacco.repository.ContaRepository;
import br.com.sassotabacco.repository.ContaSaldoRepository;
import br.com.sassotabacco.repository.ContasRepository;
import br.com.sassotabacco.repository.FluxoCaixaRepository;
import br.com.sassotabacco.repository.FluxoContasRepository;
import br.com.sassotabacco.service.S3Service;
import br.com.sassotabacco.util.Conversor;



@CrossOrigin
@RestController	
@RequestMapping("/cp")
public class ContasPagarController {
	
	@Autowired
	private ContasRepository contasRepository;
	@Autowired
	private FluxoCaixaRepository fluxoCaixaRepository;
	@Autowired
	private FluxoContasRepository fluxoContasRepository;
	@Autowired
	private S3Service s3Service;
	@Autowired
	private ContaSaldoRepository contaSaldoRepository;
	@Autowired
	private ContaRepository contaRepository;
	
	//Consulta por ID
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Contas>> getId(@PathVariable("id") int id) {
	Optional<Contas> conta = contasRepository.findById(id);
		if (conta==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(conta);
	}
	
	//Consulta Inicial
	@GetMapping("/{idempresa}")
	@Cacheable("consultaContasPagar")
	public ResponseEntity<Optional<List<Contas>>> listarCP(@PathVariable int idempresa) {
		Conversor c = new Conversor();
		Date data = c.SomarDiasData(new Date(), 90);
		Optional<List<Contas>> lista = contasRepository.findAllContas(data, "p", idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Documento
	@GetMapping("/doc/{idempresa}")
	@Cacheable("consultaContasPagar")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasDocument(@PathVariable("documento") String documento, @PathVariable int idempresa) {
		Optional<List<Contas>> lista = contasRepository.findAllContasDocumento(documento, "p", idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Nome todas
	@GetMapping("nometodas/{nome}/{idempresa}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasNomeTodas(@PathVariable("nome") String nome, @PathVariable int idempresa) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasNomeTodas(nome, "p", idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Nome Pagar
	@GetMapping("nomepagar/{nome}/{idempresa}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasNomePagar(@PathVariable("nome") String nome, @PathVariable int idempresa) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasNomePagar(nome, "p", idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
		
	//Consulta Nome Pagas
	@GetMapping("nomepagas/{nome}/{idempresa}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasNomePagas(@PathVariable("nome") String nome, @PathVariable int idempresa) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasNomePagas(nome, "p", idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Data Vencimento todas
	@GetMapping("dvtodas/{datainicial}/{datafinal}/{nome}/{idempresa}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasDataVencimentoTodas(@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal, @PathVariable("nome") String nome, @PathVariable int idempresa) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasDataVencimentoTodas(nome, datainicial, datafinal, "p", idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Data Vencimento pagar
	@GetMapping("dvpagar/{datainicial}/{datafinal}/{nome}/{idempresa}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasDataVencimentoPagar(@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal, @PathVariable("nome") String nome, @PathVariable int idempresa) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasDataVencimentoPagar(nome, datainicial, datafinal, "p", idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Data Vencimento pagas
	@GetMapping("dvpagas/{datainicial}/{datafinal}/{nome}/{idempresa}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasDataVencimentoPagas(@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal, @PathVariable("nome") String nome, @PathVariable int idempresa ) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasDataVencimentoPagas(nome, datainicial, datafinal, "p", idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	
	
	@PostMapping("/salvar")
	@CachePut("consultaContasReceber")
	@ResponseStatus(HttpStatus.CREATED)
	public Contas salvar(@Valid @RequestBody Contas conta) {
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
	
	
	@PostMapping("/baixar")
	@CachePut("consultaContasReceber")
	@ResponseStatus(HttpStatus.CREATED)
	public Contas baixar(@Valid @RequestBody Contas conta) {
		conta = contasRepository.save(conta);
		Fluxocaixa fluxoCaixa = fluxoCaixaRepository.findFluxoCaixa(conta.getDatapagamento(), 7);
		boolean novoFluxo = false;
		if (fluxoCaixa == null) {
			fluxoCaixa = new Fluxocaixa();
			fluxoCaixa.setData(conta.getDatavencimento());
			fluxoCaixa.setEntradas(0.0f);
			fluxoCaixa.setEntradasprevistas(0.0f);
			fluxoCaixa.setSaidas(0.0f);
			fluxoCaixa.setSaidasprevistas(0.0f);
			fluxoCaixa.setConta(conta.getConta());
			novoFluxo = true;
		}
		fluxoCaixa.setSaidas(fluxoCaixa.getSaidas() + conta.getValorpago());
		fluxoCaixa = fluxoCaixaRepository.save(fluxoCaixa);
		if (novoFluxo) {
			Fluxocontas fluxoContas = new Fluxocontas();
			fluxoContas.setContas(conta);
			fluxoContas.setFluxocaixa(fluxoCaixa);
			fluxoContasRepository.save(fluxoContas);
		}
		Contasaldo contaSaldo = contaSaldoRepository.findByConta(conta.getConta().getIdconta(),"@", conta.getEmpresa().getIdempresa());
		contaSaldo.setSaldoinicial(contaSaldo.getSaldoliquido() - conta.getValorpago());
		contaSaldo.setEntradas(contaSaldo.getSaidas() + conta.getValorpago());
		contaSaldo.setSaldo(contaSaldo.getSaldo() - conta.getValorpago());
		contaSaldoRepository.save(contaSaldo);
		return contasRepository.save(conta);
	}
	
	@PostMapping("/upload")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> uploadFile(@RequestParam(name="file") MultipartFile file) {
		URI uri = s3Service.uploadFileCP(file);
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/hoje/{idempresa}")
	public ResponseEntity<Float>  vencidasHoje(@PathVariable int idempresa) {
		Float valor = contasRepository.valorContasVencimentoHoje(new Date(),"p", idempresa);
		if (valor == null) {
			valor = 0.0f;
		}
		return ResponseEntity.ok(valor);
	}
	
	@GetMapping("/vencidas/{idempresa}")
	public ResponseEntity<Float>  vencidas(@PathVariable int idempresa) {
		Float valor = contasRepository.valorContasVencidas(new Date(),"p", idempresa);
		if (valor == null) {
			valor = 0.0f;
		}
		return ResponseEntity.ok(valor);
	}
	
	@GetMapping("/restomes/{idempresa}")
	public ResponseEntity<Float>  vencerRestoMes(@PathVariable int idempresa) {
		Conversor c = new Conversor();
		String data = c.ConvercaoDataPadrao(new Date());
		String mesano = data.substring(6,10) + "-" + data.substring(3,5);
		String mes = data.substring(3,5);
		
		String cData =  mesano + "-" + String.valueOf(c.getRestoMes(Integer.parseInt(mes)));
		Date dataFinal = c.ConvercaoStringData(cData);
		Float valor = contasRepository.contasRestoMes(new Date(), dataFinal,"r", idempresa);
		if (valor == null) {
			valor = 0.0f;
		}
		return ResponseEntity.ok(valor);
	}


}
