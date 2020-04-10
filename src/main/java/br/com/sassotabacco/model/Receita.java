package br.com.sassotabacco.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreceita")
    private Integer idreceita;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @Column(name = "unidade")
    private String unidade;
    @JoinColumn(name = "estoque_idestoque", referencedColumnName = "idestoque")
    @ManyToOne(optional = false)
    private Estoque estoque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<Producao> producaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<Receitaproduto> receitaprodutoList;

    public Receita() {
    }

    public Receita(Integer idreceita) {
        this.idreceita = idreceita;
    }

    public Integer getIdreceita() {
        return idreceita;
    }

    public void setIdreceita(Integer idreceita) {
        this.idreceita = idreceita;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<Producao> getProducaoList() {
        return producaoList;
    }

    public void setProducaoList(List<Producao> producaoList) {
        this.producaoList = producaoList;
    }

    public List<Receitaproduto> getReceitaprodutoList() {
        return receitaprodutoList;
    }

    public void setReceitaprodutoList(List<Receitaproduto> receitaprodutoList) {
        this.receitaprodutoList = receitaprodutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreceita != null ? idreceita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.idreceita == null && other.idreceita != null) || (this.idreceita != null && !this.idreceita.equals(other.idreceita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Receita[ idreceita=" + idreceita + " ]";
    }
    
}

