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
@Table(name = "comprasconta")
public class Comprasconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomprasconta")
    private Integer idcomprasconta;
    @JoinColumn(name = "compras_idcompras", referencedColumnName = "idcompras")
    @ManyToOne(optional = false)
    private Compras compras;
    @JoinColumn(name = "contas_idcontas", referencedColumnName = "idcontas")
    @ManyToOne(optional = false)
    private Contas contas;

    public Comprasconta() {
    }

    public Comprasconta(Integer idcomprasconta) {
        this.idcomprasconta = idcomprasconta;
    }

    public Integer getIdcomprasconta() {
        return idcomprasconta;
    }

    public void setIdcomprasconta(Integer idcomprasconta) {
        this.idcomprasconta = idcomprasconta;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomprasconta != null ? idcomprasconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprasconta)) {
            return false;
        }
        Comprasconta other = (Comprasconta) object;
        if ((this.idcomprasconta == null && other.idcomprasconta != null) || (this.idcomprasconta != null && !this.idcomprasconta.equals(other.idcomprasconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Comprasconta[ idcomprasconta=" + idcomprasconta + " ]";
    }
    
}
