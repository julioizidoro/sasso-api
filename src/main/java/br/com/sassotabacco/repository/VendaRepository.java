package br.com.sassotabacco.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer>{
	
	Optional<Venda> findById(int id);
	
	//Listar Vendas Data
	@Query("Select v from Venda v where v.datatipo>= :datainicial and v.datatipo<=:datafinal and v.empresa.idempresa= :idempresa order by v.datavalidade ")
	List<Venda> findByVendas(@Param("datainicial") Date datainicial, @Param("datafinal") Date datafinal, @Param("idempresa") int idempresa);

}
