package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sassotabacco.model.Categoriaconta;

public interface CategoriaContaRepository extends JpaRepository<Categoriaconta, Integer>{
	
	Optional<Categoriaconta> findById(int id);
	Optional<List<Categoriaconta>> findByDescricaoContainingOrderByDescricao(String Descricao);
	List<Categoriaconta> findAll();
}
