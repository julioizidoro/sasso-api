package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Fluxolancamento;

public interface FluxoLancamentoRepository  extends JpaRepository<Fluxolancamento, Integer>{
	
	Optional<List<Fluxolancamento>> findById(int id);
	
	@Query("Select f from Fluxolancamento f where f.fluxocaixa.idfluxocaixa= :idfluxocaixa ")
	Optional<List<Fluxolancamento>> findAllLancamentos(@Param("idfluxocaixa") int idfluxocaixa);

}
