package br.com.sassotabacco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sassotabacco.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	Conta findById(int id);
	
	@Query("Select c from Conta c where c.descricao like CONCAT('%', :descricao, '%') and c.mostrar=1 order by c.descricao")
	List<Conta> findByDescricao(String descricao);
	
	

}
