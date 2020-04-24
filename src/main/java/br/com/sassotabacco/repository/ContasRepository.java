package br.com.sassotabacco.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Contas;


public interface ContasRepository extends JpaRepository<Contas, Integer>{
	
	//consulta por ID ok
	Optional<Contas> findById(int id);
	
	//Consulta inicial ok
	@Query("Select c from Contas c where c.datavencimento<= :data and c.tipo= :tipo and c.datapagamento is NULL and c.empresa.idempresa= :idempresa order by c.datavencimento")
	Optional<List<Contas>> findAllContas(@Param("data") Date data, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
			
	//ConsultaDocumento ok
	@Query("Select c from Contas c where c.documento= :documento and c.tipo= :tipo and c.empresa.idempresa= :idempresa order by c.datavencimento")
	Optional<List<Contas>> findAllContasDocumento(@Param("documento") String documento, @Param("tipo") String tipo, @Param("idempresa") int idempresa);	
	
	//Consulta nome todas 
	@Query("Select c from Contas c where c.instituicao.nome like CONCAT('%', :nome, '%') and c.tipo= :tipo and c.empresa.idempresa= :idempresa order by c.instituicao.nome")
	Optional<List<Contas>> findAllContasNomeTodas(@Param("nome") String nome, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	
	@Query("Select c from Contas c where c.instituicao.nome like CONCAT('%', :nome, '%') and c.tipo= :tipo and c.datapagamento is NULL and c.empresa.idempresa= :idempresa order by c.instituicao.nome")
	Optional<List<Contas>> findAllContasNomePagar(@Param("nome") String nome, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	
	@Query("Select c from Contas c where c.instituicao.nome like CONCAT('%', :nome, '%') and c.tipo= :tipo and c.valorpago>0 and c.empresa.idempresa= :idempresa  order by c.instituicao.nome")
	Optional<List<Contas>> findAllContasNomePagas(@Param("nome") String nome, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	
	//Consulta data vencimento + todas + nome
	@Query("Select c from Contas c where c.instituicao.nome like CONCAT('%', :nome, '%') and c.datavencimento>= :datainicio and c.datavencimento<= :datafinal and c.tipo= :tipo and c.empresa.idempresa= :idempresa order by c.datavencimento")
	Optional<List<Contas>> findAllContasDataVencimentoTodas(@Param("nome") String nome, @Param("datainicio") Date datainicio, @Param("datafinal") Date datafina, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	
	//Consulta data vencimento + Pagar + nome
	@Query("Select c from Contas c where c.instituicao.nome like CONCAT('%', :nome, '%') and c.datavencimento>= :datainicio and c.datavencimento<= :datafinal and c.tipo= :tipo and c.datapagamento is NULL and c.empresa.idempresa= :idempresa order by c.datavencimento")
	Optional<List<Contas>> findAllContasDataVencimentoPagar(@Param("nome") String nome, @Param("datainicio") Date datainicio, @Param("datafinal") Date datafina, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	
	//Consulta data vencimento + Paggas + nome
	@Query("Select c from Contas c where c.instituicao.nome like CONCAT('%', :nome, '%') and c.datavencimento>= :datainicio and c.datavencimento<= :datafinal and c.tipo= :tipo and c.valorpago>0 and c.empresa.idempresa= :idempresa order by c.datavencimento")
	Optional<List<Contas>> findAllContasDataVencimentoPagas(@Param("nome") String nome, @Param("datainicio") Date datainicio, @Param("datafinal") Date datafina, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	
	//Consulta vencendo hoje
	@Query(
	value = "select distinct sum(valorparcela) as valorcontas From contas where datavencimento= :data and tipo= :tipo and valorpago=0 and empresa_idempresa= :idempresa  ",
	nativeQuery = true)
		Float valorContasVencimentoHoje(@Param("data") Date data, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	
	@Query(
	value = "select distinct sum(valorparcela) as valorcontas From contas where datavencimento> :datainicial and datavencimento<= :datafinal  and tipo= :tipo and valorpago=0 and empresa_idempresa= :idempresa ",
	nativeQuery = true)
		Float contasRestoMes(@Param("datainicial") Date datainicial,  @Param("datafinal") Date datafinal, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	
	@Query(
	value = "select distinct sum(valorparcela) as valorcontas From contas where datavencimento< :data  and tipo= :tipo and valorpago=0 and empresa_idempresa= :idempresa ",
	nativeQuery = true)
		Float valorContasVencidas(@Param("data") Date data, @Param("tipo") String tipo, @Param("idempresa") int idempresa);
	

}
