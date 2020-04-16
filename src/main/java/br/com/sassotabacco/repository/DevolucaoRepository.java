package br.com.sassotabacco.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Devolucao;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Integer>{
	
	Optional<Devolucao> findById(int id);
	
	//Listar Data
	@Query("Select d from Devolucao d where d.data>= :data order by d.data ")
	List<Devolucao> findByData(@Param("data") Date data);
	
}
