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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "instituicaocontato")
public class Instituicaocontato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinstituicaocontato")
    private Integer idinstituicaocontato;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "fone")
    private String fone;
    @Column(name = "cargo")
    private String cargo;
    @JsonBackReference	
	@JoinColumn(name = "instituicao_idinstituicao", referencedColumnName = "idinstituicao")
    @OneToOne(optional = false)
    private Instituicao instituicao;

    public Instituicaocontato() {
    }

    public Instituicaocontato(Integer idinstituicaocontato) {
        this.idinstituicaocontato = idinstituicaocontato;
    }

    public Integer getIdinstituicaocontato() {
        return idinstituicaocontato;
    }

    public void setIdinstituicaocontato(Integer idinstituicaocontato) {
        this.idinstituicaocontato = idinstituicaocontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstituicaocontato != null ? idinstituicaocontato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituicaocontato)) {
            return false;
        }
        Instituicaocontato other = (Instituicaocontato) object;
        if ((this.idinstituicaocontato == null && other.idinstituicaocontato != null) || (this.idinstituicaocontato != null && !this.idinstituicaocontato.equals(other.idinstituicaocontato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Instituicaocontato[ idinstituicaocontato=" + idinstituicaocontato + " ]";
    }
    
}
