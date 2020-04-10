package br.com.sassotabacco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sassotabacco.model.Receitaproduto;

public interface ReceitaProdutoRepository extends JpaRepository<Receitaproduto, Integer> {
	
	Optional<Receitaproduto> findById(int id);
	
	
	
}
