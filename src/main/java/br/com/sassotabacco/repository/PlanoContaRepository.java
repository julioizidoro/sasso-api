package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Planoconta;

public interface PlanoContaRepository extends JpaRepository<Planoconta, Integer>{
	
	@Query("select p from Planoconta p where p.grupoplanoconta.idgrupoplanoconta= :grupo order by p.descricao")
	Optional<List<Planoconta>> findGrupo(@Param("grupo") int grupo);
	Optional<List<Planoconta>> findByDescricaoContainingOrderByDescricao(String Descricao);
	Optional<Planoconta> findById(int id);
	List<Planoconta> findAll();
	
	

}