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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "fluxocontas")
public class Fluxocontas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfluxocontas")
    private Integer idfluxocontas;
	@JsonBackReference
	@JoinColumn(name = "fluxocaixa_idfluxocaixa", referencedColumnName = "idfluxocaixa")
    @OneToOne(optional = false)
    private Fluxocaixa fluxocaixa;
	@JoinColumn(name = "contas_idcontas", referencedColumnName = "idcontas")
    @OneToOne(optional = false)
    private Contas contas;
	
	public Fluxocontas() {
	
	}

	public Integer getIdfluxocontas() {
		return idfluxocontas;
	}

	public void setIdfluxocontas(Integer idfluxocontas) {
		this.idfluxocontas = idfluxocontas;
	}

	public Fluxocaixa getFluxocaixa() {
		return fluxocaixa;
	}

	public void setFluxocaixa(Fluxocaixa fluxocaixa) {
		this.fluxocaixa = fluxocaixa;
	}

	public Contas getContas() {
		return contas;
	}

	public void setContas(Contas contas) {
		this.contas = contas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idfluxocontas == null) ? 0 : idfluxocontas.hashCode());
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
		Fluxocontas other = (Fluxocontas) obj;
		if (idfluxocontas == null) {
			if (other.idfluxocontas != null)
				return false;
		} else if (!idfluxocontas.equals(other.idfluxocontas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fluxocontas [idfluxocontas=" + idfluxocontas + "]";
	}
}
