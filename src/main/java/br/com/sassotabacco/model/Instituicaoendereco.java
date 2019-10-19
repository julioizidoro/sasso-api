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
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "instituicaoendereco")
public class Instituicaoendereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinstituicaoendereco")
    private Integer idinstituicaoendereco;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "cep")
    private String cep;
    @JoinColumn(name = "instituicao_idinstituicao", referencedColumnName = "idinstituicao")
    @OneToOne(optional = false)
    private Instituicao instituicao;
   
    public Instituicaoendereco() {
    }

    public Instituicaoendereco(Integer idinstituicaoendereco) {
        this.idinstituicaoendereco = idinstituicaoendereco;
    }

    public Integer getIdinstituicaoendereco() {
        return idinstituicaoendereco;
    }

    public void setIdinstituicaoendereco(Integer idinstituicaoendereco) {
        this.idinstituicaoendereco = idinstituicaoendereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstituicaoendereco != null ? idinstituicaoendereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituicaoendereco)) {
            return false;
        }
        Instituicaoendereco other = (Instituicaoendereco) object;
        if ((this.idinstituicaoendereco == null && other.idinstituicaoendereco != null) || (this.idinstituicaoendereco != null && !this.idinstituicaoendereco.equals(other.idinstituicaoendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Instituicaoendereco[ idinstituicaoendereco=" + idinstituicaoendereco + " ]";
    }
    
}
