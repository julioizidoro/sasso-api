package br.com.sassotabacco.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sassotabacco.bean.FluxoCaixaBean;
import br.com.sassotabacco.model.Fluxocaixa;
import br.com.sassotabacco.repository.FluxoCaixaRepository;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController	
@RequestMapping("/fluxocaixa")
public class FluxoCaixaController {
	
	@Autowired
	private FluxoCaixaRepository fluxoCaixaRepository;
	
	@GetMapping
	@Cacheable("consultaFluxoCaixa")
	public ResponseEntity<List<Fluxocaixa>> listarData() {
		Conversor c = new Conversor();
		Date datainicial = c.SomarDiasData(new Date(), -1);
		Date datafinal = c.SomarDiasData(new Date(), 9);	
		List<Fluxocaixa> lista = fluxoCaixaRepository.findAllFluxoCaixaData(datainicial, datafinal);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		FluxoCaixaBean fluxoCaixaBean = new FluxoCaixaBean(lista, fluxoCaixaRepository);
		fluxoCaixaBean.calcularSaldos(0);
		lista = fluxoCaixaBean.getListaFluxo();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar")
	@Cacheable("consultaFluxoCaixa")
	public ResponseEntity<List<Fluxocaixa>> listarInicial() {
		Conversor c = new Conversor();
		Date datainicial = c.SomarDiasData(new Date(), -1);
		List<Fluxocaixa> lista = fluxoCaixaRepository.findAllFluxoCaixaInicial(datainicial);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		FluxoCaixaBean fluxoCaixaBean = new FluxoCaixaBean(lista, fluxoCaixaRepository);
		fluxoCaixaBean.calcularSaldos(0);
		lista = fluxoCaixaBean.getListaFluxo();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("data/{data}")
	public ResponseEntity<List<Fluxocaixa>> getId(@PathVariable("data") String data) {
		Conversor c = new Conversor();
		Date dataStart = c.ConvercaoStringData(data);
		List<Fluxocaixa> listaFluxoCaixa = fluxoCaixaRepository.findData(dataStart);
		if (listaFluxoCaixa==null) {
			return ResponseEntity.notFound().build();
		}
		FluxoCaixaBean fluxoCaixaBean = new FluxoCaixaBean(listaFluxoCaixa, fluxoCaixaRepository);
		fluxoCaixaBean.calcularSaldos(0);
		 listaFluxoCaixa = fluxoCaixaBean.getListaFluxo();
		return ResponseEntity.ok(listaFluxoCaixa);
	}
	
	
	
	

}
