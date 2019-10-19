package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sassotabacco.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
		
		Usuario findByUserAndPasswordAndSituacao(String user, String password, boolean Situacao);
		Optional<List<Usuario>> findByNomeContainingOrderByNome(String Nome);
		Optional<List<Usuario>> findBySituacaoOrderByNome(boolean Situacao);
}

