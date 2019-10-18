/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "categoriaconta")
public class Categoriaconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategoriaconta")
    private Integer idcategoriaconta;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriacontaIdcategoriaconta")
    private List<Planoconta> planocontaList;

    public Categoriaconta() {
    }

    public Categoriaconta(Integer idcategoriaconta) {
        this.idcategoriaconta = idcategoriaconta;
    }

    public Integer getIdcategoriaconta() {
        return idcategoriaconta;
    }

    public void setIdcategoriaconta(Integer idcategoriaconta) {
        this.idcategoriaconta = idcategoriaconta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Planoconta> getPlanocontaList() {
        return planocontaList;
    }

    public void setPlanocontaList(List<Planoconta> planocontaList) {
        this.planocontaList = planocontaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoriaconta != null ? idcategoriaconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriaconta)) {
            return false;
        }
        Categoriaconta other = (Categoriaconta) object;
        if ((this.idcategoriaconta == null && other.idcategoriaconta != null) || (this.idcategoriaconta != null && !this.idcategoriaconta.equals(other.idcategoriaconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Categoriaconta[ idcategoriaconta=" + idcategoriaconta + " ]";
    }
    
}
