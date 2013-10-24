package com.siscampeonato.dao;

import java.util.List;

import org.hibernate.Session;

import com.siscampeonato.entidades.Time;
import com.siscampeonato.repository.TimeRepository;

public class TimeDAO implements TimeRepository{
	
	private Session session; 

	public TimeDAO(Session session) {
		this.session = session;
	}

	@Override
	public List<Time> listarTodos() {
		return this.session.createCriteria(Time.class).list();
	}

	@Override
	public void guardar(Time time) {
		this.session.merge(time);
		
	}

	@Override
	public void excluir(Time time) {
		this.session.delete(time);
	}

	@Override
	public Time buscarPorCodigo(Integer id) {
		return (Time) this.session.get(Time.class, id);
		
	}

}
