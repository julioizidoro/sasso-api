package br.com.sassotabacco.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contas")
public class Contas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontas")
    private Integer idcontas;
    @Size(max = 45)
    @Column(name = "documento")
    private String documento;
    @Column(name = "dataemissao")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "datavencimento")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    @Column(name = "numeroparcela")
    private int numeroparcela;
    @Column(name = "valorparcela")
    private Float valorparcela;
    @Column(name = "desconto")
    private Float desconto;
    @Column(name = "juros")
    private Float juros;
    @Column(name = "datapagamento")
    @Temporal(TemporalType.DATE)
    private Date datapagamento;
    @Column(name = "valorpago")
    private Float valorpago;  
	@Size(max = 200)
    @Column(name = "observacao")
    private String observacao;
	@Column(name = "codigobarras")
    private String codigobarras;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    
    @JoinColumn(name = "instituicao_idinstituicao", referencedColumnName = "idinstituicao")
    @OneToOne(optional = false)
    private Instituicao instituicao;
   
    
    @JoinColumn(name = "conta_idconta", referencedColumnName = "idconta")
    @OneToOne(optional = false)
    private Conta conta;
    @JoinColumn(name = "planoconta_idplanoconta", referencedColumnName = "idplanoconta")
    @OneToOne(optional = false)
    private Planoconta planoconta;
    
    
    @OneToMany(mappedBy = "contas")
    private List<Contasarquivos> contasarquivosList;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;

	public List<Contasarquivos> getContasarquivosList() {
		return contasarquivosList;
	}



	public void setContasarquivosList(List<Contasarquivos> contasarquivosList) {
		this.contasarquivosList = contasarquivosList;
	}



	public Contas() {
		
	}

	

	public Integer getIdcontas() {
		return idcontas;
	}



	public void setIdcontas(Integer idcontas) {
		this.idcontas = idcontas;
	}



	public String getDocumento() {
		return documento;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}



	public Date getDataemissao() {
		return dataemissao;
	}



	public void setDataemissao(Date dataemissao) {
		this.dataemissao = dataemissao;
	}



	public Date getDatavencimento() {
		return datavencimento;
	}



	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}



	

	public int getNumeroparcela() {
		return numeroparcela;
	}



	public void setNumeroparcela(int numeroparcela) {
		this.numeroparcela = numeroparcela;
	}



	public Float getValorparcela() {
		return valorparcela;
	}



	public void setValorparcela(Float valorparcela) {
		this.valorparcela = valorparcela;
	}



	public Float getDesconto() {
		return desconto;
	}



	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}



	public Float getJuros() {
		return juros;
	}



	public void setJuros(Float juros) {
		this.juros = juros;
	}



	public Date getDatapagamento() {
		return datapagamento;
	}



	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}



	public Float getValorpago() {
		return valorpago;
	}



	public void setValorpago(Float valorpago) {
		this.valorpago = valorpago;
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



	public Planoconta getPlanoconta() {
		return planoconta;
	}



	public void setPlanoconta(Planoconta planoconta) {
		this.planoconta = planoconta;
	}



	public Instituicao getInstituicao() {
		return instituicao;
	}



	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}


	public String getCodigobarras() {
		return codigobarras;
	}



	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}



	public Conta getConta() {
		return conta;
	}



	public void setConta(Conta conta) {
		this.conta = conta;
	}



	public Empresa getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcontas == null) ? 0 : idcontas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contas other = (Contas) obj;
		if (idcontas == null) {
			if (other.idcontas != null)
				return false;
		} else if (!idcontas.equals(other.idcontas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contas [idcontas=" + idcontas + "]";
	}
}
