package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Acertoproduto;

public interface AcertoProdutoRepository extends JpaRepository<Acertoproduto, Integer>{
	
	Optional<Acertoproduto> findById(int id);
	
	//Listar Acerto produto
	@Query("Select a from Acertoproduto a where a.acerto.idacerto= :id order by a.idacertoproduto ")
	List<Acertoproduto> findByAcerto(@Param("id") int id);
	
}