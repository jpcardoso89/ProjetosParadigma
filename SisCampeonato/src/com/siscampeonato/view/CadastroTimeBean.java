package com.siscampeonato.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.siscampeonato.bo.RegraNegocioException;
import com.siscampeonato.bo.TimeBO;
import com.siscampeonato.entidades.Campeonato;
import com.siscampeonato.entidades.Time;
import com.siscampeonato.repository.CampeonatoRepository;
import com.siscampeonato.util.FacesUtil;
import com.siscampeonato.util.RepositoriosUtil;

@ManagedBean
@SessionScoped
public class CadastroTimeBean implements Serializable{

	private static final long serialVersionUID = 6663431989056851085L;
	private Time time = new Time();
	private List<Campeonato> campeonatos = new ArrayList<Campeonato>();
	
	public String salvar(){
		TimeBO timeBO = new TimeBO(RepositoriosUtil.getTimes());
		
		try {
			timeBO.salvar(time);
			this.time = new Time();
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_INFO, "Time salvo com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_INFO, e.getMessage());
		}
		
		return null;
	}
	
	public void excluir(){
		TimeBO timeBO = new TimeBO(RepositoriosUtil.getTimes());
		timeBO.excluir(time);
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Campeonato> getCampeonatos() {
		CampeonatoRepository campeonatos = RepositoriosUtil.getCampeonatos();
		this.campeonatos = campeonatos.listarTodos();
		return this.campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}
	
	public void participacaoModificado(ValueChangeEvent event){
		this.time.setCampeonato(null);
		FacesContext.getCurrentInstance().renderResponse();
		
	}
	
	

}
