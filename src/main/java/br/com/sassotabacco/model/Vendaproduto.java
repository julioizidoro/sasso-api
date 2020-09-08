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
@Table(name = "vendaproduto")
public class Vendaproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvendaproduto")
    private Integer idvendaproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @Column(name = "subtotal")
    private Float subtotal;
    @JoinColumn(name = "estoque_idestoque", referencedColumnName = "idestoque")
    @ManyToOne(optional = false)
    private Estoque estoque;
    @JsonBackReference	
    @JoinColumn(name = "venda_idvenda", referencedColumnName = "idvenda")
    @ManyToOne(optional = false)
    private Venda venda;
    @Column(name = "custototal")
    private Float custototal;
    @Column(name = "lucrobruto")
    private Float lucrobruto;
    
    

    public Vendaproduto() {
    }

    public Vendaproduto(Integer idvendaproduto) {
        this.idvendaproduto = idvendaproduto;
    }

    public Integer getIdvendaproduto() {
        return idvendaproduto;
    }

    public void setIdvendaproduto(Integer idvendaproduto) {
        this.idvendaproduto = idvendaproduto;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Float getCustototal() {
		return custototal;
	}

	public void setCustototal(Float custototal) {
		this.custototal = custototal;
	}

	public Float getLucrobruto() {
		return lucrobruto;
	}

	public void setLucrobruto(Float lucrobruto) {
		this.lucrobruto = lucrobruto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idvendaproduto != null ? idvendaproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendaproduto)) {
            return false;
        }
        Vendaproduto other = (Vendaproduto) object;
        if ((this.idvendaproduto == null && other.idvendaproduto != null) || (this.idvendaproduto != null && !this.idvendaproduto.equals(other.idvendaproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vendaproduto[ idvendaproduto=" + idvendaproduto + " ]";
    }
    
}
