package br.com.sassotabacco.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "formapagamento")
public class Formapagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformapagamento")
    private Integer idformapagamento;
	@Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
	
	public Formapagamento() {
	
	}
	
	public Integer getIdformapagamento() {
		return idformapagamento;
	}

	public void setIdformapagamento(Integer idformapagamento) {
		this.idformapagamento = idformapagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idformapagamento == null) ? 0 : idformapagamento.hashCode());
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
		Formapagamento other = (Formapagamento) obj;
		if (idformapagamento == null) {
			if (other.idformapagamento != null)
				return false;
		} else if (!idformapagamento.equals(other.idformapagamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Formapagamento [descricao=" + descricao + "]";
	}
	
	
	
	

}
