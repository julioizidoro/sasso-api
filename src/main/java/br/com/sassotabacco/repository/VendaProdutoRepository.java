package br.com.sassotabacco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Vendaproduto;

	public interface VendaProdutoRepository extends JpaRepository<Vendaproduto, Integer>{
		
		Optional<Vendaproduto> findById(int id);
		
		//Listar Produtos venda
		@Query("Select v from Vendaproduto v where v.venda.idvenda>= :idvenda order by v.estoque.produto.descricao")
		List<Vendaproduto> findByVenda(@Param("idvenda") int idvenda);

	}
