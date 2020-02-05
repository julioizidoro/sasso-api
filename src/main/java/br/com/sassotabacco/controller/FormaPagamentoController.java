package br.com.sassotabacco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sassotabacco.model.Formapagamento;
import br.com.sassotabacco.repository.FormaPagamentoRepository;

@CrossOrigin
@RestController	
@RequestMapping("/api/formapagamento")
public class FormaPagamentoController {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@GetMapping
	@Cacheable("consultaFormaPagamento")
	public ResponseEntity<Optional<List<Formapagamento>>> listar() {
		Optional<List<Formapagamento>> lista = formaPagamentoRepository.findAllForma();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
}
