package br.com.sassotabacco.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "planoconta")
public class Planoconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplanoconta")
    private Integer idplanoconta;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 10)
    @Column(name = "conta")
    private String conta;
    @JoinColumn(name = "grupoplanoconta_idgrupoplanoconta", referencedColumnName = "idgrupoplanoconta")
    @ManyToOne(optional = false)
    private Grupoplanoconta grupoplanoconta;
    @Column(name = "lancamentobens")
    private boolean lancamentobens;

    
    
    public Planoconta() {
    }

    public Planoconta(Integer idplanoconta) {
        this.idplanoconta = idplanoconta;
    }

    public Integer getIdplanoconta() {
        return idplanoconta;
    }

    public void setIdplanoconta(Integer idplanoconta) {
        this.idplanoconta = idplanoconta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Grupoplanoconta getGrupoplanoconta() {
        return grupoplanoconta;
    }

    public void setGrupoplanoconta(Grupoplanoconta grupoplanoconta) {
        this.grupoplanoconta = grupoplanoconta;
    }

    public boolean isLancamentobens() {
		return lancamentobens;
	}

	public void setLancamentobens(boolean lancamentobens) {
		this.lancamentobens = lancamentobens;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idplanoconta != null ? idplanoconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planoconta)) {
            return false;
        }
        Planoconta other = (Planoconta) object;
        if ((this.idplanoconta == null && other.idplanoconta != null) || (this.idplanoconta != null && !this.idplanoconta.equals(other.idplanoconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.mavenproject1.Planoconta[ idplanoconta=" + idplanoconta + " ]";
    }
    
}
