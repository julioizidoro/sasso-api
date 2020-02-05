package br.com.sassotabacco.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name = "fluxocaixa")
public class Fluxocaixa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfluxocaixa")
    private Integer idfluxocaixa;
	@Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
	@Column(name = "entradas")
    private Float entradas;
	@Column(name = "saidas")
    private Float saidas;
	@Column(name = "entradasprevistas")
    private Float entradasprevistas;
	@Column(name = "saidasprevistas")
    private Float saidasprevistas;
	@JoinColumn(name = "conta_idconta", referencedColumnName = "idconta")
    @OneToOne(optional = false)
    private Conta conta;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fluxocaixa")
    private List<Fluxocontas> fluxocontasList;
	@Transient
    private Float saldoanterior;
    @Transient
    private Float saldoatual;
	
	public Fluxocaixa() {
	
	}

	public Integer getIdfluxocaixa() {
		return idfluxocaixa;
	}

	public void setIdfluxocaixa(Integer idfluxocaixa) {
		this.idfluxocaixa = idfluxocaixa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getEntradas() {
		return entradas;
	}

	public void setEntradas(Float entradas) {
		this.entradas = entradas;
	}

	public Float getSaidas() {
		return saidas;
	}

	public void setSaidas(Float saidas) {
		this.saidas = saidas;
	}


	public Float getEntradasprevistas() {
		return entradasprevistas;
	}

	public void setEntradasprevistas(Float entradasprevistas) {
		this.entradasprevistas = entradasprevistas;
	}

	public Float getSaidasprevistas() {
		return saidasprevistas;
	}

	public void setSaidasprevistas(Float saidasprevistas) {
		this.saidasprevistas = saidasprevistas;
	}

	public List<Fluxocontas> getFluxocontasList() {
		return fluxocontasList;
	}

	public void setFluxocontasList(List<Fluxocontas> fluxocontasList) {
		this.fluxocontasList = fluxocontasList;
	}

	public Float getSaldoanterior() {
		return saldoanterior;
	}

	public void setSaldoanterior(Float saldoanterior) {
		this.saldoanterior = saldoanterior;
	}

	public Float getSaldoatual() {
		return saldoatual;
	}

	public void setSaldoatual(Float saldoatual) {
		this.saldoatual = saldoatual;
	}


	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idfluxocaixa == null) ? 0 : idfluxocaixa.hashCode());
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
		Fluxocaixa other = (Fluxocaixa) obj;
		if (idfluxocaixa == null) {
			if (other.idfluxocaixa != null)
				return false;
		} else if (!idfluxocaixa.equals(other.idfluxocaixa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fluxocaixa [saldoatual=" + (getEntradasprevistas() - getSaidasprevistas()) + "]";
	}

}
