package br.com.sassotabacco.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sassotabacco.model.Conta;
import br.com.sassotabacco.repository.BancoRepository;
import br.com.sassotabacco.repository.FluxoCaixaRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/bancos")
public class ContaController {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private FluxoCaixaRepository fluxoCaixaRepository;
	
	
	@GetMapping("{descricao}")
	public ResponseEntity<List<Conta>> listarNome(@PathVariable("descricao") String descricao) {
		if (descricao.equalsIgnoreCase("@")) {
			descricao = "";
		}
		List<Conta> lista = bancoRepository.findBanoAll(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		for (int i=0;i<lista.size();i++) {
			float saldo = fluxoCaixaRepository.calculaSaldo(new Date(), lista.get(i).getIdconta());
			lista.get(i).setSaldoatual(saldo);
		}
		
		return ResponseEntity.ok(lista);
	}

}
