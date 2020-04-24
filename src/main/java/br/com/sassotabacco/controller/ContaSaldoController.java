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

import br.com.sassotabacco.model.Contasaldo;
import br.com.sassotabacco.repository.ContaSaldoRepository;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("/contasaldos")
public class ContaSaldoController {
	
	@Autowired
	private ContaSaldoRepository contaSaldoRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Contasaldo salvar(@Valid @RequestBody Contasaldo contaSaldo) {
		return contaSaldoRepository.save(contaSaldo);
	}
	
	@GetMapping("/listar/{mesano}/{idempresa}")
	public ResponseEntity<List<Contasaldo>> listarMesAno(@PathVariable("mesano") String mesano, @PathVariable("idempresa") int idempresa) {
		if (mesano.equalsIgnoreCase("@")) {
			Conversor c = new Conversor();
			String data = c.ConvercaoDataPadrao(new Date());
			mesano = data.substring(3,5) + "/" + data.substring(6,10);
		}
		List<Contasaldo> lista = contaSaldoRepository.findByMesAno(mesano, idempresa);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/conta/{idconta}/{mesano}/{idempresa}")
	public ResponseEntity<Contasaldo> getMesAno(@PathVariable("idconta") int idconta, @PathVariable("mesano") String mesano, @PathVariable("idempresa") int idempresa) {
		if (mesano.equalsIgnoreCase("@")) {
			Conversor c = new Conversor();
			String data = c.ConvercaoData(new Date());
			mesano = data.substring(0, 2) + "/" + data.substring(7,10);
		}
		Contasaldo contaSaldo = contaSaldoRepository.findByConta(idconta, mesano, idempresa);
		if (contaSaldo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contaSaldo);
	}
	
	@GetMapping("/{idconta}")
	public ResponseEntity<Optional<Contasaldo>> getId(@PathVariable("idconta") int idconta) {
		Optional<Contasaldo> contaSaldo = contaSaldoRepository.findById(idconta);
		if (contaSaldo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contaSaldo);
	}
	
	@GetMapping("/ativos/{idempresa}")
	public ResponseEntity<List<Contasaldo>> getAtivos(@PathVariable("idempresa") int idempresa) {
		List<Contasaldo> listaContaSaldo = contaSaldoRepository.findByAtivos(idempresa);
		if (listaContaSaldo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaContaSaldo);
	}
	
	@PostMapping("/gerarsaldo/{idempresa}")
	@ResponseStatus(HttpStatus.CREATED)
	public String iniciarMes(@Valid @RequestBody Contasaldo contaSaldo, @PathVariable("idempresa") int idempresa) {
		List<Contasaldo> listaAbertos = contaSaldoRepository.findByAtivos(idempresa);
		try {
			if (listaAbertos != null) {
				
				for (Contasaldo aberto : listaAbertos) {
					Contasaldo nova = new Contasaldo();
					nova.setConta(aberto.getConta());
					nova.setEntradas(0.0f);
					nova.setMesano(contaSaldo.getMesano());
					nova.setSaidas(0.0f);
					nova.setSaldoinicial(aberto.getSaldo());
					nova.setSaldo(aberto.getSaldo());
					nova.setAberto(true);
					contaSaldoRepository.save(nova);
					aberto.setAberto(false);
					contaSaldoRepository.save(aberto);
				}
				return "Saldo gerado com sucesso.";
			}
		} catch (Exception e) {
			return "Erro ao gerar saldos " + e.getMessage();
		}
		return "Sem contas para gerar saldo.";
	}
}
