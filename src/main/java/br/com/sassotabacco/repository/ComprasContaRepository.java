package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Comprasconta;

public interface ComprasContaRepository extends JpaRepository<Comprasconta, Integer> {
	
	Optional<Comprasconta> findById(int id);
	
	@Query("Select c from Comprasconta c where c.compras.idcompras= :id order by c.contas.numeroparcela")
	List<Comprasconta> findByComprasConta(@Param("id") int id);
	

}