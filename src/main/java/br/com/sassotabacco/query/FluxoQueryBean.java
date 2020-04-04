package br.com.sassotabacco.query;

import java.util.Date;

public class FluxoQueryBean {
	
	private Date data;
	private String documento;
	private String descricao;
	private int idGrupoConta;
	private int idPlanoContas;
	private int idConta;
	private float valorEntrada;
	private float valorSaida;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdGrupoConta() {
		return idGrupoConta;
	}
	public void setIdGrupoConta(int idGrupoConta) {
		this.idGrupoConta = idGrupoConta;
	}
	public int getIdPlanoContas() {
		return idPlanoContas;
	}
	public void setIdPlanoContas(int idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public float getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(float valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	public float getValorSaida() {
		return valorSaida;
	}
	public void setValorSaida(float valorSaida) {
		this.valorSaida = valorSaida;
	}
	
	
	
	

}
