package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Estoque;


public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
	
	@Query("Select e from Estoque e where e.produto.descricao like CONCAT('%', :descricao, '%') order by e.produto.descricao")
	Optional<List<Estoque>> findProdutoDescricao(@Param("descricao") String descricao);
	
	Optional<Estoque> findById(int id);
	
	

}
