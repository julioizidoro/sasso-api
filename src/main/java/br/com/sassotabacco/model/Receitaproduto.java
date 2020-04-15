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

@Entity
@Table(name = "receitaproduto")

public class Receitaproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreceitaproduto")
    private Integer idreceitaproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @JoinColumn(name = "receita_idreceita", referencedColumnName = "idreceita")
    @ManyToOne(optional = false)
    private Receita receita;
    @JoinColumn(name = "estoque_idestoque", referencedColumnName = "idestoque")
    @ManyToOne(optional = false)
    private Estoque estoque;

    public Receitaproduto() {
    }

    public Receitaproduto(Integer idreceitaproduto) {
        this.idreceitaproduto = idreceitaproduto;
    }

    public Integer getIdreceitaproduto() {
        return idreceitaproduto;
    }

    public void setIdreceitaproduto(Integer idreceitaproduto) {
        this.idreceitaproduto = idreceitaproduto;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idreceitaproduto != null ? idreceitaproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receitaproduto)) {
            return false;
        }
        Receitaproduto other = (Receitaproduto) object;
        if ((this.idreceitaproduto == null && other.idreceitaproduto != null) || (this.idreceitaproduto != null && !this.idreceitaproduto.equals(other.idreceitaproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Receitaproduto[ idreceitaproduto=" + idreceitaproduto + " ]";
    }
    
}

