package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Comprasproduto;

public interface ComprasProdutoRepository extends JpaRepository<Comprasproduto	, Integer> {
	
	Optional<Comprasproduto> findById(int id);
	
	@Query("Select c from Comprasproduto c where c.compras.idcompras= :id order by c.estoque.produto.descricao")
	List<Comprasproduto> findByComprasConta(@Param("id") int id);
	

}
