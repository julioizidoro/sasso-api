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
	@Column(name = "banco")
	private String banco;
	@Column(name = "datasaldo")
	@Temporal(TemporalType.DATE)
    private Date datasaldo;
	@Column(name = "saldoinicial")
	private float saldoinicial;;
	@Transient
	private float saldoatual;

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

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Date getDatasaldo() {
		return datasaldo;
	}

	public void setDatasaldo(Date datasaldo) {
		this.datasaldo = datasaldo;
	}

	public float getSaldoinicial() {
		return saldoinicial;
	}

	public void setSaldoinicial(float saldoinicial) {
		this.saldoinicial = saldoinicial;
	}

	public float getSaldoatual() {
		return saldoatual;
	}

	public void setSaldoatual(float saldoatual) {
		this.saldoatual = saldoatual;
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
