package br.com.sassotabacco.controller;

import java.util.Date;
import java.util.List;

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

import br.com.sassotabacco.model.Conta;
import br.com.sassotabacco.repository.ContaRepository;
import br.com.sassotabacco.repository.FluxoCaixaRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/contas")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private FluxoCaixaRepository fluxoCaixaRepository;
	
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Conta salvar(@Valid @RequestBody Conta conta) {
		return contaRepository.save(conta);
	}
	
	@GetMapping("/listar/{descricao}")
	public ResponseEntity<List<Conta>> listarNome(@PathVariable("descricao") String descricao) {
		if (descricao.equalsIgnoreCase("@")) {
			descricao = "";
		}
		List<Conta> lista = contaRepository.findByDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		for (int i=0;i<lista.size();i++) {
			float saldo = 0;//fluxoCaixaRepository.calculaSaldo(new Date(), lista.get(i).getIdconta());
			lista.get(i).setSaldoatual(saldo);
		}
		
		return ResponseEntity.ok(lista);
	}

}
