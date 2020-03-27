package br.com.sassotabacco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sassotabacco.model.Contasarquivos;

public interface ContasArquivosRepository extends JpaRepository<Contasarquivos, Integer>{
	
	Optional<Contasarquivos> findById(int id);

}
