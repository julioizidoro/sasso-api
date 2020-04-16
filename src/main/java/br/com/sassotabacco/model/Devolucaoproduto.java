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
@Table(name = "devolucaoproduto")
public class Devolucaoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevolucaoproduto")
    private Integer iddevolucaoproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @Column(name = "custo")
    private Float custo;
    @JoinColumn(name = "devolucao_iddevolucao", referencedColumnName = "iddevolucao")
    @ManyToOne(optional = false)
    private Devolucao devolucao;
    @JoinColumn(name = "estoque_idestoque", referencedColumnName = "idestoque")
    @ManyToOne(optional = false)
    private Estoque estoque;

    public Devolucaoproduto() {
    }

    public Devolucaoproduto(Integer iddevolucaoproduto) {
        this.iddevolucaoproduto = iddevolucaoproduto;
    }

    public Integer getIddevolucaoproduto() {
        return iddevolucaoproduto;
    }

    public void setIddevolucaoproduto(Integer iddevolucaoproduto) {
        this.iddevolucaoproduto = iddevolucaoproduto;
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

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
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
        hash += (iddevolucaoproduto != null ? iddevolucaoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucaoproduto)) {
            return false;
        }
        Devolucaoproduto other = (Devolucaoproduto) object;
        if ((this.iddevolucaoproduto == null && other.iddevolucaoproduto != null) || (this.iddevolucaoproduto != null && !this.iddevolucaoproduto.equals(other.iddevolucaoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Devolucaoproduto[ iddevolucaoproduto=" + iddevolucaoproduto + " ]";
    }
    
}
