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

import br.com.sassotabacco.model.Contas;
import br.com.sassotabacco.model.Contasaldo;
import br.com.sassotabacco.model.Fluxocaixa;
import br.com.sassotabacco.model.Fluxocontas;
import br.com.sassotabacco.repository.ContaSaldoRepository;
import br.com.sassotabacco.repository.ContasRepository;
import br.com.sassotabacco.repository.FluxoCaixaRepository;
import br.com.sassotabacco.repository.FluxoContasRepository;
import br.com.sassotabacco.service.S3Service;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController	
@RequestMapping("/cr")
public class ContasReceberController {
	
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
	
	//Consulta por ID
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Contas>> getId(@PathVariable("id") int id) {
	Optional<Contas> conta = contasRepository.findById(id);
		if (conta==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(conta);
	}
	
	//Consulta Inicial
	@GetMapping
	@Cacheable("consultaContasReceber")
	public ResponseEntity<Optional<List<Contas>>> listarCR() {
		Conversor c = new Conversor();
		Date data = c.SomarDiasData(new Date(), 90);
		Optional<List<Contas>> lista = contasRepository.findAllContas(data, "r");
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Documento
	@GetMapping("/doc/{documento}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasDocument(@PathVariable("documento") String documento) {
		Optional<List<Contas>> lista = contasRepository.findAllContasDocumento(documento, "r");
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Nome todas
	@GetMapping("nometodas/{nome}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasNomeTodas(@PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasNomeTodas(nome, "r");
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Nome Pagar
	@GetMapping("nomepagar/{nome}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasNomePagar(@PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasNomePagar(nome, "r");
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
		
	//Consulta Nome Pagas
	@GetMapping("nomepagas/{nome}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasNomePagas(@PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasNomePagas(nome, "r");
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Data Vencimento todas
	@GetMapping("dvtodas/{datainicial}/{datafinal}/{nome}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasDataVencimentoTodas(@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal, @PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasDataVencimentoTodas(nome, datainicial, datafinal, "r");
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Data Vencimento pagar
	@GetMapping("dvreeceber/{datainicial}/{datafinal}/{nome}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasDataVencimentoPagar(@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal, @PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasDataVencimentoPagar(nome, datainicial, datafinal, "r");
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	//Consulta Data Vencimento pagas
	@GetMapping("dvrecebidas/{datainicial}/{datafinal}/{nome}")
	public ResponseEntity<Optional<List<Contas>>>  findAllContasDataVencimentoPagas(@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal, @PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		Optional<List<Contas>> lista = contasRepository.findAllContasDataVencimentoPagas(nome, datainicial, datafinal, "r");
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/salvar")
	@CachePut("consultaContasReceber")
	@ResponseStatus(HttpStatus.CREATED)
	public Contas salvar(@Valid @RequestBody Contas conta) {
		conta = contasRepository.save(conta);
		Fluxocaixa fluxoCaixa = fluxoCaixaRepository.findFluxoCaixa(conta.getDatavencimento());
		if (fluxoCaixa == null) {
			fluxoCaixa = new Fluxocaixa();
			fluxoCaixa.setData(conta.getDatavencimento());
			fluxoCaixa.setEntradas(0.0f);
			fluxoCaixa.setEntradasprevistas(0.0f);
			fluxoCaixa.setSaidas(0.0f);
			fluxoCaixa.setSaidasprevistas(0.0f);
		}
		fluxoCaixa.setEntradasprevistas(fluxoCaixa.getEntradasprevistas() + conta.getValorparcela());
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
		Fluxocaixa fluxoCaixa = fluxoCaixaRepository.findFluxoCaixa(conta.getDatapagamento());
		boolean novoFluxo = false;
		if (fluxoCaixa == null) {
			fluxoCaixa = new Fluxocaixa();
			fluxoCaixa.setData(conta.getDatavencimento());
			fluxoCaixa.setEntradas(0.0f);
			fluxoCaixa.setEntradasprevistas(0.0f);
			fluxoCaixa.setSaidas(0.0f);
			fluxoCaixa.setSaidasprevistas(0.0f);
			novoFluxo = true;
		}
		fluxoCaixa.setEntradas(fluxoCaixa.getEntradas() + conta.getValorpago());
		fluxoCaixa = fluxoCaixaRepository.save(fluxoCaixa);
		if (novoFluxo) {
			Fluxocontas fluxoContas = new Fluxocontas();
			fluxoContas.setContas(conta);
			fluxoContas.setFluxocaixa(fluxoCaixa);
			fluxoContasRepository.save(fluxoContas);
		}
		Contasaldo contaSaldo = contaSaldoRepository.findByConta(conta.getConta().getIdconta(),"@");
		contaSaldo.setSaldoinicial(contaSaldo.getSaldoliquido() + conta.getValorpago());
		contaSaldo.setEntradas(contaSaldo.getEntradas() + conta.getValorpago());
		contaSaldo.setSaldo(contaSaldo.getSaldo() + conta.getValorpago());
		contaSaldoRepository.save(contaSaldo);
		return contasRepository.save(conta);
	}
	
	@PostMapping("/upload")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> uploadFile(@RequestParam(name="file") MultipartFile file) {
		URI uri = s3Service.uploadFileCR(file);
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/hoje")
	public ResponseEntity<Float>  vencidasHoje() {
		Float valor = contasRepository.valorContasVencimentoHoje(new Date(),"r");
		if (valor == null) {
			valor = 0.0f;
		}
		return ResponseEntity.ok(valor);
	}
	
	@GetMapping("/vencidas")
	public ResponseEntity<Float>  vencidas() {
		Float valor = contasRepository.valorContasVencidas(new Date(),"r");
		if (valor == null) {
			valor = 0.0f;
		}
		return ResponseEntity.ok(valor);
	}
	
	@GetMapping("/restomes")
	public ResponseEntity<Float>  vencerRestoMes() {
		Conversor c = new Conversor();
		String data = c.ConvercaoDataPadrao(new Date());
		String mesano = data.substring(6,10) + "-" + data.substring(3,5);
		String mes = data.substring(3,5);
		
		String cData =  mesano + "-" + String.valueOf(c.getRestoMes(Integer.parseInt(mes)));
		Date dataFinal = c.ConvercaoStringData(cData);
		Float valor = contasRepository.contasRestoMes(new Date(), dataFinal,"r");
		if (valor == null) {
			valor = 0.0f;
		}
		return ResponseEntity.ok(valor);
	}

}
