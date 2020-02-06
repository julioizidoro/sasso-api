package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Estoque;


public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
	
	Optional<Estoque> findById(int id);
	
	@Query("Select e from Estoque e where e.produto.descricao like CONCAT('%', :descricao, '%') order by e.produto.descricao")
	Optional<List<Estoque>> findProdutoDescricao(@Param("descricao") String descricao);

	@Query("Select e from Estoque e where e.produto.codigobarras like CONCAT('%', :codigobarras, '%') order by e.produto.descricao")
	Optional<List<Estoque>> findProdutoCodigoBarras(@Param("codigobarras") String codigobarras);
	
	@Query("Select e from Estoque e where e.produto.idproduto = :idproduto order by e.produto.descricao")
	Optional<Estoque> findProdutoId(@Param("idproduto") int idproduto);
	
}
