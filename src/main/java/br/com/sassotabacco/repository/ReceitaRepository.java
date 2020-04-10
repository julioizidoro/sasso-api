package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sassotabacco.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
	
	Optional<Receita> findById(int id);
	
	@Query("Select r from Receita r  order by r.estoque.produto.descricao")
	Optional<List<Receita>> findByAll();
	
}