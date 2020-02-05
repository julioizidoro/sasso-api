package br.com.sassotabacco.controller;

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

import br.com.sassotabacco.model.Contasarquivos;
import br.com.sassotabacco.repository.ContasArquivosRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/ca")
public class ContasArquivosController {
	
	@Autowired
	private ContasArquivosRepository contasArquivosRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Contasarquivos salvar(@Valid @RequestBody Contasarquivos arquivo) {
		return contasArquivosRepository.save(arquivo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contasarquivos> buscar(@PathVariable Integer id) {
		Optional<Contasarquivos> arquivo = contasArquivosRepository.findById(id);
		
		if (arquivo==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(arquivo.get());
	}

}
