package com.siscampeonato.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.siscampeonato.bo.RegraNegocioException;
import com.siscampeonato.bo.TimeBO;
import com.siscampeonato.entidades.Time;
import com.siscampeonato.util.FacesUtil;
import com.siscampeonato.util.RepositoriosUtil;

@ManagedBean
@SessionScoped
public class CadastroTimeBean implements Serializable{

	private static final long serialVersionUID = 6663431989056851085L;
	
	private Time time = new Time();

	public void upload(){
		if(time.getEscudo() != null){
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_INFO, "Sucesso");
		}else{
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_ERROR, "Falha");
		}
		System.out.println("cfvgbhnjkl");
		TimeBO timeBO = new TimeBO(RepositoriosUtil.getTimes());
		
		try {
			timeBO.salvar(time);
			this.time = new Time();
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_INFO, "Time salvo com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMessage(FacesMessage.SEVERITY_INFO, e.getMessage());
		}
	}
	
	public String salvar(){
		System.out.println("cfvgbhnjkl");
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
	
	

}
