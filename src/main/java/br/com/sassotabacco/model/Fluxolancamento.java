package br.com.sassotabacco.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "fluxolancamento")
public class Fluxolancamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfluxolancamento")
    private Integer idfluxolancamento;
	@Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
	@Column(name = "valorentrada")
    private Float valorentrada;
	@Column(name = "valorsaida")
    private Float valorsaida;
	@JoinColumn(name = "planoconta_idplanoconta", referencedColumnName = "idplanoconta")
    @OneToOne(optional = false)
    private Planoconta planoconta;
	@JoinColumn(name = "formapagamento_idformapagamento", referencedColumnName = "idformapagamento")
    @OneToOne(optional = false)
    private Formapagamento formapagamento;
	@JsonBackReference
    @JoinColumn(name = "fluxocaixa_idfluxocaixa", referencedColumnName = "idfluxocaixa")
    @OneToOne(optional = false)
    private Fluxocaixa fluxocaixa;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @OneToOne(optional = false)
    private Usuario usuario;
    
	public Fluxolancamento() {
	
	}

	public Integer getIdfluxolancamento() {
		return idfluxolancamento;
	}

	public void setIdfluxolancamento(Integer idfluxolancamento) {
		this.idfluxolancamento = idfluxolancamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getValorentrada() {
		return valorentrada;
	}

	public void setValorentrada(Float valorentrada) {
		this.valorentrada = valorentrada;
	}

	public Float getValorsaida() {
		return valorsaida;
	}

	public void setValorsaida(Float valorsaida) {
		this.valorsaida = valorsaida;
	}

	public Planoconta getPlanoconta() {
		return planoconta;
	}

	public void setPlanoconta(Planoconta planoconta) {
		this.planoconta = planoconta;
	}

	public Formapagamento getFormapagamento() {
		return formapagamento;
	}

	public void setFormapagamento(Formapagamento formapagamento) {
		this.formapagamento = formapagamento;
	}

	public Fluxocaixa getFluxocaixa() {
		return fluxocaixa;
	}

	public void setFluxocaixa(Fluxocaixa fluxocaixa) {
		this.fluxocaixa = fluxocaixa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idfluxolancamento == null) ? 0 : idfluxolancamento.hashCode());
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
		Fluxolancamento other = (Fluxolancamento) obj;
		if (idfluxolancamento == null) {
			if (other.idfluxolancamento != null)
				return false;
		} else if (!idfluxolancamento.equals(other.idfluxolancamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fluxolancamento [idfluxolancamento=" + idfluxolancamento + ", data=" + data + "]";
	}
	
	
    
    
	
	

}
