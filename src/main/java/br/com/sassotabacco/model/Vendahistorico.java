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

	/**
	 *
	 * @author julio.silva
	 */
	@Entity
	@Table(name = "vendahistorico")
	public class Vendahistorico implements Serializable {

	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "idvendahistorico")
	    private Integer idvendahistorico;
	    @Column(name = "data")
	    @Temporal(TemporalType.DATE)
	    private Date data;
	    @Column(name = "tipo")
	    private String tipo;
	    @Column(name = "situacao")
	    private String situacao;
	    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
	    @ManyToOne(optional = false)
	    private Usuario usuario;
	    @JoinColumn(name = "venda_idvenda", referencedColumnName = "idvenda")
	    @ManyToOne(optional = false)
	    private Venda venda;

	    public Vendahistorico() {
	    }

	    public Vendahistorico(Integer idvendahistorico) {
	        this.idvendahistorico = idvendahistorico;
	    }

	    public Integer getIdvendahistorico() {
	        return idvendahistorico;
	    }

	    public void setIdvendahistorico(Integer idvendahistorico) {
	        this.idvendahistorico = idvendahistorico;
	    }

	    public Date getData() {
	        return data;
	    }

	    public void setData(Date data) {
	        this.data = data;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

	    public String getSituacao() {
	        return situacao;
	    }

	    public void setSituacao(String situacao) {
	        this.situacao = situacao;
	    }

	    public Usuario getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(Usuario usuario) {
	        this.usuario = usuario;
	    }

	    public Venda getVenda() {
	        return venda;
	    }

	    public void setVenda(Venda venda) {
	        this.venda = venda;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idvendahistorico != null ? idvendahistorico.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Vendahistorico)) {
	            return false;
	        }
	        Vendahistorico other = (Vendahistorico) object;
	        if ((this.idvendahistorico == null && other.idvendahistorico != null) || (this.idvendahistorico != null && !this.idvendahistorico.equals(other.idvendahistorico))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "model.Vendahistorico[ idvendahistorico=" + idvendahistorico + " ]";
	    }
	    
	}
