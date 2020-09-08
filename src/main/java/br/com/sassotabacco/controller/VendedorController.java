package br.com.sassotabacco.controller;

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

import br.com.sassotabacco.model.Vendedor;
import br.com.sassotabacco.repository.VendedorRepository;

@CrossOrigin
@RestController
@RequestMapping("vendedores")
public class VendedorController {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor salvar(@Valid @RequestBody Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vendedor> buscarVendedor(@PathVariable Integer id) {
		Optional<Vendedor> vendedor = vendedorRepository.findById(id);
		
		if (vendedor==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(vendedor.get());
	}
	
	@GetMapping("listar/{nome}")
	public ResponseEntity<List<Vendedor>> listar(@PathVariable String nome) {
		List<Vendedor> lista = vendedorRepository.findByNome(nome);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}

}
