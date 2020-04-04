package br.com.sassotabacco.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contasaldo")
public class Contasaldo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcontasaldo")
	private Integer idcontasaldo;
	@Column(name = "mesano")
	private String mesano;
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
	@Column(name = "aberto")
	private boolean aberto;
	@JoinColumn(name = "conta_idconta", referencedColumnName = "idconta")
    @OneToOne(optional = false)
    private Conta conta;
	

	public Contasaldo() {

	}
	
	public Integer getIdcontasaldo() {
		return idcontasaldo;
	}

	public void setIdcontasaldo(Integer idcontasaldo) {
		this.idcontasaldo = idcontasaldo;
	}

	public String getMesano() {
		return mesano;
	}

	public void setMesano(String mesano) {
		this.mesano = mesano;
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcontasaldo == null) ? 0 : idcontasaldo.hashCode());
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
		Contasaldo other = (Contasaldo) obj;
		if (idcontasaldo == null) {
			if (other.idcontasaldo != null)
				return false;
		} else if (!idcontasaldo.equals(other.idcontasaldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contasaldo [saldo=" + saldo + "]";
	}
	
	
}
