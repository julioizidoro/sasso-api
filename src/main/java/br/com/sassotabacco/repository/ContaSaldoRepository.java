package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Contasaldo;



public interface ContaSaldoRepository extends JpaRepository<Contasaldo, Integer>{
	
	Optional<Contasaldo> findById(int id);
	
	@Query("Select c from Contasaldo c where c.mesano = :mesano and c.empresa.idempresa= :idempresa order by c.conta.descricao")
	List<Contasaldo> findByMesAno(String mesano, @Param("idempresa") int idempresa);
	
	@Query("Select c from Contasaldo c where c.mesano = :mesano and c.conta.idconta = :idconta and c.empresa.idempresa= :idempresa ")
	Contasaldo findByConta(int idconta, String mesano, @Param("idempresa") int idempresa);
	
	@Query("Select c from Contasaldo c where c.aberto=true and c.empresa.idempresa= :idempresa ")
	List<Contasaldo> findByAtivos(@Param("idempresa") int idempresa);
	
	
	

}