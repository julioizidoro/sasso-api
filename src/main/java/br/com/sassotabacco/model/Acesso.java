package br.com.sassotabacco.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acesso implements Serializable	 {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacesso")
    private Integer idacesso;
    @Column(name = "nome")
    private String nome;
  /*  @Column(name = "dashboard")
    private boolean dashboard;
    @Column(name = "cadastro")
    private boolean cadastro;
    @Column(name = "cadclienteincluir")
    private boolean cadclienteincluir;
    @Column(name = "cadclienteeditar")
    private boolean cadclienteeditar;
    @Column(name = "cadfornecedorincluir")
    private boolean cadfornecedorincluir;
    @Column(name = "cadfornecedoreditar")
    private boolean cadfornecedoreditar;
    @Column(name = "cadobrasincluir")
    private boolean cadobrasincluir;
    @Column(name = "cadobraseditar")
    private boolean cadobraseditar;
    @Column(name = "cadfaseobraincluir")
    private boolean cadfaseobraincluir;
    @Column(name = "cadfaseobraseditar")
    private boolean cadfaseobraseditar;
    @Column(name = "cadsubfaseobraincluir")
    private boolean cadsubfaseobraincluir;
    @Column(name = "cadsubfaseobraeditar")
    private boolean cadsubfaseobraeditar;
    @Column(name = "cadprodutosincluir")
    private boolean cadprodutosincluir;
    @Column(name = "cadprodutoseditar")
    private boolean cadprodutoseditar;
    @Column(name = "cadgrupocontasincluir")
    private boolean cadgrupocontasincluir;
    @Column(name = "cadgrupocontaseditar")
    private boolean cadgrupocontaseditar;
    @Column(name = "cadplanocontasincluir")
    private boolean cadplanocontasincluir;
    @Column(name = "cadplanocontaseditar")
    private boolean cadplanocontaseditar;
    @Column(name = "bens")
    private boolean bens;
    @Column(name = "benscontrole")
    private boolean benscontrole;
    @Column(name = "benscontroleincluir")
    private boolean benscontroleincluir;
    @Column(name = "benscontroleeditar")
    private boolean benscontroleeditar;
    @Column(name = "obras")
    private boolean obras;
    @Column(name = "obrainclir")
    private boolean obrainclir;
    @Column(name = "obraeditar")
    private boolean obraeditar;
    @Column(name = "compras")
    private boolean compras;
    @Column(name = "comprassolciitacao")
    private boolean comprassolciitacao;
    @Column(name = "comprassolciitacaoincluir")
    private boolean comprassolciitacaoincluir;
    @Column(name = "comprassolciitacaoeditar")
    private boolean comprassolciitacaoeditar;
    @Column(name = "compraspedido")
    private boolean compraspedido;
    @Column(name = "compraspedidoincluir")
    private boolean compraspedidoincluir;
    @Column(name = "compraspedidoeditar")
    private boolean compraspedidoeditar;
    @Column(name = "financeiro")
    private boolean financeiro;
    @Column(name = "financeirocp")
    private boolean financeirocp;
    @Column(name = "financeirocpincluir")
    private boolean financeirocpincluir;
    @Column(name = "financeirocpeditar")
    private boolean financeirocpeditar;
    @Column(name = "financeirocppagar")
    private boolean financeirocppagar;
    @Column(name = "financeirocr")
    private boolean financeirocr;
    @Column(name = "financeirocrincluir")
    private boolean financeirocrincluir;
    @Column(name = "financeirocreditar")
    private boolean financeirocreditar;
    @Column(name = "financeirocrreceber")
    private boolean financeirocrreceber;
    @Column(name = "financeirofc")
    private boolean financeirofc;
    @Column(name = "cadcliente")
    private boolean cadcliente;
    @Column(name = "cadfornecedor")
    private boolean cadfornecedor;
    @Column(name = "cadobras")
    private boolean cadobras;
    @Column(name = "cadplanocontas")
    private boolean cadplanocontas;
    @Column(name = "cadgrupocontas")
    private boolean cadgrupocontas;
    @Column(name = "cadfasesobras")
    private boolean cadfasesobras;
    @Column(name = "cadprodutos")
    private boolean cadprodutos;
    @Column(name = "cadsubfaseobras")
    private boolean cadsubfaseobras;
    
    @Column(name = "cadusuario")
    private boolean cadusuario;
    @Column(name = "cadusuarioincluir")
    private boolean cadusuarioincluir;
    @Column(name = "cadusuarioeditar")
    private boolean cadusuarioediar;
    
    @Column(name = "cadacesso")
    private boolean cadacesso;
    @Column(name = "cadacessoincluir")
    private boolean cadacessoincluir;
    @Column(name = "cadacessoeditar")
    private boolean cadacessoeditar;
    
    @Transient
    private String numerousuario;
    @Transient
    private String nomeusuario;*/
   
    public Acesso() {
    }

    public Acesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public Integer getIdacesso() {
        return idacesso;
    }

    public void setIdacesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idacesso != null ? idacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.idacesso == null && other.idacesso != null) || (this.idacesso != null && !this.idacesso.equals(other.idacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acesso[ idacesso=" + idacesso + " ]";
    }
    
}
