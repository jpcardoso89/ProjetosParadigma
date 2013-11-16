package com.siscampeonato.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.siscampeonato.bo.CampeonatoBO;
import com.siscampeonato.bo.RegraNegocioException;
import com.siscampeonato.entidades.Campeonato;
import com.siscampeonato.entidades.Time;
import com.siscampeonato.util.FacesUtil;
import com.siscampeonato.util.RepositoriosUtil;

@ManagedBean
@SessionScoped
public class CadastroCampeonatoBean implements Serializable {

	private static final long serialVersionUID = -5415548640974354281L;
	private Campeonato campeonato = new Campeonato();
	private List<Time> timeSelecionado = new ArrayList<Time>();

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public void salvar() {
		System.out.println("tghj");
		CampeonatoBO campeonatoBO = new CampeonatoBO(
				RepositoriosUtil.getCampeonatos());
		try {
			this.campeonato.setTimes(timeSelecionado);
			campeonatoBO.salvar(this.campeonato);
			this.campeonato = new Campeonato();
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_INFO,
					"Campeonato salvo com sucesso");

		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage());
		}
	}

	public List<Time> getTimeSelecionado() {
		return timeSelecionado;
	}

	public void setTimeSelecionado(List<Time> timeSelecionado) {
		this.timeSelecionado = timeSelecionado;
	}

}
