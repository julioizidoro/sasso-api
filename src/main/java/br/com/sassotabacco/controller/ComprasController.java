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

import br.com.sassotabacco.model.Compras;
import br.com.sassotabacco.repository.ComprasRepository;
import br.com.sassotabacco.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("compras")
public class ComprasController {
	
	@Autowired
	private ComprasRepository comprasRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Compras salvar(@Valid @RequestBody Compras compra) {
		return comprasRepository.save(compra);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Compras> buscar(@PathVariable Integer id) {
		Optional<Compras> compras = comprasRepository.findById(id);
		
		if (compras==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(compras.get());
	}
	
	
	@GetMapping("listar/{nome}")
	public ResponseEntity<List<Compras>> listar(@PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		Conversor c = new Conversor();
		Date data90 = c.SomarDiasData(new Date(), -90);
		List<Compras> lista = comprasRepository.findAll(nome, data90);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/doc/{documento}")
	public ResponseEntity<List<Compras>> listarDocumento(@PathVariable("documento") String documento) {
		List<Compras> lista = comprasRepository.findDocumento(documento);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/nome/{nome}")
	public ResponseEntity<List<Compras>> listarNome(@PathVariable("nome") String nome) {
		List<Compras> lista = comprasRepository.findNome(nome);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

}
