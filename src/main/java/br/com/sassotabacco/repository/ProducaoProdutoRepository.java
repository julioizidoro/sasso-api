package br.com.sassotabacco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sassotabacco.model.Producaoproduto;

public interface ProducaoProdutoRepository extends JpaRepository<Producaoproduto, Integer> {
	
	Optional<Producaoproduto> findById(int id);
	

}
