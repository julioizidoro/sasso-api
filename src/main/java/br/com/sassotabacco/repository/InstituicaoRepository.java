package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sassotabacco.model.Instituicao;



public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer>{
	
	Optional<List<Instituicao>> findByTipoOrderByNome(String Tipo);
	Optional<List<Instituicao>> findByNomeContainingOrEmailContainingOrderByNome(String Nome, String Email);
	Optional<List<Instituicao>> findByNomeContainingOrderByNome(String Nome);

}
