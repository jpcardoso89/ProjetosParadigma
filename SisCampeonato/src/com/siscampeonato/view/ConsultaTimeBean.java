package com.siscampeonato.view;

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
public class ConsultaTimeBean {
	
	private List<Time> times;

	public List<Time> getTimes() {
		RepositoriosUtil.getTimes().listarTodos()
		return times;
	}
	
	
	
}
