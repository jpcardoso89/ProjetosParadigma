package com.siscampeonato.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.siscampeonato.bo.TimeBO;
import com.siscampeonato.entidades.Time;
import com.siscampeonato.repository.TimeRepository;
import com.siscampeonato.util.RepositoriosUtil;

@ManagedBean
@SessionScoped
public class ConsultaTimeBean implements Serializable{

	private static final long serialVersionUID = -8388262202564940322L;
	private List<Time> times = new ArrayList<Time>();
	private Time timeSelecionado = new Time();

	public List<Time> getTimes() {
		TimeRepository times = RepositoriosUtil.getTimes();
		this.times = times.listarTodos();
		return this.times;
	}

	public Time getTimeSelecionado() {
		return timeSelecionado;
	}

	public void setTimeSelecionado(Time timeSelecionado) {
		this.timeSelecionado = timeSelecionado;
	}
	
	public void excluir(){
		TimeBO timeBO = new TimeBO(RepositoriosUtil.getTimes());
		timeBO.excluir(timeSelecionado);
		
	}

}
