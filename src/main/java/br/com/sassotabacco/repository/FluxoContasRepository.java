package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Fluxocontas;

public interface FluxoContasRepository extends JpaRepository<Fluxocontas, Integer> {
	
	@Query("Select f from Fluxocontas f where f.fluxocaixa.idfluxocaixa= :idfluxo")
	Optional<List<FluxoCaixaRepository>> findAllFluxoCaixa(@Param("idfluxo") int idfluxo);
	@Query("Select f from Fluxocontas f where f.contas.idcontas= :idconta")
	Fluxocontas buscarConta(@Param("idconta") int idconta);

}
