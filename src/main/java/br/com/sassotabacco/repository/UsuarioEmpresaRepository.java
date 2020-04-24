package br.com.sassotabacco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sassotabacco.model.Usuarioempresa;

public interface UsuarioEmpresaRepository extends JpaRepository<Usuarioempresa, Integer> {
	
	@Query("Select u from Usuarioempresa u where u.usuario.idusuario= :id order by u.empresa.nomefantasia")
	List<Usuarioempresa> findByUsuario(@Param("id") int id);

}
