package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Planoconta;

public interface PlanoContaRepository  extends JpaRepository<Planoconta, Integer>{
	
	Optional<Planoconta> findById(int id);
	Optional<List<Planoconta>> findByDescricaoContainingOrderByDescricao(String Descricao);
	
	@Query("select p from Planoconta p where p.categoriaconta.idcategoriaconta= :idcategoria order by p.descricao")
	Optional<List<Planoconta>> findCategoria(
	@Param("idcategoria") int idCategoria);
	Optional<List<Planoconta>> findByCategoriacontaOrderByDescricao(String Descricao);
	List<Planoconta> findAll();
} 
