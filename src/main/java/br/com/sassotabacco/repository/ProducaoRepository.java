package br.com.sassotabacco.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Producao;
import br.com.sassotabacco.model.Producaoproduto;

public interface ProducaoRepository extends JpaRepository<Producao, Integer> {
	
	Optional<Producao> findById(int id);
	
	@Query("Select p from Producao p where p.data >= :data and p.receita.estoque.produto.descricao like CONCAT('%', :descricao, '%')  and p.empresa.idempresa= :idempresa order by p.data")
	List<Producao> findByDescricao(@Param("descricao") String descricao, @Param("data") Date data, @Param("idempresa") int idempresa);
	
	@Query("Select p from Producaoproduto p where p.producao.idproducao= :id  order by p.estoque.produto.descricao")
	List<Producaoproduto> findByProducaoProduto(@Param("id") int id);
	
}
