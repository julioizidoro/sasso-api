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

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "grupoplanoconta")
public class Grupoplanoconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupoplanoconta")
    private Integer idgrupoplanoconta;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 100)
    @Column(name = "conta")
    private String conta;
    

    public Grupoplanoconta() {
    }

    public Grupoplanoconta(Integer idgrupoplanoconta) {
        this.idgrupoplanoconta = idgrupoplanoconta;
    }

    public Integer getIdgrupoplanoconta() {
        return idgrupoplanoconta;
    }

    public void setIdgrupoplanoconta(Integer idgrupoplanoconta) {
        this.idgrupoplanoconta = idgrupoplanoconta;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupoplanoconta != null ? idgrupoplanoconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoplanoconta)) {
            return false;
        }
        Grupoplanoconta other = (Grupoplanoconta) object;
        if ((this.idgrupoplanoconta == null && other.idgrupoplanoconta != null) || (this.idgrupoplanoconta != null && !this.idgrupoplanoconta.equals(other.idgrupoplanoconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.mavenproject1.Grupoplanoconta[ idgrupoplanoconta=" + idgrupoplanoconta + " ]";
    }
    
}
