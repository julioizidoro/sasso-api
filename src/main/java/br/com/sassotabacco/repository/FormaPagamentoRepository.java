package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sassotabacco.model.Formapagamento;

public interface FormaPagamentoRepository extends JpaRepository<Formapagamento, Integer>{
	
	@Query("Select f from Formapagamento f order by f.descricao")
	Optional<List<Formapagamento>> findAllForma();
}
