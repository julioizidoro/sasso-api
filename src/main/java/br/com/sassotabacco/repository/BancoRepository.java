package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Conta;

public interface BancoRepository extends JpaRepository<Conta, Integer>{
	
	Optional<Conta> findById(int id);
	
	@Query("Select b from Conta b where b.descricao like CONCAT('%', :descricao, '%') order by b.descricao")
	List<Conta> findBanoAll(@Param("descricao") String descricao);
}
