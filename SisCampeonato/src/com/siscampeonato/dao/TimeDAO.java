package com.siscampeonato.dao;

import java.util.List;

import org.hibernate.Session;

import com.siscampeonato.entidades.Time;
import com.siscampeonato.repository.TimeRepository;

public class TimeDAO implements TimeRepository{
	
	private Session session; 
//	hauhauhauhau
	public TimeDAO(Session session) {
		this.session = session;
	}

	@Override
	public List<Time> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPorCodigo(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
