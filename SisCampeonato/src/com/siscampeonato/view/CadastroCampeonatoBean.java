package com.siscampeonato.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.siscampeonato.entidades.Campeonato;
import com.siscampeonato.entidades.Time;

@ManagedBean
@SessionScoped
public class CadastroCampeonatoBean implements Serializable{

	private static final long serialVersionUID = -5415548640974354281L;
	private Campeonato campeonato = new Campeonato();
	

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}


	
	
}
