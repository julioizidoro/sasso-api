package br.com.sassotabacco.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sassotabacco.model.Producao;

public interface ProducaoRepository extends JpaRepository<Producao, Integer> {
	
	Optional<Producao> findById(int id);
	
	@Query("Select p from Producao p where p.data <= :data order by p.data")
	Optional<List<Producao>> findByData(Date data);
	List<Producao> findAll();
}
