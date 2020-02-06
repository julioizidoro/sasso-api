package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sassotabacco.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	Optional<Conta> findById(int id);
	
	@Query("Select c from Conta c where c.descricao like CONCAT('%', :descricao, '%') order by c.descricao")
	List<Conta> findByDescricao(String descricao);
	
	

}
