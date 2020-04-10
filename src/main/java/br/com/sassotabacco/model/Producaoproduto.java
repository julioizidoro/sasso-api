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
@Table(name = "producaoproduto")
public class Producaoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducaoproduto")
    private Integer idproducaoproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @Column(name = "custo")
    private Float custo;
    @JoinColumn(name = "producao_idproducao", referencedColumnName = "idproducao")
    @ManyToOne(optional = false)
    private Producao producao;

    public Producaoproduto() {
    }

    public Producaoproduto(Integer idproducaoproduto) {
        this.idproducaoproduto = idproducaoproduto;
    }

    public Integer getIdproducaoproduto() {
        return idproducaoproduto;
    }

    public void setIdproducaoproduto(Integer idproducaoproduto) {
        this.idproducaoproduto = idproducaoproduto;
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

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducaoproduto != null ? idproducaoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producaoproduto)) {
            return false;
        }
        Producaoproduto other = (Producaoproduto) object;
        if ((this.idproducaoproduto == null && other.idproducaoproduto != null) || (this.idproducaoproduto != null && !this.idproducaoproduto.equals(other.idproducaoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Producaoproduto[ idproducaoproduto=" + idproducaoproduto + " ]";
    }
    
}
