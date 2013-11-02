package com.siscampeonato.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.siscampeonato.entidades.Time;
import com.siscampeonato.repository.TimeRepository;
import com.siscampeonato.util.RepositoriosUtil;

@ManagedBean
@SessionScoped
public class ConsultaTimeBean implements Serializable{

	private static final long serialVersionUID = -8388262202564940322L;
	private List<Time> times = new ArrayList<Time>();

	public List<Time> getTimes() {
		TimeRepository times = RepositoriosUtil.getTimes();
		this.times = times.listarTodos();
		return this.times;
	}

}
