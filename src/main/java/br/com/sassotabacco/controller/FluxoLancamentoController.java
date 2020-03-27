package br.com.sassotabacco.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sassotabacco.model.Fluxocaixa;
import br.com.sassotabacco.model.Fluxolancamento;
import br.com.sassotabacco.repository.FluxoCaixaRepository;
import br.com.sassotabacco.repository.FluxoLancamentoRepository;

@CrossOrigin
@RestController	
@RequestMapping("/api/fl")
public class FluxoLancamentoController {
	
	@Autowired
	private FluxoLancamentoRepository fluxoLancamentoRepository;
	@Autowired FluxoCaixaRepository fluxoCaixaRepository;
	
	// Consulta por ID
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<List<Fluxolancamento>>> getId(@PathVariable("id") int id) {
		Optional<List<Fluxolancamento>> fluxo = fluxoLancamentoRepository.findById(id);
		if (fluxo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(fluxo);
	}

	// Consulta Inicial
	@GetMapping("/fc/{id}")
	@Cacheable("consultafluxoLancamento")
	public ResponseEntity<Optional<List<Fluxolancamento>>> listarCR(@PathVariable("idfluxo") int idfluxocaixa) {
		Optional<List<Fluxolancamento>> listafluxo = fluxoLancamentoRepository.findAllLancamentos(idfluxocaixa);
		if (listafluxo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listafluxo);
	}
	
	@PostMapping("/salvar")
	@CachePut("consultafluxoLancamento")
	@ResponseStatus(HttpStatus.CREATED)
	public Fluxolancamento salvar(@Valid @RequestBody Fluxolancamento fluxoLancamento) {
		fluxoLancamento = fluxoLancamentoRepository.save(fluxoLancamento);
		Fluxocaixa fluxoCaixa = fluxoCaixaRepository.getId(fluxoLancamento.getFluxocaixa().getIdfluxocaixa());
		fluxoCaixa.setEntradas(fluxoCaixa.getEntradas() + fluxoLancamento.getValorentrada());
		fluxoCaixa.setSaidas(fluxoCaixa.getSaidas() + fluxoLancamento.getValorsaida());
		fluxoCaixa = fluxoCaixaRepository.save(fluxoCaixa);
		return fluxoLancamento;
	}

}
