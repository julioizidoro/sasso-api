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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "producao")
public class Producao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducao")
    private Integer idproducao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Float quantidade;
    @Column(name = "custo")
    private Float custo;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "planoconta_idplanoconta", referencedColumnName = "idplanoconta")
    @ManyToOne(optional = false)
    private Planoconta planoconta;
    @JoinColumn(name = "receita_idreceita", referencedColumnName = "idreceita")
    @ManyToOne(optional = false)
    private Receita receita;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Producao() {
    }

    public Producao(Integer idproducao) {
        this.idproducao = idproducao;
    }

    public Integer getIdproducao() {
        return idproducao;
    }

    public void setIdproducao(Integer idproducao) {
        this.idproducao = idproducao;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Planoconta getPlanoconta() {
        return planoconta;
    }

    public void setPlanoconta(Planoconta planoconta) {
        this.planoconta = planoconta;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (idproducao != null ? idproducao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producao)) {
            return false;
        }
        Producao other = (Producao) object;
        if ((this.idproducao == null && other.idproducao != null) || (this.idproducao != null && !this.idproducao.equals(other.idproducao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Producao[ idproducao=" + idproducao + " ]";
    }
    
}

