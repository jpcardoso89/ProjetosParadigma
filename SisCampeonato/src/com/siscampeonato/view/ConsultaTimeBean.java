package com.siscampeonato.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.siscampeonato.entidades.Time;
import com.siscampeonato.util.RepositoriosUtil;
@ManagedBean
@SessionScoped
public class ConsultaTimeBean {
	
	private List<Time> times = new ArrayList<Time>();
	private List<Time> timesSelecionados = new ArrayList<Time>();
	

	public List<Time> getTimes() {
		this.times = RepositoriosUtil.getTimes().listarTodos();
		return times;
	}


	public List<Time> getTimesSelecionados() {
		return timesSelecionados;
	}


	public void setTimesSelecionados(List<Time> timesSelecionados) {
		this.timesSelecionados = timesSelecionados;
	}
	
	
	
}
