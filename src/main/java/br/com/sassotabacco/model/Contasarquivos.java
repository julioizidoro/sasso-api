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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "contasarquivos")
public class Contasarquivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasarquivos")
    private Integer idcontasarquivos;
    @Column(name = "nomeoriginal")
    private String nomeoriginal;
    @Column(name = "uri")
    private String uri;
    @JsonBackReference
    @JoinColumn(name = "contas_idcontas", referencedColumnName = "idcontas")
    @ManyToOne
    private Contas contas;

    public Contasarquivos() {
    }

    public Contasarquivos(Integer idcontasarquivos) {
        this.idcontasarquivos = idcontasarquivos;
    }

    public Integer getIdcontasarquivos() {
        return idcontasarquivos;
    }

    public void setIdcontasarquivos(Integer idcontasarquivos) {
        this.idcontasarquivos = idcontasarquivos;
    }

    

    public String getNomeoriginal() {
		return nomeoriginal;
	}

	public void setNomeoriginal(String nomeoriginal) {
		this.nomeoriginal = nomeoriginal;
	}

	public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontasarquivos != null ? idcontasarquivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contasarquivos)) {
            return false;
        }
        Contasarquivos other = (Contasarquivos) object;
        if ((this.idcontasarquivos == null && other.idcontasarquivos != null) || (this.idcontasarquivos != null && !this.idcontasarquivos.equals(other.idcontasarquivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contasarquivos[ idcontasarquivos=" + idcontasarquivos + " ]";
    }
    
}
