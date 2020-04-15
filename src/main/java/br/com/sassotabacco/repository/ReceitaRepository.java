package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Receita;
import br.com.sassotabacco.model.Receitaproduto;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
	
	Optional<Receita> findById(int id);
	
	@Query("Select r from Receita r where r.estoque.produto.descricao like CONCAT('%', :descricao, '%')  order by r.estoque.produto.descricao")
	List<Receita> findByDescricao(@Param("descricao") String descricao);
	
	@Query("Select r from Receitaproduto r where r.receita.idreceita= :id  order by r.estoque.produto.descricao")
	List<Receitaproduto> findByReceitaProduto(@Param("id") int id);
	
}