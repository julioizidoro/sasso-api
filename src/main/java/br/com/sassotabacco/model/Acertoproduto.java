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
@Table(name = "acertoproduto")
public class Acertoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacertoproduto")
    private Integer idacertoproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @Column(name = "custo")
    private Float custo;
    @JoinColumn(name = "acerto_idacerto", referencedColumnName = "idacerto")
    @ManyToOne(optional = false)
    private Acerto acerto;
    @JoinColumn(name = "estoque_idestoque", referencedColumnName = "idestoque")
    @ManyToOne(optional = false)
    private Estoque estoque;

    public Acertoproduto() {
    }

    public Acertoproduto(Integer idacertoproduto) {
        this.idacertoproduto = idacertoproduto;
    }

    public Integer getIdacertoproduto() {
        return idacertoproduto;
    }

    public void setIdacertoproduto(Integer idacertoproduto) {
        this.idacertoproduto = idacertoproduto;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Float getCusto() {
        return custo;
    }

    public void setCusto(Float custo) {
        this.custo = custo;
    }

    public Acerto getAcerto() {
        return acerto;
    }

    public void setAcerto(Acerto acerto) {
        this.acerto = acerto;
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
        hash += (idacertoproduto != null ? idacertoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acertoproduto)) {
            return false;
        }
        Acertoproduto other = (Acertoproduto) object;
        if ((this.idacertoproduto == null && other.idacertoproduto != null) || (this.idacertoproduto != null && !this.idacertoproduto.equals(other.idacertoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acertoproduto[ idacertoproduto=" + idacertoproduto + " ]";
    }
    
}
