package br.com.sassotabacco.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Compras;



public interface ComprasRepository extends JpaRepository<Compras, Integer>{
	
	Optional<Compras> findById(int id);
	@Query("Select c from Compras c where c.instituicao.nome like CONCAT('%', :nome, '%') and "
			+ " c.datacompra>= :data90  and c.empresa.idempresa= :idempresa  order by c.datacompra ")
	List<Compras> findAll(@Param("nome") String nome, @Param("data90") Date data90, @Param("idempresa") int idempresa);
	
	
	//Listar documento
	@Query("Select c from Compras c where c.documento= :documento and c.empresa.idempresa= :idempresa order by c.datacompra ")
	List<Compras> findDocumento(@Param("documento") String documento, @Param("idempresa") int idempresa);
	
	//Listar nome
	@Query("Select c from Compras c where c.instituicao.nome like CONCAT('%', :nome, '%') and c.empresa.idempresa= :idempresa order by c.datacompra ")
	List<Compras> findNome(@Param("nome") String nome, @Param("idempresa") int idempresa);
	
}