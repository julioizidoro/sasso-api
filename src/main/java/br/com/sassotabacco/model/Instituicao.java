/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sassotabacco.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "instituicao")
public class Instituicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinstituicao")
    private Integer idinstituicao;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipojuridico")
    private String tipojuridico;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "cpfcnpj")
    private String cpfcnpj;
    @Column(name = "possuiie")
    private String possuiie;
    @Column(name = "ie")
    private String ie;
    @Column(name = "im")
    private String im;
    @Column(name = "optantesimples")
    private Short optantesimples;
    @Column(name = "email")
    private String email;
    @Column(name = "fonefixo")
    private String fonefixo;
    @Column(name = "fonecelular")
    private String fonecelular;
    @Column(name = "datanascimento")
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "tipo")
    private String tipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instituicao")
    private Instituicaocontato instituicaocontato;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instituicao")
    private Instituicaoendereco instituicaoendereco;

    public Instituicao() {
    }

    public Instituicao(Integer idinstituicao) {
        this.idinstituicao = idinstituicao;
    }

    public Integer getIdinstituicao() {
        return idinstituicao;
    }

    public void setIdinstituicao(Integer idinstituicao) {
        this.idinstituicao = idinstituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipojuridico() {
        return tipojuridico;
    }

    public void setTipojuridico(String tipojuridico) {
        this.tipojuridico = tipojuridico;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getPossuiie() {
        return possuiie;
    }

    public void setPossuiie(String possuiie) {
        this.possuiie = possuiie;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public Short getOptantesimples() {
        return optantesimples;
    }

    public void setOptantesimples(Short optantesimples) {
        this.optantesimples = optantesimples;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonefixo() {
        return fonefixo;
    }

    public void setFonefixo(String fonefixo) {
        this.fonefixo = fonefixo;
    }

    public String getFonecelular() {
        return fonecelular;
    }

    public void setFonecelular(String fonecelular) {
        this.fonecelular = fonecelular;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    

	public Instituicaocontato getInstituicaocontato() {
		return instituicaocontato;
	}

	public void setInstituicaocontato(Instituicaocontato instituicaocontato) {
		this.instituicaocontato = instituicaocontato;
	}

	public Instituicaoendereco getInstituicaoendereco() {
		return instituicaoendereco;
	}

	public void setInstituicaoendereco(Instituicaoendereco instituicaoendereco) {
		this.instituicaoendereco = instituicaoendereco;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstituicao != null ? idinstituicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituicao)) {
            return false;
        }
        Instituicao other = (Instituicao) object;
        if ((this.idinstituicao == null && other.idinstituicao != null) || (this.idinstituicao != null && !this.idinstituicao.equals(other.idinstituicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Instituicao[ idinstituicao=" + idinstituicao + " ]";
    }
    
}
