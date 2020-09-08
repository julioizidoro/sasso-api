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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author julio.silva
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvenda")
    private Integer idvenda;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "hora")
    private String hora;
    @Column(name = "datatipo")
    @Temporal(TemporalType.DATE)
    private Date datatipo;
    @Column(name = "situacaotipo")
    private String situacaotipo;
    @Column(name = "datavalidade")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @Lob
    @Column(name = "formapagamento")
    private String formapagamento;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Float subtotal;
    @Column(name = "desconto")
    private Float desconto;
    @Column(name = "totalliquido")
    private Float totalliquido;
    @Column(name = "condicaopagamento")
    private String condicaopagamento;
    @Column(name = "observacaoparcela")
    private String observacaoparcela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<Vendaproduto> vendaprodutoList;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;
    
    
   
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @Column(name = "numeroitens")
    private Integer numeroitens;

    public Venda() {
    }

    public Venda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public Integer getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDatatipo() {
        return datatipo;
    }

    public void setDatatipo(Date datatipo) {
        this.datatipo = datatipo;
    }

    public String getSituacaotipo() {
        return situacaotipo;
    }

    public void setSituacaotipo(String situacaotipo) {
        this.situacaotipo = situacaotipo;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
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

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Float getTotalliquido() {
        return totalliquido;
    }

    public void setTotalliquido(Float totalliquido) {
        this.totalliquido = totalliquido;
    }

    public String getCondicaopagamento() {
        return condicaopagamento;
    }

    public void setCondicaopagamento(String condicaopagamento) {
        this.condicaopagamento = condicaopagamento;
    }

    public String getObservacaoparcela() {
        return observacaoparcela;
    }

    public void setObservacaoparcela(String observacaoparcela) {
        this.observacaoparcela = observacaoparcela;
    }

    
    public List<Vendaproduto> getVendaprodutoList() {
        return vendaprodutoList;
    }

    public void setVendaprodutoList(List<Vendaproduto> vendaprodutoList) {
        this.vendaprodutoList = vendaprodutoList;
    }

   

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

	public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public Integer getNumeroitens() {
		return numeroitens;
	}

	public void setNumeroitens(Integer numeroitens) {
		this.numeroitens = numeroitens;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idvenda != null ? idvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idvenda == null && other.idvenda != null) || (this.idvenda != null && !this.idvenda.equals(other.idvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Venda[ idvenda=" + idvenda + " ]";
    }
    
}
