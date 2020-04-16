package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Acerto;
import br.com.sassotabacco.model.Devolucaoproduto;

public interface DevolucaoProdutoRepository extends JpaRepository<Devolucaoproduto, Integer>{
	
	Optional<Devolucaoproduto> findById(int id);
	
	//Listar id devolucao
	@Query("Select d from Devolucaoproduto d where d.devolucao.iddevolucao= :id order by d.iddevolucaoproduto ")
	List<Devolucaoproduto> findByDevolucao(@Param("id") int id);
	
}
