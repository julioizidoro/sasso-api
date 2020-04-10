/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "comprasproduto")
public class Comprasproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomprasproduto")
    private Integer idcomprasproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @Column(name = "custo")
    private Float custo;
    @Column(name = "subtotal")
    private Float subtotal;
    @JoinColumn(name = "compras_idcompras", referencedColumnName = "idcompras")
    @ManyToOne(optional = false)
    private Compras compras;
    @JoinColumn(name = "estoque_idestoque", referencedColumnName = "idestoque")
    @ManyToOne(optional = false)
    private Estoque estoque;

    public Comprasproduto() {
    }

    public Comprasproduto(Integer idcomprasproduto) {
        this.idcomprasproduto = idcomprasproduto;
    }

    public Integer getIdcomprasproduto() {
        return idcomprasproduto;
    }

    public void setIdcomprasproduto(Integer idcomprasproduto) {
        this.idcomprasproduto = idcomprasproduto;
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

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
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
        hash += (idcomprasproduto != null ? idcomprasproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprasproduto)) {
            return false;
        }
        Comprasproduto other = (Comprasproduto) object;
        if ((this.idcomprasproduto == null && other.idcomprasproduto != null) || (this.idcomprasproduto != null && !this.idcomprasproduto.equals(other.idcomprasproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Comprasproduto[ idcomprasproduto=" + idcomprasproduto + " ]";
    }
    
}
