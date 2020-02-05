/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sassotabacco.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduto")
    private Integer idproduto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "codgiobarras")
    private String codgiobarras;
    @Column(name = "unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "estoqueminimo")
    private Float estoqueminimo;
    @Column(name = "estoquemaximo")
    private Float estoquemaximo;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "cest")
    private String cest;
    @Column(name = "pesoliquido")
    private Float pesoliquido;
    @Column(name = "pesobruto")
    private String pesobruto;
    @Column(name = "materiaprima")
    private Short materiaprima;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produto")
    private Estoque estoque;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodgiobarras() {
        return codgiobarras;
    }

    public void setCodgiobarras(String codgiobarras) {
        this.codgiobarras = codgiobarras;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Float getEstoqueminimo() {
        return estoqueminimo;
    }

    public void setEstoqueminimo(Float estoqueminimo) {
        this.estoqueminimo = estoqueminimo;
    }

    public Float getEstoquemaximo() {
        return estoquemaximo;
    }

    public void setEstoquemaximo(Float estoquemaximo) {
        this.estoquemaximo = estoquemaximo;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public Float getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(Float pesoliquido) {
        this.pesoliquido = pesoliquido;
    }

    public String getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto123(String pesobruto) {
        this.pesobruto = pesobruto;
    }

    public Short getMateriaprima() {
        return materiaprima;
    }

    public void setMateriaprima(Short materiaprima) {
        this.materiaprima = materiaprima;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
