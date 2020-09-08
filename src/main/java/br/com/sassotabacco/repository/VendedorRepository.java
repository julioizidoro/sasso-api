package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
	
	Optional<Vendedor> findById(int id);
	
	@Query("Select v from Vendedor v where v.nome like CONCAT('%', :nome, '%') and v.situacao=1 order by v.nome ")
	List<Vendedor> findByNome(@Param("nome") String nome);
		
}
