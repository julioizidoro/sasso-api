/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sassotabacco.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "compras")
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompras")
    private Integer idcompras;
    @Column(name = "datacompra")
    @Temporal(TemporalType.DATE)
    private Date datacompra;
    @Column(name = "documento")
    private String documento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valortotal")
    private Float valortotal;
    @Column(name = "desconto")
    private Float desconto;
    @Column(name = "frete")
    private Float frete;
    @Column(name = "totalliquido")
    private Float totalliquido;
    @Column(name = "formapagamento")
    private String formapagamento;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "instituicao_idinstituicao", referencedColumnName = "idinstituicao")
    @ManyToOne(optional = false)
    private Instituicao instituicao;
    @JoinColumn(name = "planoconta_idplanoconta", referencedColumnName = "idplanoconta")
    @ManyToOne(optional = false)
    private Planoconta planoconta;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;
    

    public Compras() {
    }

    public Compras(Integer idcompras) {
        this.idcompras = idcompras;
    }

    public Integer getIdcompras() {
        return idcompras;
    }

    public void setIdcompras(Integer idcompras) {
        this.idcompras = idcompras;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Float getFrete() {
        return frete;
    }

    public void setFrete(Float frete) {
        this.frete = frete;
    }

    public Float getTotalliquido() {
        return totalliquido;
    }

    public void setTotalliquido(Float totalliquido) {
        this.totalliquido = totalliquido;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Planoconta getPlanoconta() {
        return planoconta;
    }

    public void setPlanoconta(Planoconta planoconta) {
        this.planoconta = planoconta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompras != null ? idcompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.idcompras == null && other.idcompras != null) || (this.idcompras != null && !this.idcompras.equals(other.idcompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Compras[ idcompras=" + idcompras + " ]";
    }
    
}
