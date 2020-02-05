package br.com.sassotabacco.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.sassotabacco.model.Fluxocaixa;
import br.com.sassotabacco.repository.FluxoCaixaRepository;

public class FluxoCaixaBean {
	
	private FluxoCaixaRepository fluxoCaixaRepository;
	private List<Fluxocaixa> listaFluxo = new ArrayList<Fluxocaixa>();
	
	public FluxoCaixaBean(List<Fluxocaixa> listaFluxo, FluxoCaixaRepository fluxoCaixaRepository) {
		this.fluxoCaixaRepository = fluxoCaixaRepository;
		this.listaFluxo = listaFluxo;
	}
	
		public List<Fluxocaixa> getListaFluxo() {
		return listaFluxo;
	}

	public void setListaFluxo(List<Fluxocaixa> listaFluxo) {
		this.listaFluxo = listaFluxo;
	}

	public void calcularSaldos(int idconta) {
		for (int i=0;i<listaFluxo.size();i++) {
			Date data = listaFluxo.get(i).getData();
			System.out.print(data);
			float saldo = fluxoCaixaRepository.calculaSaldo(data, idconta);
			
			this.listaFluxo.get(i).setSaldoanterior(saldo);
			saldo = saldo - (listaFluxo.get(i).getEntradas() + listaFluxo.get(i).getSaidasprevistas());
			saldo = saldo + (listaFluxo.get(i).getSaidas() + listaFluxo.get(i).getEntradasprevistas()); 
			this.listaFluxo.get(i).setSaldoatual(saldo);
		}
	}
}
