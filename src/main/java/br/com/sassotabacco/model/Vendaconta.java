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

/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "vendaconta")
public class Vendaconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvendaconta")
    private Integer idvendaconta;
    @JoinColumn(name = "contas_idcontas", referencedColumnName = "idcontas")
    @ManyToOne(optional = false)
    private Contas contas;
    @JoinColumn(name = "venda_idvenda", referencedColumnName = "idvenda")
    @ManyToOne(optional = false)
    private Venda venda;

    public Vendaconta() {
    }

    public Vendaconta(Integer idvendaconta) {
        this.idvendaconta = idvendaconta;
    }

    public Integer getIdvendaconta() {
        return idvendaconta;
    }

    public void setIdvendaconta(Integer idvendaconta) {
        this.idvendaconta = idvendaconta;
    }

    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvendaconta != null ? idvendaconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendaconta)) {
            return false;
        }
        Vendaconta other = (Vendaconta) object;
        if ((this.idvendaconta == null && other.idvendaconta != null) || (this.idvendaconta != null && !this.idvendaconta.equals(other.idvendaconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vendaconta[ idvendaconta=" + idvendaconta + " ]";
    }
    
}
