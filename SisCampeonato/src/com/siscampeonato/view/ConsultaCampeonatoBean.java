package com.siscampeonato.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.siscampeonato.bo.CampeonatoBO;
import com.siscampeonato.bo.RegraNegocioException;
import com.siscampeonato.entidades.Campeonato;
import com.siscampeonato.repository.CampeonatoRepository;
import com.siscampeonato.util.FacesUtil;
import com.siscampeonato.util.RepositoriosUtil;

@ManagedBean
@SessionScoped
public class ConsultaCampeonatoBean implements Serializable{
	private static final long serialVersionUID = 1757929884637073756L;
	
	private List<Campeonato> campeonatos = new ArrayList<Campeonato>();
	private Campeonato campeonatoSelecionado = new Campeonato();

	public void excluir() {
		CampeonatoBO campeonatoBO = new CampeonatoBO(
				RepositoriosUtil.getCampeonatos());
		try {
			campeonatoBO.excluir(this.campeonatoSelecionado);
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_ERROR, "Campeonato possui times!");
		}

	}

	public List<Campeonato> getCampeonatos() {
		CampeonatoRepository campeonatos = RepositoriosUtil.getCampeonatos();
		this.campeonatos = campeonatos.listarTodos();
		return this.campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}

	public Campeonato getCampeonatoSelecionado() {
		return campeonatoSelecionado;
	}

	public void setCampeonatoSelecionado(Campeonato campeonatoSelecionado) {
		this.campeonatoSelecionado = campeonatoSelecionado;
	}

}
