package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sassotabacco.model.Acesso;



public interface AcessoRepository extends JpaRepository<Acesso, Integer>{
	
	Optional<Acesso> findById(int id);
	Optional<List<Acesso>> findByNomeContainingOrderByNome(String Nome);
	List<Acesso> findAll();
	
}
