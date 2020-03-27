package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sassotabacco.model.Grupoplanoconta;

public interface GrupoPlanoContaRepository extends JpaRepository<Grupoplanoconta, Integer>{
	
	Optional<List<Grupoplanoconta>> findByDescricaoContainingOrderByDescricao(String Descricao);
	Optional<Grupoplanoconta> findById(int id);
	List<Grupoplanoconta> findAll();

}