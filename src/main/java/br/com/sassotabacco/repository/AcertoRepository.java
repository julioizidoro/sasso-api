package br.com.sassotabacco.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Acerto;

public interface AcertoRepository extends JpaRepository<Acerto, Integer>{
	
	Optional<Acerto> findById(int id);
	
	//Listar Data
	@Query("Select a from Acerto a where a.data>= :data  and a.empresa.idempresa= :idempresa order by a.data ")
	List<Acerto> findByData(@Param("data") Date data, @Param("idempresa") int idempresa);
	
}