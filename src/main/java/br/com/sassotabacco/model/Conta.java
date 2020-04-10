package br.com.sassotabacco.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idconta")
	private Integer idconta;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "logo")
	private String logo;
	@Column(name = "mostrar")
	private boolean mostrar;
	

	public Conta() {

	}
	
	

	public Integer getIdconta() {
		return idconta;
	}



	public void setIdconta(Integer idconta) {
		this.idconta = idconta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLogo() {
		return logo;
	}



	public void setLogo(String logo) {
		this.logo = logo;
	}



	public boolean isMostrar() {
		return mostrar;
	}



	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idconta == null) ? 0 : idconta.hashCode());
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
		Conta other = (Conta) obj;
		if (idconta == null) {
			if (other.idconta != null)
				return false;
		} else if (!idconta.equals(other.idconta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Banco [descricao=" + descricao + "]";
	}
	
	

}
