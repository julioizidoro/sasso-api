package br.com.sassotabacco.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarioempresa")
public class Usuarioempresa {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuarioempresa")
    private Integer idusuarioempresa;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;
    
	public Integer getIdusuarioempresa() {
		return idusuarioempresa;
	}
	public void setIdusuarioempresa(Integer idusuarioempresa) {
		this.idusuarioempresa = idusuarioempresa;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idusuarioempresa == null) ? 0 : idusuarioempresa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarioempresa other = (Usuarioempresa) obj;
		if (idusuarioempresa == null) {
			if (other.idusuarioempresa != null)
				return false;
		} else if (!idusuarioempresa.equals(other.idusuarioempresa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuarioempresa [idusuarioempresa=" + idusuarioempresa + "]";
	}
    
    

}
