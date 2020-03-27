package br.com.sassotabacco.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	@Column(name = "saldoinicial")
	private float saldoinicial;
	@Column(name = "entradas")
	private float entradas;
	@Column(name = "saidas")
	private float saidas;
	@Column(name = "saldoliquido")
	private float saldoliquido;
	@Column(name = "saldo")
	private float saldo;
	@Column(name = "logo")
	private String logo;
	

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

	
	
	public float getSaldoinicial() {
		return saldoinicial;
	}



	public void setSaldoinicial(float saldoinicial) {
		this.saldoinicial = saldoinicial;
	}



	public float getEntradas() {
		return entradas;
	}



	public void setEntradas(float entradas) {
		this.entradas = entradas;
	}



	public float getSaidas() {
		return saidas;
	}



	public void setSaidas(float saidas) {
		this.saidas = saidas;
	}



	public float getSaldoliquido() {
		return saldoliquido;
	}



	public void setSaldoliquido(float saldoliquido) {
		this.saldoliquido = saldoliquido;
	}



	public float getSaldo() {
		return saldo;
	}



	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}



	



	public String getLogo() {
		return logo;
	}



	public void setLogo(String logo) {
		this.logo = logo;
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
