package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sassotabacco.model.Contasaldo;



public interface ContaSaldoRepository extends JpaRepository<Contasaldo, Integer>{
	
	Optional<Contasaldo> findById(int id);
	
	@Query("Select c from Contasaldo c where c.mesano = :mesano order by c.conta.descricao")
	List<Contasaldo> findByMesAno(String mesano);
	
	@Query("Select c from Contasaldo c where c.mesano = :mesano and c.conta.idconta = :idconta")
	Contasaldo findByConta(int idconta, String mesano);
	
	

}