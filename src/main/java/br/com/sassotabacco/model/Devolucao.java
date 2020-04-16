package br.com.sassotabacco.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "devolucao")
public class Devolucao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevolucao")
    private Integer iddevolucao;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo")
    private Float custo;
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "planoconta_idplanoconta", referencedColumnName = "idplanoconta")
    @ManyToOne(optional = false)
    private Planoconta planoconta;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "instituicao_idinstituicao", referencedColumnName = "idinstituicao")
    @ManyToOne(optional = false)
    private Instituicao instituicao;

    public Devolucao() {
    }

    public Devolucao(Integer iddevolucao) {
        this.iddevolucao = iddevolucao;
    }

    public Integer getIddevolucao() {
        return iddevolucao;
    }

    public void setIddevolucao(Integer iddevolucao) {
        this.iddevolucao = iddevolucao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getCusto() {
        return custo;
    }

    public void setCusto(Float custo) {
        this.custo = custo;
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

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (iddevolucao != null ? iddevolucao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucao)) {
            return false;
        }
        Devolucao other = (Devolucao) object;
        if ((this.iddevolucao == null && other.iddevolucao != null) || (this.iddevolucao != null && !this.iddevolucao.equals(other.iddevolucao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Devolucao[ iddevolucao=" + iddevolucao + " ]";
    }
    
}

